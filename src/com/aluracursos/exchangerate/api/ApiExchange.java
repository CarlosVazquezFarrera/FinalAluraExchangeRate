package com.aluracursos.exchangerate.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchange {
    public void getInfo() throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/119493f15cc70605540adda5/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
