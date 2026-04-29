Repositorio educativo para estudiar el paso desde una narrativa de problema hacia el diseño UML y la implementación Java de un sistema básico de biblioteca organizado bajo MVC.

# Sistema Biblioteca POO MVC

Proyecto educativo desarrollado en Java para ilustrar el análisis, diseño e implementación de un sistema básico de gestión de biblioteca utilizando Programación Orientada a Objetos y una organización basada en el patrón Modelo–Vista–Controlador (MVC).

## Descripción

El sistema permite gestionar libros, usuarios y préstamos de una biblioteca escolar mediante una aplicación de consola. El objetivo principal es mostrar cómo una narrativa de problema puede transformarse progresivamente en clases, relaciones, paquetes, reglas de negocio y código Java funcional.

## Funcionalidades principales

- Registro de libros con código, título, autor y estado de disponibilidad.
- Registro de usuarios con identificador, nombre y correo electrónico.
- Registro de préstamos de libros a usuarios.
- Validación de disponibilidad antes de realizar un préstamo.
- Registro de devoluciones.
- Consulta de libros registrados, usuarios registrados y préstamos activos.

## Organización del proyecto

El proyecto está organizado siguiendo una estructura MVC:

- `modelo`: contiene las clases del dominio, como `Libro`, `Usuario`, `Prestamo` y `Biblioteca`.
- `controlador`: contiene la clase `BibliotecaController`, responsable de coordinar las operaciones del sistema.
- `vista`: contiene la clase `BibliotecaVista`, encargada de la interacción por consola.
- `app`: contiene la clase `Main`, punto de entrada de la aplicación.

## Objetivo pedagógico

Este proyecto busca apoyar el aprendizaje de conceptos fundamentales de POO, tales como clases, objetos, encapsulamiento, asociaciones, dependencias, colecciones, reglas de negocio, separación de responsabilidades y organización de código mediante paquetes.

## Ejecución

Ejecutar la clase principal:

```bash
javac app/Main.java
java app.Main
