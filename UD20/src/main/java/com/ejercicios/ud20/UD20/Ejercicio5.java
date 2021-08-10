package com.ejercicios.ud20.UD20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

public class Ejercicio5 extends JFrame {

	private JTextArea areaTexto;

	public Ejercicio5() {
		JButton boton = new JButton("limpiar");
		areaTexto = new JTextArea(15, 60);
		JPanel panel = new JPanel();
		panel.add(boton);
		panel.add(areaTexto);
		add(panel);
// SE CREA UN OYENTE RATON QUE SE ASOCIA AL AREA DE TEXTO
		ActionListener oyenteBoton = new OyenteAccion();
		boton.addActionListener(oyenteBoton);
		MouseListener oyenteRaton = new OyenteRaton();
		areaTexto.addMouseListener(oyenteRaton);

	}

	class OyenteRaton extends MouseInputAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			areaTexto.append("Has hecho clic en \n");
			areaTexto.append("Posicion X:" + e.getX());
			areaTexto.append("Posicion Y:" + e.getY());

		}

		@SuppressWarnings("deprecation")
		@Override
		public void mousePressed(MouseEvent e) {
// SE TRATA DE UNA OPERACION CON BITS. SI OS PARECE RARO, MIRAD LA
// DOCUMENTACIÓN
			if (((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)) {
				areaTexto.append("Pulsado el botón derecho");
			}

			areaTexto.append("Se ha pulsado el botón del ratón");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			areaTexto.append("Se ha soltado el botón del ratón");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			areaTexto.append("El ratón ha entrado en el componente");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			areaTexto.append("El ratón ha salido del componente");
		}
	}

// OYENTE DE ACCIONES QUE LIMPIA EL CONTENIDO DEL TEXTO
	class OyenteAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			areaTexto.setText("");

		}

	}

	public static void main(String[] args) {
		Ejercicio5 ventana = new Ejercicio5();
		ventana.setTitle("Todos los eventos del ratón");
		ventana.pack();
		ventana.setVisible(true);

	}

}