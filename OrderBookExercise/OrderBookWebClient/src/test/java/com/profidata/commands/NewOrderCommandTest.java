/*package com.profidata.commands;

import com.profidata.commands.NewOrderCommand;
import com.profidata.web.dto.CreateOrderRequestDTO;
import com.profidata.web.dto.CreateOrderResponseDTO;
import com.profidata.web.dto.CurrencyPairDTO;
import com.profidata.application.service.OrderApplicationService;
import com.profidata.application.service.RateApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NewOrderCommandTest {

    private OrderApplicationService orderApplicationService;
    private RateApplicationService rateApplicationService;
    private NewOrderCommand command;

    @BeforeEach
    void setup() throws Exception {
        orderApplicationService = mock(OrderApplicationService.class);
        rateApplicationService = mock(RateApplicationService.class);
        when(rateApplicationService.getSupportedCurrencyPairs()).thenReturn(List.of(createPair("EUR", "CHF")));

        command = new NewOrderCommand(orderApplicationService, rateApplicationService);
    }

    private CurrencyPairDTO createPair(String c1, String c2) {
        CurrencyPairDTO dto = new CurrencyPairDTO();
        dto.setCcy1(c1);
        dto.setCcy2(c2);
        return dto;
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "new buy EUR CHF 1.14 31.12.2025",
            "new BUY USD JPY 1.00 01.01.2030",
            "new sell GBP USD 1.30 10.10.2025",
            "  new SELL EUR USD 1.05 15.05.2026"
    })
    void supportsReturnsTrueForValidPatterns(String input) {
        assertTrue(command.supports(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "update order 1",
            "create order",
            "new something wrong",
            "order new buy EUR CHF",
            "buy new EUR CHF 1.14 31.12.2025"
    })
    void supportsReturnsFalseForInvalidPatterns(String input) {
        assertFalse(command.supports(input));
    }


    @Test
    void validateReturnsTrueForValidInput() throws Exception {
        boolean result = command.validate("new buy EUR CHF 1.14 31.12.2025");
        assertTrue(result);
    }

    @Test
    void validateReturnsFalseWhenPartsAreMissing() throws Exception {
        boolean result = command.validate("new buy EUR CHF 1.14");
        assertFalse(result);
    }

    @Test
    void validateReturnsFalseWhenCurrencyPairUnsupported() throws Exception {
        when(rateApplicationService.getSupportedCurrencyPairs()).thenReturn(List.of(createPair("USD", "JPY")));
        boolean result = command.validate("new buy EUR CHF 1.14 31.12.2025");
        assertFalse(result);
    }

    @Test
    void validateReturnsFalseWhenLimitIsInvalid() throws Exception {
        boolean result = command.validate("new buy EUR CHF abc 31.12.2025");
        assertFalse(result);
    }

    @Test
    void validateReturnsFalseWhenDateIsInvalid() throws Exception {
        boolean result = command.validate("new buy EUR CHF 1.14 23.1.111");
        assertFalse(result);
    }

    @Test
    void executeCallsOrderServiceWhenInputIsValid() throws Exception {
        CreateOrderResponseDTO fakeResponse = new CreateOrderResponseDTO();
        fakeResponse.setId("2");
        when(orderApplicationService.createOrder(any())).thenReturn(fakeResponse);
        command.execute("new buy EUR CHF 1.14 31.12.2025");

        ArgumentCaptor<CreateOrderRequestDTO> captor = ArgumentCaptor.forClass(CreateOrderRequestDTO.class);

        verify(orderApplicationService).createOrder(captor.capture());
        CreateOrderRequestDTO dto = captor.getValue();

        assertTrue(dto.isBuy());
        assertEquals("EUR", dto.getInvestmentCcy());
        assertEquals("CHF", dto.getCounterCcy());
        assertEquals(1.14, dto.getLimit());
        assertEquals("31.12.2025", dto.getValidUntil());
    }

    @Test
    void executeDoesNotCallOrderServiceWhenInputIsInvalid() throws Exception {
        command.execute("new buy EUR CHF abc 31.12.2025");
        verify(orderApplicationService, never()).createOrder(any());
    }



    @Test
    void validateReturnFalseWhenInputDoesNotHaveSixParts() throws Exception {
       boolean result=  command.validate("new buy EUR CHF 1.2");
       assertFalse(result);
    }

    @Test
    void validateReturnFalseWhenInputHasHaveSixParts() throws Exception {
        boolean result=  command.validate("new buy EUR CHF 1.2 31.02.2024");
        assertTrue(result);
    }

}




 */
