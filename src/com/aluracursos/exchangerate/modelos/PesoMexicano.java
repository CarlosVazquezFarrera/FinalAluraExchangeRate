package com.aluracursos.exchangerate.modelos;

import java.util.Map;

public class PesoMexicano extends Moneda {
    public PesoMexicano(Map<String, Double> conversionRates) {
        super("MXN", conversionRates);
    }
}
