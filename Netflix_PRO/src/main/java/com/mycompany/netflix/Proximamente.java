/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;



/**
 * clase donde se ocupan metodos abstractos.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Proximamente {
    //Atributos.

    private String nombre;
    private String sinopsis;
    private String duracion;
    private String categoria;
    private String clasificacion;

    //Constructor.
    public Proximamente(String nombre, String sinopsis, String duracion, String categoria, String clasificacion) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
        this.categoria = categoria;
        this.clasificacion = clasificacion;
    }

    public Proximamente() {
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

    //Metodos Abstractos
    /**
     * Este metodo nos ayudara a llamar a la funcion guardarProximamente.
     */
    public void guardar() {
        ProximamenteDB.guardarProximamente(this);
    }

    /**
     * Este metodo nos ayudara a llamar a la funcion consultarProximamente.
     */
    public void consultar() {
        ProximamenteDB.consultarProximamente();
    }

    /**
     * Este metodo nos ayuduar a llamar a la funcion eliminarProximamente.
     */
    public void eliminar() {
        ProximamenteDB.eliminarProximamente(this.nombre);
    }

}
