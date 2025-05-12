package com.avilcom.moneyconverter.main.main;

import com.avilcom.moneyconverter.main.apihandling.apiexchange;
import com.avilcom.moneyconverter.main.apihandling.currencyconverter;
import com.avilcom.moneyconverter.main.apihandling.recordCurrency;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class main extends currencyconverter {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Aquí están las variables que se utilizarán

        Scanner menuInput = new Scanner(System.in);
        currencyconverter converter = new currencyconverter();
        Gson gson = new Gson();
        //Loop
        while(true) {
            System.out.println("Bienvenid@ al conversor de monedas, escriba la moneda de la que desea convertir, o escriba 'salir'");
            System.out.println("Monedas aceptadas: (ARS, COP, USD, EUR, MXN, BRL, PEN, CLP)");
            var base = menuInput.nextLine().toUpperCase();
            if (base.equals("SALIR")) {
                break;
            }
            if (!converter.validCurrency(base)) {
                System.out.println("Moneda no válida, vuelve a intentarlo");
                continue;
            }
            System.out.println("Moneda de destino: (ARS, COP, USD, EUR, MXN, BRL, PEN, CLP)");
            var target = menuInput.nextLine().toUpperCase();
            if (!converter.validCurrency(target)) {
                System.out.println("Moneda no válida, vuelve a intentarlo");
                continue;
            }
            System.out.println("Ahora escriba la cantidad que desea convertir");
            double amount = menuInput.nextDouble();
            menuInput.nextLine();
            String response = converter.convert(base, target, amount);
            recordCurrency prettyJson = gson.fromJson(response,recordCurrency.class);
            System.out.println("Has convertido [$" + amount +"]"+" ["+prettyJson.base_code()+"] a ["+prettyJson.target_code()+"] y esto dió como resultado: [$"+prettyJson.conversion_result()+"]");
        }

        }
    }
