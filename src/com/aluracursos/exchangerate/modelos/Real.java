package com.aluracursos.exchangerate.modelos;

import java.util.Map;

public class Real extends Moneda{
    public Real(Map<String, Double> conversionRates) {
        super("BRL", conversionRates);
    }
}
