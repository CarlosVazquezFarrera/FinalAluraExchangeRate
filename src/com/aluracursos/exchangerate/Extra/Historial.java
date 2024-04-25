package com.aluracursos.exchangerate.Extra;

import com.aluracursos.exchangerate.modelos.Moneda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private final List<String> monedas = new ArrayList<String>();

    public void add(String conversion) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        String text = "| " + formattedDateTime + " | -> " + conversion;
        monedas.add(text);
    }
    public void showHistory() {
        if(monedas.size() < 1) {
            System.out.println("Sin búsquedas hasta el momento");
        }
        else {
            System.out.println("Historial de búsquedas");
            monedas.forEach(System.out::println);
        }
    }
}
