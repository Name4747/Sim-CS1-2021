package sim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blob {
    //Fields
    private int x, y, vx, vy, hp;
    private final static int SIZE = 10, MAX_SPEED = 10;
    private final static Color COLOR = Color.CYAN;
    
    //Constructor
    //overloaded
    public Blob(int x, int y) {
        this.x = x;
        this.y = y;
        this.vx = (int) (Math.random()*2*MAX_SPEED) - MAX_SPEED;
        this.vy = (int) (Math.random()*2*MAX_SPEED) - MAX_SPEED;
    }
    
    //no-args constructor
    public Blob() {
        this.hp = 10;
        this.x = (int) (Math.random()*(600-25));
        this.y = (int) (Math.random()*(600-50));        
        this.vx = (int) (Math.random()*2*MAX_SPEED) - MAX_SPEED;
        this.vy = (int) (Math.random()*2*MAX_SPEED) - MAX_SPEED;
    }
    
    //Methods
    public void move() {
        x += vx;
        y += vy;
    }
    
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(x, y, SIZE, SIZE);
    }
    
    public void collideWorldBounds(World w) {
        if (x > (w.getSIZE()-25) || x < 0) {
            vx *= -1;
        }
        if (y > (w.getSIZE()-50) || y < 0) {
            vy *= -1;
        }
    }
    
    public void collide(Blob other) {
        if (circleVsCircle(this,other)) {
            if (this.hp > other.hp) {
                other.hp--;
            }
            else if (this.hp < other.hp) {
                this.hp--;
            }
            else {
                this.hp--;
                other.hp--;
            }
            int tempvx = this.vx;
            int tempvy = this.vy;
            this.vx = other.vx;
            this.vy = other.vy;
            other.vx = tempvx;
            other.vy = tempvy;
        }
    }
    
    private boolean circleVsCircle(Blob b1, Blob b2) {
        if (dist(b1,b2) < Blob.SIZE)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    private double dist(Blob b1, Blob b2) {
        return Math.sqrt(Math.pow(b2.x-b1.x,2)+Math.pow(b2.y-b1.y,2));
    }
    //Getters & setters

    public int getHp() {
        return hp;
    }
    
}
