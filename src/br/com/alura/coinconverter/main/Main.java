package br.com.alura.coinconverter.main;

import br.com.alura.coinconverter.api.ConnectToApi;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        SetConvertion setConvertion = new SetConvertion();

        int choice = 0;
        while (choice != 7) {
            choice = menu.lobby();
            if(choice == 7){
                break;
            }
            setConvertion.set(choice);
        }

    }
}
