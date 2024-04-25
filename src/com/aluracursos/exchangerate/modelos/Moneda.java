package com.aluracursos.exchangerate.modelos;
import java.util.Map;

public abstract class Moneda {

    public Moneda(String currencyCode, Map<String, Double> conversionRates) {
        this.currencyCode = currencyCode;
        this.conversionRates = conversionRates;
    }

    private final String currencyCode;
    private final Map<String, Double> conversionRates;

    private double getRate() {
        return this.conversionRates.get(this.currencyCode);
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    protected double convertFromUSD(double mount) {
        return mount * this.getRate();
    }
    protected double convertToUSD(double mount) {
        double value = 1 / this.getRate();
        return value * mount;
    }

    public String fromUSD(double amount ) {
        return "El valor de " + amount  + " [USD] corresponde al valor final de: " + this.convertFromUSD(amount ) + " [" +this.getCurrencyCode()+"]\n";
    }

    public String toUSD(double amount ) {
        return  "El valor de " + amount  + "[" + this.getCurrencyCode() + "]" + " corresponde al valor final de: " + this.convertToUSD(amount ) + " [USD]\n";
    }
}
