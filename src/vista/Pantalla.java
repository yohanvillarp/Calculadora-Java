package vista;

import java.awt.Color;

import javax.swing.JPanel;

public class Pantalla extends JPanel{
	
	//singleton
	private static Pantalla instance = new Pantalla();
	public static Pantalla getInstance() {
		return instance;
	}
	private Pantalla() {
		//prueba de color
		setBackground(Color.YELLOW);
	}
}
