
package sim;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ethan Keene
 */
public class Blob {
    //Fields
    private int x, y, vx, vy;
    private final static int SIZE = 10, MAX_SPEED = 10;
    private final static Color COLOR = Color.RED;
    
    //Constructor
    //overloaded
    public Blob(int x, int y) {
        this.x = x;
        this.y = y;
        this.vx = (int) (Math.random()*MAX_SPEED);
        this.vy = (int) (Math.random()*MAX_SPEED);
    }
    //no-args constructor
    public Blob() {
        this.x = (int) (Math.random()*600);
        this.y = (int) (Math.random()*600);
        this.vx = (int) (Math.random()*MAX_SPEED);
        this.vy = (int) (Math.random()*MAX_SPEED);
    }
    //Methods
    public void move() {
        x += vx;
        y += vy;
    }
    
    public void draw (Graphics g) {
        g.setColor(COLOR);
        g.fillOval(x, y, SIZE, SIZE);
    }
    //Getters & Setters
    
}
