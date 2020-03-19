package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaInstrucciones {
	PImage pantallaDos;
	PApplet app;
	
	public PantallaInstrucciones(PApplet app) {
        this.pantallaDos =app.loadImage("../data/intrucciones.png");
        this.app=app;
	}
	
	public void pintarPantalla() {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaDos,app.width / 2,app.height / 2, 1300, 800);
		   
	}
}
