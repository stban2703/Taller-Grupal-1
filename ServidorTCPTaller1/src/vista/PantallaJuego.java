package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaJuego {
	PImage pantallaTres;
	PApplet app;
	int tiempo;
	
	public PantallaJuego(PApplet app) {
        this.pantallaTres =app.loadImage("../data/juego.png");
        this.app=app;
	}
	
	public void pintarPantalla() {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaTres,app.width / 2,app.height / 2, 1200, 700);
		  this.tiempo=0;
		   
	}
	
	 public void pintarTiempo() {
		 this.tiempo++;
    	 app.fill(255);
         app.textSize(40);
         app.textAlign(app.CENTER);
         app.text(this.tiempo, 175, 62);
	}
}
