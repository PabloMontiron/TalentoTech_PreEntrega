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

    @Override
    public String toString() {
        String aux = "";

        if (!lPedidos.isEmpty()) {
            for (Pedido p : lPedidos) {
                aux += p.toString();
                aux +=("----------------\n");
            }

            return aux;

        } else {
            return "No hay pedidos aún \n";
        }
    }

}
