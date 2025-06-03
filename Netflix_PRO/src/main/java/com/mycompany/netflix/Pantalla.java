package com.mycompany.netflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Sub-clase principal --> donde se llaman a todos los metodos de todas las
 * clases para que el programa funcione de la mejor manera.
 *
 * @author Aldo Hérnandez, Héctor Vázquez, Luis Soto, Bryan Alexander.
 */
public class Pantalla {

    private Scanner scan;
    public boolean acceso;

    public Pantalla() {
        scan = new Scanner(System.in);
    }

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    /**
     * Pantalla principal, donde se manejan los metodos para registrar al
     * usuario, iniciar sesión, recuperar contraseña y salir del programa.
     */
    public void PantallaPrincipal() {

        Usuario u = new Usuario();
        Cuenta c = new Cuenta();
        int op;

        do {
            System.out.println("***********************************************************************");
            System.out.println("*                        BIENVENIDO A NETFLIX                         *");
            System.out.println("***********************************************************************");
            System.out.println("* 1. Registrar Usuario                                                *");
            System.out.println("* 2. Iniciar sesión                                                   *");
            System.out.println("* 3. Recuperar Contraseña                                             *");
            System.out.println("* 4. Salir                                                            *");
            System.out.println("***********************************************************************");
            System.out.println("Ingrese la opcion deseada:");
            op = scan.nextInt();

            switch (op) {
                case 1: {
                    if (u.RegistrarUsuario()) {
                        System.out.println("¡El registro del Usuario ha sido existoso!");
                        if (RegistrarDatosPlan(u)) {
                            System.out.println("¡El registro exitoso!");
                        } else {
                            System.err.println("El registro no fue exitoso.");
                        }
                    } else {
                        System.err.println("El registro del Usuario no fue exitoso.");
                    }
                    PantallaPrincipal();
                    break;
                }
                case 2: {
                    c.showIniciarSesion();
                    break;
                }
                case 3: {

                    boolean recuperacion = c.RecuperaCuenta();

                    int j = 1;
                    do {
                        if (j != 1) {
                            recuperacion = c.RecuperaCuenta();
                        }

                        if (recuperacion) {
                            System.out.println("Cuenta Recuparada con Exito.");
                            op = 2;
                        } else {
                            j++;
                            System.out.println("Datos No Validos");
                            System.out.println("Ingrese la opcion deseada: (1) Reintentar, (2) Salir al menu.");
                            op = scan.nextInt();
                        }
                    } while (op != 2);

                    PantallaPrincipal();
                    break;
                }
                case 4: {
                    System.out.println("Hasta Pronto");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida");
                }
            }
            break;

        } while (op != 4);
    }

    /**
     * Se registra al usuario para que pueda acceder al plan que el usuario
     * quisiera, que metodo de pago usará.
     *
     * @param u --> parametro de tipo usuario que seguirá con el prceso de
     * registro.
     * @return --> Todos los datos del usuario ya registrado.
     */
    public boolean RegistrarDatosPlan(Usuario u) {

        Plan p = null;
        int opc, op;
        String Metododepago = null;

        System.out.println("***********************************************************************");
        System.out.println("*                                                                     *");
        System.out.println("*                 SELLECIONA EL PLAN IDEAL PARA TI                    *");
        System.out.println("*                                                                     *");
        System.out.println("***********************************************************************");
        System.out.println("*                                                                     *");
        System.out.println("*Ver todo lo que quieras.Sin anuncios                                 *");
        System.out.println("*                                                                     *");
        System.out.println("*   PLAN BASICO     **   PLAN ESTANDAR   **    PLAN PREMIUM           *");
        System.out.println("*       $139        **       $196        **      $266                 *");
        System.out.println("*       MEJOR       **       BUENA       **      OPTIMA               *");
        System.out.println("*       480P        **       1080P       **      4K+HDR               *");
        System.out.println("*                                                                     *");
        System.out.println("***********************************************************************");

        do {
            System.out.println("***********************************************************************");
            System.out.println("*                                                                     *");
            System.out.println("* Ingresa tu plan:                                                    *");
            System.out.println("* 1: Basico                                                           *");
            System.out.println("* 2: Estandar                                                         *");
            System.out.println("* 3. Premium                                                          *");
            System.out.println("*                                                                     *");
            System.out.println("***********************************************************************");
            op = scan.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("* Formato de Pago                                                     *");
                    System.out.println("*   (1) Tarjeta                                                       *");
                    System.out.println("*   (2) Efectivo                                                      *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************");
                    opc = scan.nextInt();
                    if (opc == 1) {
                        Metododepago = "Tarjeta";
                    } else if (opc == 2) {
                        Metododepago = "Efectivo";
                    }
                    PlanBasico pb = new PlanBasico("Basico", 139, Metododepago);
                    pb.TipoDePlan(u.getUser_p());
                }
                case 2 -> {
                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("* Formato de Pago                                                     *");
                    System.out.println("*   (1) Tarjeta                                                       *");
                    System.out.println("*   (2) Efectivo                                                      *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************");
                    opc = scan.nextInt();
                    if (opc == 1) {
                        Metododepago = "Tarjeta";
                    } else if (opc == 2) {
                        Metododepago = "Efectivo";
                    }
                    PlanEstandar pb = new PlanEstandar("Estandar", 196, Metododepago);
                    pb.TipoDePlan(u.getUser_p());
                }
                case 3 -> {
                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("* Formato de Pago                                                     *");
                    System.out.println("*   (1) Tarjeta                                                       *");
                    System.out.println("*   (2) Efectivo                                                      *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************");
                    opc = scan.nextInt();
                    if (opc == 1) {
                        Metododepago = "Tarjeta";
                    } else if (opc == 2) {
                        Metododepago = "Efectivo";
                    }
                    PlanEstandar pb = new PlanEstandar("Premium", 266, Metododepago);
                    pb.TipoDePlan(u.getUser_p());
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }

        } while (op < 1 || op > 3);

        return true;
    }

    /**
     * Todos los metodos que contiene netflix: Buscar algún título. Ver Mi lista
     * Los títulos que estan próximos a estrenarse. Estado de cuenta de la
     * cuenta que se resgistró, desde el correo hasta el plan que contrató. El
     * módificar info, desde la contraseña y el plan al que esta suscrito. Y por
     * último el eliminar por completo la cuenta.
     *
     * @param c --> Recibe como parametro la cuenta con la que se registró o con
     * la que se inicio la sesión.
     */
    public void PerfilNetflix(Cuenta c) {

        Usuario u = new Usuario();

        int opcion;
        boolean cont = false;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("***********************************************************************");
            System.out.println("*                                                                     *");
            System.out.println("*                      ¿Quién está viendo ahora?                      *");
            System.out.println("*                                " + c.getUser_p() + "                              *");
            System.out.println("*                                                                     *");
            System.out.println("***********************************************************************");
            System.out.println("*                                                                     *");
            System.out.println("*                         CONTENIDO DE NETFLIX:                       *");
            System.out.println("*                                                                     *");
            System.out.println("***********************************************************************");
            System.out.println("* 1: Buscar                                                           *");
            System.out.println("* 2: Ver Mi Lista.                                                    *");
            System.out.println("* 3. Proximamente.                                                    *");
            System.out.println("* 4. Catalogo.                                                        *");
            System.out.println("* 5. Estado de Cuenta.                                                *");
            System.out.println("* 6. Módificar Informacion.                                            *");
            System.out.println("* 7. Eliminar Cuenta.                                                 *");
            System.out.println("* 8. Cerrar Sesión.                                                   *");
            System.out.println("*                                                                     *");
            System.out.println("***********************************************************************");
            System.out.println("*                                                                     *");
            System.out.println("*                         Digite una opcion:                          *");
            System.out.println("*                                                                     *");
            System.out.println("***********************************************************************");

            opcion = scan.nextInt();

            switch (opcion) {
                case 1: {
                    int choose;
                    String tipo = null, nombre;
                    do {
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("*                 ¿QUÉ TIPO DE CONTENIDO QUIERE BUSCAR?               *");
                        System.out.println("*                                                                     *");
                        System.out.println("* Teclea la funcion que desees:                                       *");
                        System.out.println("* 1: Serie                                                            *");
                        System.out.println("* 2: Pelicula                                                         *");
                        System.out.println("* 3: Documental                                                       *");
                        System.out.println("* 4. Regresar al menu principal                                       *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("*                         Digite una opcion:                          *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");

                        choose = scan.nextInt();

                        switch (choose) {
                            case 1:
                                tipo = "serie_";
                                cont = true;
                                break;
                            case 2:
                                tipo = "pelicula_";
                                cont = true;
                                break;
                            case 3:
                                tipo = "documental_";
                                cont = true;
                                break;
                            case 4:
                                System.out.println("***********************************************************************");
                                System.out.println("*                                                                     *");
                                System.out.println("*                           Adios                                     *");
                                System.out.println("*                                                                     *");
                                System.out.println("***********************************************************************");
                                cont = false;
                                break;

                        };
                        if (cont != false) {
                            System.out.println("***********************************************************************");
                            System.out.println("*                                                                     *");
                            System.out.println("*                 Busca el título que deseas:                         *");
                            System.out.println("*                                                                     *");
                            System.out.println("***********************************************************************");
                            Scanner tit = new Scanner(System.in);
                            nombre = tit.nextLine();
                            Buscador buscar = new Buscador();
                            buscar.buscarPorNombre(nombre, tipo);
                        }

                    } while (choose != 4);
                    break;

                }

                case 2: {
                    int elim;
                    String title;
                    Scanner eliminar = new Scanner(System.in);
                    Scanner eliminar1 = new Scanner(System.in);
                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("*                             Mi Lista                                *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************");
                    MiListaDB.consultarLista(c.getUser_p());
                    Mi_lista ML = new Mi_lista();
                    System.out.println("\n");
                    System.out.println("¿Deseas eliminar algún título? Sí[1]/No[0]");
                    elim = eliminar.nextInt();
                    while (elim == 1) {
                        System.out.println("Escribe el nombre de la pélicula que deseas eliminar: ");
                        title = eliminar1.nextLine();
                        ML.modifyFile("MiLista_" + c.getUser_p() + ".txt", title, "");
                        System.out.println("El título se ha eliminado de mi lista.");
                        break;
                    }
                    System.out.println("\n");

                    break;
                }
                case 3: {
                    int salir = 1;
                    do {
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("*                         Proximamente....                            *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");

                        Proximamente ref1 = new Proximamente();
                        ref1.consultar();

                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("* Pulsa 2 para regresar al menú principal                             *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        salir = scan.nextInt();
                    } while (salir != 2);
                    break;
                }

                case 4: {
                    Scanner scan2 = new Scanner(System.in);
                    String nombre;
                    int seleccionar;

                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("*                         CATALOGO                                    *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************\n");

                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("*                         Peliculas                                   *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************");
                    Pelicula P = new Pelicula();
                    P.consultar();
                    System.out.println("\n***********************************************************************");
                    System.out.println("*                                                                       *");
                    System.out.println("*                         Series                                        *");
                    System.out.println("*                                                                       *");
                    System.out.println("***********************************************************************\n");
                    Serie S = new Serie();
                    S.consultar();
                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("*                         Documentales                                *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************\n");
                    Documental D = new Documental();
                    D.consultar();
                    do {
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("* ¿Deseas ver algun titulo del catalogo?                              *");
                        System.out.println("*   (1) SI                                                            *");
                        System.out.println("*   (2) NO                                                            *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        seleccionar = scan.nextInt();
                        if (seleccionar != 1 && seleccionar != 2) {
                            System.out.println("Seleccion inválida, intente de nuevo.");
                        }

                        Catalogo cat = new Catalogo();
                        switch (seleccionar) {
                            case 1: {

                                System.out.println("Ingresa el titulo que quieres reproducir:");
                                nombre = scan2.nextLine();
                                cat.reproduccionDeTítulo(nombre, c.getUser_p());
                                break;

                            }
                            case 2: {
                                System.out.println("adios");
                                break;
                            }
                        }

                    } while (seleccionar != 2);
                    break;
                }

                case 5: {
                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("*                   Estado Actual De La Cuenta.                       *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************");
                    UsuarioDB.consultar(c.getUser_p());
                    int k = 0;
                    do {
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("* Presiona (2) para salir                                             *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        k = scan.nextInt();
                    } while (k != 2);

                    break;
                }

                case 6: {

                    int modificar;
                    do {
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("*                      Modificar Informacion.                         *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("* Teclea la funcion que desees:                                       *");
                        System.out.println("* 1: Modificar Password                                               *");
                        System.out.println("* 2: Modificar Plan                                                   *");
                        System.out.println("* 3. Regresar al menu principal                                       *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("*                         Digite una opcion:                          *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        modificar = scan.nextInt();
                        switch (modificar) {
                            case 1: {
                                String LineaE = c.getUser() + "," + c.getPassword() + "," + c.getUser_p();
                                System.out.println("Ingresa la Nueva Contraseña");
                                String new_password = scan.next();
                                String LineaN = c.getUser() + "," + new_password + "," + c.getUser_p();
                                String archivoU = "usuario_" + c.getUser_p() + ".txt";

                                Usuario.modifyFile("sesion.txt", LineaE, LineaN);
                                Usuario.modifyFileUsuario(archivoU, c.getPassword(), new_password);
                                System.out.println("Tu contraseña se ha modificado exitosamente.");
                                System.out.println("\"Podrás cambiar tu contraseña de nuevo cuando vuelvas a iniciar sesión\".");

                                break;
                            }
                            case 2: {

                                try {
                                    Plan p = null;
                                    p = Plan.PlanUsuario(c.getUser_p());
                                    p.detalles();
                                    System.out.println("***********************************************************************");
                                    System.out.println("*                                                                     *");
                                    System.out.println("*                   SELLECIONA EL PLAN IDEAL PARA TI                  *");
                                    System.out.println("*                                                                     *");
                                    System.out.println("* Ver todo lo que quieras.Sin anuncios                                *");
                                    System.out.println("*                                                                     *");
                                    System.out.println("*   PLAN BASICO     **   PLAN ESTANDAR   **    PLAN PREMIUM           *");
                                    System.out.println("*       $139        **       $196        **      $266                 *");
                                    System.out.println("*       MEJOR       **       BUENA       **      OPTIMA               *");
                                    System.out.println("*       480P        **       1080P       **      4K+HDR               *");
                                    System.out.println("*                                                                     *");
                                    System.out.println("***********************************************************************");
                                    int opc, op;
                                    boolean a = false;
                                    String Metododepago = null;
                                    String plan = null;
                                    String pago = null;
                                    do {
                                        System.out.println("***********************************************************************");
                                        System.out.println("*                                                                     *");
                                        System.out.println("* Ingresa tu plan:                                                    *");
                                        System.out.println("* 1: Basico                                                           *");
                                        System.out.println("* 2: Estandar                                                         *");
                                        System.out.println("* 3. Premium                                                          *");
                                        System.out.println("*                                                                     *");
                                        System.out.println("***********************************************************************");
                                        op = scan.nextInt();

                                        switch (op) {
                                            case 1 -> {
                                                plan = "Basico";
                                                pago = "139";
                                                a = true;
                                            }
                                            case 2 -> {
                                                plan = "Estandar";
                                                pago = "196";
                                                a = true;
                                            }
                                            case 3 -> {
                                                plan = "Premium";
                                                pago = "266";
                                                a = true;
                                            }

                                            default -> {
                                                System.out.println("Opcion no valida");
                                            }
                                        }
                                        if (a != false) {
                                            System.out.println("***********************************************************************");
                                            System.out.println("*                                                                     *");
                                            System.out.println("* Formato de Pago:                                                    *");
                                            System.out.println("* 1: Tarjeta                                                          *");
                                            System.out.println("* 2: Efectivo                                                         *");
                                            System.out.println("*                                                                     *");
                                            System.out.println("***********************************************************************");
                                            opc = scan.nextInt();
                                            if (opc == 1) {
                                                Metododepago = "Tarjeta";
                                            } else if (opc == 2) {
                                                Metododepago = "Efectivo";
                                            }
                                        }
                                        String user_p = "usuario_" + c.getUser_p() + ".txt";
                                        Usuario.modifyFileUsuario(user_p, p.getPlan(), plan);
                                        String pago1;
                                        pago1 = Integer.toString(p.getPago());
                                        Usuario.modifyFileUsuario(user_p, pago1, pago);
                                        Usuario.modifyFileUsuario(user_p, p.getTipodepago(), Metododepago);

                                    } while (op < 1 || op > 3);

                                } catch (Exception e2) {
                                    System.out.print("Error");
                                }

                                break;
                            }
                            case 3: {
                                break;
                            }
                            default: {
                                System.out.println("Opcion no valida");
                                break;
                            }

                        }
                        break;
                    } while (modificar != 3);
                    break;
                }

                case 7: {
                    int eliminar = 0;
                    String perfil0;
                    Scanner elim = new Scanner(System.in);
                    do {
                        System.out.println("***********************************************************************");
                        System.out.println("*                                                                     *");
                        System.out.println("*                           ELIMINAR CUENTA                           *");
                        System.out.println("*                                                                     *");
                        System.out.println("***********************************************************************");
                        System.out.println("¿Deseas eliminar la cuenta? (1)SI / (2)NO");
                        eliminar = elim.nextInt();
                        switch (eliminar) {
                            case 1: {
                                String LineaE = c.getUser() + "," + c.getPassword() + "," + c.getUser_p();
                                Usuario.modifyFile("sesion.txt", LineaE, "");
                                UsuarioDB.eliminarUsuario(c.getUser_p());

                                opcion = 8;
                                PantallaPrincipal();
                                break;
                            }
                            case 2: {
                                break;
                            }
                            default: {
                                System.out.println("Opcion no valida");
                                break;
                            }

                        }
                        break;
                    } while (eliminar != 2);
                    break;
                }
                case 8: {
                    System.out.println("***********************************************************************");
                    System.out.println("*                                                                     *");
                    System.out.println("*                           SESIÓN CERRADA.                           *");
                    System.out.println("*                                                                     *");
                    System.out.println("***********************************************************************");
                    PantallaPrincipal();
                    break;
                }

            }

        } while (opcion
                != 8);

    }

}
