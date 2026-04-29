package modelo;

public class Libro {

    private String codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String codigo, String titulo, String autor) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El codigo del libro no puede estar vacio.");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El titulo del libro no puede estar vacio.");
        }

        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacio.");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException("El libro no esta disponible para prstamo.");
        }

        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "[" + codigo + "] " + titulo + " - " + autor + " (" + estado + ")";
    }
}
