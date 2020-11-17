
package sim;

import java.awt.Color;
import java.awt.Graphics;



/**
 *
 * @author Ethan Keene
 */
public class World {
    private final int SIZE = 600;
    private final Color bg = Color.GRAY;
    private Blob[] blobs = new Blob[5000];
    
    public World() {
        for (int i = 0; i < blobs.length; i++) {
            blobs[i] = new Blob();
        }
    }
    
    public void draw(Graphics g) {
        //for each loop, enhanced for loop
        for (Blob blob : blobs) {
            blob.move();
            blob.draw(g);
        }
    }
}
