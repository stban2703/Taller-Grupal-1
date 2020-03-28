package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaJuego {
	private PImage pantallaTres;
	private PApplet app;
	private int tiempo;

	public PantallaJuego(PApplet app) {
		this.pantallaTres = app.loadImage("../data/juego.png");
		this.app = app;
		this.tiempo = 0;
	}

	public void pintarPantalla() {
		app.imageMode(app.CENTER);
		app.image(this.pantallaTres, app.width / 2, app.height / 2, 1200, 700);

	}

	public void pintarTiempo() {
		if(app.frameCount%60 == 0) {
			this.tiempo++;
		}
		app.fill(0);
		app.textSize(30);
		app.textAlign(app.CENTER, app.CENTER);
		app.text(this.tiempo, 205, 55);
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
}
