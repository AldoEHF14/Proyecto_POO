
package com.mycompany.netflix;

/**
 * Clase Película que hereda los metodos y atributos de Metraje.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Pelicula extends Metraje {

    public Pelicula(String nombre, String sinopsis, int anio, int calif, String duracion, String categoria, String clasificacion) {
        super(nombre, sinopsis, anio, calif, duracion, categoria, clasificacion);
    }

    //Constructor vacio.
    public Pelicula() {

    }

    /**
     * Este metodo nos ayudara a llamar a la funcion guardar pelicula.
     */
    @Override
    public void guardar() {
        PeliculaDB.guardarPelicula(this);
        //PeliculaDB.GuardarCatalogoPelicula(this);
    }

    /**
     * Este metodo nos ayudara a llamar a la funcion guardar pelicula.
     */
    @Override
    public void consultar() {
        //PeliculaDB.consultarPelicula(this.nombre);
        PeliculaDB.consultarCatalogoPelicula();
    }

    /**
     * Este metodo nos ayudara a ver el contenido de cada pelicula.
     */
    @Override
    public void detalles() {
        System.out.println("\tDetalles de la Película.\n");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Sinopsis: " + this.sinopsis);
        System.out.println("Calificacion: " + this.calif);
        System.out.println("Año de estreno: " + this.anio);
        System.out.println("Duracion: " + this.duracion);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Clasificacion: " + this.clasificacion);
    }

    /**
     * Este metodo nos ayudara a eliminar un titulo de pelicula
     */
    @Override
    public void eliminar() {
        PeliculaDB.eliminarPelicula(this.nombre);
    }

}
