package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Color;

public class primeraVentanaSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtVentas;
	private JTextField txtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					primeraVentanaSwing frame = new primeraVentanaSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public primeraVentanaSwing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gabriel\\OneDrive\\Trabalhos\\Redebras\\Criativo\\Logos\\LogoTransparente.png.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtVentas = new JTextField();
		txtVentas.setForeground(new Color(240, 124, 0));
		txtVentas.setFont(new Font("Britannic Bold", Font.PLAIN, 41));
		txtVentas.setText("Ventas");
		txtVentas.setBounds(147, 90, 127, 42);
		contentPane.add(txtVentas);
		txtVentas.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCliente.setText("Cliente:");
		txtCliente.setBounds(77, 155, 68, 19);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(175, 155, 99, 19);
		contentPane.add(formattedTextField);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(284, 155, 73, 21);
		contentPane.add(btnNewButton);
	}
}
