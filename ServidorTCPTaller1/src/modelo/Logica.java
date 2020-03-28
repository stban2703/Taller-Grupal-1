package modelo;

import java.util.ArrayList;

import comm.ComunicacionTCP;
import comm.ComunicacionTCP.OnMessageListener;
import processing.core.PApplet;
import processing.core.PImage;
import vista.PantallaInicial;
import vista.PantallaInstrucciones;
import vista.PantallaJuego;
import vista.PantallaResumen;

public class Logica implements OnMessageListener {

	private PApplet app;
	private int pantalla = 0;
	private PantallaInicial pantallaInicio;
	private PantallaInstrucciones pantallaInstrucciones;
	private PantallaJuego pantallaJuego;
	private PantallaResumen pantallaResumen;
	private JugadorUno jugadorUno;
	public JugadorDos jugadorDos;
	private ComunicacionTCP comm;
	private int vidasU, vidasD;
	//private PImage perdedor, ganador;
	public JugadorDos getJugadorDos() {
		return jugadorDos;
	}

	public void setJugadorDos(JugadorDos jugadorDos) {
		this.jugadorDos = jugadorDos;
	}

	private ArrayList<Vida> vidasJ1;
	private ArrayList<Vida> vidasJ2;

	private ArrayList<Meteoro> meteoritos;

	public Logica(PApplet app) {
		this.app = app;
		pantallaInicio = new PantallaInicial(app);
		pantallaInstrucciones = new PantallaInstrucciones(app);
		pantallaJuego = new PantallaJuego(app);
		pantallaResumen = new PantallaResumen(app);
		jugadorUno = new JugadorUno(132, 586, 8, 3, app);
		jugadorDos = new JugadorDos(800, 586, 8, 3, app);

		vidasJ1 = new ArrayList<Vida>();
		vidasJ2 = new ArrayList<Vida>();

		meteoritos = new ArrayList<Meteoro>();

		comm = new ComunicacionTCP();
		comm.setObserver(this);
		
		vidasU=3;
		vidasD=3;
	}
	
	public void conectar() {
		comm.esperarConexion();
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
			
			System.out.println(vidasU+" "+vidasD);

			break;

		case 3:
			this.pantallaResumen.pintarPantalla();
	
			
			//PIERDE JUGADOR 1
			if(vidasU==0 &&vidasD!=0) {
			this.pantallaResumen.pintarPerdedorUno();
			}
			//GANA JUGADOR 2
			if(vidasU!=0 &&vidasD==0) {
			this.pantallaResumen.pintarGanadorUno();
			}
			
			//PIERDE JUGADOR 2
			if(vidasD==0 &&vidasU!=0) {
			this.pantallaResumen.pintarPerdedorDos();
			}
			//GANA JUGADOR 2
			if(vidasD!=0 &&vidasU==0) {
			this.pantallaResumen.pintarGanadorDos();
			}

			if (app.mouseX >= 774 && app.mouseX <= 876 && app.mouseY >= 325 && app.mouseY <= 434) {
				app.cursor(app.HAND);
			} else {
				app.cursor(app.ARROW);
			}
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
			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE SIGUIENTE EN LA PANTALLA RESUMEN, LA OPCIÓN DE REINICIAR
			if (app.mouseX >= 774 && app.mouseX <= 876 && app.mouseY >= 325 && app.mouseY <= 434) {
				app.cursor(app.HAND);
				//this.pantalla = 0;
			} 
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
				vidasU--;
			}

			if (meteoritoX >= jugadorDosx - 113 && meteoritoX <= jugadorDosx + 113 && meteoritoY >= jugadorDosy - 73.5
					&& meteoritoY <= jugadorDosy + 73.5 && jugadorDos.isPerderVida()) {
				jugadorDos.restarVida();
				jugadorDos.setPerderVida(false);
				vidasD--;
			}
		}

		if (!jugadorUno.isPerderVida() && app.frameCount % 70 == 0) {
			jugadorUno.setPerderVida(true);
			
		}

		if (!jugadorDos.isPerderVida() && app.frameCount % 70 == 0) {
			jugadorDos.setPerderVida(true);
		
		}
		if(vidasU<0) {
			vidasU=0;
		}
		if(vidasD<0) {
			vidasD=0;
		}
		if(vidasU==0 || vidasD==0) {
			
			this.pantalla = 3;
		}

	}

	@Override
	public void onMessage(String mensaje) {
		switch (mensaje) {
		case "DERECHA":
			jugadorDos.moverDerecha();
			System.out.println("derrrr" + "/" + jugadorDos.getPosX());
			break;
		case "IZQUIERDA":
			jugadorDos.moverIzquierda();
			System.out.println("izzzzz");
			break;

		case "DESLIZAR":
			jugadorDos.moverIzquierdaDeslizar();
			jugadorDos.moverDerechaDeslizar();
			System.out.println("dessssss");
			break;
		default:
			break;
		}
	}

}
