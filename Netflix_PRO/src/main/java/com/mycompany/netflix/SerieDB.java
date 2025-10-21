/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * En esta clase se ocupan los metodos para crear, eliminar y consultar
 * archivos.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class SerieDB {

    /**
     * Este metodo nos ayudara a guardar la informacion de cada serie en un
     * archivo de texto. El archivo se guardara con el nombre del titulo de la
     * serie en el que contendra toda la informacion al respecto de este.
     *
     * @param serie
     * @return
     */
    public static boolean guardarSerie(Serie serie) {
        FileWriter archivo = null;
        PrintWriter pw = null;

        try {
            archivo = new FileWriter("serie_" + serie.nombre + ".txt");
            pw = new PrintWriter(archivo);

            pw.println("Nombre:" + serie.getNombre());
            pw.println("Sinopsis:" + serie.getSinopsis());
            pw.println("Calificacion:" + serie.getCalif());
            pw.println("Año de estreno:" + serie.getAnio());
            pw.println("Duracion:" + serie.getDuracion());
            pw.println("Categoria:" + serie.getCategoria());
            pw.println("Clasificacion:" + serie.getClasificacion());
            pw.println("Número de temporadas de la serie:" + serie.getTemporadas());
            pw.println("Número de episodios:" + serie.getEpisodios());

        } catch (Exception e) {
            System.out.println("Error al crear archivo");
        } finally {
            try {
                if (archivo != null) {
                    archivo.close();
                    return true;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return false;
    }

    /**
     * Este metodo ayudara a que todos los titulos de Serie se guarden en un
     * archivo de texto global, donde se encuentren cada uno de ellos con sus
     * espeficaciones correspondientes.
     *
     * @param serie
     * @return
     */
    public static boolean GuardarCatalogoSerie(Serie serie) {
        File archivo;
        FileWriter escribir = null;
        PrintWriter linea;
        archivo = new File("Series.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //Escribimos en el archivo

                linea.println("Nombre:" + serie.getNombre());
                linea.println("Sinopsis:" + serie.getSinopsis());
                linea.println("Calificacion:" + serie.getCalif());
                linea.println("Año de estreno:" + serie.getAnio());
                linea.println("Duracion:" + serie.getDuracion());
                linea.println("Categoria:" + serie.getCategoria());
                linea.println("Clasificacion:" + serie.getClasificacion());
                linea.println("Número de temporadas de la serie:" + serie.getTemporadas());
                linea.println("Número de episodios:" + serie.getEpisodios());

                linea.close();
                escribir.close();

            } catch (Exception ex) {
                System.err.println("Error al crear archivo");
            } finally {
                try {
                    if (archivo != null) {
                        escribir.close();
                        return true;
                    }
                } catch (Exception e2) {
                    System.out.println("Error al cerrar archivo");
                }
            }
        } else {
            try {
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //Escribimos en el archivo
                linea.println("************************************************");
                linea.println("Nombre:" + serie.getNombre());
                linea.println("Sinopsis:" + serie.getSinopsis());
                linea.println("Calificacion:" + serie.getCalif());
                linea.println("Año de estreno:" + serie.getAnio());
                linea.println("Duracion:" + serie.getDuracion());
                linea.println("Categoria:" + serie.getCategoria());
                linea.println("Clasificacion:" + serie.getClasificacion());
                linea.println("Número de temporadas de la serie:" + serie.getTemporadas());
                linea.println("Número de episodios:" + serie.getEpisodios());

                linea.close();
                escribir.close();

            } catch (Exception ex) {
                System.err.println("Error al crear archivo");
            } finally {
                try {
                    if (archivo != null) {
                        escribir.close();
                        return true;
                    }
                } catch (Exception e2) {
                    System.out.println("Error al cerrar archivo");
                }
            }
        }
        return false;
    }

    /**
     * Nos ayudara en su momento a poder consultar un archivo de tipo serie.
     *
     * @param nombre
     * @return
     */
    public static Serie consultarSerie(String nombre) {
        Serie series = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("serie_" + nombre + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            series = new Serie();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split(":");

                if (keyValue[0].equals(("Nombre"))) {
                    series.setNombre(keyValue[1]);
                } else if (keyValue[0].equals("Sinopsis")) {
                    series.setSinopsis(keyValue[1]);
                } else if (keyValue[0].equals("Calificacion")) {
                    series.setCalif(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Año de estreno")) {
                    series.setAnio(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Duracion")) {
                    series.setDuracion(keyValue[1]);
                } else if (keyValue[0].equals("Categoria")) {
                    series.setCategoria(keyValue[1]);
                } else if (keyValue[0].equals("Clasificacion")) {
                    series.setClasificacion(keyValue[1]);
                } else if (keyValue[0].equals("Número de temporadas de la serie")) {
                    series.setTemporadas(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Número de episodios")) {
                    series.setEpisodios(Integer.parseInt(keyValue[1]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return series;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Nos podra ayudar en su momento a poder consultar el archivo Series.
     *
     * @return
     */
    public static Serie consultarCatalogoSerie() {
        Serie series = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Series.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            series = new Serie();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return series;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Nos ayudara a eliminar un titulo con su archivo de tipo Serie.
     *
     * @param nombre
     * @return
     */
    public static boolean eliminarSerie(String nombre) {
        try {

            File archivo = new File("serie_" + nombre + ".txt");

            boolean estatus = archivo.delete();

            if (!estatus) {
                System.out.println("\tELIMINACION DE SERIE.\n");

                System.out.println("Se ha eliminado la serie exitosamente.\n");

            }

        } catch (Exception e) {

            System.out.println("Error al Eliminar archivo");

        }
        return false;

    }
}
