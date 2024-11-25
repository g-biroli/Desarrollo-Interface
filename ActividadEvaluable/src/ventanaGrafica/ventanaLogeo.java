package ventanaGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class ventanaLogeo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaLogeo frame = new ventanaLogeo();
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
	public ventanaLogeo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(42, 65, 88, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(42, 151, 120, 33);
		contentPane.add(lblContrasea);
		
		JLabel lblCargo = new JLabel("CARGO");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCargo.setBounds(42, 231, 120, 33);
		contentPane.add(lblCargo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(176, 239, 151, 21);
		comboBox.addItem("Selecione una opcion");
		comboBox.addItem("Alumno");
		comboBox.addItem("Profesor");
		contentPane.add(comboBox);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpiar.setBounds(190, 296, 127, 21);
		contentPane.add(btnLimpiar);
		
		textField = new JTextField();
		textField.setBounds(176, 74, 151, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 160, 151, 19);
		contentPane.add(passwordField);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(411, 284, 94, 33);
		contentPane.add(btnEntrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(529, 284, 94, 33);
		contentPane.add(btnSalir);
		
		JButton ImagemUniversidadEuropea = new JButton("");
		ImagemUniversidadEuropea.setIcon(new ImageIcon(ventanaLogeo.class.getResource("/imagenes/bwhsLDu0_200x200.png")));
		ImagemUniversidadEuropea.setBounds(447, 89, 132, 129);
		contentPane.add(ImagemUniversidadEuropea);
	}
}
