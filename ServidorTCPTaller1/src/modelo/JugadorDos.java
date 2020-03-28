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
	private boolean deslizarDerecha;
	private boolean deslizarIzquierda;

	public JugadorDos(float posX, float posY, int velocidad, int vida, PApplet app) {
		this.app = app;
		this.imagen = app.loadImage("../data/rocky.png");
		this.posX = posX;
		this.posY = posY;
		this.velocidad = velocidad;
		this.vida = vida;
		this.perderVida = true;
		this.deslizarDerecha = false;
		this.deslizarIzquierda = false;
	}

	public void pintar() {
		app.imageMode(app.CENTER);
		app.image(this.imagen, this.posX, this.posY, 226, 147);
		if (posX<90 ) {
			posX=90;
		}
		if (posX> 1093) {
			posX=1093;
		}

	}

	public void moverDerecha() {
		this.posX += this.velocidad;
		this.deslizarDerecha = true;
		this.deslizarIzquierda = false;
	}

	public void moverIzquierda() {
		this.posX -= this.velocidad;
		this.deslizarDerecha = false;
		this.deslizarIzquierda = true;
	}

	public void moverDerechaDeslizar() {
		if (this.deslizarDerecha) {
			this.posX += 226;
			this.deslizarDerecha = false;
		}
	}

	public void moverIzquierdaDeslizar() {
		if (this.deslizarIzquierda) {
			this.posX -= 226;
			this.deslizarIzquierda = false;
		}
	}

	public void restarVida() {
		this.vida--;
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
