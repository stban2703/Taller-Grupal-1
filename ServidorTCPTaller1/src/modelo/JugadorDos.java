package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class JugadorDos {
	private PApplet app;
	private float posX;
	private float posY;
	private int velocidad;
	private int vida;
	private PImage imagen;
	private boolean deslizar;
	private boolean perderVida;

	public JugadorDos(float posX, float posY, int velocidad, int vida, PApplet app) {
		this.app = app;
		this.imagen = app.loadImage("../data/rocky.png");
		this.posX = posX;
		this.posY = posY;
		this.velocidad = velocidad;
		this.vida = vida;
	}

	public void pintar() {
		app.imageMode(app.CENTER);
		app.image(this.imagen, posX, posY, 226, 147);

	}

	public void mover() {
		
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

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public PImage getImagen() {
		return imagen;
	}

	public void setImagen(PImage imagen) {
		this.imagen = imagen;
	}

	public boolean isDeslizar() {
		return deslizar;
	}

	public void setDeslizar(boolean deslizar) {
		this.deslizar = deslizar;
	}

	public boolean isPerderVida() {
		return perderVida;
	}

	public void setPerderVida(boolean perderVida) {
		this.perderVida = perderVida;
	}

}
