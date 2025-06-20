package com.techlab.pre_entrega;
import java.util.ArrayList;
import java.util.Scanner;

// -->EN DESARROLLO<--
public class GestorClientes {

    ArrayList<Cliente> lClientes;

    public GestorClientes() {
        lClientes = new ArrayList<>();
    }

    //
    public void agregarCliente(Cliente cliente) {
        lClientes.add(cliente);
    }

    public Cliente buscarClientePorId(int id) {

        for (Cliente c : lClientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    public Cliente obtenerCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione tipo de Cliente: ");
        System.out.println("--------------------------- ");
        System.out.println("1: Nuevo cliente");
        System.out.println("2: Cliente existente");
        System.out.println("3: Cancelar operacion");

        System.out.print("Respuesta: ");
        int resp = sc.nextInt();
        sc.nextLine();

        if (resp == 1) {
            Cliente cliente = new Cliente();
            cliente.altaCliente();
            agregarCliente(cliente);

            return cliente;

        } else if (resp == 2) {
            boolean finWhile = false;
            while (!finWhile) {
                System.out.println("Ingrese ID de cliente: ");
                System.out.print("Respuesta: ");
                int idCliente = sc.nextInt();
                sc.nextLine();

                Cliente cliente = buscarClientePorId(idCliente); // ver met

                if (cliente == null) {
                    System.out.println("No se encontro un cliente con ID: " + idCliente);
                    System.out.println("Seleccione una opcion: ");
                    System.out.println("1: Ingresar nuevamente ID");
                    System.out.println("2: Cancelar Pedido");

                    System.out.print("Respuesta: ");
                    resp = sc.nextInt();
                    sc.nextLine(); //

                    if (resp == 2) {
                        System.out.println("Operación canecela.");
                        System.out.println("------------------ ");
                        // aca cerarria el finwhile que no le veo mucho sentido
                        return null;
                    } else if (resp != 1) {
                        System.out.println("Ingrese una opción válida.");
                    }

                } else {
                    return cliente;
                }
            }
        } else if (resp == 3) {
            System.out.println("Operación cancelada.");
            System.out.println("------------------- ");
            return null; // si se cancela la operacion Cliente sera null.
        } else {
            System.out.println("Ingrese una opción válida.");
        }

        return null; // en si no deberia llegar a este return...sino lo pongo java lo marca como error.
    }


}


