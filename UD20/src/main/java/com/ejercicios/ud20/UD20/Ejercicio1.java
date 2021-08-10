package com.ejercicios.ud20.UD20;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio1 extends JFrame {
	private static final long serialVersionUID = 1L;

public Ejercicio1() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JLabel etiqueta = new JLabel("Ventana de ejemplo");
add(etiqueta);
setResizable(true);
pack();
setVisible(true);
}

public static void main(String args[]) {
	Ejercicio1 ejemplo = new Ejercicio1();
}

}