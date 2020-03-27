package vista;

import comm.ComunicacionTCP;
import modelo.Logica;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}

	private ComunicacionTCP comm;
	private Logica logica;

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		logica = new Logica(this);
		logica.conectar();

	}

	public void draw() {
		background(255);
		logica.pintarPantallas();
	}

	public void mousePressed() {
		System.out.print(mouseX + " " + mouseY + "\n");
		logica.evaluarPantallas();

	}
	public void keyPressed() {
		logica.moverPersonajeUno();

	}
	
}
