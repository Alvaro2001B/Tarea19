package ejercicio1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * TAREA 19 EJERCICIO 1
 * @author Alvaro Benitez Carmona
 *
 */
public class main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel text;
	private JTextField name;
	private JButton saludar;
	private JPanel window, textPanel, fieldPanel, bottonPanel;

	public main() {
		super("Ejercicio 1 - SALUDAR ");
		this.setLocation(490, 150);
		this.setSize(600, 500);
		this.setLayout(new BorderLayout(0, 70));

		// Declaramos todas la variables
		frame = new JFrame("Saludar");
		text = new JLabel("Escribe un nombre para saludar:");
		name = new JTextField("Nombre...", 10);
		window = new JPanel();
		textPanel = new JPanel();
		fieldPanel = new JPanel();
		bottonPanel = new JPanel();
		saludar = new JButton("Saludar!!");

		// ActionListene
		saludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hola " + name.getText() + " bienvenido!!! :D", "SALUDAR!!!!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		;

		// Creamos la estructura de los JPanel
		textPanel.setLayout(new FlowLayout());
		textPanel.setBorder(new EmptyBorder(150, 0, 0, 0));
		fieldPanel.setLayout(new FlowLayout());
		fieldPanel.setBorder(new EmptyBorder(20, 0, 0, 10));
		bottonPanel.setLayout(new FlowLayout());
		bottonPanel.setBorder(new EmptyBorder(0, 0, 180, 0));
		window.setLayout(new BorderLayout());

		// Añadimos todo a los JPanels
		textPanel.add(text);
		fieldPanel.add(name);
		bottonPanel.add(saludar);
		window.add(textPanel, BorderLayout.NORTH);
		window.add(fieldPanel, BorderLayout.CENTER);
		window.add(bottonPanel, BorderLayout.SOUTH);

		// Finalmente añadimos la estructura a JFrame inicials
		this.add(window);

		// Ponemos la vista en true y declaramos la ultima opcion
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new main();
	}

}
