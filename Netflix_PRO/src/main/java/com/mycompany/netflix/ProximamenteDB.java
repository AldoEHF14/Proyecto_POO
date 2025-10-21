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
 * En esta clase se hace el manejo de archivos, desde consultar hasta eliminar.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class ProximamenteDB {

    /**
     * Se crea al archivo donde se guadarán los títulos que estan proximos a
     * estrenarse.
     *
     * @param proximamente --> argumento de tipo proximamente, que servirá para
     * guardar los títulos.
     * @return --> se crea el archivo con las películas.
     */
    public static boolean guardarProximamente(Proximamente proximamente) {
        File archivo;
        FileWriter escribir = null;
        PrintWriter linea;
        archivo = new File("Proximamente.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //Escribimos en el archivo
                linea.println("Nombre:" + proximamente.getNombre());
                linea.println("Sinopsis:" + proximamente.getSinopsis());
                linea.println("Duracion:" + proximamente.getDuracion());
                linea.println("Categoria:" + proximamente.getCategoria());
                linea.println("Clasificacion:" + proximamente.getClasificacion());

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
                linea.println("Nombre:" + proximamente.getNombre());
                linea.println("Sinopsis:" + proximamente.getSinopsis());
                linea.println("Duracion:" + proximamente.getDuracion());
                linea.println("Categoria:" + proximamente.getCategoria());
                linea.println("Clasificacion:" + proximamente.getClasificacion());

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
     * Funcion en donde se consulta el archivo de los títulos proximos a
     * estrenarse.
     *
     * @return --> la consulta del archivo.
     */
    public static Proximamente consultarProximamente() {
        Proximamente proximamente = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Proximamente.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            proximamente = new Proximamente();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return proximamente;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Eliminar el archivo donde se encuentran todas las películas.
     *
     * @param nombre --> eliminar el archivo o el nombre de proximamente.
     * @return
     */
    public static boolean eliminarProximamente(String nombre) {
        try {

            File archivo = new File("prox_" + nombre + ".txt");

            boolean estatus = archivo.delete();

            if (!estatus) {
                System.out.println("\tELIMINACION DE PROXIAMENTE.\n");

                System.out.println("Se ha eliminado el título exitosamente.\n");

            }

        } catch (Exception e) {

            System.out.println("Error al Eliminar archivo");

        }
        return false;

    }
}
