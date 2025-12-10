package com.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.config.Configuration;
import com.example.dto.CurrencyPairDTO;
import com.example.dto.FXRateDTO;
import com.example.exceptions.ApiRequestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
/**
 * Service responsible for the communication with API.
 * It sends requests for retrieving all rates and all supported currency pairs from the backend.
 */
public class RateService {

    private final HttpClient client;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String serverUrl;


    public RateService(Configuration config) {
        this.serverUrl = config.getServerUrl();
        int timeout = config.getTimeout();

        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(timeout))
                .build();
    }

    public List<FXRateDTO> getRates() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/rateSnapshot"))
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ApiRequestException("Network error while calling API", e);
        }

        int status = response.statusCode();

        if (status < 200 || status >= 300) {
            throw new ApiRequestException("Failed to retrieve rates.",
                    status, response.body());
        }
        return mapper.readValue(response.body(), new TypeReference<List<FXRateDTO>>() {
        });
    }

    //Todo maybe get allowed currencies must be cached
    public List<CurrencyPairDTO> getSupportedCurrencyPairs() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/supportedCurrencyPairs"))
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ApiRequestException("Network error while calling API", e);
        }
        int status = response.statusCode();

        if (status < 200 || status >= 300) {
            throw new ApiRequestException("Failed to retrieve supported currency pairs",
                    status, response.body());
        }

        return mapper.readValue(response.body(), new TypeReference<List<CurrencyPairDTO>>() {
        });
    }

}
