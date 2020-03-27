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

	private ArrayList<Meteoro> meteoritos;

	public Logica(PApplet app) {
		this.app = app;
		pantallaInicio = new PantallaInicial(app);
		pantallaInstrucciones = new PantallaInstrucciones(app);
		pantallaJuego = new PantallaJuego(app);
		pantallaResumen = new PantallaResumen(app);
		jugadorUno = new JugadorUno(132, 586, 3, 3, app);
		jugadorDos = new JugadorDos(800, 586, 2, 3, app);

		vidasJ1 = new ArrayList<Vida>();
		vidasJ2 = new ArrayList<Vida>();

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
		

			// Agregar vidas al arraylist
			for (int i = 0; i < 3; i++) {
				vidasJ1.add(new Vida(728 + (40 * i), 61, true, app));
				vidasJ2.add(new Vida(1065 + (40 * i), 61, true, app));
				vidasJ1.get(i).pintar();
				vidasJ2.get(i).pintar();
			}

			// Mostrar vidas jugador 1
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

			// Mostrar vida jugador 2
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

			perderVida();

			break;

		case 3:
			this.pantallaResumen.pintarPantalla();

			break;

		default:
			break;
		}

	}
	public void moverPersonajeUno() {
	
		jugadorUno.mover();
		
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

	public void perderVida() {
		for (int i = 0; i < meteoritos.size(); i++) {
			float meteoritoX = meteoritos.get(i).getPosX();
			float meteoritoY = meteoritos.get(i).getPosY();
			float jugadorUnox = jugadorUno.getPosX();
			float jugadorUnoy = jugadorUno.getPosY();
			float jugadorDosx = jugadorDos.getPosX();
			float jugadorDosy = jugadorDos.getPosY();
			
			if (meteoritoX >= jugadorUnox - 113 && meteoritoX <= jugadorUnox + 113 && meteoritoY >= jugadorUnoy - 73.5
					&& meteoritoY <= jugadorUnoy + 73.5 && jugadorUno.isPerderVida()) {
				jugadorUno.restarVida();
				jugadorUno.setPerderVida(false);
			}
			
			if (meteoritoX >= jugadorDosx - 113 && meteoritoX <= jugadorDosx + 113 && meteoritoY >= jugadorDosy - 73.5
					&& meteoritoY <= jugadorDosy + 73.5 && jugadorDos.isPerderVida()) {
				jugadorDos.restarVida();
				jugadorDos.setPerderVida(false);
			}
		}

		if (!jugadorUno.isPerderVida() && app.frameCount % 120 == 0) {
			jugadorUno.setPerderVida(true);
		}
		
		if (!jugadorDos.isPerderVida() && app.frameCount % 120 == 0) {
			jugadorDos.setPerderVida(true);
		}

	}

}
