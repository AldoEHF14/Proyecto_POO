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
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase que esta relacionada con la clase usuario, pero en esta se hace uso de
 * archivos.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class UsuarioDB {

    /**
     * Se crea un archivo de tipo usuario, esto para guardar el perfil, el email
     * y la contra.
     *
     * @param u --> Parametro de tipo usuario, donde se crea el archivo.
     * @return --> La creacion del archivo.
     */
    public static boolean crear(Usuario u) {
        FileWriter archivo = null;
        PrintWriter pw = null;

        try {
            archivo = new FileWriter("usuario_" + u.getUser_p() + ".txt");
            pw = new PrintWriter(archivo);

            pw.println("User=" + u.getUser_p());
            pw.println("Email=" + u.getUser());
            pw.println("Password=" + u.getPassword());
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

    /**
     * Comsulta lo que tenemos dentro del archivo.
     *
     * @param user_p --> Se consulta gracias al nombre del perfil.
     * @return --> Consulta del archivo.
     */
    public static Usuario consultar(String user_p) {
        Usuario u = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("usuario_" + user_p + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            u = new Usuario();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return u;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }

    /**
     * Eliminacion completa del archivo.
     *
     * @param user_p --> El nombre de perfl como parametro.
     * @return
     */
    public static boolean eliminarUsuario(String user_p) {
        File archivo = new File("usuario_" + user_p + ".txt");
        if (archivo.delete()) {
            System.out.println("\tELIMINACION DE USUARIO.\n");
            System.out.println("Se ha eliminado el usuario exitosamente.\n");

        } else {
            System.out.println("no se encontro el archivo");
        }
        return false;
    }

}
