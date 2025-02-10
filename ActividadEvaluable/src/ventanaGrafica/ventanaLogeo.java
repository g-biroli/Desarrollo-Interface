package ventanaGrafica;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ventanaLogeo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField passwordField;
	private JButton btnSalir;
	private JButton btnEntrar;
	private String usuario = "Gabriel";
	private String pass="1234";
	private JComboBox<String> comboBox;
	
	

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
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(42, 65, 88, 33);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(42, 151, 120, 33);
		contentPane.add(lblContrasea);
		
		JLabel lblCargo = new JLabel("CARGO");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCargo.setBounds(42, 231, 120, 33);
		contentPane.add(lblCargo);
		
		JComboBox comboBox = new JComboBox<>();
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
		
		tfUsuario = new JTextField();
		tfUsuario.setToolTipText("Introduza el usuario");
		tfUsuario.setBounds(176, 74, 151, 19);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 160, 151, 19);
		contentPane.add(passwordField);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setBounds(411, 284, 94, 33);
		contentPane.add(btnEntrar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(529, 284, 94, 33);
		contentPane.add(btnSalir);
		
		JButton ImagemUniversidadEuropea = new JButton("");
		ImagemUniversidadEuropea.setIcon(new ImageIcon(ventanaLogeo.class.getResource("/imagenes/bwhsLDu0_200x200.png")));
		ImagemUniversidadEuropea.setBounds(447, 89, 132, 129);
		contentPane.add(ImagemUniversidadEuropea);
	}
		protected JTextField getTfUsuario() {
			return tfUsuario;
		}
			protected JButton getBtnSalir() {
			return btnSalir;
		}
			protected JButton getBtnEntrar() {
			return btnEntrar;
		}
			protected JPasswordField getPasswordField() {
			return passwordField;
		} 
	
			@Override
			public void actionPerformed(ActionEvent e) {
			    Object ob = e.getSource();
			    
			    if (ob.equals(btnSalir)) {
			        System.exit(EXIT_ON_CLOSE);
			    }
			    
			    if (ob.equals(btnEntrar)) {
			        String usuarioIngresado = tfUsuario.getText();
			        String contrasenaIngresada = new String(passwordField.getPassword());
					String tipoUsuario = comboBox.getSelectedItem().toString();
			        
			        if (usuarioIngresado.isEmpty() || contrasenaIngresada.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Valores vacíos");
			        } else {
			            if (usuarioIngresado.equals(usuario) && contrasenaIngresada.equals(pass)) {
			                JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioIngresado);
			                abrirVentanaSegunUsuario(tipoUsuario);
			            } else {
			                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
			            }
			        }
			    }
			}
			
			// Método para abrir la ventana correcta
			private void abrirVentanaSegunUsuario(String tipoUsuario) {
			    if (tipoUsuario.equals("Profesor")) {
			        ventanaProfesor profesorFrame = new ventanaProfesor();
			        profesorFrame.setVisible(true);
			    } else if (tipoUsuario.equals("Alumno")) {
			        ventanaAlumno alumnoFrame = new ventanaAlumno();
			        alumnoFrame.setVisible(true);
			    }
			    dispose(); // Cierra la ventana de login
			}
}