package com.techlab.pre_entrega;

import java.util.ArrayList;
import java.util.Scanner;

// -->EN DESARROLLO<--
public class Pedido {
    private ArrayList<Producto> lPedido;
    private int idPedido = 0;
    private Cliente cliente;
    private double montoTotal;
    private static int totalDePedidosRealizados = 0;

    public Pedido() {
        lPedido = new ArrayList<>();
        this.setIdPedido(totalDePedidosRealizados); // podria poner -> setIdPedido(toalDePedidosRealizados++) como parte del parametro y evito la linea de abajo
        totalDePedidosRealizados++; // quizas mejor, incrementa cuando se concreta el pedido
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
    /*
    public void nuevoPedido(Catalogo catalogo; Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        boolean continuarPedido = true;

        // 1ro se asigna un cliente al pedido, sino existe se crea uno nuevo
        boolean finWhile = false;
        while ((!finWhile) && (continuarPedido)) {




        }

        // 2do selecciono productos --> se usara el metodo de listar por coincidencia de nombres por cada prod. que se añada para mayor facilidad de busqueda
        // si el pedido no se cancelo por no asignar cliente
        if (continuarPedido) {
            System.out.println("Seleccione producto y cantidad. Se listaran las opciones que coincidan con la busqueda.");
            System.out.print("Nombre de producto: ");
            String nomProd = Utils.formatearString(sc.nextLine());

            ArrayList<Producto> lista = como hago para acceder desde Pedido a Catalogo para usar el metodo de buscarpornombre?

            // FALTA DESARROLLAR
        }
    }

    */

    // toString
}
