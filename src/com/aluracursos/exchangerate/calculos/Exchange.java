package com.aluracursos.exchangerate.calculos;

import com.aluracursos.exchangerate.Extra.Historial;
import com.aluracursos.exchangerate.Extra.Linea;
import com.aluracursos.exchangerate.api.ApiExchange;
import com.aluracursos.exchangerate.modelos.*;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Exchange {
    final ApiExchange api = new ApiExchange();
    final Historial historial = new Historial();
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
        if (option == 9) {
            historial.showHistory();
            return;
        }

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
        this.convert(option, moneda);
    }

    private void convert(int option, Moneda moneda) {
        String conversion;
        if (Option.convertFromUSD(option)) {
            conversion = moneda.fromUSD(amount);
        }
        else  {
            conversion = moneda.toUSD(amount);
        }
        System.out.println(conversion);
        historial.add(conversion);
    }

}
