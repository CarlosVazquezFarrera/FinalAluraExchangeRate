package com.aluracursos.exchangerate.modelos;

import java.util.Map;

public class PesoArgentino extends Moneda{
    public PesoArgentino(Map<String, Double> conversionRates) {
        super("ARS", conversionRates);
    }
}
