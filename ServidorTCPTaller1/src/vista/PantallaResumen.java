package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaResumen {
	PImage pantallaCuatro, ganador, perdedor;
	PApplet app;
	
	public PantallaResumen(PApplet app) {
        this.pantallaCuatro =app.loadImage("../data/resumen.png");
        this.ganador =app.loadImage("../data/ganador.png");
        this.perdedor =app.loadImage("../data/perdedor.png");
        this.app=app;
	}
	
	public void pintarPantalla() {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaCuatro,app.width / 2,app.height / 2, 1300, 800);
		   
	}
	public void pintarGanadorUno() {
		 app.imageMode(app.CENTER);
		 app.image(this.ganador,600,337, 116, 39);
	}
	public void pintarPerdedorUno() {
		 app.imageMode(app.CENTER);
		 app.image(this.perdedor,600,337, 116, 39);
	}
	public void pintarGanadorDos() {
		 app.imageMode(app.CENTER);
		 app.image(this.ganador,600,580, 116, 39);
	}
	public void pintarPerdedorDos() {
		 app.imageMode(app.CENTER);
		 app.image(this.perdedor,600,580, 116, 39);
	}
}
