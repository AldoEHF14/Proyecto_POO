
package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Clase buscador; donde el usuario podrá buscar algún título del cátalogo, ya
 * sea serie, película o documental.
 *
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Buscador {
    //Atributo.

    protected String buscar;

    //Crear constructor.
    public Buscador(String buscar) {
        this.buscar = buscar;
    }

    public Buscador() {

    }

    //Metodos get and set
    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    /**
     * Función de tipo cátalogo; donde el metodo consulta el archivo donde se
     * encuentra este título, en caso de no encontrarlo, el programa te dirá que
     * no existe.
     *
     * @param nombre --> nombre del título que deseas buscar.
     * @param tipo --> Aqí se pasará el tipo del título que estas buscando, ya
     * sea serie, peli o documental.
     * @return --> El nombre y la sinopsis.
     */
    public Catalogo buscarPorNombre(String nombre, String tipo) {

        //Creamos el tipo catalogo
        Catalogo catalogo = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(tipo + nombre + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            catalogo = new Catalogo();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split(":");

                if (keyValue[0].equals(("Nombre"))) {
                    catalogo.setNombre(keyValue[1]);
                    System.out.println(catalogo.getNombre());
                } else if (keyValue[0].equals("Sinopsis")) {
                    catalogo.setSinopsis(keyValue[1]);
                    System.out.println(catalogo.getSinopsis());
                }
            }
        } catch (Exception e) {
            System.out.println("!Ay¡ Esa opcion no esta disponible.");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return catalogo;
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo");
            }
        }
        return null;
    }
}
