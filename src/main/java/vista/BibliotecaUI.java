package vista;

import controlador.BibliotecaController;
import modelo.Libro;
import modelo.EntidadNoEncontradaException;
import modelo.LibroNoDisponibleException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BibliotecaUI extends JFrame {
    private BibliotecaController controller;
    private JTextArea txtSalida;

    public BibliotecaUI(BibliotecaController controller) {
        this.controller = controller;
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Sistema de Biblioteca - MVC");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        JPanel panelNorte = new JPanel();
        JButton btnListar = new JButton("Listar Libros");
        JButton btnPrestar = new JButton("Prestar Libro");

        panelNorte.add(btnListar);
        panelNorte.add(btnPrestar);
        add(panelNorte, BorderLayout.NORTH);

        txtSalida = new JTextArea();
        txtSalida.setEditable(false);
        add(new JScrollPane(txtSalida), BorderLayout.CENTER);

        btnListar.addActionListener(e -> {
            ArrayList<Libro> libros = controller.obtenerLibros();
            txtSalida.setText("--- Catálogo de Libros ---\n");
            for (Libro l : libros) {
                txtSalida.append(l.toString() + "\n");
            }
        });

        btnPrestar.addActionListener(e -> {
            String idUsuario = JOptionPane.showInputDialog(this, "Ingrese ID del Usuario:");
            if (idUsuario == null || idUsuario.trim().isEmpty()) return;

            String codLibro = JOptionPane.showInputDialog(this, "Ingrese Código del Libro:");
            if (codLibro == null || codLibro.trim().isEmpty()) return;

            try {
                controller.prestarLibro(idUsuario, codLibro);
                JOptionPane.showMessageDialog(this, "Préstamo exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                btnListar.doClick(); 
            } catch (EntidadNoEncontradaException | LibroNoDisponibleException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Préstamo", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void iniciar() {
        setVisible(true);
    }
}