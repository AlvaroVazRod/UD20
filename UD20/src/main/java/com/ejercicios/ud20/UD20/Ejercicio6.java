package com.ejercicios.ud20.UD20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio6 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField campoAltura;
	private JTextField campoPeso;
	private JTextField campoIMC;

public Ejercicio6() {
JLabel etiquetaAltura = new JLabel("Altura (metros)");
JLabel etiquetaPeso = new JLabel("Peso(kg)");
JLabel etiquetaIMC = new JLabel("IMC");
JButton calcular = new JButton("Calcular IMC");
campoAltura = new JTextField(6);
campoPeso = new JTextField(6);
campoIMC = new JTextField(6);
campoIMC.setEditable(false);
JPanel panel = new JPanel();

panel.add(etiquetaAltura);
panel.add(campoAltura);
panel.add(etiquetaPeso);
panel.add(campoPeso);
panel.add(calcular);
panel.add(etiquetaIMC);
panel.add(campoIMC);
add(panel);
// AL OYENTE DE CALCULAR SE LE ASOCIA UN OYENTE DE ACCIONES MEDIANTE
// CLASE ANONIMA
calcular.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
Double peso = Double.parseDouble(campoPeso.getText());
Double altura = Double.parseDouble(campoAltura.getText());
Double imc = peso / (altura * altura);
// DAMOS FORMATO AL RESULTADO
String resultado = String.format("%6.2f", imc);
campoIMC.setText(resultado);

}
});

}

	public static void main(String[] args) {

		Ejercicio6 ventana = new Ejercicio6();
		ventana.setTitle("Indice de Msasa Corporal");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(400, 200);
		ventana.setVisible(true);

	}

}