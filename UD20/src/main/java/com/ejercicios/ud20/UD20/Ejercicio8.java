package com.ejercicios.ud20.UD20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Ejercicio8 extends JPanel {
	private static final long serialVersionUID = 1L;
	private final double TASA_CAMBIO = 166.386;
	private double cambioEfectivo = TASA_CAMBIO;
	private JTextField campoCantidad;
	private JTextField campoResultado;

	public Ejercicio8() {
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
// PULSANDO ALT + e SE ACTIVA ESTE BOTON. SI LA LETRA APARECE EN EL
// TEXTO DEL BOTON, SU PRIMERA OCURRENCIA
// APARECERA SUBRAYADA
		moneda.setMnemonic(KeyEvent.VK_E);
		add(moneda);
		moneda.addActionListener(new OyenteBotonConmutador());
		JButton cambio = new JButton("Cambiar");
		cambio.setMnemonic(KeyEvent.VK_C);
		;
		add(cambio);
		cambio.addActionListener(new OyenteCambio());
		JButton borrar = new JButton("Borrar");
		borrar.setMnemonic(KeyEvent.VK_B);
		add(borrar);
// SE AÑADE UN OYENTE ANONIMO QUE INVOCA AL METODO PRIVADO DE BORRADO DE
// DATOS
		borrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				borrarDatos();
			}
		});

	}

	private void borrarDatos() {
		campoCantidad.setText("0.0");
		campoResultado.setText("0.0");

	}

// OYENTE DE ACCIONES QUE OBTIENE LA CANTIDAD A CAMBIAR,
// REALIZA LA CONVERSION Y MUESTRA EL RESULTADO
	class OyenteCambio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double dinero = 0.0;
// PROTEGEMOS LA LECTURA DE DATOS PARA EVITAR QUE UN ERROR EN EL
// FORMATO PROVOQUE UNA TERMINACION ANOMALA
			try {
				dinero = Double.parseDouble(campoCantidad.getText());
			} catch (NumberFormatException ex) {
// SE CREA UNA VENTANA EMERGENTE CON EL MENSAJE DE ERROR
				JOptionPane.showMessageDialog(Ejercicio8.this,
						"Solo se pueden introducir digitos y el punto decimal”, “Error en el formato numérico");
				borrarDatos();
			}
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
		Ejercicio8 calc = new Ejercicio8();
		ventana.add(calc);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(400, 200);
		ventana.setVisible(true);

	}

}