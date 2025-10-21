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
 * Clase Mi lista, donde se usan metodos para consultar y eliminar.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class MiListaDB {

    /**
     * Funcion de tipo Mi_lista para poder consultar el archivo en donde tenemos
     * dichos títulos.
     *
     * @param user_p --> Se usa el user_p para poder entrar a Mi lista y
     * consultar las películas que tiene dicho perfil.
     * @return
     */
    public static Mi_lista consultarLista(String user_p) {
        Mi_lista ML = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("MiLista_" + user_p + ".txt");

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            ML = new Mi_lista();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("No tienes ningún título guardado en Mi lista");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return ML;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Eliminacion del archivo Mi_lista.
     *
     * @param user_p Eliminar conforme al perfil que se requiera.
     * @return la eliminacion del perfil.
     */
    public static boolean eliminacionDeLista(String user_p) {
        File archivo = new File("MiLista_" + user_p + ".txt");

        if (archivo.delete()) {
            System.out.println("\tELIMINACION DE MI LISTA.\n");
            System.out.println("Se ha eliminado Mi lista correctamente.\n");

        } else {
            System.out.println("no se encontro el archivo");
        }
        return false;
    }
}
