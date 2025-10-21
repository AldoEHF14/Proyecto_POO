package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Mi lista, donde el usuario podrá agregar títulos a mi lista, eliminar
 * algun título.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Mi_lista {

    //Atributo.
    protected String nombre;
    protected String user_p;
    protected String sinopsis;
    protected String duracion;
    protected String categoria;
    protected String clasificacion;
    protected LinkedList<Metraje> miLista = new LinkedList<Metraje>();

    //Constructor.
    public Mi_lista() {
    }

    //Constrctor con parametros
    public Mi_lista(LinkedList<Metraje> miLista) {
        this.miLista = miLista;
    }

    public String getUser_p() {
        return user_p;

    }

    //Metodos get and set
    public void setUser_p(String user_p) {
        this.user_p = user_p;
    }

    public LinkedList<Metraje> getMiLista() {
        return miLista;
    }

    public void setMiLista(LinkedList<Metraje> miLista) {
        this.miLista = miLista;
    }

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

    //Metodos
    public void agregarLista(Metraje metraje) {
        this.miLista.add(metraje);
        System.out.println("**************************************************");
        System.out.println("\tAGREGAR A MI LISTA.");
        System.out.println("El título que has escogido, se ha agregado a Mi lista.");
    }

    public void borrarDeLista(String nombre) {

        boolean cont = true;

        for (Metraje me : miLista) {

            if (me.getNombre().equals(nombre)) {
                System.out.println("**************************************************");
                System.out.println("\tELIMINACION DE TÍTULO DE MI LISTA.");
                System.out.println("El título se ha eliminado de Mi lista.");
                miLista.remove(me);
                cont = false;

            }
        }
        if (cont != false) {
            System.out.println("**************************************************");
            System.out.println("No se ha encontrado el título dentro de tu lista.");
        }
    }

    public void consultarMiLista() {

        int iterador = 1;

        System.out.println("\tMI LISTA\n");
        for (Metraje me : miLista) {
            me.consultar();
            System.out.println("**************************************************");
            System.out.println("Título: " + iterador);
            System.out.println("Nombre: " + me.getNombre());
            System.out.println("Sinopsis: " + me.getSinopsis());
            System.out.println("Duracion: " + me.getDuracion());
            System.out.println("Clasificacion: " + me.getClasificacion());
            System.out.println("Categoria: " + me.getCategoria());

            iterador++;
        }
    }

    /**
     * Este metodo funciona para poder guardar en mi lista.
     *
     * @param nombre --> Será el nombre de la película que se guardará en Mi
     * lista.
     * @param usuario --> Este parametro funciona para pasar el nombre del
     * perfil y se escriba dentro del archivo con el perfil requerido.
     * @return --> Guardar en mi Lista
     */
    public boolean RegLista(String nombre, String usuario) {
        //Scanner scan = new Scanner(System.in);
        System.out.println("*************************************************");
        System.out.println("************   Guardar en mi lista   ************\n");
        this.nombre = nombre;

        this.user_p = usuario;

        System.out.println("*************************************************");
        System.out.println("\n");
        return GuardarLista();

    }

    /**
     * se guarda la informacion de la lista.
     *
     * @return
     */
    public boolean GuardarLista() {
        try {
            return CrearLista(nombre, user_p);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Función donde se crea el archivo para guardar los títulos que el usuario
     * desea.
     *
     * @param nombre --> Será el nombre del título que el usuario guardará
     * dentro de Mi lista.
     * @param user_p --> Será el nombre del perfil en donde se guadarán los
     * títulos.
     * @return
     * @throws IOException
     */
    public static boolean CrearLista(String nombre, String user_p) throws IOException {

        FileWriter archivo = null;
        PrintWriter pw = null;
        File formato;
        formato = new File("MiLista_" + user_p + ".txt");

        if (!formato.exists()) {
            try {
                formato.createNewFile();
                archivo = new FileWriter(formato, true);
                pw = new PrintWriter(archivo);
                pw.println(nombre);

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
                pw.println(nombre);

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
     * @param oldString --> El título que deseas eliminar.
     * @param newString --> La paabara eliminada.
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
}
