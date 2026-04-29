package modelo;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        if (buscarLibroPorCodigo(libro.getCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe un libro registrado con el codigo " + libro.getCodigo() + ".");
        }

        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }

        if (buscarUsuarioPorId(usuario.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un usuario registrado con el id " + usuario.getId() + ".");
        }

        usuarios.add(usuario);
    }

    public Libro buscarLibroPorCodigo(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }

        return null;
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equalsIgnoreCase(id)) {
                return usuario;
            }
        }

        return null;
    }

    public Prestamo registrarPrestamo(String idUsuario, String codigoLibro) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("No existe un usuario registrado con el id " + idUsuario + ".");
        }

        Libro libro = buscarLibroPorCodigo(codigoLibro);
        if (libro == null) {
            throw new IllegalArgumentException("No existe un libro registrado con el codigo " + codigoLibro + ".");
        }

        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamos.add(prestamo);

        return prestamo;
    }

    public void devolverLibro(String codigoLibro) {
        Prestamo prestamoActivo = buscarPrestamoActivoPorCodigoLibro(codigoLibro);

        if (prestamoActivo == null) {
            throw new IllegalArgumentException("No existe un prestamo activo para el libro con codigo " + codigoLibro + ".");
        }

        prestamoActivo.finalizar();
    }

    private Prestamo buscarPrestamoActivoPorCodigoLibro(String codigoLibro) {
        for (Prestamo prestamo : prestamos) {
            boolean mismoLibro = prestamo.getLibro().getCodigo().equalsIgnoreCase(codigoLibro);
            if (mismoLibro && prestamo.estaActivo()) {
                return prestamo;
            }
        }

        return null;
    }

    public ArrayList<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }

    public ArrayList<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public ArrayList<Prestamo> listarPrestamosActivos() {
        ArrayList<Prestamo> activos = new ArrayList<>();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaActivo()) {
                activos.add(prestamo);
            }
        }

        return activos;
    }
}
