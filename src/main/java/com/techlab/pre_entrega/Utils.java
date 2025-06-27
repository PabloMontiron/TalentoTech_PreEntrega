package com.techlab.pre_entrega;

import com.techlab.pre_entrega.excepciones.CadenaInvalidaException;
import com.techlab.pre_entrega.excepciones.DniInvalidoException;
import com.techlab.pre_entrega.excepciones.PrecioInvalidoException;
import com.techlab.pre_entrega.excepciones.StockInvalidoException;

public class Utils {

    public static String formatearString(String str) {
        str = str.trim().toLowerCase();
        String[] cadena = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cadena.length; i++) {
            if (!cadena[i].isEmpty()) {
                String primeraLetra = cadena[i].substring(0, 1).toUpperCase();

                String resto = cadena[i].substring(1);

                sb.append(primeraLetra).append(resto);

                if (i < cadena.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void validarPrecio(double p) throws PrecioInvalidoException {
        if (p <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor a cero.");
        }
    }

    public static void validarStock(int stock) throws StockInvalidoException {
        if (stock < 0) {
            throw new StockInvalidoException("El stock debe ser igual o mayor a 0.");
        }
    }

    public static void validarCadena(String cadena) throws CadenaInvalidaException {
        if (cadena == null || cadena.trim().isEmpty()) {
            throw new CadenaInvalidaException("No se registro ningún dato.");
        }
    }

    public static void validarDni(int dni) throws DniInvalidoException {
        if (dni < 0) {
            throw new DniInvalidoException("El DNI debe ser un número entero positivo.");
        }
    }
}
