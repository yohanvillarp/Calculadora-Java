package controller;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Pantalla;

public class Events {
	public static ActionListener eventPressButton() {
		//logica de botones
		ActionListener logicaButton = (e) ->{
			JButton btn = (JButton)e.getSource();
			Pantalla.getInstance().addNumber(btn.getText());
		};
		return logicaButton;
	}
}
