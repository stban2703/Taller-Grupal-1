package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaResumen {
	PImage pantallaCuatro;
	PApplet app;
	
	public PantallaResumen(PApplet app) {
        this.pantallaCuatro =app.loadImage("../data/resumen.png");
        this.app=app;
	}
	
	public void pintarPantalla() {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaCuatro,app.width / 2,app.height / 2, 1200, 700);
		   
	}
}
