package com.aluracursos.exchangerate.api;
import com.aluracursos.exchangerate.modelos.Rates;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiExchange {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    public Map<String, Double> getRate() throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/119493f15cc70605540adda5/latest/USD";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
        var rates = gson.fromJson(res.body(), Rates.class);
        return rates.conversion_rates();
    }
}
