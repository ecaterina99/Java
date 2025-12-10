package com.profidata.domain.model;

import com.profidata.domain.valueObject.CurrencyPair;
import com.profidata.domain.valueObject.Limit;
import com.profidata.domain.valueObject.OrderId;
import com.profidata.domain.valueObject.ValidUntil;
//Obiecte care au o identitate unică.

public record Order(
        OrderId id,
        CurrencyPair pair,
        boolean buy,
        Limit limit,
        ValidUntil validUntil
) {}