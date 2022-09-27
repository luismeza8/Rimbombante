/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.rimbombante.backend;

/**
 *
 * @author lm
 */
public class Curp {

    public static void main(String[] args) {

        System.out.println(primerLetraYVocalInterna("meza")
                + primeraLetraSegundoApellido("acosta")
                + primerLetraNombrePila("luis")
                + obtenerFecha("06", "08", "2003")
                + obtenerCodigoEstado("Sonora")
                + primerConsonanteInternaSegundoApellido("acosta")
        );
    }
    
    static String obtenerCurp(String nombres, String primerApellido){
        String curp = primerLetraYVocalInterna(nombres) + primeraLetraSegundoApellido(primerApellido);
        
        return curp;
    }

    static char primerVocalInterna(String palabra) {
        String palabraMayuscula = palabra.toUpperCase();

        String vocales = "AEIOU";

        for (int i = 1; 0 <= palabraMayuscula.length(); i++) {
            if (vocales.contains(String.valueOf(palabraMayuscula.charAt(i)))) {
                return palabraMayuscula.charAt(i);
            }
        }

        return ' ';
    }

    static char primerConsonanteInterna(String palabra) {
        String palabraMayuscula = palabra.toUpperCase();

        String vocales = "AEIOU";

        for (int i = 1; 0 <= palabraMayuscula.length(); i++) {
            if (!vocales.contains(String.valueOf(palabraMayuscula.charAt(i)))) {
                return palabraMayuscula.charAt(i);
            }
        }

        return ' ';
    }

    static String primerLetraYVocalInterna(String palabra) {
        char[] letras = {palabra.toUpperCase().charAt(0), primerVocalInterna(palabra)};

        return new String(letras);
    }

    static char primeraLetraSegundoApellido(String segundoApellido) {
        return segundoApellido.toUpperCase().charAt(0);
    }

    static char primerLetraNombrePila(String nombrePila) {
        return nombrePila.toUpperCase().charAt(0);
    }

    static char primerConsonanteInternaPrimerApellido(String primerApellido) {
        return primerConsonanteInterna(primerApellido);
    }

    static char primerConsonanteInternaSegundoApellido(String segundoApellido) {
        return primerConsonanteInterna(segundoApellido);
    }
    
    public static String obtenerFecha(String dia, String mes, String anio){
        return anio.charAt(2) + "" + anio.charAt(3) + mes + dia;
    }
    
    public static String obtenerCodigoEstado(String estado){
        switch (estado) {
            case "Aguascalientes":
                return "AS";
            case "Baja California":
                return "BC";
            case "Baja California Sur":
                return "Bs";
            case "Campeche":
                return "CC";
            case "Coahuila de Zaragoza":
                return "CL";
            case "Colima":
                return "CM";
            case "Chiapas":
                return "CS";
            case "Chihuahua":
                return "CH";
            case "Distrito Federal":
                return "DF";
            case "Durango":
                return "DG";
            case "Guanajuato":
                return "GT";
            case "Guerrero":
                return "GR";
            case "Hidalgo":
                return "HG";
            case "Jalisco":
                return "JC";
            case "México":
                return "MC";
            case "Michoacán de Ocampo":
                return "MN";
            case "Morelos":
                return "MS";
            case "Nayarit":
                return "NT";
            case "Nuevo León":
                return "NL";
            case "Oaxaca":
                return "OC";
            case "Puebla":
                return "PL";
            case "Querétaro":
                return "QT";
            case "Quintana Roo":
                return "QR";
            case "San Luis Potosí":
                return "SP";
            case "Sinaloa":
                return "Sl";
            case "Sonora":
                return "SR";
            case "Tabasco":
                return "TC";
            case "Tamaulipas":
                return "TS";
            case "Tlaxcala":
                return "TL";
            case "Veracruz":
                return "VZ";
            case "Yucatán":
                return "YN";
            case "Zacatecas":
                return "ZS";
            case "Nacido en el Extranjero":
                return "NE";
            default:
                return " ";
        }
    }

}
