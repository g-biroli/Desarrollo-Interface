package ventanaGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ventanaProfesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaProfesor frame = new ventanaProfesor();
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
	public ventanaProfesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(29, 211, 243, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbPrimero = new JCheckBox("Primero");
		chckbPrimero.setFont(new Font("Tahoma", Font.PLAIN, 23));
		chckbPrimero.setBounds(51, 28, 127, 37);
		panel.add(chckbPrimero);
		
		JCheckBox chckbSegundo = new JCheckBox("Segundo");
		chckbSegundo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		chckbSegundo.setBounds(51, 80, 127, 37);
		panel.add(chckbSegundo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(289, 211, 222, 176);
		contentPane.add(panel_1);
		
		JCheckBox chckbInformatica = new JCheckBox("Informatica");
		chckbInformatica.setFont(new Font("Tahoma", Font.PLAIN, 23));
		chckbInformatica.setBounds(51, 19, 146, 37);
		panel_1.add(chckbInformatica);
		
		JCheckBox chckbDependencia = new JCheckBox("Dependencia");
		chckbDependencia.setFont(new Font("Tahoma", Font.PLAIN, 23));
		chckbDependencia.setBounds(51, 69, 165, 37);
		panel_1.add(chckbDependencia);
		
		JCheckBox chckbEnfermaria = new JCheckBox("Enfermaria");
		chckbEnfermaria.setFont(new Font("Tahoma", Font.PLAIN, 23));
		chckbEnfermaria.setBounds(51, 118, 146, 37);
		panel_1.add(chckbEnfermaria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(530, 40, 286, 347);
		contentPane.add(scrollPane);
	}
}
