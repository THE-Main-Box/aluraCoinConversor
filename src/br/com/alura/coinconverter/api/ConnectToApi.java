package br.com.alura.coinconverter.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectToApi {

    private String url;

    public String search(String currency) {

        currency = currency.toUpperCase();

        url = "https://v6.exchangerate-api.com/v6/d0a994edf65f4390c3d9cfc7/latest/" + currency;

        String resp = "";

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (!response.body().isEmpty()) {
                resp = response.body();
            }

        } catch (Exception e) {
            System.out.println("Erro ao solicitar dados da api " + e);
            resp = "";
        }
            return resp;

    }


}
