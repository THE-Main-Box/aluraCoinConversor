package br.com.alura.coinconverter.main;

import java.util.Scanner;

public class Menu {

    private Scanner reader = new Scanner(System.in);
    private int choice;

//    apenas um menu onde é mostrado as opções disponiveis
    public int lobby(){
        System.out.println("********************************************");
        System.out.println("Seja bem vindo ao CONVERSOR DE MOEDAS.");
        System.out.println("Escolha um tipo de moeda para começar:");
        System.out.println("ou escolha a opção 7 para sair");
        System.out.println();

        System.out.println("1) Dolar ==> Real Brasileiro");
        System.out.println("2) Real Brasileiro ==> Dolar");
        System.out.println();
        System.out.println("3) Dolar ==> Euro");
        System.out.println("4) Euro ==> Dolar");
        System.out.println();
        System.out.println("5) Peso Argentino ==> Dolar");
        System.out.println("6) Dolar ==> Peso argentino");
        System.out.println();
        System.out.println("7) Sair");
        System.out.println();
        System.out.println("********************************************");

        choice = reader.nextInt();

        return choice;
    }

    public double setValueToConvert(){
        System.out.println("Escreva o valor a ser calculado:");
        return reader.nextDouble();
    }

    public void showConvertedValue(double ogValue, String ogCurrency, double convertedValue, String convetedCurrency){
        System.out.println("O resultado da conversão de [%.2f] %s para [%s] é".formatted(ogValue, ogCurrency, convetedCurrency));
        System.out.println("[%.2f]%s".formatted(convertedValue, convetedCurrency));
    }

}
