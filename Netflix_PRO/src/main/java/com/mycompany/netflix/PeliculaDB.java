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
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class PeliculaDB {

    /**
     * Este metodo nos ayudara a guardar la informacion de cada pelicula en un
     * archivo de texto. El archivo se guardara con el nombre del titulo de la
     * pelicula en el que contendra toda la informacion al respecto de este.
     *
     * @param pelicula
     * @return
     */
    public static boolean guardarPelicula(Pelicula pelicula) {
        FileWriter archivo = null;
        PrintWriter pw = null;

        try {
            archivo = new FileWriter("pelicula_" + pelicula.nombre + ".txt");
            pw = new PrintWriter(archivo);

            pw.println("Nombre:" + pelicula.getNombre());
            pw.println("Sinopsis:" + pelicula.getSinopsis());
            pw.println("Calificacion:" + pelicula.getCalif());
            pw.println("Año de estreno:" + pelicula.getAnio());
            pw.println("Duracion:" + pelicula.getDuracion());
            pw.println("Categoria:" + pelicula.getCategoria());
            pw.println("Clasificacion:" + pelicula.getClasificacion());

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
     * Este metodo ayudara a que todos los titulos de Pelicula se guarden en un
     * archivo de texto global, donde se encuentren cada uno de ellos con sus
     * espeficaciones correspondientes.
     *
     * @param pelicula
     * @return
     */
    public static boolean GuardarCatalogoPelicula(Pelicula pelicula) {
        File archivo;
        FileWriter escribir = null;
        PrintWriter linea;
        archivo = new File("Peliculas.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //Escribimos en el archivo

                linea.println("Nombre:" + pelicula.getNombre());
                linea.println("Sinopsis:" + pelicula.getSinopsis());
                linea.println("Calificacion:" + pelicula.getCalif());
                linea.println("Año de estreno:" + pelicula.getAnio());
                linea.println("Duracion:" + pelicula.getDuracion());
                linea.println("Categoria:" + pelicula.getCategoria());
                linea.println("Clasificacion:" + pelicula.getClasificacion());

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
                linea.println("Nombre:" + pelicula.getNombre());
                linea.println("Sinopsis:" + pelicula.getSinopsis());
                linea.println("Calificacion:" + pelicula.getCalif());
                linea.println("Año de estreno:" + pelicula.getAnio());
                linea.println("Duracion:" + pelicula.getDuracion());
                linea.println("Categoria:" + pelicula.getCategoria());
                linea.println("Clasificacion:" + pelicula.getClasificacion());

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
     * Nos ayudara en su momento a poder consultar un archivo de tipo pelicula.
     *
     * @param nombre
     * @return
     */
    public static Pelicula consultarPelicula(String nombre) {
        Pelicula pelicula = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("pelicula_" + nombre + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            pelicula = new Pelicula();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split(":");

                if (keyValue[0].equals(("Nombre"))) {
                    pelicula.setNombre(keyValue[1]);
                } else if (keyValue[0].equals("Sinopsis")) {
                    pelicula.setSinopsis(keyValue[1]);
                } else if (keyValue[0].equals("Calificacion")) {
                    pelicula.setCalif(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Año de estreno")) {
                    pelicula.setAnio(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Duracion")) {
                    pelicula.setDuracion(keyValue[1]);
                } else if (keyValue[0].equals("Categoria")) {
                    pelicula.setCategoria(keyValue[1]);
                } else if (keyValue[0].equals("Clasificacion")) {
                    pelicula.setClasificacion(keyValue[1]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return pelicula;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Nos podra ayudar en su momento a poder consultar el archivo Peliculas.
     *
     * @return
     */
    public static Pelicula consultarCatalogoPelicula() {
        Pelicula pelicula = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Peliculas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            pelicula = new Pelicula();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return pelicula;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Nos ayudara a eliminar un titulo con su archivo de tipo Pelicula.
     *
     * @param nombre
     * @return
     */
    public static boolean eliminarPelicula(String nombre) {
        try {

            File archivo = new File("pelicula_" + nombre + ".txt");

            boolean estatus = archivo.delete();

            if (!estatus) {
                System.out.println("\tELIMINACION DE PELÍCULA.\n");

                System.out.println("Se ha eliminado la pelicula exitosamente.\n");

            }

        } catch (Exception e) {

            System.out.println("Error al Eliminar archivo");

        }
        return false;

    }
}
