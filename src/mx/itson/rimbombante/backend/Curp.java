/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.rimbombante.backend;

import mx.itson.rimbombante.backend.enumeradores.Sexo;

/**
 * Contiene métodos para la obtención de la clave CURP
 *
 * @author lm
 */
public class Curp {

    /**
     * Pide toda la información necesaria para hacer la curp
     * @param nombres Nombre(s) del usuario
     * @param primerApellido Primer Apellido del usuario
     * @param segundoApellido Segundo Apellido del usuario
     * @param diaNacimiento Dia de nacimineto del usuario
     * @param mesNacimineto Mes de nacimiento del usuario
     * @param anioNacimiento Año de nacimiento  del usuario
     * @param sexo Sexo del usuario
     * @param estado Estado de nacimiento del usuario
     * @return La CURP completa
     */
    public String obtenerCurp(
            String nombres,
            String primerApellido,
            String segundoApellido,
            String diaNacimiento,
            String mesNacimineto,
            int anioNacimiento,
            Sexo sexo,
            String estado) {

        nombres = limpiarPalabra(nombres);
        primerApellido = limpiarPalabra(primerApellido);
        segundoApellido = limpiarPalabra(segundoApellido);

        String nombreCompuesto = obtenerNombreCompuesto(nombres);

        String curp = obtenerPrimerLetraYVocalInterna(primerApellido)
                + obtenerPrimeraLetraSegundoApellido(segundoApellido)
                + obtenerPrimerLetraNombrePila(nombreCompuesto)
                + obtenerFechaNacimiento(diaNacimiento, mesNacimineto, anioNacimiento)
                + obtenerSexo(sexo)
                + obtenerCodigoEstado(estado)
                + obtenerPrimerConsonanteInterna(primerApellido)
                + obtenerPrimerConsonanteInternaSegundoApellido(segundoApellido)
                + obtenerPrimerConsonanteInterna(nombres)
                + obtenerCaracterSegunAnio(anioNacimiento)
                + '1';

        return curp;
    }

    /**
     * Limpia la palabra de espacios, reemplazando también los acentos de cada
     * vocal haciendo que esta se convierta en mayúsculas. param: palabra
     * return: la palabra sin espacios al inicio ni al final, removiendo los
     * acentos
     */
    static String limpiarPalabra(String palabra) {
        return palabra.trim()
                .replace('á', 'a')
                .replace('é', 'e')
                .replace('í', 'i')
                .replace('ó', 'o')
                .replace('ú', 'u').toUpperCase();
    }

    /**
     * Obtiene la primera vocal interna de la palabra, empezando por la primera
     * posición de caracteres saltando posiciónes hasta llegar a la vocal param:
     * obtenerPrimerVocalInterna, palabra, vocales return: el caracter que sea
     * la primera vocal interna del nombre.
     */
    static char obtenerPrimerVocalInterna(String palabra) {
        String vocales = "AEIOU";

        for (int i = 1; 0 <= palabra.length(); i++) {
            if (vocales.contains(String.valueOf(palabra.charAt(i)))) {
                return palabra.charAt(i);
            }
        }

        return ' ';
    }

    /**
     * Obtiene el primer caracter consonante interno del nombre o la palabra
     * ingresada param: obtenerPrimerConsonanteInterna, palabra, vocales return:
     * el caracter de la palabra que sea la primer consonante interna del nombre
     * o palabra ingresada.
     */
    static char obtenerPrimerConsonanteInterna(String palabra) {
        String vocales = "BCDFGHJKLMÑPQRSTVWXYZ";

        for (int i = 1; 0 <= palabra.length(); i++) {
            if (vocales.contains(String.valueOf(palabra.charAt(i)))) {
                return palabra.charAt(i);
            }
        }

        return ' ';
    }

    /**
     * Obtiene la primer letra y vocal interna separándola con arreglo de
     * caracteres, dependiendo la posición, la primera posición (0) se recorre.
     * param: obtenerPrimerLetraYVocalInterna palabra return: la primera vocal
     * interna de palabra
     */

    static String obtenerPrimerLetraYVocalInterna(String palabra) {
        char[] letras = {palabra.charAt(0), obtenerPrimerVocalInterna(palabra)};

        return new String(letras);
    }

    /**
     * Obtiene la primera letra del primer apellido param: obtenerPrimerLetra,
     * apellidoPaterno return: Un caracter que es la primera letra del primer
     * apellido
     */
    static public char obtenerPrimerLetra(String apellidoPaterno) {
        return apellidoPaterno.charAt(0);
    }

    /**
     * Obtiene la primera letra del segundo apellido param: obtenerPrimerLetra,
     * segundoApellido return: Un caracter que es la primera letra del segundo
     * apellido
     */

    static char obtenerPrimeraLetraSegundoApellido(String segundoApellido) {
        return segundoApellido.charAt(0);
    }

    /**
     * Obtiene el primer caracter del primer nombre param:
     * obtenerPrimerLetraNombrePila, nombrePila return: el caracter que se
     * encuentra en la primera posición del nombre de pila o primer nombre
     */

    static char obtenerPrimerLetraNombrePila(String nombrePila) {
        return nombrePila.charAt(0);
    }

    /**
     * Obtiene la primer consonante interna del segundo apellido o del apellido
     * materno param: obtenerPrimerConsonanteInternaSegundoApellido,
     * segundoApellido return: la primer letra consonante dentro del segundo
     * apellido o del apellido materno.
     */
    static char obtenerPrimerConsonanteInternaSegundoApellido(String segundoApellido) {
        if (segundoApellido.equals("X")) {
            return 'X';
        } else {
            return obtenerPrimerConsonanteInterna(segundoApellido);
        }
    }

    /**
     * Obtiene fecha de nacimiento partiendo del dia, mes, año param:
     * obtenerFecha, dia, mes, anio return: dos dígitos para el día, mes y año
     * correspondientes de los datos ingresados. Acá se mencionaba que eran 2
     * dígitos para el día, para el mes y año, no sé si lo habrás puesto
     */
    public static String obtenerFechaNacimiento(String dia, String mes, int anio) {
        String anioString = "" + anio;

        return anioString.charAt(2) + "" + anioString.charAt(3) + mes + dia;
    }

    /**
     * Establece cada código de cada estado equivalente a la pertenencia de cada
     * individuo. param: obtenerCodigoEstado return: el código hecho en dos
     * cifras para determinar la pertenencia del individuo.
     */
    public static String obtenerCodigoEstado(String estado) {
        switch (estado) {
            case "Aguascalientes":
                return "AS";
            case "Baja California":
                return "BC";
            case "Baja California Sur":
                return "BS";
            case "Campeche":
                return "CC";
            case "Coahuila":
                return "CL";
            case "Colima":
                return "CM";
            case "Chiapas":
                return "CS";
            case "Chihuahua":
                return "CH";
            case "Ciudad de México":
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
            case "Michoacán":
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

    /**
     * Regresa un caracter según el sexo
     * @param sexo El enum sexo
     * @return El caracter correspondiente al sexo
     */
    static char obtenerSexo(Sexo sexo) {
        switch (sexo) {
            case HOMBRE:
                return 'H';
            case MUJER:
                return 'M';
            case NOBINARIO:
                return 'X';
            default:
                throw new AssertionError();
        }
    }

    /**
     * Regresa el caracter correspondiente al año dado
     * @param anio El entero correpondiente al año
     * @return El caracter correspondiente
     */
    static char obtenerCaracterSegunAnio(int anio) {
        if (anio >= 2000) {
            return 'A';
        } else {
            return '0';
        }
    }

    /**
     * Este metodo se encarga de comprobar si el nombre es compuesto
     * @param nombres Los nombres
     * @return El primer o segundo nombre, según corresponda
     */
    static String obtenerNombreCompuesto(String nombres) {
        String[] arrayNombres = nombres.split(" ");

        if (arrayNombres.length == 2) {
            if (arrayNombres[0].equals("JOSE") || arrayNombres[0].equals("MARIA")) {
                return arrayNombres[1];
            } else {
                return arrayNombres[0];
            }
        } else {
            if(arrayNombres[0].equals("JOSE") || arrayNombres[0].equals("MARIA")){
                return arrayNombres[arrayNombres.length-1];
            } else {
             return arrayNombres[0];
            }
        }

    }
}
