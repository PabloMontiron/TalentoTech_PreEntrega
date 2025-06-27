package com.techlab.pre_entrega;
import com.techlab.pre_entrega.excepciones.CadenaInvalidaException;
import com.techlab.pre_entrega.excepciones.PrecioInvalidoException;
import com.techlab.pre_entrega.excepciones.StockInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private int categoria; // extra

    private static int contadorProductos = 0;
    private int idProducto;

    // Const.
    //public Producto() {}

    // ahora hay que manjear esos errores con try catch etc...
    public Producto(String nombre, double precio, int stock)
        throws PrecioInvalidoException, StockInvalidoException, CadenaInvalidaException {
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
        this.idProducto = ++contadorProductos;
    }

    // Get & Set
    public void setNombre(String nombre) throws CadenaInvalidaException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new CadenaInvalidaException("No se registro nigún dato.");
        }
        this.nombre = nombre;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor a cero.");
        }
        this.precio = precio;
    }

    public void  setStock(int stock) throws StockInvalidoException {
        if (stock < 0) {
            throw new StockInvalidoException("El stock debe ser igual o mayor a 0.");
        }
        this.stock = stock;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public int getIdProducto() {
        return this.idProducto;
    }

    public static int getContadorProductos() {
        return contadorProductos;
    }

    // Metodos
    public void actualizarProducto(Producto producto) {
        Scanner sc = new Scanner(System.in);
        boolean finWhile = false;
        while (!finWhile) {
            System.out.println("Seleccione el número de campo a atualizar");
            System.out.println("-------------------------");
            System.out.println("1: Nombre del producto");
            System.out.println("2: Precio");
            System.out.println("3: Stock (Atención! Sustituye el valor actual)");
            System.out.println("4: Salir al menú anterior");
            System.out.println("-------------------------");
            System.out.print("Respuesta: ");
            int resp = sc.nextInt();
            sc.nextLine(); //

            if (resp == 1) {
                String nombreAux = producto.getNombre();

                System.out.println("Actualizar Nombre de producto");
                System.out.println("-----------------------------");
                System.out.println();
                System.out.println("-> Nombre actual: " + nombreAux);
                System.out.println();
                System.out.println("-----------------------------");

                String nuevoNom = "";
                boolean nombreOk = false;
                while (!nombreOk) {
                    try {
                        System.out.print("Ingrese nuevo nombre completo de producto: ");
                        nuevoNom = Utils.formatearString(sc.nextLine());
                        producto.setNombre(nuevoNom);
                        nombreOk = true;
                    } catch (CadenaInvalidaException e) {
                        System.out.println("Error al actualizar el nombre: " + e.getMessage());
                    }
                }

                System.out.println("El producto " + nombreAux + ", se ha actualizado correctamente a : " + nuevoNom);
                System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ----");

            } else if (resp == 2) {
                System.out.println("Actualizar Precio");
                System.out.println("Precio actual: " + producto.getPrecio() + " $ ");
                System.out.println("------------------");

                boolean precioOk = false;
                while (!precioOk) {
                    try {
                        System.out.print("Ingrese nuevo precio: ");
                        double nuevoPrecio = sc.nextDouble();
                        sc.nextLine();

                        producto.setPrecio(nuevoPrecio);
                        System.out.println("El precio del producto " + producto.getNombre() + ", se ha actualizado correctamente a : " + nuevoPrecio + " $ ");
                        System.out.println("--------------------");
                        precioOk = true;
                    } catch (PrecioInvalidoException e) {
                        System.out.println("Error al actualizr precio: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Debe ingresar un valor numérico.");
                        sc.nextLine(); // limpio bufer si se ingresa String (no consume el primer salto de line)
                    }
                }

            } else if (resp == 3) {
                System.out.println("Actualizar Stock");
                System.out.println("----------------");
                int stockAux = producto.getStock();
                System.out.println("Stock actual: " + producto.getStock());

                int nuevoStock = 0;
                boolean stockOk = false;
                while (!stockOk) {
                    try {
                        System.out.print("Ingrese nuevo Stock: ");
                        nuevoStock = sc.nextInt();
                        sc.nextLine();

                        Utils.validarStock(nuevoStock);
                        stockOk = true;
                    } catch (StockInvalidoException e) {
                        System.out.println("El stock debe ser igual o mayor a 0.");
                    } catch (InputMismatchException e) {
                        System.out.println("Debe ingresar un valor numérico.");
                        sc.nextLine();
                    }
                }

                boolean respValida = false;
                while (!respValida) {
                    try {
                        System.out.println("El Stock pasará de: " + stockAux + ", a : " + nuevoStock);
                        System.out.println("1: Confirmar");
                        System.out.println("2: Cancelar operacion");


                        System.out.print("Respuesta: ");
                        resp = sc.nextInt();
                        respValida = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Debe ingresar un valor numérico.");
                        sc.nextLine();
                    }
                }

                if (resp == 1) {
                    finWhile = true;
                    try {
                        producto.setStock(nuevoStock);
                    } catch (Exception e) {
                        System.out.println("El stock debe ser igual o mayor a 0.");
                    }
                    System.out.println("El Stock del producto " + producto.getNombre() + ", se ha actualizado correctamente a : " + nuevoStock + " unidades.");
                    System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ----");
                } else if (resp == 2) {
                    System.out.println("Actualización cancelada.");
                    System.out.println("------------------------");
                } else {
                    System.out.println("Ingrese una opción válida.");
                }

            } else if (resp == 4) {
                finWhile = true;

            } else {
                System.out.println("Ingrese una opción válida.");
            }
        }
    }

    @Override
    public String toString() {
        return  "ID producto: " + this.getIdProducto() + "\n" +
                this.getNombre() + ", " + this.getPrecio() + " $ " + ", Stock: " + this.getStock();
    }
}
