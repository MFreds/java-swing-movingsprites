package id.ac.its.fredi.movingsprite;

import java.awt.Image;
import java.awt.image.BufferedImageOp;

import javax.swing.ImageIcon;

public class Asteroid extends Sprite {

	 public Asteroid(int x, int y) {
		 super(x,y);
	     initAsteroid();
	    }

	    private void initAsteroid() {
		loadImage("src/resources/asteroid.png");
		getImageDimensions();
		
	}
	
}