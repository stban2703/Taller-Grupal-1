package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Meteoro {
	private PApplet app;
	private float posX;
	private float posY;
	private int velocidad;
	private PImage imagen;
	
	public Meteoro(float posX, float posY, int velocidad, PImage imagen ,PApplet app) {
		this.app=app;
	}
	public void pintar() {
		
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
	public PImage getImagen() {
		return imagen;
	}
	public void setImagen(PImage imagen) {
		this.imagen = imagen;
	}

	
	
}
