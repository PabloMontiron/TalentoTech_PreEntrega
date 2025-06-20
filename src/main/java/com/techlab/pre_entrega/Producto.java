package com.techlab.pre_entrega;
import java.util.Scanner;

public abstract class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private int categoria; // extra

    private static int contadorProductos = 0;
    private int idProducto;

    // Const.
    public Producto() {}

    public Producto(String nombre, double precio, int stock) {
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
        this.idProducto = ++contadorProductos;
    }

    // Get & Set

    // EL MEOTODO PUEDE LANZAR UNA EXCEPCION Y LUEGO QUIEN LO INVOQUE DEBERIA MANEJARLA ... ??
    public void setNombre(String nombre) { // aca podria derivar una excepcion y que el que lo invoque use try catch
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Campo vacío. Debe asignar un nombre");
        }
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("El valor debe ser mayor a cero.");
        }
    }

    public void  setStock(int stock) {
        if (stock > 0) {
            this.stock = stock;
        } else {
            System.out.println("El valor debe ser mayor a cero.");
        }
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

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

                System.out.print("Ingrese nuevo nombre completo de producto: ");

                String nuevoNom = Utils.formatearString(sc.nextLine());
                producto.setNombre(nuevoNom); // ver excepciones...

                System.out.println("El producto " + nombreAux + ", se ha actualizado correctamente a : " + nuevoNom);
                System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ----");

            } else if (resp == 2) {
                System.out.println("Actualizar Precio");
                System.out.println("Precio actual: " + producto.getPrecio() + " $ ");
                System.out.println("------------------");

                System.out.print("Ingrese nuevo precio: ");
                double nuevoPrecio = sc.nextDouble();

                producto.setPrecio(nuevoPrecio); // ver excepciones...
                System.out.println("El precio del producto " + producto.getNombre() + ", se ha actualizado correctamente a : " + nuevoPrecio + " $ ");
                System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ----");

            } else if (resp == 3) {
                System.out.println("Actualizar Stock");
                System.out.println("----------------");
                int stockAux = producto.getStock();
                System.out.println("Stock actual: " + producto.getStock());

                System.out.print("Ingrese nuevo Stock: ");
                int nuevoStock = sc.nextInt();
                sc.nextLine();

                System.out.println("El Stock pasará de: " + stockAux + ", a : " + nuevoStock);
                System.out.println("1: Confirmar");
                System.out.println("2: Cancelar operacion");

                System.out.print("Respuesta: ");
                resp = sc.nextInt();

                if (resp == 1) {
                    finWhile = true;
                    producto.setStock(nuevoStock); // ver excepciones...
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
