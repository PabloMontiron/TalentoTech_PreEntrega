package com.techlab.pre_entrega;

import com.techlab.pre_entrega.excepciones.CadenaInvalidaException;
import com.techlab.pre_entrega.excepciones.PrecioInvalidoException;
import com.techlab.pre_entrega.excepciones.StockInvalidoException;

public class Infusion extends Producto {

    private String paisDeOrigen;

    //public Infusion() {}

    public Infusion(String nombre, double precio, int stock)
        throws PrecioInvalidoException, StockInvalidoException, CadenaInvalidaException {
        super(nombre,precio,stock);
    }

    public Infusion(String nombre, double precio, int stock, String paisDeOrigen)
        throws PrecioInvalidoException, StockInvalidoException, CadenaInvalidaException {
        super(nombre,precio,stock);
        this.paisDeOrigen = paisDeOrigen;
    }

    // Get & Set
    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    // Metodos
    @Override
    public String toString() {
        String aux = super.toString() + "\n";

        if (this.getPaisDeOrigen() != null) {
            aux += "Pais de origen: " + this.getPaisDeOrigen();
        } else {
            this.setPaisDeOrigen("----");
            aux += "Pais de origen: " + this.getPaisDeOrigen();
        }
        return aux;
    }
}
