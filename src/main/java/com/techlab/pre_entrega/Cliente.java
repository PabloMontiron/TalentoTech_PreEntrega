package com.techlab.pre_entrega;
import java.util.Scanner;


public class Cliente {
    private String nombreCompleto;
    private int dni;
    private String fechaNac;
    private int idCliente;
    private static int contador = 1;

    // Const
    public Cliente() { }

    /*
    public Cliente(String nombre, int dni, String fechaNac) {
        this.nombreCompleto = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }
    */

    // Get & Set
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    // Mét
    public void altaCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los siguientes datos: ");
        System.out.print("Nombre Completo: ");
        String nomYApe = Utils.formatearString(sc.nextLine());

        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();

        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fecha = sc.nextLine();

        this.setNombreCompleto(nomYApe);
        this.setDni(dni);
        this.setFechaNac(fecha);

        this.setIdCliente(contador);
        contador++;

        System.out.println("Se ha dado de alta el cliente.");
    }
}