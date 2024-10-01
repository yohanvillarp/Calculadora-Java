package controller;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Pantalla;

public class Events {
	public static ActionListener eventPressButton() {
		//logica de botones
		ActionListener logicaButton = (e) ->{
			JButton btn = (JButton)e.getSource();
			Pantalla.getInstance().addNumberOrSigno(btn.getText());
		};
		return logicaButton;
	}
	public static ActionListener eventDelete() {
		ActionListener delete = (e) ->
			Pantalla.getInstance().deleteAll();
		return delete;
	}
	public static ActionListener eventDeleteLast() {
		ActionListener delete = (e) ->
			Pantalla.getInstance().removeLastCharacter();
		return delete;
	}
}
