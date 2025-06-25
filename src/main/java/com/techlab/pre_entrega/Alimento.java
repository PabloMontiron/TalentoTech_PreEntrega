package com.techlab.pre_entrega;

import com.techlab.pre_entrega.excepciones.CadenaInvalidaException;
import com.techlab.pre_entrega.excepciones.PrecioInvalidoException;
import com.techlab.pre_entrega.excepciones.StockInvalidoException;

public class Alimento extends Producto {

    String peso;
    String fechaVencimiento;

    // Const.
    public Alimento(String nombre, double precio, int stock, String peso)
        throws PrecioInvalidoException, StockInvalidoException, CadenaInvalidaException {
        super(nombre,precio,stock);
        this.peso = peso;
    }

    public Alimento(String nombre, double precio, int stock, String peso, String fechaVencimiento)
        throws PrecioInvalidoException, StockInvalidoException, CadenaInvalidaException {
        super(nombre,precio,stock);
        this.peso = peso;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Get & Set
    public void setPeso(String peso) throws CadenaInvalidaException {
        Utils.validarCadena(peso);
        this.peso = peso;
    }

    public String getPeso() {
        return this.peso;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) throws CadenaInvalidaException{
        Utils.validarCadena(fechaVencimiento);
        this.fechaVencimiento = fechaVencimiento;
    }

    // Metodos
    @Override
    public String toString() {
        String aux = super.toString() + "\n" +
                "Peso: " + this.getPeso() + "\n";

        if (this.getFechaVencimiento() != null) {
            aux += "Fecha de vencimiento: " + this.getFechaVencimiento() + "\n";
        } else {
            try {
                this.setFechaVencimiento("----");
                aux += "Pais de origen: " + this.getFechaVencimiento() + "\n";
            } catch (CadenaInvalidaException e) {
                System.out.println("No se registro ningún dato.");
            }
        }
        return aux;
    }
}

