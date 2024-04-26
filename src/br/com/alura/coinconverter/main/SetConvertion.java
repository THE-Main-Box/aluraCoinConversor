package br.com.alura.coinconverter.main;

import br.com.alura.coinconverter.api.ConnectToApi;

public class SetConvertion {

    private GetConvertionRate convertionRate;
    private ConnectToApi connectToApi = new ConnectToApi();
    private String toFindEquivalentCurrency, currency, response;
    private Menu menu = new Menu();
    private double value, convertedValue;
    private boolean breakProgram = false;


    public void set(int choice){

        breakProgram = false;

        switch (choice){
            case 1:
                currency = "usd";
                toFindEquivalentCurrency = "brl";
                break;
            case 2:
                currency = "brl";
                toFindEquivalentCurrency = "usd";
                break;
            case 3:
                currency = "usd";
                toFindEquivalentCurrency = "eur";
                break;
            case 4:
                currency = "eur";
                toFindEquivalentCurrency = "usd";
                break;
            case 5:
                currency = "ars";
                toFindEquivalentCurrency = "usd";
                break;
            case 6:
                currency = "usd";
                toFindEquivalentCurrency = "ars";
                break;
            default:
                System.out.println("Escolha uma opção válida");
                breakProgram = true;
                break;
        }

        if(breakProgram){
            return;
        }

        value = menu.setValueToConvert();

        convertedValue = this.calculate();

        menu.showConvertedValue(value, currency.toUpperCase(), convertedValue, toFindEquivalentCurrency.toUpperCase());
    }

    private double calculate(){
        response = connectToApi.search(currency);
        convertionRate = new GetConvertionRate(response);

        convertionRate.getConvertion(currency);
        double rateCurrency = convertionRate.getConversionRate();

        convertionRate.getConvertion(toFindEquivalentCurrency);
        double rateToFind = convertionRate.getConversionRate();


        if (rateCurrency != 0 && rateToFind != 0) {
            convertionRate.convert(value);
            return convertionRate.getConvertedValue();
        } else {
            System.out.println("Taxas de conversão não encontradas.");
            return 0.0;
        }

    }
}
