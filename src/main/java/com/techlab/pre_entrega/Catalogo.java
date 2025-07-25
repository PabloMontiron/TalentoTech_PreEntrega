package com.techlab.pre_entrega;
import com.techlab.pre_entrega.excepciones.CadenaInvalidaException;
import com.techlab.pre_entrega.excepciones.PrecioInvalidoException;
import com.techlab.pre_entrega.excepciones.StockInvalidoException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Catalogo {

    private String[] categorias = {"Infusiones","Alimentos"};

    private ArrayList<Producto> lProductosCatalogo;

    private static int cantElementos; // antes = 0;

    public Catalogo() {

        this.lProductosCatalogo = new ArrayList<>();

        // Al instancir un catalogo se crean las categorias ya preestablecidas. De momento son solo dos cat.
        this.categorias = new String[] {
                categorias[0] = "Infusiones",
                categorias[1] = "Alimentos"
        };
    }

    // Metodos
    public void agregarProductoAlCatalogo(Producto producto) {
        lProductosCatalogo.add(producto);
    }

    public void subCampoInfusion(String nombre, double precio, int stock) {
        Scanner sc = new Scanner(System.in);

        boolean finWhile = false;
        while (!finWhile) {
            // tipo -> Infusion
            int resp = 0;
            boolean respOk = false;
            while (!respOk) {
                try {
                    System.out.println("¿Desea añadir el Pais de origen?");
                    System.out.println("1: Añadir pais de origen");
                    System.out.println("2: Omitir");

                    System.out.print("Respuesta: ");
                    resp = sc.nextInt();
                    sc.nextLine();

                    respOk = true;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un valor numérico.");
                    sc.nextLine();
                }
            }

            if (resp == 1) {
                String pais = "";
                boolean cadenaOk = false;
                while (!cadenaOk) {
                    try {
                        System.out.print("Pais de origen: ");
                        pais = Utils.formatearString(sc.nextLine());
                        Utils.validarCadena(pais);
                        finWhile = true;
                        cadenaOk = true;
                    } catch (CadenaInvalidaException e) {
                        System.out.println("No se registro ningún dato.");
                    }
                }
                try {
                    Infusion infusion = new Infusion(nombre, precio, stock);
                    infusion.setPaisDeOrigen(pais);
                    agregarProductoAlCatalogo(infusion);
                } catch (PrecioInvalidoException | StockInvalidoException | CadenaInvalidaException e) {
                    System.out.println("No se pudo agregar el producto." + e.getMessage());
                }

            } else if (resp == 2) {
                finWhile = true;
                try {
                    Infusion infusion = new Infusion(nombre, precio, stock);
                    agregarProductoAlCatalogo(infusion);
                } catch (PrecioInvalidoException | StockInvalidoException | CadenaInvalidaException e) {
                    System.out.println("No se puedo agregar el producto." + e.getMessage());
                }
            } else {
                System.out.println("Ingrese una opción válida.");
            }
        }
    }

    public void subCampoAlimento(String nombre, double precio, int stock) {
        Scanner sc = new Scanner(System.in);

        boolean finWhile = false;
        while (!finWhile) {
            String peso = "";
            boolean pesoOk = false;
            while (!pesoOk) {
                try {
                    System.out.print("Peso (puede completar con '----' si no es relevante): ");
                    peso = sc.nextLine();
                    Utils.validarCadena(peso);
                    pesoOk = true;

                } catch (CadenaInvalidaException e) {
                    System.out.println("No se registro ningún dato.");
                }
            }

            int resp = 0;
            boolean respOk = false;
            while (!respOk) {
                try {
                    System.out.println("¿Desea añadir la fecha de vencimiento?");
                    System.out.println("1: Si");
                    System.out.println("2: Omitir");

                    System.out.print("Respuesta: ");
                    resp = sc.nextInt();
                    sc.nextLine();
                    respOk = true;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un valor numérico.");
                    sc.nextLine();
                }
            }

            if (resp == 1) {
                String vencimiento = "";
                boolean fechaOk = false;
                while (!fechaOk) {
                    try {
                        System.out.print("Fecha de vencimiento (dd/mm/aaaa): ");
                        vencimiento = sc.nextLine();
                        Utils.validarCadena(vencimiento);
                        finWhile = true;
                        fechaOk = true;
                    } catch (CadenaInvalidaException e) {
                        System.out.println("No se registro ningún dato.");
                    }
                }
                try {
                    Alimento alimento = new Alimento(nombre,precio,stock,peso,vencimiento);
                    agregarProductoAlCatalogo(alimento);
                } catch (PrecioInvalidoException | StockInvalidoException | CadenaInvalidaException e) {
                    System.out.println("No se puedo agregar el producto.\" + e.getMessage()");
                }


            } else if (resp == 2) {
                finWhile = true;
                 try {
                     Alimento alimento = new Alimento(nombre,precio,stock,peso);
                     agregarProductoAlCatalogo(alimento);
                 } catch (PrecioInvalidoException | StockInvalidoException | CadenaInvalidaException e) {
                     System.out.println("No se puedo agregar el producto." + e.getMessage());
                 }
            } else {
                System.out.println("Ingrese una opción válida.");
            }

        }
    }

    public void agregarProducto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cantidad actual de productos en el catálogo: " + Producto.getContadorProductos());
        System.out.println("-------------------------------------------  ");

        System.out.println("Agregar nuevo producto al catálogo");
        System.out.println();

        System.out.println("Ingrese los siguientes datos del producto a agregar: ");
        System.out.println("---------------------------------------------------- ");

        String nombre = "";
        boolean nombreOk = false;
        while (!nombreOk) {
            try {
                System.out.print("-> Nombre de venta: ");
                nombre = Utils.formatearString(sc.nextLine());
                Utils.validarCadena(nombre);
                nombreOk = true;
            } catch (CadenaInvalidaException e) {
                System.out.println("No se registro nigún dato.");
            }
        }

        double precio = 0;
        boolean precioValido = false;
        while (!precioValido) {
            try {
                System.out.print("-> Precio: ");
                precio = sc.nextDouble();
                sc.nextLine();

                Utils.validarPrecio(precio);
                precioValido = true;
            } catch (PrecioInvalidoException e) {
                System.out.println("Precio inválido: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                sc.nextLine();
            }
        }

        int stock = 0;
        boolean stockOk = false;
        while (!stockOk) {
            try {
                System.out.print("-> Stock inicial: ");
                stock = sc.nextInt();
                sc.nextLine();

                Utils.validarStock(stock);
                stockOk = true;
            } catch (StockInvalidoException e) {
                System.out.println("Stock inválido: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                sc.nextLine();
            }
        }

        // Desde este punto los campos son especificos del tipo de producto
        boolean finWhile = false;
        while (!finWhile) {
            System.out.println("Categorías disponibles: ");
            System.out.println("----------------------  ");

            for (int i = 0; i < categorias.length; i++) {
                System.out.println("Cat: " + (i + 1) + " -> " + categorias[i]);
            }

            int tipoCategoria = 0;
            boolean respOk = false;
            while (!respOk) {
                try {
                    System.out.print("Ingrese numero de categoria del producto: ");
                    tipoCategoria = sc.nextInt();
                    sc.nextLine();
                    respOk = true;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un valor numérico.");
                    sc.nextLine();
                }
            }

            if ((tipoCategoria >= 1) && (tipoCategoria <= categorias.length)) {

                if (tipoCategoria == 1) {
                    subCampoInfusion(nombre, precio, stock);
                    finWhile = true;
                } else if (tipoCategoria == 2) {
                    subCampoAlimento(nombre, precio, stock);
                    finWhile = true;
                }

            } else {
                System.out.println("Valor fuera de rango. Valores aceptados ( 1 hasta " + categorias.length + " ) ");
            }
        }
        // trabajar excepcion, si producto es null o algo deberia decir "Fallo la carga del producto"
        System.out.println("Producto agregado.");
        System.out.println("------------------");
    }

    // Caso a) Busqueda por ID de producto -
    public Producto buscarProductoPorId(int idProducto) {

        for (Producto p : lProductosCatalogo) {
            if (p.getIdProducto() == idProducto) {
                // si existe retorna producto
                return p;
            }
        }
        // si no existe retorna null.
        return null;
    }

    // Caso b) Busqueda por nombre de producto -> lista todos los productos que incluyan todas las palabras claves que se especifiquen
    public ArrayList<Producto> buscarProductoPorNombre(String nomProducto) {

        ArrayList<Producto> lista = new ArrayList<>();

        String[] palabrasClave = nomProducto.split(" ");

        // recorrro todo el catalogo -> los prod que contienen todas la palabras claves se agregan a la lista que luego se retornara
        for (Producto p : lProductosCatalogo) {

            String prodActual = p.getNombre();

            boolean contieneTodas = true;

            for (String palabra : palabrasClave) {
                if (!prodActual.contains(palabra)) {
                    contieneTodas = false;
                    break; // corto el for interno
                }
            }

            if (contieneTodas) {
                lista.add(p);
            }
        }
        // si no hubo coincidencias retorna como empty la lista
        return lista;
    }

    public void eliminarProductoDelCatalogo() {
        Scanner sc = new Scanner(System.in);

        int idProducto = 0;
        boolean respOk = false;
        while (!respOk) {
            try {
                System.out.print("Ingrese el ID de producto a eliminar: ");
                idProducto = sc.nextInt();
                sc.nextLine();
                respOk = true;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                sc.nextLine();
            }
        }

        Producto prodSelec = buscarProductoPorId(idProducto);

        if (prodSelec != null) {
            int resp = 0;
            respOk = false;
            while (!respOk) {
                try {
                    System.out.println("Se eliminara el producto: " + prodSelec.getNombre());
                    System.out.println("1: Confirmar");
                    System.out.println("2: Cancelar operacion");

                    System.out.print("Respuesta: ");
                    resp = sc.nextInt();
                    sc.nextLine();

                    respOk = true;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un valor numérico.");
                    sc.nextLine();
                }
            }

            boolean finWhile = false;
            while (!finWhile) {
                if (resp == 1) {
                    finWhile = true;
                    String aux = prodSelec.getNombre();
                    lProductosCatalogo.remove(prodSelec);
                    System.out.println("Se ha eliminado el producto: " + aux + " del catálogo.");
                    System.out.println("------------------------------------------------------");
                } else if (resp == 2) {
                    finWhile = true;
                    System.out.println("Operación cancelada.");
                    System.out.println("--------------------");
                } else {
                    System.out.println("Ingrese una opcón válida.");
                    System.out.println("-------------------------");
                }
            }

        } else {
            System.out.println("No se encontro ningún producto con el ID: " + idProducto);
        }
    }

    @Override
    public String toString() {
        String aux = "";

        for (Producto p : lProductosCatalogo) {
            aux += p.toString() + "\n";
        }
        return aux;
    }

}
