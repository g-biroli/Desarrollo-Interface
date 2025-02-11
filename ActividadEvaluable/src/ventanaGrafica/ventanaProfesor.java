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

    public ventanaProfesor() {
        setTitle("Gestión de Notas - Profesor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        // Lista de alumnos y modulos
        comboAlumnos = new JComboBox<>(new String[]{"María", "Carlos", "Fernanda"});
        comboModulos = new JComboBox<>(new String[]{"Desarrollo Web", "Desarrollo de Interfaces", "Programación"});
        txtNota = new JTextField();
        btnGuardar = new JButton("Guardar Nota");

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNota();
            }
        });

        add(new JLabel("Seleccionar Alumno:"));
        add(comboAlumnos);
        add(new JLabel("Seleccionar Módulo:"));
        add(comboModulos);
        add(new JLabel("Nota:"));
        add(txtNota);
        add(btnGuardar);

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


