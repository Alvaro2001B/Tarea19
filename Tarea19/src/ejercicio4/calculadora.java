package ejercicio4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * TAREA 19 EJERCICIO 4
 * 
 * @author Alvaro Benitez Carmona
 *
 */
public class calculadora extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField operador1, operador2, resultado1;
	private JButton suma, resta, multi, div, exit, about;
	private JLabel text1, text2, text4;
	private JPanel operadores, operaciones, operaciones_arriba, operaciones_centro, operaciones_abajo, window, centro,
			vacio, south;

	public calculadora() {
		super("Calculadora");
		this.setLocation(490, 150);
		this.setSize(600, 500);
		this.setLayout(new BorderLayout(0, 70));

		// Inicializamos las variables
		operador1 = new JTextField("", 10);
		operador2 = new JTextField("", 10);
		resultado1 = new JTextField("", 10);
		suma = new JButton("SUMA");
		resta = new JButton("RESTA");
		multi = new JButton("MULTIPLICACION");
		div = new JButton("DIVISION");
		exit = new JButton("Salir");
		about = new JButton("Resultado");

		text1 = new JLabel("CALCULADORA");
		text2 = new JLabel("=");
		text4 = new JLabel("");

		// Inicializamos los JPanels
		operadores = new JPanel();
		operaciones = new JPanel();
		operaciones_arriba = new JPanel();
		operaciones_centro = new JPanel();
		operaciones_abajo = new JPanel();
		window = new JPanel();
		centro = new JPanel();
		vacio = new JPanel();
		south = new JPanel();

		// Indicamos los layouts
		window.setLayout(new BorderLayout());
		operadores.setLayout(new FlowLayout());
		operaciones.setLayout(new BorderLayout());
		operaciones_arriba.setLayout(new FlowLayout());
		operaciones_centro.setLayout(new FlowLayout());
		operaciones_abajo.setLayout(new FlowLayout());
		south.setLayout(new FlowLayout());
		centro.setLayout(getLayout());

		// ADD de las variables
		operadores.add(operador1);
		operadores.add(text4);
		operadores.add(operador2);
		operadores.add(text2);
		operadores.add(resultado1);
		operadores.setBorder(new EmptyBorder(30, 20, 0, 0));
		text1.setBorder(new EmptyBorder(60, 250, 0, 0));
		suma.setSize(multi.getSize());
		resta.setSize(multi.getSize());
		div.setSize(multi.getSize());
		operaciones_arriba.add(suma);
		operaciones_arriba.add(resta);
		operaciones_abajo.add(multi);
		operaciones_abajo.add(div);
		operaciones.add(operaciones_arriba, BorderLayout.NORTH);
		operaciones.add(operaciones_abajo, BorderLayout.CENTER);
		operaciones_centro.add(about);
		operaciones_centro.add(exit);
		operaciones.setBorder(new EmptyBorder(100, 0, 100, 0));
		operaciones.add(operaciones_centro, BorderLayout.SOUTH);
		south.add(vacio);
		south.add(operaciones);
		south.add(vacio);
		window.add(text1, BorderLayout.NORTH);
		window.add(operadores, BorderLayout.CENTER);

		window.add(south, BorderLayout.SOUTH);

		// Action listener
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text4.setText("+");
			}
		});
		;

		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text4.setText("-");
			}
		});
		;

		multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text4.setText("x");
			}
		});
		;

		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text4.setText("/");
			}
		});
		;

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					switch (text4.getText()) {
					case "+":
						resultado1.setText(String.valueOf(
								Double.parseDouble(operador1.getText()) + Double.parseDouble(operador2.getText())));
						break;
					case "-":
						resultado1.setText(String.valueOf(
								Double.parseDouble(operador1.getText()) - Double.parseDouble(operador2.getText())));
						break;
					case "x":
						resultado1.setText(String.valueOf(
								Double.parseDouble(operador1.getText()) * Double.parseDouble(operador2.getText())));
						break;
					case "/":
						double r = Double.parseDouble(operador1.getText()) / Double.parseDouble(operador2.getText());
						double q = Double.parseDouble(operador1.getText()) % Double.parseDouble(operador2.getText());
						resultado1.setText("Q=" + q + "  R=" + r);
						break;
					case "":
						JOptionPane.showMessageDialog(null, "Selecciona un tipo de operacion", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						break;
					}
				} catch (ArithmeticException ex) {
					System.out.println("No se puede poner 0 en el divisor.");
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				}
			}

		});
		;

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		;

		// Finalmente añadimos la estructura a JFrame inicials
		this.add(window);

		// Ponemos la vista en true y declaramos la ultima opcion
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new calculadora();

	}

}
