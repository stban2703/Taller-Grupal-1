package vista;

import comm.ComunicacionTCP;
import modelo.Logica;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}

	ComunicacionTCP comm;
	Logica logica;

	public void settings() {
		size(1200, 700);
	}

	public void setup() {

		comm = new ComunicacionTCP(this);
		comm.esperarConexion();
		logica = new Logica(this);

	}

	public void draw() {
		background(255);
		logica.pintarPantallas();
	}

	public void mousePressed() {
		System.out.print(mouseX + " " + mouseY + "\n");
		logica.evaluarPantallas();

	}
	public void KeyPressed() {
		
		switch (keyCode) {
		case RIGHT:
			
			break;
	    case LEFT:
			
			break;	
         case 32: //BARRA ESPACIADORA
			
			break;	
	

		default:
			break;
		}
		 
		 
	}
}
