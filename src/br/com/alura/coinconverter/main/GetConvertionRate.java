package br.com.alura.coinconverter.main;

import br.com.alura.coinconverter.record.ExchangeRates;
import com.google.gson.Gson;

import java.util.Map;

public class GetConvertionRate {

    private String response;
    private Gson gson;
    private double conversionRates, convertedValue;

    public GetConvertionRate(String apiResponse){
        response = apiResponse;
        gson = new Gson();
    }

    public void getConvertion(String currency){

        currency = currency.toUpperCase();

        ExchangeRates exchangeRates = gson.fromJson(response, ExchangeRates.class);
        Map<String, Double> conversion_rates = exchangeRates.conversion_rates();

        conversionRates = conversion_rates.get(currency);
    }

    public void convert(double value) {
        convertedValue = value * conversionRates;
    }

    public double getConversionRate() {
        return conversionRates;
    }

    public double getConvertedValue() {
        return convertedValue;
    }
}
