package com.aluracursos.exchangerate.principal;

import com.aluracursos.exchangerate.api.ApiExchange;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var api = new ApiExchange();
        int option = 0;
        String linea = "********************************************\n";
        String menu = """
                1) Dólar => Peso Mexicano
                2) Pesos Mexicanos => Dólar
                3) Dolar => Pesos Argetinos
                4) Pesos Argentinos => Dolar
                5) Dólar => Real breasileño
                6) Real breasileño => Dólar""";
        do{
            System.out.println("Bienvenido");
            System.out.println(linea);
            System.out.println(menu);
            System.out.println(linea);
            System.out.println("Para salir teclee cualuier otro número\n");
            System.out.println(linea);

            System.out.print("Selecciona una optión:");
            option = scanner.nextInt();
        }while (option > 0 && option <= 6);
        System.out.println("Gracias por la preferencia");
    }
}
