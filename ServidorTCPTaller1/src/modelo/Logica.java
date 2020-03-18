package modelo;

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
	
	public Logica(PApplet app) {
		this.app=app;
		pantallaInicio = new PantallaInicial(app);
		pantallaInstrucciones = new PantallaInstrucciones(app);
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
		
			
			break;

		case 2:
			
			this.pantallaJuego.pintarPantalla();
			break;

		case 3:
			this.pantallaResumen.pintarPantalla();

			break;
		}
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
