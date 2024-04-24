package com.aluracursos.exchangerate.calculos;

import com.aluracursos.exchangerate.Extra.Linea;
import com.aluracursos.exchangerate.api.ApiExchange;
import com.aluracursos.exchangerate.modelos.*;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Exchange {
    final ApiExchange api = new ApiExchange();
    Map<String, Double> rates;
    double amount ;

    public void loadData() {
        if (rates == null) {
            try {
                rates = api.getRate();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void start(int option) {
        if (option <= 0 || option > 8) return;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea convertir: ");
        amount = scanner.nextDouble();
        Linea.print();
        Moneda moneda = null;
        switch (option) {
            case 1, 2 -> {
                moneda = new PesoMexicano(rates);
            }
            case 3, 4 -> {
                moneda = new PesoArgentino(rates);
            }
            case 5, 6 -> {
                moneda = new Real(rates);
            }
            case 7,8 -> {
                moneda = new PesoColombiano(rates);
            }
        }
        this.showConvertion(option, moneda);
    }

    private void showConvertion(int option, Moneda moneda) {
        if (Option.convertFromUSD(option)) {
            moneda.fromUSD(amount);
        }
        else  {
            moneda.toUSD(amount);
        }
    }

}
