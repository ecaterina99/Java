package com.profidata.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profidata.DTO.CurrencyPairDTO;
import com.profidata.config.Configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class CurrencyPairService {
    private final HttpClient client;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String serverUrl;


    public CurrencyPairService(Configuration config) {
        this.serverUrl = config.getServerUrl();
        int timeout = config.getTimeout();

        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(timeout))
                .build();
    }

    public List<CurrencyPairDTO> getSupportedCurrencyPair() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/supportedCurrencyPairs"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();

        return mapper.readValue(json, new TypeReference<List<CurrencyPairDTO>>() {
        });
    }

}
