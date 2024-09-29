package vista;

import java.awt.Color;

import javax.swing.JPanel;

public class Teclado extends JPanel{
	
	//singleton
	private static Teclado instance = new Teclado();
	public static Teclado getInstance() {
		return instance;
	}
	private Teclado() {
		//prueba de color
		setBackground(Color.CYAN);
	}
}
