/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;

/**
 * Clase Serie que hereda todos los atributos y metodos de la clase metraje.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Serie extends Metraje {

    //Atributos.
    protected int temporadas;
    protected int episodios;

    //Constructor.
    public Serie(int temporadas, int episodios, String nombre, String sinopsis, int anio, int calif, String duracion, String categoria, String clasificacion) {
        super(nombre, sinopsis, anio, calif, duracion, categoria, clasificacion);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    //Constructor vacio.
    public Serie() {

    }

    public Serie(int temporadas, int episodios) {
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    //Metodos get and set
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

    //Metodo para mostrar los datos.
    /**
     * Este metodo nos ayudara a llamar a la funcion guardarSerie.
     */
    @Override
    public void guardar() {
        SerieDB.guardarSerie(this);
        //SerieDB.GuardarCatalogoSerie(this);
    }

    /**
     * Este metodo nos ayudara a llamar a la funcion ConsultarSerie.
     */
    @Override
    public void consultar() {
        //SerieDB.consultarSerie(this.nombre);
        SerieDB.consultarCatalogoSerie();
    }

    /**
     * Esta funcion nos ayudara a mostrar los detalles y contenidos de la Series
     */
    @Override
    public void detalles() {

        System.out.println("\tDetalles de la Serie.\n");
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
     * Este metodo nos ayudara a llamar la funcion eliminarSerie.
     */
    @Override
    public void eliminar() {
        SerieDB.eliminarSerie(this.nombre);
    }

}
