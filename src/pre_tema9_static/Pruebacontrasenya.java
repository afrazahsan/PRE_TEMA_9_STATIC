package pre_tema9_static;

import java.util.Scanner;

public class Pruebacontrasenya {

    public static void main(String[] args) {
        Password[] listadoPasswords;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la cantidad de Contraseñas a generar");
        int numContraseñas = sc.nextInt();
        sc.nextLine();
        listadoPasswords = new Password[numContraseñas];
        boolean[] sonFuertes = new boolean[numContraseñas];

        System.out.println("Dime la longitud de los passwords");
        int longitudPass = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numContraseñas; i++) {
            Password p = new Password(longitudPass);
            boolean repetido = false;
            for (int j = 0; j < i; j++) {
                if (p.getContraseña().equals(listadoPasswords[j].getContraseña())) {
                    repetido = true;
                }
            }
            if (!repetido) {
                listadoPasswords[i] = p;
                sonFuertes[i] = p.esFuerte();
            } else {
                i--;
            }

        }

        for (int i = 0; i < numContraseñas; i++) {
            System.out.println(listadoPasswords[i].getContraseña() + " <--> " + sonFuertes[i]);
        }
    }

}
