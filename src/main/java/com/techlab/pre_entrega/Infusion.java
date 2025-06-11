package com.techlab.pre_entrega;

public class Infusion extends Producto {

    private String paisDeOrigen;

    public Infusion() {}

    public Infusion(String nombre, double precio, int stock) {
        super(nombre,precio,stock);
    }

    public Infusion(String nombre, double precio, int stock, String paisDeOrigen) {
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
            aux += "Pais de origen: " + this.getPaisDeOrigen(); // QUIZAS NO USAR UN GETTER SINO "Pasis de origen: ---- "; ASI NO MAS A MANO..??
        }
        return aux;
    }
}
