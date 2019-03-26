package pre_tema9_static;

import java.util.Random;

public class Password {

    private static int longitud;
    private String contraseña;

    public Password() {
        longitud = 8;
        this.contraseña = "";
        this.generarPassword();
    }

    public Password(int longitud) {
        Password.longitud = 8;
        this.contraseña = "";
        this.generarPassword();
    }

    /**
     * Obtener de forma aleatoria, tantos caracteres como la longitud que viene
     * marcado en el atributo
     *
     * Obtendremos un numero aleatorio entre los diferentes caracteres que
     * pueden contener la contraseña y lo concatenaremos con el atributo
     * contraseña, esto los repetiré tantas veces como la variable longitud
     */
    private void generarPassword() {
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int numero = random.nextInt(74);
            int letraNumero = numero + 48;
            char caracter = (char) letraNumero;
            contraseña += caracter;
        }
    }

    public boolean esFuerte() {
        int mayusculas = 0, minusculas = 0, numeros = 0;
        for (char caracter : this.contraseña.toCharArray()) {
            int caracNumero = (int) caracter;
            if (caracNumero >= 48 && caracNumero <= 57) {
                numeros++;
            }
            if (caracNumero >= 65 && caracNumero <= 90) {
                mayusculas++;
            }
            if (caracNumero >= 97 && caracNumero <= 122) {
                minusculas++;
            }
        }
        if (mayusculas > 2 && minusculas > 1 && numeros > 5) {
            return true;
        } else {
            return false;
        }
    }

    public static int getLongitud() {
        return longitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public static void setLongitud(int longitud) {
        Password.longitud = longitud;
    }
}
