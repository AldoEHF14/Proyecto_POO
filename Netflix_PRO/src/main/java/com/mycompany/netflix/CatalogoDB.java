/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Clase donde se crea el metodo para guardar el catalogo.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class CatalogoDB {

    /**
     * Este metodo se utilizo para poder guardar el contenido de catalogo en un
     * archivo de texto. Resiviendo como parametro un objeto c de tipo Catalogo.
     *
     * @return el guardar el archivo.
     */
    public static boolean guardarCatalogo(Catalogo c) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        try {

        } catch (Exception e) {
            System.err.println("Error al crear archivo");
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
}
