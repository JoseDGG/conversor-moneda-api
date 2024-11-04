package com.jdgg.conversor.servicios;

import com.google.gson.Gson;
import com.jdgg.conversor.modelos.Monedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Consultador{
    private Gson gson = new Gson();
    private String direccion;
    private String baseCurrency;

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Map<String, Double> getConversionRates() {
        try {
        Monedas monedas = llamarAPI();
        return monedas.conversion_rates(); //retorna un mapa con las conversiones de monedas que hay en la API
        }catch (Exception e){
            System.out.println("No se pudo obtener las tasas de conversión. Por favor, intente otra vez.");
        }
        return null;
    }

    private Monedas llamarAPI(){
        direccion = "https://v6.exchangerate-api.com/v6/d6157628efd1566faf50f4f5/latest/" + baseCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(),Monedas.class);
        }catch(Exception e){
            System.out.println("Error en la llamada a la API");
            return null;
        }
    }
}
