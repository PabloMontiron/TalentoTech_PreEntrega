package com.techlab.pre_entrega;
import com.techlab.pre_entrega.excepciones.CadenaInvalidaException;
import com.techlab.pre_entrega.excepciones.DniInvalidoException;

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
    public String getFechaNac() {
        return fechaNac;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setDni(int dni) throws DniInvalidoException {
        if (dni < 0) {
            throw new DniInvalidoException("El DNI debe ser un número positivo entero.");
        }
        this.dni = dni;
    }

    public void setNombreCompleto(String nombreCompleto) throws CadenaInvalidaException{
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new CadenaInvalidaException("No se registro nigún dato.");
        }
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNac(String fechaNac) throws CadenaInvalidaException {
        Utils.validarCadena(fechaNac);
        this.fechaNac = fechaNac;
    }

    // Mét
    public void altaCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los siguientes datos: ");

        String nomYApe = "";
        boolean nombreOk = false;
        while (!nombreOk) {
            try {
                System.out.print("Nombre Completo: ");
                nomYApe = Utils.formatearString(sc.nextLine());
                Utils.validarCadena(nomYApe);
                nombreOk = true;
            } catch (CadenaInvalidaException e) {
                System.out.println("No se registro nigún dato.");
                sc.nextLine();
            }
        }

        int dni = 0;
        boolean dniOk = false;
        while (!dniOk) {
            try {
                System.out.print("DNI: ");
                dni = sc.nextInt();
                sc.nextLine();
                Utils.validarDni(dni);
                dniOk = true;
            } catch (DniInvalidoException e) {
                System.out.println("El DNI debe ser un número entero positivo.");
                sc.nextLine();
            }

        }

        String fecha = "";
        boolean fechaOk = false;
        while (!fechaOk) {
            try {
                System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
                fecha = sc.nextLine();
                Utils.validarCadena(fecha);
                fechaOk = true;
            } catch (CadenaInvalidaException e) {
                System.out.println("No se registro nigún dato.");
                sc.nextLine();
            }
        }

        try {
            this.setNombreCompleto(nomYApe);
        } catch (CadenaInvalidaException e) {
            System.out.println("No se registro nigún dato.");
        }

        try {
            this.setDni(dni);
        } catch (DniInvalidoException e) {
            System.out.println("El DNI debe ser un número positivo entero.");
        }

        try {
            this.setFechaNac(fecha);
        } catch (CadenaInvalidaException e) {
            System.out.println("No se registro nigún dato.");
        }

        this.setIdCliente(contador);
        contador++;

        System.out.println("Se ha dado de alta el cliente.");
    }
}