package com.techlab.pre_entrega;

import com.techlab.pre_entrega.excepciones.PrecioInvalidoException;

public class Alimento extends Producto {

    String peso;
    String fechaVencimiento;

    // Const.
    public Alimento(String nombre, double precio, int stock, String peso)
        throws PrecioInvalidoException {
        super(nombre,precio,stock);
        this.peso = peso;
    }

    public Alimento(String nombre, double precio, int stock, String peso, String fechaVencimiento)
        throws PrecioInvalidoException {
        super(nombre,precio,stock);
        this.peso = peso;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Get & Set
    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPeso() {
        return this.peso;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
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
            this.setFechaVencimiento("----");
            aux += "Pais de origen: " + this.getFechaVencimiento() + "\n"; // QUIZAS NO USAR UN GETTER SINO "Pasis de origen: ---- "; ASI NO MAS A MANO..??
        }

        return aux;
    }
}

