package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaInicial {
	PImage pantallaUno;
	PApplet app;
	
	public PantallaInicial(PApplet app) {
        this.pantallaUno =app.loadImage("../data/fondo.png");
        this.app=app;
	}
	
	public void pintarPantalla() {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaUno,app.width / 2,app.height / 2, 1200, 700);
		   
	}
}
