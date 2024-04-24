package br.com.alura.coinconverter.main;

import br.com.alura.coinconverter.api.ConnectToApi;

public class SetConvertion {

    private GetConvertionRate convertionRate;
    private ConnectToApi connectToApi = new ConnectToApi();
    private String toFind, passed, response;
    private Menu menu = new Menu();
    private double value, convertedValue;


    public void set(int choice){

        switch (choice){
            case 1:
                passed = "usd";
                toFind = "brl";
                break;
            case 2:
                passed = "brl";
                toFind = "usd";
                break;
            case 3:
                passed = "usd";
                toFind = "eur";
                break;
            case 4:
                passed = "eur";
                toFind = "usd";
                break;
            case 5:
                passed = "ars";
                toFind = "usd";
                break;
            case 6:
                passed = "usd";
                toFind = "ars";
                break;
        }

        value = menu.setValueToConvert();

        convertedValue = this.calculate();

        menu.showConvertedValue(convertedValue);
    }

    private double calculate(){
        response = connectToApi.search(passed);
        convertionRate = new GetConvertionRate(response);

        convertionRate.getConvertion(passed);
        double ratePassed = convertionRate.getConversionRate();

        convertionRate.getConvertion(toFind);
        double rateToFind = convertionRate.getConversionRate();


        if (ratePassed != 0 && rateToFind != 0) {
            convertionRate.convert(value);
            return convertionRate.getConvertedValue();
        } else {
            System.out.println("Taxas de conversão não encontradas.");
            return 0.0;
        }

    }
}
