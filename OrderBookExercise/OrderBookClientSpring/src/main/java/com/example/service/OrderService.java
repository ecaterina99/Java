package com.example.service;

import com.example.dto.CreateOrderRequestDTO;
import com.example.dto.CreateOrderResponseDTO;
import com.example.exceptions.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;

import java.util.List;
/**
 * Service responsible for the communication with API.
 * It sends requests for creating orders, deleting orders and retrieving all orders.
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final WebClient orderServiceWebClient;

   public CreateOrderResponseDTO createOrder(CreateOrderRequestDTO order) {

        try {
            return orderServiceWebClient.post().uri("/createOrder").bodyValue(order).exchangeToMono(response -> {

                if (response.statusCode().is2xxSuccessful()) {
                    return response.bodyToMono(CreateOrderResponseDTO.class);
                }
                return response.bodyToMono(String.class).flatMap(body -> Mono.error(
                        new ApiRequestException("Failed to create order", response.statusCode().value(), body)));
            }).block();

        } catch (WebClientRequestException e) {
            throw new ApiRequestException("Order service is not reachable", e);
        } catch (Exception e) {
            throw new ApiRequestException("Unexpected error while creating order", e);
        }
    }


    public Boolean deleteOrder(String id) {
        try {
            return orderServiceWebClient.post().uri("/cancelOrder").bodyValue(id).exchangeToMono(response -> {

                if (response.statusCode().is2xxSuccessful()) {
                    return response.bodyToMono(String.class);
                }

                return response.bodyToMono(String.class).flatMap(body -> Mono.error(
                        new ApiRequestException("Failed to delete order", response.statusCode().value(), body)));
            }).map(Boolean::parseBoolean).block();

        } catch (WebClientRequestException e) {
            throw new ApiRequestException("Order service is not reachable", e);
        } catch (Exception e) {
            throw new ApiRequestException("Unexpected error while deleting order", e);
        }
    }

    public List<CreateOrderResponseDTO> getOrders() {

        try {
            return orderServiceWebClient.get().uri("/retrieveOrders").exchangeToMono(response -> {

                if (response.statusCode().is2xxSuccessful()) {
                    return response.bodyToFlux(CreateOrderResponseDTO.class).collectList();
                }

                return response.bodyToMono(String.class).flatMap(body -> Mono.error(
                        new ApiRequestException("Failed to retrieve orders", response.statusCode().value(), body)));
            }).block();

        } catch (WebClientRequestException e) {
            throw new ApiRequestException("Order service is not reachable", e);
        } catch (Exception e) {
            throw new ApiRequestException("Unexpected error while retrieving orders", e);
        }
    }
}

/*
    private final RestClient orderServiceClient;

    public CreateOrderResponseDTO createOrder(CreateOrderRequestDTO order) {
        try {
            return orderServiceClient.post()
                    .uri("/createOrder")
                    .body(order)
                    .retrieve()
                    .body(CreateOrderResponseDTO.class);
        } catch (RestClientException e) {
            throw new ApiRequestException("Failed to create order", e);
        }
    }


 */