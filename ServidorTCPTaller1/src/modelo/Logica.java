package modelo;

import java.util.ArrayList;
import processing.core.PApplet;
import vista.PantallaInicial;
import vista.PantallaInstrucciones;
import vista.PantallaJuego;
import vista.PantallaResumen;

public class Logica {

	private PApplet app;
	private int pantalla = 0;
	private PantallaInicial pantallaInicio;
	private PantallaInstrucciones pantallaInstrucciones;
	private PantallaJuego pantallaJuego;
	private PantallaResumen pantallaResumen;
	private JugadorUno jugadorUno;
	private JugadorDos jugadorDos;
	
	private ArrayList<Vida> vidasJ1;
	private ArrayList<Vida> vidasJ2;

	///////
	private ArrayList<Meteoro> meteoritos;

	public Logica(PApplet app) {
		this.app = app;
		pantallaInicio = new PantallaInicial(app);
		pantallaInstrucciones = new PantallaInstrucciones(app);
		pantallaJuego = new PantallaJuego(app);
		pantallaResumen = new PantallaResumen(app);
		jugadorUno = new JugadorUno(457, 586, 2, 3, app);
		jugadorDos = new JugadorDos(800, 586, 2, 3, app);
		
		vidasJ1 = new ArrayList<Vida>();
		vidasJ2 = new ArrayList<Vida>();
		
		///////////
		meteoritos = new ArrayList<Meteoro>();

	}

	public void pintarPantallas() {
		switch (pantalla) {

		case 0:

			this.pantallaInicio.pintarPantalla();
			if (app.mouseX >= 475 && app.mouseX <= 692 && app.mouseY >= 204 && app.mouseY <= 418) {
				app.cursor(app.HAND);
			} else {
				app.cursor(app.ARROW);
			}

			break;

		case 1:
			this.pantallaInstrucciones.pintarPantalla();

			if (app.mouseX >= 997 && app.mouseX <= 1054 && app.mouseY >= 587 && app.mouseY <= 635) {
				app.cursor(app.HAND);
			} else {
				app.cursor(app.ARROW);
			}

			break;

		case 2:

			this.pantallaJuego.pintarPantalla();
			this.pantallaJuego.pintarTiempo();
			this.jugadorUno.pintar();
			this.jugadorDos.pintar();

			for(int i = 0; i < 3; i++) {
				vidasJ1.add(new Vida(728 + (40 * i), 61, true, app));
				vidasJ2.add(new Vida(1065 + (40 * i), 61, true, app));
				vidasJ1.get(i).pintar();
				vidasJ2.get(i).pintar();
			}
			
			//Mostrar vidas jugador 1
			switch (jugadorUno.getVida()) {
			case 0:
				vidasJ1.get(0).setMostrarVida(false);
				vidasJ1.get(1).setMostrarVida(false);
				vidasJ1.get(2).setMostrarVida(false);
				break;
			case 1:
				vidasJ1.get(1).setMostrarVida(false);
				vidasJ1.get(2).setMostrarVida(false);
				break;

			case 2:
				vidasJ1.get(2).setMostrarVida(false);
				break;
			}
			
			//Mostrar vida jugador 2
			switch (jugadorDos.getVida()) {
			case 0:
				vidasJ2.get(0).setMostrarVida(false);
				vidasJ2.get(1).setMostrarVida(false);
				vidasJ2.get(2).setMostrarVida(false);
				break;
			case 1:
				vidasJ2.get(1).setMostrarVida(false);
				vidasJ2.get(2).setMostrarVida(false);
				break;

			case 2:
				vidasJ2.get(2).setMostrarVida(false);
				break;
			}

			
			// Agregar meteoros
			if (app.frameCount % 40 == 0) {
				meteoritos.add(new Meteoro((int) app.random(50, 1100), -10, app));
			}
			
			for (int i = 0; i < meteoritos.size(); i++) {
				meteoritos.get(i).pintar();
				meteoritos.get(i).mover();
			}

			break;

		case 3:
			this.pantallaResumen.pintarPantalla();

			break;

		default:
			break;
		}
	}
	
	public void KeyPressed() {
		
		
	}


	public void evaluarPantallas() {
		switch (pantalla) {

		case 0:
			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE JUGAR
			if (app.mouseX >= 475 && app.mouseX <= 692 && app.mouseY >= 204 && app.mouseY <= 418) {
				app.cursor(app.HAND);
				this.pantalla = 1;
			}

			break;

		case 1:

			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE SIGUIENTE EN LA PANTALLA INSTRUCCIONES
			if (app.mouseX >= 997 && app.mouseX <= 1054 && app.mouseY >= 587 && app.mouseY <= 635) {
				app.cursor(app.HAND);
				this.pantalla = 2;
			}

			break;

		case 2:

			break;

		case 3:

			break;

		default:
			break;
		}

	}

}
