package ventanaGrafica;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ventanaAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAlumno frame = new ventanaAlumno();
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
	public ventanaAlumno() {
		setTitle("Ventana Alumno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(768, 479);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Bienvenido Alumno");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setIcon(new ImageIcon(ventanaProfesor.class.getResource("/imagenes/bwhsLDu0_200x200.png")));
        btnNewButton.setBounds(289, 30, 180, 163);
        panel.add(btnNewButton);

        getContentPane().add(panel);
	}

}
