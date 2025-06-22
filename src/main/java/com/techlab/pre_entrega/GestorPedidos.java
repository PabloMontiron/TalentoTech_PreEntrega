package com.techlab.pre_entrega;

import java.util.ArrayList;

public class GestorPedidos {

    private ArrayList<Pedido> lPedidos;

    // Const
    public GestorPedidos() {
        lPedidos = new ArrayList<>();
    }

    // Met
    public void agregarPedidoAlGestor(Pedido pedido) {
        lPedidos.add(pedido);
    }

    //
    public String toString() {
        String aux = "";

        if (!lPedidos.isEmpty()) {
            for (Pedido p : lPedidos) {

                aux += "ID Pedido: " + p.getIdPedido() + "\n";

                aux += p.toString();
            }
            System.out.println("----------------------------");
            return aux;

        } else {
            return "No hay pedidos aún";
        }
    }

}
