package modelo;

import java.time.LocalDate;

public class Prestamo {

    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;

    public Prestamo(Usuario usuario, Libro libro) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }

        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        if (!libro.estaDisponible()) {
            throw new IllegalStateException("No se puede prestar un libro que no esta disponible.");
        }

        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
        this.activo = true;

        libro.prestar();
    }

    public void finalizar() {
        if (!activo) {
            throw new IllegalStateException("El prestamo ya se encuentra finalizado.");
        }

        this.fechaDevolucion = LocalDate.now();
        this.activo = false;
        this.libro.devolver();
    }

    public boolean estaActivo() {
        return activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    @Override
    public String toString() {
        String estado = activo ? "Activo" : "Finalizado";
        String devolucion = fechaDevolucion == null ? "Sin devolucion" : fechaDevolucion.toString();

        return "Prestamo{" +
                "usuario=" + usuario.getNombre() +
                ", libro=" + libro.getTitulo() +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + devolucion +
                ", estado=" + estado +
                '}';
    }
}