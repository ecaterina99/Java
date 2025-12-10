/*package com.profidata.commands;

import com.profidata.web.dto.CurrencyPairDTO;
import com.profidata.web.dto.FXRateDTO;
import com.profidata.application.service.RateApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AllRatesCommandTest {

    private RateApplicationService rateApplicationService;
    private AllRatesCommand command;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        rateApplicationService = mock(RateApplicationService.class);
        command = new AllRatesCommand(rateApplicationService);

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    private FXRateDTO rate(String c1, String c2, double ask, double bid) {
        CurrencyPairDTO pair = new CurrencyPairDTO();
        pair.setCcy1(c1);
        pair.setCcy2(c2);
        FXRateDTO dto = new FXRateDTO();
        dto.setCcyPair(pair);
        dto.setAsk(ask);
        dto.setBid(bid);

        return dto;
    }

    @Test
    void testExecutePrintsRates() throws Exception {
        List<FXRateDTO> mockRates = List.of(rate("USD", "EUR", 1.10, 1.09), rate("GBP", "USD", 1.30, 1.29));

        when(rateApplicationService.getRates()).thenReturn(mockRates);

        command.execute("rates");
        String out = output.toString();

        verify(rateApplicationService).getRates();

        assertTrue(out.contains("ccPair: USD - EUR"));
        assertTrue(out.contains("ask: 1.1"));
        assertTrue(out.contains("bid: 1.09"));
        assertTrue(out.contains("ccPair: GBP - USD"));
        assertTrue(out.contains("ask: 1.3"));
        assertTrue(out.contains("bid: 1.29"));
    }

    @Test
    void testExecutePrintEmptyList() throws Exception {
        List<FXRateDTO> mockRates = List.of();
        when(rateApplicationService.getRates()).thenReturn(mockRates);
        command.execute("rates");
        String out = output.toString();

        assertTrue(out.contains("The list is empty"));

    }

}

 */
