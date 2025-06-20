package com.techlab.pre_entrega;
import java.util.ArrayList;
import java.util.Scanner;

// -->EN DESARROLLO<--
public class Pedido {

    private ArrayList<Producto> lPedido;
    private int idPedido ;
    private Cliente cliente;
    private double montoTotal;

    private static int totalDePedidosRealizados;

    // Const
    public Pedido() {
        lPedido = new ArrayList<>();

        this.setIdPedido(idPedido++);

        totalDePedidosRealizados++; // luego --> incrementa cuando se concreta el pedido!
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
        lPedido.add(producto);

        System.out.println("Producto agregado.");
        System.out.println("------------------");
    }

    public void nuevoPedido(Catalogo catalogo, Cliente cliente) { // de momento es VOID... el main es quien tiene el catalogo, solo encuentro esa forma de conectarlos
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione producto y cantidad. Se listaran las opciones que coincidan con la busqueda.");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.print("Nombre de producto: ");
        String nomProd = Utils.formatearString(sc.nextLine());

        ArrayList<Producto> resultado =  catalogo.buscarProductoPorNombre(nomProd);

        if (!resultado.isEmpty()) {
            System.out.println("Resultado de busqueda");
            System.out.println("---------------------");

            int posProd = 1;
            for (Producto p : resultado) {
                System.out.println("Posicion: " + posProd + ", Prod: " + p.getNombre());
                posProd++;
            }
            System.out.println("---- ---- ---- ---- ---- ----");

            System.out.print("Ingrese el número de posición del producto a modificar o 0 'cero' para volver atrás: ");
            int resp = sc.nextInt();
            sc.nextLine();

            if ((resp >= 1) && (resp <= resultado.size())) {
                Producto prodSelec = resultado.get(resp - 1);
                System.out.println("Seleccionaste el producto: " + prodSelec.getNombre());

                boolean finWhile = false;

                while (!finWhile) {
                    System.out.println("Ingrese 1 para agregar al pedido o 2 para volver atras.");
                    resp = sc.nextInt();
                    sc.nextLine();

                    if (resp == 1) {
                        agregarProductoAlPedido(prodSelec);
                        finWhile = true;
                    } else if (resp != 2) {
                        System.out.println("Ingrese una opción válida.");
                    }
                }

            }
        }

    }
    // toString
}
