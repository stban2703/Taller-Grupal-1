package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Vida {
	private PApplet app;
	private float posX;
	private float posY;
	private PImage imagen;
	private boolean mostrarVida;

	public Vida(float posX, float posY, boolean mostrarVida, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.imagen = app.loadImage("../data/vida.png");
		this.mostrarVida = mostrarVida;
		this.app = app;

	}

	public void pintar() {
		app.imageMode(app.CENTER);
		if (this.mostrarVida == true) {
			app.image(this.imagen, this.posX, this.posY);
		}
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public PImage getImagen() {
		return imagen;
	}

	public void setImagen(PImage imagen) {
		this.imagen = imagen;
	}

	public boolean isMostrarVida() {
		return mostrarVida;
	}

	public void setMostrarVida(boolean mostrarVida) {
		this.mostrarVida = mostrarVida;
	}


}
