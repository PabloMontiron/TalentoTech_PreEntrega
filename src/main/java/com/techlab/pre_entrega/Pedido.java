package com.techlab.pre_entrega;
import java.util.ArrayList;
import java.util.Scanner;

// -->EN DESARROLLO<--
public class Pedido {

    private ArrayList<Producto> lProductos = new ArrayList<>();
    private int idPedido;
    private Cliente cliente;
    private double montoTotal;

    private static int totalDePedidosRealizados = 1;

    // Const
    public Pedido() {};

    public Pedido(Cliente cliente, ArrayList<Producto> lista) {
        this.setIdPedido(totalDePedidosRealizados);
        this.lProductos = new ArrayList<>(lista);
        this.setCliente(cliente);
        totalDePedidosRealizados++;
    }

    // Get & Set
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    // Metodos
    public void agregarProductoAlPedido(Producto producto) {
        lProductos.add(producto);

        System.out.println("Producto agregado.");
        System.out.println("------------------");
    }

    public void nuevoPedido(Catalogo catalogo, Cliente cliente, GestorPedidos gp) {
        Scanner sc = new Scanner(System.in);

        boolean finWhilePedido = false;
        while (!finWhilePedido) {
            System.out.println("Seleccione producto y cantidad. Se listarán las opciones que coincidan con la busqueda.");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("Nombre de producto: ");
            String nomProd = Utils.formatearString(sc.nextLine());

            ArrayList<Producto> resultado = catalogo.buscarProductoPorNombre(nomProd);

            if (!resultado.isEmpty()) {
                System.out.println("Resultado de busqueda");
                System.out.println("---------------------");

                int posProd = 1;
                for (Producto p : resultado) {
                    System.out.println("Posicion: " + posProd + ", Prod: " + p.getNombre());
                    posProd++;
                }
                System.out.println("---- ---- ---- ---- ---- ----");

                System.out.print("Ingrese el número de posición del producto a agregar o 0 'cero' para volver atrás: ");
                int resp = sc.nextInt();
                sc.nextLine();

                if ((resp >= 1) && (resp <= resultado.size())) {
                    Producto prodSelec = resultado.get(resp - 1);
                    System.out.println("Seleccionaste el producto: " + prodSelec.getNombre());

                    boolean finWhile = false;
                    while (!finWhile) {
                        System.out.println("Quiere agregar el producto al pedido?");
                        System.out.println("1: Agregar");
                        System.out.println("2: Volver atras");
                        resp = sc.nextInt();
                        sc.nextLine();

                        if (resp == 1) {
                            agregarProductoAlPedido(prodSelec);

                            System.out.println("Se agrego el producto al pedido.");
                            finWhile = true;

                        } else if (resp != 2) {
                            System.out.println("Ingresaste un valor fuera de rango.");
                        }
                    }

                    finWhile = false;
                    while (!finWhile) {
                        System.out.println("Quiere agregar otro producto al pedido?");

                        System.out.println("1: Agregar otro producto");
                        System.out.println("2: Finalizar pedido");
                        resp = sc.nextInt();
                        sc.nextLine();

                        if (resp == 2) {
                            System.out.println("Pedido finalizado");
                            System.out.println("-----------------");

                            Pedido nuevoPedido = new Pedido(cliente,lProductos);
                            gp.agregarPedidoAlGestor(nuevoPedido);
                            finWhile = true;
                            finWhilePedido = true;

                        } else if (resp == 1) {
                            finWhile = true;
                        } else {
                            System.out.println("Inresaste un valor fuera de rango");
                        }
                    }

                } else {
                    System.out.println("----");
                }
            } else {
                System.out.println("No se encontraron productos con esas palabras");
            }
        }
    }

    @Override
    public String toString() {
        String aux = "";

        aux += "ID Pedido: " + this.getIdPedido() + "\n";

        if (cliente != null) {
            aux += cliente.getNombreCompleto() + "\n";
        }

        if (!lProductos.isEmpty()) {
            aux += "Detalles del pedido: \n";
            System.out.println("--------------------");
            for (Producto p : lProductos) {
                aux += p.getNombre() +  "\n";
                aux += p.getPrecio() + " $ " +  "\n";
                aux += "Cantidad: ---- " +  "\n";
            }
            aux += "Total a abonar: ---- $ " + "\n";

        } else {
            return "No hay ningún producto en este pedido.\n";
        }
        return aux;
    }

}
