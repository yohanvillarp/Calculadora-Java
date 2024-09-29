package vista;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

import org.w3c.dom.Text;

/*
 * Filtración numérica tomada de stack overflow y modificada con fines especificos
 * https://stackoverflow.com/questions/11093326/restricting-jtextfield-input-to-integers
 */
class NumericFilter extends DocumentFilter {

// Método que se llama al intentar insertar texto en el documento
	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {

		// Obtiene el documento asociado al filtro
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();

		// Agrega el texto existente en el documento al StringBuilder
		sb.append(doc.getText(0, doc.getLength()));

		// Inserta el nuevo texto en la posición especificada
		sb.insert(offset, string);

		// Verifica si el texto resultante es un número válido
		if (test(sb.toString())) {
			// Si es válido, realiza la inserción en el documento
			super.insertString(fb, offset, string, attr);
		} else {
			// Si no es válido, aquí podrías advertir al usuario
		}
	}

// Método privado que verifica si un texto puede convertirse a un entero
	private boolean test(String text) {
		try {
			// Intenta convertir el texto a un entero
			Integer.parseInt(text);
			return true; // Retorna verdadero si no lanza una excepción
		} catch (NumberFormatException e) {
			return false; // Retorna falso si lanza una excepción
		}
	}

// Método que se llama al intentar reemplazar texto en el documento
	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {

		// Obtiene el documento asociado al filtro
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();

		// Agrega el texto existente en el documento al StringBuilder
		sb.append(doc.getText(0, doc.getLength()));

		// Reemplaza el texto en la posición especificada
		sb.replace(offset, offset + length, text);

		// Verifica si el texto resultante es un número válido
		if (test(sb.toString())) {
			// Si es válido, realiza la sustitución en el documento
			super.replace(fb, offset, length, text, attrs);
		} else {
			// Si no es válido, aquí podrías advertir al usuario
		}
	}

// Método que se llama al intentar eliminar texto en el documento
	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {

		// Obtiene el documento asociado al filtro
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		boolean zeroNum = false;

		// Agrega el texto existente en el documento al StringBuilder
		sb.append(doc.getText(0, doc.getLength()));

		// Elimina el texto en la posición especificada
		sb.delete(offset, offset + length);
		System.out.println("Pos: "+offset+" "+offset+length);
		
		//caso especial - ningún caracter
		if(sb.length()==0)
			zeroNum = true;
			

		// Verifica si el texto resultante es un número válido
		if (test(sb.toString()) || zeroNum) {
			// Si es válido, realiza la eliminación en el documento
			super.remove(fb, offset, length);
			
			//insertando 0 en caso de que no haya ningún número
			if(zeroNum)
				super.insertString(fb, offset, "0", null);
		} else {
			// Si no es válido, aquí podrías advertir al usuario
		}
	}
}
