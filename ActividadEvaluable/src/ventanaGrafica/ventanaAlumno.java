package ventanaGrafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ventanaAlumno extends JFrame {
    private JTable tablaNotas;
    private DefaultTableModel modelo;
    private String alumnoActual = "María"; //usuario de login

    public ventanaAlumno() {
        setTitle("Notas del Alumno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Módulo");
        modelo.addColumn("Nota");

        tablaNotas = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaNotas);

        cargarNotas();

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void cargarNotas() {
        try (Connection conexion = ConexionBD.conectar()) {
            String sql = "SELECT modulo, nota FROM notas WHERE alumno = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, alumnoActual);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("modulo"), rs.getDouble("nota")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las notas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ventanaAlumno());
    }
}

