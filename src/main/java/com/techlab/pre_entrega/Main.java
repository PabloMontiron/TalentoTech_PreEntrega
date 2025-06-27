package com.techlab.pre_entrega;
import com.techlab.pre_entrega.excepciones.CadenaInvalidaException;
import com.techlab.pre_entrega.excepciones.PrecioInvalidoException;
import com.techlab.pre_entrega.excepciones.StockInvalidoException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        GestorClientes gc = new GestorClientes();
        GestorPedidos gp = new GestorPedidos();

        // --> Instancio algunos productos a modo de facilitar el uso de las funciones del menu <--
        try {
            catalogo.agregarProductoAlCatalogo(new Infusion("Cafe en grano", 2500, 50));
            catalogo.agregarProductoAlCatalogo(new Infusion("Te de Jazmin", 3500, 30));
            catalogo.agregarProductoAlCatalogo(new Alimento("Galletitas FreeGult", 5000, 20, "500 gr", "17/06/2026"));
            catalogo.agregarProductoAlCatalogo(new Alimento("Galletitas GoldGult", 5000, 20, "200 gr", "17/06/2026"));
            catalogo.agregarProductoAlCatalogo(new Alimento("Chocotorta ChumpCrock", 3800, 17, "300 gr", "25/05/2026"));
            catalogo.agregarProductoAlCatalogo(new Infusion("Yerba Mate La Tranquera", 2200, 10));
        } catch (PrecioInvalidoException | StockInvalidoException | CadenaInvalidaException e) {
            System.out.println("Error al cargar los productos.");
        }
        // -- --

        // --> se puede mejorar la modularizacion.
        boolean finWhilePrograma = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Comienza Programa");
        System.out.println("xxxxxxxxxxxxxxxxx");
        int resp = 0; // var generica global para ingresar int

        while (!finWhilePrograma) {
            boolean respOk = false;
            while (!respOk) {
                try {
                    System.out.println("Ingrese una opcion: ");
                    System.out.println("------------------- ");
                    System.out.println("1: Agregar producto");
                    System.out.println("2: Listar productos");
                    System.out.println("3: Buscar/Actualizar producto");
                    System.out.println("4: Eliminar producto");
                    System.out.println("5: Crear pedido");
                    System.out.println("6: Listar pedidos");
                    System.out.println("7: Salir");

                    System.out.print("Respuesta: ");
                    resp = sc.nextInt();
                    sc.nextLine();
                    respOk = true;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un valor numérico.");
                    sc.nextLine();
                }
            }
            switch (resp) {
                // Agregar producto
                case 1:
                    boolean finWhileProducto = false;
                    while (!finWhileProducto) {
                        catalogo.agregarProducto();

                        respOk = false;
                        while (!respOk) {
                            try {
                                System.out.println("1: Agregar otro producto");
                                System.out.println("2: Volver al menu principal");

                                System.out.print("Respuesta: ");
                                resp = sc.nextInt();
                                sc.nextLine();
                                respOk = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Debe ingresar un valor numérico.");
                                sc.nextLine();
                            }
                        }

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

                    respOk = false;
                    String fin = "";
                    while (!respOk) {
                        try {
                            System.out.print("Ingrese cualquier tecla para continuar.");
                            fin = sc.nextLine();
                            Utils.validarCadena(fin);
                            respOk = true;
                        } catch (CadenaInvalidaException e) {
                            System.out.println("No se registro ningún dato.");
                        }
                    }
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
                            respOk = false;
                            while (!respOk) {
                                try {
                                    System.out.println("Ingrese una respuesta");
                                    System.out.println("1: Buscar por ID de producto");
                                    System.out.println("2: Buscar por palabras clave (Ej: Chocolate Blanco Felfort)");
                                    System.out.println("3: Salir al menú anterior");

                                    System.out.println();

                                    System.out.print("Respuesta: ");
                                    resp = sc.nextInt();
                                    sc.nextLine();
                                    respOk = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("Debe ingresar un valor numérico.");
                                    sc.nextLine();
                                }
                            }

                            if (resp == 1) {
                                Producto prodSelec = null;
                                boolean idOk =false;
                                int idProducto = 0;
                                while (!idOk) {
                                    try {
                                        System.out.print("ID de producto: ");
                                        idProducto = sc.nextInt();
                                        sc.nextLine();
                                        prodSelec = catalogo.buscarProductoPorId(idProducto);

                                        idOk = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Debe ingresar un valor numérico.");
                                        sc.nextLine();
                                    }
                                }

                                if (prodSelec != null) {
                                    System.out.println("Seleccionaste el producto: " + prodSelec.getNombre());
                                    System.out.println("-------------------------");
                                    prodSelec.actualizarProducto(prodSelec);

                                } else {
                                    System.out.println("No se encontro ningun producto con ID: " + idProducto);
                                }

                            } else if (resp == 2) {
                                ArrayList<Producto> resultado = null;
                                boolean resultOk = false;
                                while (!resultOk) {
                                    try {
                                        System.out.print("Palabras clave: ");
                                        String palabras = Utils.formatearString(sc.nextLine());
                                        Utils.validarCadena(palabras);
                                        resultado = catalogo.buscarProductoPorNombre(palabras);
                                        resultOk = true;
                                    } catch (CadenaInvalidaException e) {
                                        System.out.println("No se registro ningún dato.");
                                    }
                                }

                                if (!resultado.isEmpty()) {
                                    System.out.println("Resultado de búsqueda:");

                                    int posProd = 1;
                                    for (Producto p : resultado) {
                                        System.out.println("Posición: " + posProd + " : " + p.getNombre());
                                        posProd++;
                                    }
                                    System.out.println("---- ---- ---- ---- ----");

                                    respOk = false;
                                    while (!respOk) {
                                        try {
                                            System.out.print("Ingrese el número de posición del producto a modificar o 0 'cero' para volver atrás: ");
                                            resp = sc.nextInt();
                                            sc.nextLine();
                                            respOk = true;

                                        } catch (InputMismatchException e) {
                                            System.out.println("Debe ingresar un valor numérico.");
                                        }
                                    }

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

                // Crear pedido
                case 5:
                    System.out.println("Crear pedido");
                    System.out.println("------------");
                    Cliente cliente = gc.obtenerCliente();

                    if (cliente == null) {
                        System.out.println("Operación cancelada."); // no olvidar que el met obtenerCliente retornara null luego de buscar por id o crear un cliente. null = op cancelada directamente
                        System.out.println("--------------------");
                    } else {
                        // si existe un cliente se continua con el pedido
                        Pedido pedido = new Pedido();

                        pedido.nuevoPedido(catalogo,cliente,gp);
                    }

                    break;
                case 6:
                    // Listar pedidos
                    System.out.println("Lista de prdidos");
                    System.out.println(gp.toString());

                    respOk = false;
                    while (!respOk) {
                        try {
                            System.out.print("Ingrese cualquier tecla para continuar: ");
                            fin = sc.nextLine();
                            Utils.validarCadena(fin);
                            respOk = true;
                        } catch (CadenaInvalidaException e) {
                            System.out.println("No se registro ningún dato.");
                        }
                    }
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
