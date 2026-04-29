package modelo;

public class Usuario {

    private String id;
    private String nombre;
    private String correo;

    public Usuario(String id, String nombre, String correo) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El identificador del usuario no puede estar vacio.");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacio.");
        }

        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El correo del usuario no puede estar vacio.");
        }

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " - " + correo;
    }
}
