package comm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Logica;
import processing.core.PApplet;
import vista.Main;

public class ComunicacionTCP extends Thread {
	private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;
    String line;
    Main main;
    Logica logica;
    private PApplet app;
    public ComunicacionTCP(Main main) {
		this.main=main;
	}
    public void run() {
		try {
			ServerSocket server=new ServerSocket(5000);
			System.out.println("ESPERANDO");
			this.socket=server.accept();
			System.out.println("CONEXIÓN ACEPTADA");
			
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			this.reader=new BufferedReader(isr);
			
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			this.writer=new BufferedWriter(osw);
			
			while(true) {
				recibirMensaje();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void esperarConexion() {
		this.start();
	}
	
	public void mandarMensaje(String mensaje) {
		new Thread(
				()->{
					try {
						writer.write(mensaje+"\n");
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			).start();
	}
	public void recibirMensaje() throws IOException {
		line=reader.readLine();
		System.out.println(line);
		if(line.startsWith("DERECHA")) {
		
			
		}
		
		}
	
	
	
	
	
	public void cerrarConexion() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
