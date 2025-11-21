package com.profidata.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profidata.DTO.CreateOrderResponseDTO;
import com.profidata.config.Configuration;
import com.profidata.DTO.CreateOrderRequestDTO;

public class OrderService {

    private final HttpClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    private final String serverUrl;


    public OrderService(Configuration config) {
        this.serverUrl = config.getServerUrl();
        int timeout = config.getTimeout();

        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(timeout))
                .build();
    }


    public List<CreateOrderResponseDTO> getOrders() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/retrieveOrders"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();

        return mapper.readValue(json, new TypeReference<List<CreateOrderResponseDTO>>() {
        });
    }


    public CreateOrderResponseDTO createOrder(CreateOrderRequestDTO createOrderRequestDTO) throws Exception {
        String json = mapper.writeValueAsString(createOrderRequestDTO);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/createOrder"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(response.body(), CreateOrderResponseDTO.class);
    }

    public boolean deleteOrder(String id) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/cancelOrder"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(id))
                .build();


        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return Boolean.parseBoolean(response.body().trim());
    }


}