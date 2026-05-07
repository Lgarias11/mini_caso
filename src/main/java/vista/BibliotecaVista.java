package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.BibliotecaController;
import modelo.*;

public class BibliotecaVista {

    private BibliotecaController controller;
    private Scanner scanner;

    public BibliotecaVista(BibliotecaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            try {
                switch (opcion) {
                    case 1:
                        registrarLibro();
                        break;
                    case 2:
                        registrarUsuario();
                        break;
                    case 3:
                        prestarLibro();
                        break;
                    case 4:
                        devolverLibro();
                        break;
                    case 5:
                        listarLibros();
                        break;
                    case 6:
                        listarUsuarios();
                        break;
                    case 7:
                        listarPrestamosActivos();
                        break;
                    case 0:
                        System.out.println("Finalizando sistema...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (IllegalArgumentException | IllegalStateException | EntidadNoEncontradaException |
                     LibroNoDisponibleException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("===== Sistema Biblioteca =====");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar usuario");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Listar libros");
        System.out.println("6. Listar usuarios");
        System.out.println("7. Listar prestamos activos");
        System.out.println("0. Salir");
    }

    private void registrarLibro() {
        System.out.println("--- Registrar libro ---");
        String codigo = leerTexto("Codigo: ");
        String titulo = leerTexto("Titulo: ");
        String autor = leerTexto("Autor: ");

        controller.registrarLibro(codigo, titulo, autor);
        System.out.println("Libro registrado correctamente.");
    }

    private void registrarUsuario() {
        System.out.println("--- Registrar usuario ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String correo = leerTexto("Correo: ");

        controller.registrarUsuario(id, nombre, correo);
        System.out.println("Usuario registrado correctamente.");
    }

    private void prestarLibro() throws EntidadNoEncontradaException, LibroNoDisponibleException {
        System.out.println("--- Prestar libro ---");
        String idUsuario = leerTexto("ID del usuario: ");
        String codigoLibro = leerTexto("Codigo del libro: ");

        controller.prestarLibro(idUsuario, codigoLibro);
        System.out.println("Prestamo registrado correctamente.");
    }

    private void devolverLibro() {
        System.out.println("--- Devolver libro ---");
        String codigoLibro = leerTexto("Codigo del libro: ");

        controller.devolverLibro(codigoLibro);
        System.out.println("Libro devuelto correctamente.");
    }

    private void listarLibros() {
        System.out.println("--- Libros registrados ---");
        ArrayList<Libro> libros = controller.obtenerLibros();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    private void listarUsuarios() {
        System.out.println("--- Usuarios registrados ---");
        ArrayList<Usuario> usuarios = controller.obtenerUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private void listarPrestamosActivos() {
        System.out.println("--- Prestamos activos ---");
        ArrayList<Prestamo> prestamos = controller.obtenerPrestamosActivos();

        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos activos.");
            return;
        }

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }
}
