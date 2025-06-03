package com.mycompany.netflix;

import java.util.Scanner;

/**
 * Clase que hereda de la clase Metraje; en esta clase se muestran los títulos
 * que estan disponibles en la plataforma, junto con ello el método para agregar
 * a mi lista.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Catalogo extends Metraje {

    //Conctructor vacio
    public Catalogo() {

    }

    //Metodos get and set
    //Metodos de la clase.
    public void mostrarCatalogo() {

    }

    /**
     * Método donde se observará que título que se esta reproduciendo, teniendo
     * tres opciones de usuario; Pausar el título, agregar a Mi lista, y salir
     * de este metodo.
     *
     * @param nombre --> Recibe el nombre de la pélicula.
     * @param usuario --> Este parametro funciona para pasar el perfil en el que
     * se va a guardar el título de Mi lista.
     */
    public void reproduccionDeTítulo(String nombre, String usuario) {
        int choose = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("************************************************************************");
            System.out.println("*                                                                      *");
            System.out.println(">>>>>>>>\t El titulo: " + nombre + " se esta reproduciendo");
            System.out.println("*                                                                      *");
            System.out.println("************************************************************************");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("|                                                                      |");
            System.out.println("| 0:00 _______________________________________________________________ |");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("************************************************************************");
            System.out.println("*Presiona '1' para pausar el titulo                                    *");
            System.out.println("*Presiona '2' para agregar a Mi lista.                                 *");
            System.out.println("*Presiona '3' para salir del reproductor                               *");
            System.out.println("************************************************************************");
            choose = scan.nextInt();
            switch (choose) {
                case 1: {
                    System.out.println("El titulo: " + nombre + " se pauso");

                    System.out.println("Presiona '1' para continuar el titulo");
                    choose = scan.nextInt();
                    break;
                }
                case 2: {
                    Mi_lista ML = new Mi_lista();
                    int i;
                    Scanner ML1 = new Scanner(System.in);
                    System.out.println("¿Deseas agregar este título a Mi lista? Sí[1]/No[0]");
                    i = ML1.nextInt();
                    while (i == 1) {
                        ML.RegLista(nombre, usuario);
                        System.out.println("El título se ha agregado a Mi lista");
                        break;

                    }
                    break;
                }
                case 3: {
                    System.out.println("Adios.");
                    break;
                }
            }

        } while (choose != 3);

    }

    @Override
    public void guardar() {

    }

    @Override
    public void consultar() {

    }

    @Override
    public void detalles() {

    }

    @Override
    public void eliminar() {

    }

}
