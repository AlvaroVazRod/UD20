package com.ejercicios.ud20.UD20;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejercicio2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JButton btn1;
	private JButton btn2;
	private JPanel panel;

	public Ejercicio2() {
		etiqueta1 = new JLabel("Boton1: 0 veces");
		etiqueta2 = new JLabel("Boton 2: 0 veces");
		btn1 = new JButton("Boton 1");
		btn2 = new JButton("Boton 2");
		panel = new JPanel();
// LOS COMPONENTES SE PRESENTAN EN EL PANEL EN EL ORDEN QUE SE AÑADEN
		panel.add(etiqueta1);
		panel.add(etiqueta2);
		panel.add(btn1);
		panel.add(btn2);
		add(panel);

		OyenteExternoAction oyenteBtn1 = new OyenteExternoAction(etiqueta1);
		OyenteExternoAction oyenteBtn2 = new OyenteExternoAction(etiqueta2);
		btn1.addActionListener(oyenteBtn1);
		btn2.addActionListener(oyenteBtn2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana con más interacción");
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Ejercicio2 ventana = new Ejercicio2();

	}

// LA CLASE OYENTE ES UNA CLASE PUBLICA EXTERNA A LA CLASE EN QUE SE GENERAN
// LOS EVENTOS
	public class OyenteExternoAction implements ActionListener {
		private int numVeces;
		private JLabel etiqueta;

		public OyenteExternoAction(JLabel etiqueta) {
			numVeces = 0;
			this.etiqueta = etiqueta;

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			numVeces++;
			JButton boton = (JButton) e.getSource();
			etiqueta.setText(boton.getText() + ": " + numVeces + " veces");
		}

	}
}