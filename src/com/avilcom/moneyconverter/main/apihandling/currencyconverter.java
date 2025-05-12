package com.avilcom.moneyconverter.main.apihandling;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class currencyconverter extends apiexchange {
    private Set<String> supportedCurrencies = new HashSet<>(Arrays.asList("COP", "USD", "EUR", "MXN", "ARS", "BRL", "PEN", "CLP"));

    public boolean validCurrency(String currency) {
        return supportedCurrencies.contains(currency.toUpperCase());
    }
    public String apiUrl(String baseCurrency, String targetCurrency, double amount) {
        return "https://v6.exchangerate-api.com/v6/27d22aa6056cd87dbd6cd4e2/pair/"
                + baseCurrency + "/" + targetCurrency + "/" + amount;
    }
    public String convert(String baseCurrency, String targetCurrency, double amount) throws IOException, InterruptedException {
        String apiUrl = apiUrl(baseCurrency, targetCurrency, amount);
        return getApi(apiUrl);
    }
}

