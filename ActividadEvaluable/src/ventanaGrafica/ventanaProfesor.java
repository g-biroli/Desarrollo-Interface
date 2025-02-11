package ventanaGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ventanaProfesor extends JFrame {
    private JComboBox<String> comboAlumnos, comboModulos;
    private JTextField txtNota;
    private JButton btnGuardar;
    private JLabel label_3;
    private JButton btnNewButton;
    private JLabel lblNewLabel;

    public ventanaProfesor() {
        setTitle("Gestión de Notas - Profesor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(646, 424);
        setLocationRelativeTo(null);

        // Lista de alumnos y modulos
        comboAlumnos = new JComboBox<>(new String[]{"María", "Carlos", "Fernanda", "Gabriel"});
        comboModulos = new JComboBox<>(new String[]{"Desarrollo Web", "Desarrollo de Interfaces", "Programación", "Acesso a Datos"});
        txtNota = new JTextField();
        btnGuardar = new JButton("Guardar Nota");

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNota();
            }
        });
        getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
        
        btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(ventanaProfesor.class.getResource("/imagenes/bwhsLDu0_200x200.png")));
        getContentPane().add(btnNewButton);
        
        lblNewLabel = new JLabel("Bienvenido Profesor");
        lblNewLabel.setBackground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("Seleccionar Alumno:");
        getContentPane().add(label);
        getContentPane().add(comboAlumnos);
        JLabel label_1 = new JLabel("Seleccionar Módulo:");
        getContentPane().add(label_1);
        getContentPane().add(comboModulos);
        JLabel label_2 = new JLabel("Nota:");
        getContentPane().add(label_2);
        getContentPane().add(txtNota);
        getContentPane().add(btnGuardar);
        
        label_3 = new JLabel("");
        getContentPane().add(label_3);

        setVisible(true);
    }
    //Metodo del profesor -> Notas
    private void guardarNota() {
        String alumno = (String) comboAlumnos.getSelectedItem();
        String modulo = (String) comboModulos.getSelectedItem();
        String nota = txtNota.getText();
        
        if (nota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una nota válida");
            return;
        }
        //Conexion con la base datos
        try (Connection conexion = ConexionBD.conectar()) {
            String sql = "INSERT INTO notas (alumno, modulo, nota) VALUES (?, ?, ?) " +
                         "ON DUPLICATE KEY UPDATE nota = VALUES(nota)";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, alumno);
            pst.setString(2, modulo);
            pst.setDouble(3, Double.parseDouble(nota));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Nota guardada con éxito!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la nota: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ventanaProfesor());
    }
}


