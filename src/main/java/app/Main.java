package app;

import controlador.BibliotecaController;
import vista.BibliotecaUI;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();

        controller.registrarLibro("101", "El Señor de los Anillos", "J.R.R. Tolkien");
        controller.registrarLibro("102", "1984", "George Orwell");
        controller.registrarUsuario("U01", "Ana", "ana@mail.com");

        BibliotecaUI interfaz = new BibliotecaUI(controller);
        interfaz.iniciar();
    }
}