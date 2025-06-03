package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase usuario: donde se hacen los metodos para registrar, guardar cuenta,
 * crear registro, modificar el estado de cuenta.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Usuario {

    private Scanner scan = new Scanner(System.in);

    private String user_p;
    private String user;
    private String password;

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

    /**
     * Este metodo nos funciona para registrar el usuario, pidiendo su email, su
     * contraseña y el nombre del perfil que llevará su cuenta.
     *
     * @return Se crea el registro.
     */
    public boolean RegistrarUsuario() {
        System.out.println("*************************************************");
        System.out.println("************   Registrar Usuario   ************\n");
        System.out.println("Ingresa el Email:");
        this.user = scan.next();
        System.out.println("Ingrese la password:");
        this.password = scan.next();
        System.out.println("Ingresa el user:");
        this.user_p = scan.next();

        return GuardarRegistro();
    }

    /**
     * Se guarda el archivo y crea el resgitro.
     *
     * @return se guarda el registro.
     */
    public boolean GuardarRegistro() {
        try {
            return UsuarioDB.crear(this) && CrearRegistro(user, password, user_p);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Se crea el archivo donde esta el nombre del perfil, la contraseña y el
     * email.
     *
     * @param user --> Nombre del perfil.
     * @param password --> Contraseña del perfil
     * @param user_p --> email del perfil.
     * @return
     * @throws IOException
     */
    public static boolean CrearRegistro(String user, String password, String user_p) throws IOException {

        FileWriter archivo = null;
        PrintWriter pw = null;
        File formato;
        formato = new File("sesion.txt");

        if (!formato.exists()) {
            try {
                formato.createNewFile();
                archivo = new FileWriter(formato, true);
                pw = new PrintWriter(archivo);
                pw.println(user + "," + password + "," + user_p);

            } catch (Exception e) {
                System.err.println("Error al crear archivo");
            } finally {
                try {
                    if (archivo != null) {
                        archivo.close();
                        return true;
                    }
                } catch (Exception e2) {
                    System.err.println("Error al cerrar archivo");
                }
            }
        } else {
            try {
                archivo = new FileWriter(formato, true);
                pw = new PrintWriter(archivo);
                pw.println(user + "," + password + "," + user_p);

            } catch (Exception e) {
                System.err.println("Error al sobreescribir archivo");
            } finally {
                try {
                    if (archivo != null) {
                        archivo.close();
                        return true;
                    }
                } catch (Exception e2) {
                    System.err.println("Error al cerrar archivo");
                }
            }
        }

        return false;
    }

    /**
     * Función donde se podrá modificar la lista, para este caso usaremos la
     * eliminación.
     *
     * @param filePath --> es el nombre del archivo dentro de nuestro
     * computador.
     * @param oldString --> palabra o cosa que deseas cambiar.
     * @param newString --> palabra a la que se cambió.
     */
    static void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        } finally {
            try {
                //Closing the resources
                reader.close();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Función donde se podrá modificar la contraseña para este caso usaremos la
     * modificacion.
     *
     * @param filePath --> es el nombre del archivo dentro de nuestro
     * computador.
     * @param oldString --> La contraseña que deseas cambiar.
     * @param newString --> La nueva contraseña.
     */
    static void modifyFileUsuario(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        } finally {
            try {
                //Closing the resources
                reader.close();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
