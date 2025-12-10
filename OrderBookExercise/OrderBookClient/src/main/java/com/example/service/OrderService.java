package com.example.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.dto.CreateOrderResponseDTO;
import com.example.config.Configuration;
import com.example.dto.CreateOrderRequestDTO;
import com.example.exceptions.ApiRequestException;
/**
 * Service responsible for the communication with API.
 * It sends requests for creating orders, deleting orders and retrieving all orders.
 */
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
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ApiRequestException("Network error while calling API", e);
        }

        int status = response.statusCode();

        if (status < 200 || status >= 300) {
            throw new ApiRequestException("Failed to retrieve orders.",
                    status, response.body());
        }

        return mapper.readValue(
                response.body(),
                new TypeReference<List<CreateOrderResponseDTO>>() {
                }
        );
    }

    public CreateOrderResponseDTO createOrder(CreateOrderRequestDTO createOrderRequestDTO) throws Exception {
        String json = mapper.writeValueAsString(createOrderRequestDTO);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/createOrder"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ApiRequestException("Network error while calling API", e);
        }

        int status = response.statusCode();

        if (status < 200 || status >= 300) {
            throw new ApiRequestException("Failed to create order",
                    status, response.body());
        }
        return mapper.readValue(response.body(), CreateOrderResponseDTO.class);
    }

    public boolean deleteOrder(String id) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/cancelOrder"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(id))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ApiRequestException("Network error while calling API", e);
        }

        int status = response.statusCode();

        if (status < 200 || status >= 300) {
            throw new ApiRequestException("Failed to delete order",
                    status, response.body());
        }

        return Boolean.parseBoolean(response.body().trim());
    }
}