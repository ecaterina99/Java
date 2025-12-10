package com.example.util;

import com.example.dto.CurrencyPairDTO;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * A helper method for working with supported currency pairs.
 */
public class CurrencyUtils {

    public static Set<String> extractSupportedPairs(List<CurrencyPairDTO> list) {
        return list.stream()
                .map(cp -> cp.getCcy1().toUpperCase() + " " + cp.getCcy2().toUpperCase())
                .collect(Collectors.toSet());
    }
}