package vista;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	//campos
	private static int WIDTH = 400;
	private static int HEIGHT = 600;
	
	//singleton
	private static Ventana instance = new Ventana();
	public static Ventana getInstance() {
		return instance;
	}
	private Ventana() {
		config();
		centerFrame();
		addPaneles();
	}
	
	private void config() {
		setLayout(new BorderLayout());
		setSize(WIDTH, HEIGHT);
		setTitle("Calculadora");
	}
	//centrando Frame
	private void centerFrame() {
		int xCenter = Toolkit.getDefaultToolkit().getScreenSize().width/2;
		int yCenter = Toolkit.getDefaultToolkit().getScreenSize().height/2;
		xCenter -= WIDTH/2; yCenter -= HEIGHT/2;
		setLocation(xCenter, yCenter);
	}
	//añadiendo paneles
	private void addPaneles() {
		add(Pantalla.getInstance(),BorderLayout.NORTH);
		add(Teclado.getInstance(),BorderLayout.CENTER);
	}
}
