package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class JugadorUno {
	private PApplet app;
	private float posX;
	private float posY;
	private int velocidad;
	private int vida;
	private PImage imagen;
	private boolean deslizarDerecha;
	private boolean deslizarIzquierda;
	private boolean perderVida;

	public JugadorUno(float posX, float posY, int velocidad, int vida, PApplet app) {
		this.app = app;
		this.imagen = app.loadImage("../data/max.png");
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
	}

	public void mover() {
		if (app.keyCode == app.RIGHT) {
			posX += velocidad;
			deslizarDerecha = true;
			deslizarIzquierda = false;
		}

		if (app.keyCode == app.LEFT) {
			posX -= velocidad;
			deslizarDerecha = false;
			deslizarIzquierda = true;
		}

		if (deslizarDerecha && app.keyCode == 32) {
			posX += 226;
			deslizarDerecha = false;
		}

		if (deslizarIzquierda && app.keyCode == 32) {
			posX -= 226;
			deslizarIzquierda = false;
		}
		//LIMITES DEL ÁREA
		if (posX<90 ) {
			posX=90;
		}
		if (posX> 1093) {
			posX=1093;
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

	public boolean isPerderVida() {
		return perderVida;
	}

	public void setPerderVida(boolean perderVida) {
		this.perderVida = perderVida;
	}

	public boolean isDeslizarDerecha() {
		return deslizarDerecha;
	}

	public void setDeslizarDerecha(boolean deslizarDerecha) {
		this.deslizarDerecha = deslizarDerecha;
	}

	public boolean isDeslizarIzquierda() {
		return deslizarIzquierda;
	}

	public void setDeslizarIzquierda(boolean deslizarIzquierda) {
		this.deslizarIzquierda = deslizarIzquierda;
	}

}
