package com.profidata.infrastructure.client;

import com.profidata.domain.model.FXRate;
import com.profidata.domain.valueObject.CurrencyPair;
import com.profidata.infrastructure.mapper.FxRateMapper;
import com.profidata.web.dto.CurrencyPairDTO;
import com.profidata.web.dto.FxRateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RateServiceClient {

    private final WebClient webClient;
    private final FxRateMapper mapper;

    public Mono<List<CurrencyPair>> getSupportedPairs() {
        return webClient.get()
                .uri("/supportedCurrencyPairs")
                .retrieve()
                .bodyToFlux(CurrencyPairDTO.class)
                .map(mapper::toDomain)
                .collectList();
    }

    public Mono<List<FXRate>> getRates() {
        return webClient.get()
                .uri("/rateSnapshot")
                .retrieve()
                .bodyToFlux(FxRateDTO.class)
                .map(mapper::toDomain)
                .collectList();
    }
}