package com.aluracursos.exchangerate.calculos;

import com.aluracursos.exchangerate.modelos.Moneda;

public class Option {
    public static boolean convertFromUSD(int option) {
        return option % 2 != 0;
    }
}
