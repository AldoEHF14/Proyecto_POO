/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Clase donde tendrá la funciones para iniciar sesión, consultar la cuenta,
 * saber sí ya hay usuario existente, y recuperacion de cuenta.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Cuenta {
// Atributos de la clase.

    Scanner scan;
    public String user_p;
    private String user;
    private String password;
    public int r;

    public Cuenta() {
        scan = new Scanner(System.in);
    }

    public String getUser_p() {
        return user_p;
    }

    public void setUser_p(String user_p) {
        this.user_p = user_p;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    /**
     * El usuario tendrá la opcion de ingresar su email y contraseña con el que se registró.
     * @return --> Que la cuenta haya o no iniciado sesión.
     */
    public Cuenta showIniciarSesion() {
        String user, password;
        System.out.println("*************************************************");
        System.out.println("Iniciar sesion");
        System.out.println("Ingresa Email:");
        user = scan.next();
        System.out.println("Ingresa password:");
        password = scan.next();
        return Cuenta.iniciarSesion(user, password);
    }

    /**
     * Se crea un archivo de texto que servirá como base de datos para guardar los usuarios y las contraseñas.
     * @param user --> Nombre del perfil.
     * @param password --> Contraseña del perfil.
     * @return --> Retorna la creación del archivo de texto con el user, contra, e email.
     */
    public static Cuenta iniciarSesion(String user, String password) {
        Cuenta c = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        boolean flag = false;
        boolean acceso = false;
        try {
            archivo = new File("sesion.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            c = new Cuenta();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split(",");
                if (keyValue[0].equals(user) && keyValue[1].equals(password)) {
                    flag = true;
                    c.setUser(keyValue[0]);
                    c.setPassword(keyValue[1]);
                    c.setUser_p(keyValue[2]);
                    if (flag == true) {
                        acceso = Cuenta.UsuarioExistente(c.getUser_p());
                        if (acceso == true) {
                            Pantalla p = new Pantalla();
                            p.PerfilNetflix(c);
                        }
                    }
                    break;
                }

            }

            if (acceso == false) {
                Pantalla p = new Pantalla();
                System.out.println("!Datos No Validos¡");
                p.PantallaPrincipal();

            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return c;
                }
            } catch (IOException e2) {
                System.err.println("Error al cerrar el archivo");
            }
        }
        return null;
    }

    /**
     * Básicamente, esta funcion te dice si la cuenta ya existe.
     * @param user_p --> Necesita el usuario para buscar y saber sí existe.
     * @return 
     */
    public static boolean UsuarioExistente(String user_p) {
        Usuario u = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        boolean flag = false;
        try {
            archivo = new File("usuario_" + user_p + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            u = new Usuario();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split("=");
                if (keyValue[0].equals(("User"))) {
                    u.setUser_p(keyValue[1]);
                } else if (keyValue[0].equals("Email")) {
                    u.setUser(keyValue[1]);
                } else if (keyValue[0].equals("Password")) {
                    u.setPassword(keyValue[1]);
                }
                flag = true;

            }

        } catch (IOException | NumberFormatException e) {
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return flag;
                }
            } catch (IOException e2) {
                System.err.println("Error al cerrar el archivo");
            }
        }
        return false;
    }

    /**
     * Funcion para poder recuperar la cuenta, esto escribiendo el email y el perfil de la cuenta
     * @return Los datos de la cuenta. 
     */
    public boolean RecuperaCuenta() {
        String user, user_p;
        System.out.println("*************************************************");
        System.out.println("Ingresa Email:");
        user = scan.next();
        System.out.println("Ingresa Perfil:");
        user_p = scan.next();

        return Cuenta.ConsultarCuenta(user, user_p);
    }

    /**
     * Metodo para consultar el archivo donde se encuentren todas las cuentas.
     * @param user
     * @param user_p
     * @return 
     */
    public static boolean ConsultarCuenta(String user, String user_p) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        boolean flag = false;
        try {
            archivo = new File("sesion.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];

            while ((linea = br.readLine()) != null) {
                keyValue = linea.split(",");
                if (keyValue[0].equals(user) && keyValue[2].equals(user_p)) {
                    flag = true;
                    System.out.println("Password: " + keyValue[1]);
                    break;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al abrir el archivo");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return flag;
                }
            } catch (IOException e2) {
                System.err.println("Error al cerrar el archivo");
            }
        }
        return false;
    }

}
