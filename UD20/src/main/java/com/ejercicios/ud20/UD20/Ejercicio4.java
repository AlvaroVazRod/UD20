package com.ejercicios.ud20.UD20;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Ejercicio4 extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	private JTextArea areaTexto;
	private JLabel etiqueta;
	private JPanel panel;
	private final String FIN = "\n";

	public Ejercicio4() {
		etiqueta = new JLabel("Eventos");
		areaTexto = new JTextArea(10, 50); // SE CREA UN AREA DE TEXTO CON 10
// FILAS Y 50 COLUMNAS
		areaTexto.setText("Texto inicial");
		panel = new JPanel();

		panel.add(etiqueta);
		panel.add(areaTexto);
		add(panel);
// CON THIS ES LA PROPIA VENTANA LA QUE SE REGISTRA A SI MISMA COMO
// OYENTE DE EVENTOS VENTANA
		addWindowListener(this);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Ventana oyente");
		setVisible(true);
		pack();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		areaTexto.append(FIN + "Ventana activada");

	}

	@Override
	public void windowClosed(WindowEvent e) {
		areaTexto.append(FIN + "Ventana cerrada");

	}

	@Override
	public void windowClosing(WindowEvent e) {
		areaTexto.append(FIN + "Ventana cerrándose");

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		areaTexto.append(FIN + "Ventana desactivada");

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		areaTexto.append(FIN + "Ventana desiconizada");

	}

	@Override
	public void windowIconified(WindowEvent e) {
		areaTexto.append(FIN + "Ventana iconizada");

	}

	@Override
	public void windowOpened(WindowEvent e) {
		areaTexto.append(FIN + "Ventana abierta");

	}

	public static void main(String[] args) {
		Ejercicio4 ventana = new Ejercicio4();

	}

}