/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;

import java.util.LinkedList;

/**
 * Clase padre que heredará a diferentes clases dentro del programa.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public abstract class Metraje {

    protected String nombre;
    protected String sinopsis;
    protected int anio;
    protected int calif;
    protected String duracion;
    protected String categoria;
    protected String clasificacion;

    //Constructor
    public Metraje(String nombre, String sinopsis, int anio, int calif, String duracion, String categoria, String clasificacion) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.anio = anio;
        this.calif = calif;
        this.duracion = duracion;
        this.categoria = categoria;
        this.clasificacion = clasificacion;
    }

    //Constructor vacio.
    public Metraje() {

    }

    //Metodos get and set.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCalif() {
        return calif;
    }

    public void setCalif(int calif) {
        this.calif = calif;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Metodos abstractos que se heredarán a otras clases, estas con el fin de
     * poder tener menos código.
     */
    public abstract void guardar();

    public abstract void consultar();

    public abstract void detalles();

    public abstract void eliminar();

}
