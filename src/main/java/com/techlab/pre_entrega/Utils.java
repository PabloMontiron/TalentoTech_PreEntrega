package com.techlab.pre_entrega;

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

}
