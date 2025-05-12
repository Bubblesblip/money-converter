package com.avilcom.moneyconverter.main.apihandling;

public record recordCurrency(String base_code, String target_code, double conversion_rate, double conversion_result) {
}
