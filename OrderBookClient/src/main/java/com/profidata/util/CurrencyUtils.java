package com.profidata.util;

import com.profidata.DTO.CurrencyPairDTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CurrencyUtils {

    public static Set<String> extractSupportedPairs(List<CurrencyPairDTO> list) {
        return list.stream()
                .map(cp -> cp.getCcy1().toUpperCase() + " " + cp.getCcy2().toUpperCase())
                .collect(Collectors.toSet());
    }
}