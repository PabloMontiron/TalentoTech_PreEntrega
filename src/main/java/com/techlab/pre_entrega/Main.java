package com.techlab.pre_entrega;


import java.util.ArrayList;
import java.util.Scanner;

// -->FALTAN TRABAJAR TODAS LAS EXCEPCIONES Y TERMINAR DE DESARROLLAR LA GETION DE PEDIDOS<--
public class Main {
    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo(); // Instancio un catalogo
        GestorClientes gc = new GestorClientes();

        // --> Instancio algunos productos a modo de facilitar el uso de las funciones del menu <--
        catalogo.agregarProductoAlCatalogo(new Infusion("Cafe en grano",2500,50));
        catalogo.agregarProductoAlCatalogo(new Infusion("Te de Jazmin",3500,30));
        catalogo.agregarProductoAlCatalogo(new Alimento("Galletitas FreeGult",5000,20,"500 gr","17/06/2026"));
        catalogo.agregarProductoAlCatalogo(new Alimento("Galletitas GoldGult",5000,20,"200 gr","17/06/2026"));
        catalogo.agregarProductoAlCatalogo(new Alimento("Chocotorta ChumpCrock",3800,17,"300 gr","25/05/2026"));
        catalogo.agregarProductoAlCatalogo(new Infusion("Yerba Mate La Tranquera",2200,10));
        // -- --

        // Modularizar toda esta seccion del manejo del menu
        boolean finWhilePrograma = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Comienza Programa");
        System.out.println("xxxxxxxxxxxxxxxxx");
        int resp; // var generica global para ingresar int

        while (!finWhilePrograma) {
            System.out.println("Ingrese una opcion: ");
            System.out.println("------------------- ");

            System.out.println("1: Agregar producto");
            System.out.println("2: Listar productos");
            System.out.println("3: Buscar/Actualizar producto");
            System.out.println("4: Eliminar producto");
            System.out.println("5: Crear pedido // NO FINALIZADO");  // en desarrollo
            System.out.println("6: Listar pedidos // NO FINALIZADO"); // en desarrollo
            System.out.println("7: Salir");

            System.out.print("Respuesta: ");
            resp = sc.nextInt();

            switch (resp) {
                // Agregar producto
                case 1:
                    boolean finWhileProducto = false;
                    while (!finWhileProducto) {
                        catalogo.agregarProducto();

                        System.out.println("1: Agregar otro producto" + "\n" +
                                "2: Volver al menu principal");

                        System.out.print("Respuesta: ");
                        resp = sc.nextInt();
                        sc.nextLine();

                        if (resp == 2) {
                            finWhileProducto = true;
                        } else if (resp != 1) {
                            System.out.println("Ingrese una opción válida.");
                        }
                    }
                    break;
                // Listar productos
                case 2:
                    System.out.println("Lista de productos");
                    System.out.println("------------------");
                    System.out.println(catalogo.toString());
                    System.out.println("------------------");
                    System.out.println("Precione cualquier tecla para continuar.");

                    String fin = sc.nextLine();
                    sc.nextLine();
                    break;

                // Buscar producto y Actualizar datos
                case 3:
                    // buscarYActualizarProducto();
                    boolean finWhileBuscar = false;

                    while (!finWhileBuscar) {
                        System.out.println("Buscar/Actualizar producto");
                        System.out.println("--------------------------");
                        System.out.println("INFO");

                        System.out.println("-> Busqueda por ID: Solo muestra el producto por el ID especificado.");
                        System.out.println("-> Busqueda por palabras clave: Lista el o los productos que incluyan todas las palabras clave especificadas.");

                        boolean finWhile = false;

                        while (!finWhile) {
                            System.out.println("Ingrese una respuesta");
                            System.out.println("1: Buscar por ID de producto" + "\n" +
                                    "2: Buscar por palabras clave (Ej: Chocolate Blanco Felfort)" + "\n" +
                                    "3: Salir al menú anterior");

                            System.out.println();

                            System.out.print("Respuesta: ");
                            resp = sc.nextInt();
                            sc.nextLine();

                            if (resp == 1) {
                                System.out.print("ID de producto: ");
                                int idProducto = sc.nextInt();

                                Producto prodSelec = catalogo.buscarProductoPorId(idProducto);

                                if (prodSelec != null) {
                                    System.out.println("Seleccionaste el producto: " + prodSelec.getNombre());
                                    System.out.println("-------------------------");
                                    prodSelec.actualizarProducto(prodSelec);

                                } else {
                                    System.out.println("No se encontro ningun producto con ID: " + idProducto);
                                }

                            } else if (resp == 2) {
                                System.out.print("Palabras clave: ");

                                String palabras = Utils.formatearString(sc.nextLine());

                                ArrayList<Producto> resultado = catalogo.buscarProductoPorNombre(palabras);

                                if (!resultado.isEmpty()) {
                                    System.out.println("Resultado de búsqueda:");

                                    int posProd = 1;
                                    for (Producto p : resultado) {
                                        System.out.println("Posición: " + posProd + " : " + p.getNombre());
                                        posProd++;
                                    }
                                    System.out.println("---- ---- ---- ---- ---- ----");
                                    System.out.print("Ingrese el número de posición del producto a modificar o 0 'cero' para volver atrás: ");
                                    resp = sc.nextInt();
                                    sc.nextLine();

                                    if ((resp >= 1) && (resp <= resultado.size())) {
                                        Producto prodSelec = resultado.get(resp - 1);
                                        System.out.println("Seleccionaste: " + prodSelec.getNombre());

                                        prodSelec.actualizarProducto(prodSelec);
                                    } else if (resp != 0) {
                                        System.out.println("Ingresaste un valor fuera de rango.");
                                    }

                                } else {
                                    System.out.println("No se encontraron productos con esas palabras");
                                }


                            } else if (resp == 3) {
                                finWhile = true;
                                finWhileBuscar = true;

                            } else {
                                System.out.println("Ingrese una opcion válida.");
                            }

                        }
                    }
                    break;

                // Eliminar producto del catálogo
                case 4:
                    catalogo.eliminarProductoDelCatalogo();
                    break;

                case 5:
                    /* -->EN DESARROLLO<--
                    System.out.println("Crear pedido");
                    System.out.println("------------");
                    Cliente cliente = gc.obtenerCliente();

                    if (cliente == null) {
                        System.out.println("No se ha encontrado ningún cliente con esa ID.");
                    } else {

                    }
                     // aca ya tengo un cliente


                    */
                    break;
                case 6:
                    // NO INICIADO
                    break;
                case 7:
                    finWhilePrograma = true;
                    System.out.println("Fin del Programa.");
                    System.out.println("xxxxxxxxxxxxxxxxx");
                    break;
            }
        }
        // close " } " -> Main
    }
}
