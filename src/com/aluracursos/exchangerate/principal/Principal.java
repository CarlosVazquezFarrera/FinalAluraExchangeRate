package com.aluracursos.exchangerate.principal;
import com.aluracursos.exchangerate.Extra.Linea;
import com.aluracursos.exchangerate.calculos.Exchange;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        exchange.loadData();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        String menu = """
                1) Dólar => Peso Mexicano
                2) Pesos Mexicanos => Dólar
                3) Dolar => Pesos Argetinos
                4) Pesos Argentinos => Dolar
                5) Dólar => Real breasileño
                6) Real breasileño => Dólar
                7) Dólar => Peso Colombiano
                8) Peso Colombiano => Dólar
                """;
        do{
            System.out.println("Bienvenido");
            Linea.print();
            System.out.println(menu);
            Linea.print();
            System.out.println("Para salir teclee cualuier otro número\n");
            Linea.print();
            System.out.print("Selecciona una opción\n");
            option = scanner.nextInt();
            Linea.print();
            exchange.start(option);
            Linea.print();
        }while (option > 0 && option <= 8);
        System.out.println("Gracias por la preferencia");
    }
}
