package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Pantalla extends JPanel{
	
	//campos
	private final int HEIGHT = 100;
	private final int WIDTH_FIELD = 370;
	
	private JTextField displayField;
	
	//singleton
	private static Pantalla instance = new Pantalla();
	public static Pantalla getInstance() {
		return instance;
	}
	private Pantalla() {
		config();
		configDisplayField();
	}
	private void config() {
		//prueba de color
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(0, HEIGHT));
	}
	private void configDisplayField() {
		displayField = new JTextField("0");
		displayField.setPreferredSize(new Dimension(WIDTH_FIELD, HEIGHT-10));
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		displayField.setFont(new Font("Segoe UI", Font.BOLD, 40));
		PlainDocument doc = (PlainDocument) displayField.getDocument();
		doc.setDocumentFilter(new PrintableFilter());
		add(displayField);
	}
	public void addNumber(String number) {
		displayField.setText(displayField.getText()+number);
	}
}
