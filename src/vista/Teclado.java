package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Events;

public class Teclado extends JPanel{
	
	//campos
	private JButton buttons[];
	private final int NUM_BUTTONS = ROWS * COLUMNS;
	private static JPanel contenedor;
	private static int ROWS = 4;
	private static int COLUMNS = 5;
	private static final String[] caracteres = {"7","8","9","DEL","AC","4","5","6","x","/","1","2","3","+","-","0",",","x10^x","Ans","="};
	
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
		setLayout(new GridLayout(ROWS,COLUMNS));
		setPreferredSize(new Dimension(370, 450));
		addButtons();
	}
	
	private void addButtons() {
		buttons = new JButton[caracteres.length];
		
		int cont = 0;
		
		for(JButton btn : buttons) {
			btn = new JButton(caracteres[cont]);
			if(!caracteres[cont].equals("DEL") && !caracteres[cont].equals("AC") && !caracteres[cont].equals("Ans") && !caracteres[cont].equals("x10^x"))
				btn.addActionListener(Events.eventPressButton());
			else {
				if(caracteres[cont].equals("AC")) btn.addActionListener(Events.eventDelete());
				if(caracteres[cont].equals("DEL")) btn.addActionListener(Events.eventDeleteLast());
			}
			btn.setPreferredSize(new Dimension(10,10));
			add(btn);
			cont++;
		}
			
	}
	
	
}
