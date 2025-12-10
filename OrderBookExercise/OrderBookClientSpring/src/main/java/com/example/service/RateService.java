package com.example.service;

import com.example.dto.CurrencyPairDTO;
import com.example.dto.FXRateDTO;
import com.example.exceptions.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Service responsible for the communication with API.
 * It sends requests for retrieving all rates and all supported currency pairs from the backend.
 */
@Service
@RequiredArgsConstructor
public class RateService {

    private final WebClient orderServiceWebClient;

    public List<FXRateDTO> getRates() {
        try {
            return orderServiceWebClient.get().uri("/rateSnapshot").exchangeToMono(response -> {
                //success

                if (response.statusCode().is2xxSuccessful()) {
                    return response.bodyToFlux(FXRateDTO.class).collectList();
                }
                //err
                return response.bodyToMono(String.class).flatMap(body -> Mono.error(
                        new ApiRequestException("Failed to retrieve FX rates", response.statusCode().value(), body)));
            }).block();

        } catch (WebClientRequestException ex) {
            throw new ApiRequestException("Unable to reach FX rate service", ex);
        }
    }

    //Todo maybe get allowed currencies must be cached
    public List<CurrencyPairDTO> getSupportedCurrencyPairs() {

        try {
            return orderServiceWebClient.get().uri("/supportedCurrencyPairs").exchangeToMono(response -> {
                //success
                if (response.statusCode().is2xxSuccessful()) {
                    return response.bodyToFlux(CurrencyPairDTO.class).collectList();
                }
                //err
                return response.bodyToMono(String.class).flatMap(body -> Mono.error(
                new ApiRequestException("Failed to retrieve supported currency pairs", response.statusCode().value(), body)));
            }).block();

        } catch (WebClientRequestException ex) {
            throw new ApiRequestException("Unable to reach currency pair service", ex);
        } catch (Exception ex) {
            throw new ApiRequestException("Unexpected error retrieving supported currency pairs", ex);
        }
    }
}
