package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Toda la informacion del plan estandar heredado de plan.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class PlanEstandar extends Plan {

    private Scanner scan = new Scanner(System.in);

    ;
    
    public PlanEstandar(String plan, int pago, String tipodepago) {
        super(plan, pago, tipodepago);
    }

    public PlanEstandar() {
    }

    /**
     * Nos ayudara a guardar los datos del plan seleecionado por el usuario.
     *
     * @param user_p
     */
    @Override
    public void TipoDePlan(String user_p) {
        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        archivo = new File("usuario_" + user_p + ".txt");

        try {
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);
            //Escribimos en el archivo
            linea.println("Plan=" + getPlan());
            linea.println("Pago=" + getPago());
            linea.println("FormatoDePago=" + getTipodepago());
            linea.close();
            escribir.close();

        } catch (IOException ex) {
            System.err.println("Error al escribir archivo al texto de pago");
        }
    }

}
