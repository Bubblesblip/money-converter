package com.avilcom.moneyconverter.main.main;

import com.avilcom.moneyconverter.main.apihandling.apiexchange;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class main extends apiexchange {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Aquí están las variables que se utilizarán
        Scanner menuInput = new Scanner(System.in);
        apiexchange urlSearch = new apiexchange();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        String baseCurrency;
        String targetCurrency;
        double amount;
        String apiSearch;
        String jsonResponse;

        //Loop
        while(true){
            System.out.println("Bienvenid@ al conversor de monedas, escriba la moneda de la que desea convertir, o escriba 'salir'");
            var search = menuInput.nextLine();
            switch (search){
                case("USD"):
                    baseCurrency = "USD";
                    System.out.println("Escriba la moneda a la que desea convertir, o atrás para ir al menú anterior");
                    search = menuInput.nextLine();
                        switch (search){
                            case("EUR"):
                                targetCurrency = "EUR";
                                System.out.println("Escriba la cantidad a convertir, sin puntos. O escriba atrás para ir al menú anterior");
                                amount = menuInput.nextDouble();
                                apiSearch = "https://v6.exchangerate-api.com/v6/27d22aa6056cd87dbd6cd4e2/pair/"+baseCurrency+"/"+targetCurrency+"/"+amount;
                                jsonResponse = urlSearch.getApi(apiSearch);
                                System.out.println("Response from API:");
                                System.out.println(jsonResponse);
                            default:
                                break;
                        }
            }
        }
    }
}
