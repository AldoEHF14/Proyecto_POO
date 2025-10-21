/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;

/**
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Documental extends Metraje {
    //Atributos.

    protected int temporadas;
    protected int episodios;

    //Constuctor.
    public Documental(int temporadas, int episodios, String nombre, String sinopsis, int anio, int calif, String duracion, String categoria, String clasificacion) {
        super(nombre, sinopsis, anio, calif, duracion, categoria, clasificacion);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    //Constructor vacio.
    public Documental() {

    }

    //Metodos get and set.
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    /**
     * Con este metodo abstracto podremos llamar a la funcion guardar
     * documental.
     */
    @Override
    public void guardar() {
        DocumentalDB.guardarDocumental(this);
        //DocumentalDB.GuardarCatalogoDocumental(this);
    }

    /**
     * Con este metodo abstracto podremos llamar a la funcion consultar
     * documental.
     */
    @Override
    public void consultar() {
        //DocumentalDB.consultarDocumetal(this.nombre);
        DocumentalDB.consultarCatalogoDocumetal();
    }

    /**
     * Nos permite ver el contenido y todos los detalles que tienen los
     * documentales
     */
    @Override
    public void detalles() {

        System.out.println("\tDetalles del documental.\n");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Sinopsis: " + this.sinopsis);
        System.out.println("Calificacion: " + this.calif);
        System.out.println("Año de estreno: " + this.anio);
        System.out.println("Duracion: " + this.duracion);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Clasificacion: " + this.clasificacion);
        System.out.println("Número de temporadas de la serie: " + this.temporadas);
        System.out.println("Número de episodios: " + this.episodios);

    }

    /**
     * Nos permitira eliminar un titulo de documental que deseemos.
     */
    @Override
    public void eliminar() {
        DocumentalDB.eliminarDocumental(this.nombre);
    }

}
