package com.aluracursos.exchangerate.modelos;

import java.util.Map;

public class PesoColombiano extends Moneda{
    public PesoColombiano(Map<String, Double> conversionRates) {
        super("COP", conversionRates);
    }
}
