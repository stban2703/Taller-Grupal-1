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

	private Vida vidaUnoJ1;
	private Vida vidaDosJ1;
	private Vida vidaTresJ1;
	private Vida vidaUnoJ2;
	private Vida vidaDosJ2;
	private Vida vidaTresJ2;

	///////
	Meteoro meteoro;
	private ArrayList <Meteoro> meteoritos;

	public Logica(PApplet app) {
		this.app = app;
		pantallaInicio = new PantallaInicial(app);
		pantallaInstrucciones = new PantallaInstrucciones(app);
		pantallaJuego = new PantallaJuego(app);
		pantallaResumen = new PantallaResumen(app);
		jugadorUno = new JugadorUno(457, 586, 2, 3, app);
		jugadorDos = new JugadorDos(800, 586, 2, 3, app);

		vidaUnoJ1 = new Vida(728, 61, true, app);
		vidaDosJ1 = new Vida(768, 61, true, app);
		vidaTresJ1 = new Vida(808, 61, true, app);
		
		vidaUnoJ2 = new Vida(1056, 61, true, app);
		vidaDosJ2 = new Vida(1096, 61, true, app);
		vidaTresJ2 = new Vida(1136, 61, true, app);

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

			
			this.vidaUnoJ1.pintar();
			this.vidaDosJ1.pintar();
			this.vidaTresJ1.pintar();
			
			switch (jugadorUno.getVida()) {
			case 0:
				
				break;
			case 1:
				vidaDosJ1.setMostrarVida(false);
				break;
			
			case 2:
				vidaTresJ1.setMostrarVida(false);
				break;
			case 3:
				
				break;
			}
			
			
			//////
			for (int i = 0; i < meteoritos.size(); i++) {
				meteoritos.add(new Meteoro(meteoro.getPosX(),meteoro.getPosY(),meteoro.getImagen(), meteoro.getVelocidad(),app));
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


	public void evaluarPantallas() {
		switch (pantalla) {

		case 0:
			// EVALUACI�N �REA SENSIBLE DEL BOT�N DE JUGAR
			if (app.mouseX >= 475 && app.mouseX <= 692 && app.mouseY >= 204 && app.mouseY <= 418) {
				app.cursor(app.HAND);
				this.pantalla = 1;
			}

			break;

		case 1:

			// EVALUACI�N �REA SENSIBLE DEL BOT�N DE SIGUIENTE EN LA PANTALLA INSTRUCCIONES
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
