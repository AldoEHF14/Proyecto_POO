/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netflix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Toda la informacion del plan premium heredado de plan.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class PlanOptima extends Plan {

    private Scanner scan = new Scanner(System.in);

    ;
    
    public PlanOptima(String plan, int pago, String tipodepago) {
        super(plan, pago, tipodepago);
    }

    public PlanOptima() {
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
