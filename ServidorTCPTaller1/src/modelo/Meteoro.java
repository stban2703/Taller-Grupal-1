package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Meteoro implements Runnable {
	private PApplet app;
	private float posX;
	private float posY;
	private int velocidad;
	private PImage imagen;
	private boolean isAlive=true;
	
	public Meteoro(float posX, float posY,PImage imagen ,int velocidad, PApplet app) {
		this.app=app;
		this.posY=0;
		this.posX = (int) app.random(50, 1100);
		this.velocidad=2;
		this.imagen = app.loadImage("../data/meteorito.png");
		new Thread(this).start();
	}
	public void pintar() {
		app.imageMode(app.CENTER);
		
		app.image(this.imagen, posX, posY, 71, 72);
	}
	public void run () {
		//mover
		
			while(isAlive) {
				mover();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}
	public void mover() {
		posX+=velocidad;
		posY+=velocidad;
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
