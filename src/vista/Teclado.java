package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Teclado extends JPanel{
	
	//campos
	private JButton buttons[];
	private final int NUM_BUTTONS = 9;
	private static JPanel contenedor;
	
	//contenedor de teclado
	private static JPanel instance = new JPanel();
	public static JPanel getInstance() {
		contenedor = new JPanel();
		contenedor.setBackground(Color.YELLOW);
		contenedor.add(new Teclado());
		return contenedor;
	}
	
	
	private Teclado() {
		config();
	}
	private void config() {
		setLayout(new GridLayout(3,3));
		setPreferredSize(new Dimension(370, 450));
		addButtons();
	}
	
	private void addButtons() {
		buttons = new JButton[NUM_BUTTONS];
		int caracter = 7; int cont = 0;
		
		while(cont!=9) {
			buttons[cont] = new JButton(""+caracter);
			
			buttons[cont].addActionListener(eventPressButton());
			add(buttons[cont]);
			if(caracter == 9) caracter = 3;
			else if(caracter == 6) caracter = 0;
			cont++; caracter++;
		}
	}
	
	private ActionListener eventPressButton() {
		//logica de botones
		ActionListener logicaButton = (e) ->{
			JButton btn = (JButton)e.getSource();
			Pantalla.getInstance().addNumber(btn.getText());
		};
		return logicaButton;
	}
}
