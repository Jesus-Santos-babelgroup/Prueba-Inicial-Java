package com.helloworld;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(">Buenas! Pon tu contraseña");
        Scanner sc = new Scanner(System.in);
        String userPassword = sc.nextLine();

        // boolean goodPassword = false;
        int passwordStrength = calcPasswordStrength(userPassword);
        System.out.println(passwordStrength);
        while (passwordStrength < 8) {
            System.out.println(">Su contraseña es débil");
            System.out.println(">¿Quiere mantenerla o hacerla más fuerte?");
            System.out.println(">(1: mantenerla, 2: cambiar)");

            // comprobar si quiere mantener la contraseña
            String answer = sc.nextLine();
            if (answer.equals("1")) {
                System.out.println("Contraseña puesta");
                return;
            } else if (answer.equals("2")) {
                System.out.println("De acuerdo! Pon una nueva contraseña");
                userPassword = sc.nextLine();
                passwordStrength = calcPasswordStrength(userPassword);
            } else {
                System.out.println("Error: Use use una de las opciones");
            }
        }

        System.out.println("Contraseña puesta");
        sc.close();
    }
}