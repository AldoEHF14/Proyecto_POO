package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public abstract class Plan {

    protected String plan;
    protected int pago;
    protected String tipodepago;

    public Plan(String plan, int pago, String tipodepago) {
        this.plan = plan;
        this.pago = pago;
        this.tipodepago = tipodepago;
    }

    public Plan() {

    }

    public abstract void TipoDePlan(String user_p);
    //public void detalles() {}

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public String getTipodepago() {
        return tipodepago;
    }

    public void setTipodepago(String tipodepago) {
        this.tipodepago = tipodepago;
    }

    /**
     * Esta funcion nos ayudara mostrar los detalles del plan que alla
     * seleccionado el usuario
     */
    public void detalles() {
        System.out.println("Plan: " + this.plan);
        System.out.println("Pago: " + this.pago);
        System.out.println("Tipodepago: " + this.tipodepago);

    }

    /**
     * Este metodo nos ayudar a guardar en un archivo los datos del plan
     * seleccionado por el usuario.
     *
     * @param user_p
     * @return
     */
    public static Plan PlanUsuario(String user_p) {
        Plan p = null;
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
            p = new PlanBasico();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split("=");
                if (keyValue[0].equals(("Plan"))) {
                    p.setPlan(keyValue[1]);
                } else if (keyValue[0].equals("Pago")) {
                    p.setPago(Integer.parseInt(keyValue[1]));
                } else if (keyValue[0].equals("FormatoDePago")) {
                    p.setTipodepago(keyValue[1]);
                }
                flag = true;
            }

        } catch (IOException | NumberFormatException e) {
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return p;
                }
            } catch (IOException e2) {
                System.err.println("Error al cerrar el archivo");
            }
        }
        return null;
    }

}
