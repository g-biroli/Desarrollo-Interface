package ventanaGrafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaProfesor extends JFrame {
    private JTable tablaNotas;
    private DefaultTableModel modelo;

    public ventanaProfesor() {
        setTitle("Gestión de Notas - Profesor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(809, 549);
        setLocationRelativeTo(null);

        // tabla con alumno y su nota
        modelo = new DefaultTableModel();
        modelo.addColumn("Alumno");
        modelo.addColumn("Nota");

        // Ejemplo de alumno
        modelo.addRow(new Object[]{"Maria", ""});
        modelo.addRow(new Object[]{"Carlos", ""});
        modelo.addRow(new Object[]{"Fernanda", ""});

        tablaNotas = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaNotas);
        scrollPane.setBounds(209, 202, 586, 288);
        
        
        // Boton para tomar nota
        JButton btnGuardar = new JButton("Tomar Notas");
        btnGuardar.setBounds(209, 491, 586, 21);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarNotas();
            }
        });
        
        

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(scrollPane);
        panel.add(btnGuardar);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("¡Bienvenido Profesor!");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
        lblNewLabel.setBounds(227, 0, 322, 40);
        panel.add(lblNewLabel);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("DAM");
        chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chckbxNewCheckBox.setBounds(39, 314, 93, 21);
        panel.add(chckbxNewCheckBox);
        
        JCheckBox chckbxDaw = new JCheckBox("DAW");
        chckbxDaw.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chckbxDaw.setBounds(39, 345, 93, 21);
        panel.add(chckbxDaw);
        
        JLabel lblNewLabel_1 = new JLabel("CURSO");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_1.setBounds(35, 260, 93, 28);
        panel.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setIcon(new ImageIcon(ventanaProfesor.class.getResource("/imagenes/bwhsLDu0_200x200.png")));
        btnNewButton.setBounds(289, 30, 180, 163);
        panel.add(btnNewButton);
        
        JComboBox<Object> comboBox = new JComboBox<>();
        comboBox.setBounds(21, 389, 129, 46);
        comboBox.addItem("SELECCIONE EL AÑO");
        comboBox.addItem("1");
        comboBox.addItem("2");
        panel.add(comboBox);
        
 
    }

    private void tomarNotas() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String alumno = (String) modelo.getValueAt(i, 0);
            String nota = (String) modelo.getValueAt(i, 1);

            System.out.println("Guardando nota: " + alumno + " - " + nota);
        }
        JOptionPane.showMessageDialog(this, "Notas guardadas con éxito!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ventanaProfesor frame = new ventanaProfesor();
            frame.setVisible(true);
        });
    }
}

