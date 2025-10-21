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
 * Clase donde se hace el manejo de archivos.
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class DocumentalDB {

    /**
     * Este metodo nos ayudara a guardar la informacion de cada documental en un
     * archivo de texto. El archivo se guardara con el nombre del titulo del
     * documental en el que contendra toda la informacion al respecto de este.
     *
     * @param documental
     * @return
     */
    public static boolean guardarDocumental(Documental documental) {
        FileWriter archivo = null;
        PrintWriter pw = null;

        try {
            archivo = new FileWriter("documental_" + documental.nombre + ".txt");
            pw = new PrintWriter(archivo);

            pw.println("Nombre:" + documental.getNombre());
            pw.println("Sinopsis:" + documental.getSinopsis());
            pw.println("Calificacion:" + documental.getCalif());
            pw.println("Año de estreno:" + documental.getAnio());
            pw.println("Duracion:" + documental.getDuracion());
            pw.println("Categoria:" + documental.getCategoria());
            pw.println("Clasificacion:" + documental.getClasificacion());
            pw.println("Número de temporadas de la serie:" + documental.getTemporadas());
            pw.println("Número de episodios:" + documental.getEpisodios());

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
     * Este metodo aydara a que todos los titulos de Documentales se guarden en
     * un archivo de texto global, donde se encuentren cada uno de ellos con sus
     * espeficaciones correspondientes.
     *
     * @param documental
     * @return
     */
    public static boolean GuardarCatalogoDocumental(Documental documental) {
        File archivo;
        FileWriter escribir = null;
        PrintWriter linea;
        archivo = new File("Documentales.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                //Escribimos en el archivo

                linea.println("Nombre:" + documental.getNombre());
                linea.println("Sinopsis:" + documental.getSinopsis());
                linea.println("Calificacion:" + documental.getCalif());
                linea.println("Año de estreno:" + documental.getAnio());
                linea.println("Duracion:" + documental.getDuracion());
                linea.println("Categoria:" + documental.getCategoria());
                linea.println("Clasificacion:" + documental.getClasificacion());
                linea.println("Número de temporadas de la serie:" + documental.getTemporadas());
                linea.println("Número de episodios:" + documental.getEpisodios());

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
                linea.println("Nombre:" + documental.getNombre());
                linea.println("Sinopsis:" + documental.getSinopsis());
                linea.println("Calificacion:" + documental.getCalif());
                linea.println("Año de estreno:" + documental.getAnio());
                linea.println("Duracion:" + documental.getDuracion());
                linea.println("Categoria:" + documental.getCategoria());
                linea.println("Clasificacion:" + documental.getClasificacion());
                linea.println("Número de temporadas de la serie:" + documental.getTemporadas());
                linea.println("Número de episodios:" + documental.getEpisodios());

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
     * Nos ayudara en su momento a poder consultar un archivo de tipo
     * documental.
     *
     * @param nombre
     * @return
     */
    public static Documental consultarDocumetal(String nombre) {
        Documental documental = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("documental_" + nombre + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            documental = new Documental();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split(":");

                if (keyValue[0].equals(("Nombre"))) {
                    documental.setNombre(keyValue[1]);
                } else if (keyValue[0].equals("Sinopsis")) {
                    documental.setSinopsis(keyValue[1]);
                } else if (keyValue[0].equals("Calificacion")) {
                    documental.setCalif(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Año de estreno")) {
                    documental.setAnio(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Duracion")) {
                    documental.setDuracion(keyValue[1]);
                } else if (keyValue[0].equals("Categoria")) {
                    documental.setCategoria(keyValue[1]);
                } else if (keyValue[0].equals("Clasificacion")) {
                    documental.setClasificacion(keyValue[1]);
                } else if (keyValue[0].equals("Número de temporadas de la serie")) {
                    documental.setTemporadas(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("Número de episodios")) {
                    documental.setEpisodios(Integer.parseInt(keyValue[1]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return documental;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Nos podra ayudar en su momento a poder consultar el archivo Documentales.
     *
     * @return
     */
    public static Documental consultarCatalogoDocumetal() {
        Documental documental = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Documentales.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            documental = new Documental();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return documental;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Nos ayudara a eliminar un titulo con su archivo de tipo Documental
     *
     * @param nombre
     * @return
     */
    public static boolean eliminarDocumental(String nombre) {
        try {

            File archivo = new File("documental_" + nombre + ".txt");

            boolean estatus = archivo.delete();

            if (!estatus) {
                System.out.println("\tELIMINACION DE DOCUMENTAL.\n");

                System.out.println("Se ha eliminado el documental exitosamente.\n");

            }

        } catch (Exception e) {

            System.out.println("Error al Eliminar archivo");

        }
        return false;

    }
}
