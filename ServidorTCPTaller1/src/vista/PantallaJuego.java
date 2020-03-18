package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaJuego {
	PImage pantallaTres;
	PApplet app;
	
	public PantallaJuego(PApplet app) {
        this.pantallaTres =app.loadImage("../data/juego.png");
        this.app=app;
	}
	
	public void pintarPantalla() {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaTres,app.width / 2,app.height / 2, 1200, 700);
		   
	}
}
