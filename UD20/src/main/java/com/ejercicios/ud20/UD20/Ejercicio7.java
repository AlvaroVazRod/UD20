package com.ejercicios.ud20.UD20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Ejercicio7 extends JPanel {
	private static final long serialVersionUID = 1L;
	private final double TASA_CAMBIO = 166.386;
	private double cambioEfectivo = TASA_CAMBIO;
	private JTextField campoCantidad;
	private JTextField campoResultado;

	public Ejercicio7() {
		add(new JLabel("Cantidad a convertir"));
		campoCantidad = new JTextField("0.0", 6);
		add(campoCantidad);
		add(new JLabel("Resultado"));
		campoResultado = new JTextField("0.0", 6);
		campoResultado.setEditable(false);
		add(campoResultado);
// EL BOTON CONMUTADOR SE FIJA QUE INICIALMENTE NO ESTE SELECCIONADO.
// LUEGO SE AÑADE AL PANEL Y SE LE ASOCIA UN OYENTE DE ACCIONES
		JToggleButton moneda = new JToggleButton("Euros a ptas", false);
		add(moneda);
		moneda.addActionListener(new OyenteBotonConmutador());
		JButton cambio = new JButton("Cambiar");
		add(cambio);
		cambio.addActionListener(new OyenteCambio());
	}

// OYENTE DE ACCIONES QUE OBTIENE LA CANTIDAD A CAMBIAR,
// REALIZA LA CONVERSION Y MUESTRA EL RESULTADO
	class OyenteCambio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double dinero = Double.parseDouble(campoCantidad.getText());
			dinero = dinero * cambioEfectivo;
			String cadena = String.format("%6.2f", dinero);
			campoResultado.setText(cadena);
		}

	}

// OYENTE DEL BOTON CONMUTADOR, QUE CAMBIA LA ETIQUETA Y CALCULA EL CAMBIO
// EFECTIVO
	class OyenteBotonConmutador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
// ES NECESARIO OBTENER EL ORIGEN DEL EVENTO
			JToggleButton boton = (JToggleButton) e.getSource();
			if (boton.isSelected()) {
				boton.setText("Ptas a Euros");
				cambioEfectivo = 1 / TASA_CAMBIO;
			} else {
				boton.setText("Euros a ptas");
				cambioEfectivo = TASA_CAMBIO;
			}
		}

	}

	public static void main(String[] args) {
// SE CREA LA VENTANA PRINCIPAL DE LA APLICACIÓN
		JFrame ventana = new JFrame("Calculadora cambio de monedas");
// SE CREA OBJETO DE TIPO CALCULADORA Y SE AÑADE A LA VENTANA PRINCIPAL
		Ejercicio7 calc = new Ejercicio7();
		ventana.add(calc);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(400, 200);
		ventana.setVisible(true);

	}

}