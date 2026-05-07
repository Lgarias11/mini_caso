package controlador;

import java.util.ArrayList;

import modelo.*;

public class BibliotecaController {

    private Biblioteca biblioteca;

    public BibliotecaController() {
        this.biblioteca = new Biblioteca();
    }

    public void registrarLibro(String codigo, String titulo, String autor) {
        Libro libro = new Libro(codigo, titulo, autor);
        biblioteca.agregarLibro(libro);
    }

    public void registrarUsuario(String id, String nombre, String correo) {
        Usuario usuario = new Usuario(id, nombre, correo);
        biblioteca.agregarUsuario(usuario);
    }

    public void prestarLibro(String idUsuario, String codigoLibro) throws EntidadNoEncontradaException, LibroNoDisponibleException {
        biblioteca.registrarPrestamo(idUsuario, codigoLibro);
    }

    public void devolverLibro(String codigoLibro) {
        biblioteca.devolverLibro(codigoLibro);
    }

    public ArrayList<Libro> obtenerLibros() {
        return biblioteca.listarLibros();
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return biblioteca.listarUsuarios();
    }

    public ArrayList<Prestamo> obtenerPrestamosActivos() {
        return biblioteca.listarPrestamosActivos();
    }
}
