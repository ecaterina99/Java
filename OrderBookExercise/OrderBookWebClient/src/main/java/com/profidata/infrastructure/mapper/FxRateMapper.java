package com.profidata.infrastructure.mapper;

import com.profidata.domain.model.FXRate;
import com.profidata.domain.valueObject.CurrencyPair;
import com.profidata.web.dto.CurrencyPairDTO;
import com.profidata.web.dto.FxRateDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FxRateMapper {
    public CurrencyPair toDomain(CurrencyPairDTO dto) {
        return new CurrencyPair(dto.ccy1(), dto.ccy2());
    }

    public FXRate toDomain(FxRateDTO dto) {
        return new FXRate(
                new CurrencyPair(dto.ccyPair().ccy1(), dto.ccyPair().ccy2()),
                BigDecimal.valueOf(dto.bid()),
                BigDecimal.valueOf(dto.ask())
        );
    }
}
