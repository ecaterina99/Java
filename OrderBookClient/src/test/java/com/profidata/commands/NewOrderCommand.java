package com.profidata.commands;

import com.profidata.DTO.CreateOrderRequestDTO;
import com.profidata.DTO.CreateOrderResponseDTO;
import com.profidata.service.CurrencyPairService;
import com.profidata.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NewOrderCommandTest {

    private OrderService orderService;
    private NewOrderCommand command;

    @BeforeEach
    void setup() {
        orderService = mock(OrderService.class);
        CurrencyPairService currencyPairService = mock(CurrencyPairService.class);
        command = new NewOrderCommand(orderService, currencyPairService);
    }


    @Test
    void supports_shouldReturnTrue_whenStartsWithNewBuy() {
        assertTrue(command.supports("new buy EUR CHF 1.14 31.12.2025"));
    }

    @Test
    void supports_shouldReturnTrue_whenStartsWithNewSell() {
        assertTrue(command.supports("new sell USD EUR 1.05 10.12.2025"));
    }

    @Test
    void supports_shouldReturnFalse_whenInvalidCommand() {
        assertFalse(command.supports("update order 1"));
        assertFalse(command.supports("new something else"));
    }

    // -------------------------
    // validate() tests
    // -------------------------
    @Test
    void validate_shouldReturnTrue_whenInputIsValid() throws Exception {
        boolean result = command.validate("new buy EUR CHF 1.14 31.12.2025");
        assertTrue(result);
    }

    @Test
    void validate_shouldReturnFalse_whenIncorrectPartsCount() throws Exception {
        boolean result = command.validate("new buy EUR CHF 1.14");
        assertFalse(result);
    }

    @Test
    void validate_shouldReturnFalse_whenCurrenciesInvalid() throws Exception {
        boolean result = command.validate("new buy EURO CHF 1.14 31.12.2025");
        assertFalse(result);
    }

    @Test
    void validate_shouldReturnFalse_whenLimitNotNumber() throws Exception {
        boolean result = command.validate("new buy EUR CHF abc 31.12.2025");
        assertFalse(result);
    }

    @Test
    void validate_shouldReturnFalse_whenDateInvalid() throws Exception {
        boolean result = command.validate("new buy EUR CHF 1.14 99.99.9999");
        assertFalse(result);
    }

    // -------------------------
    // execute() tests
    // -------------------------
    @Test
    void execute_shouldCallOrderService_whenInputIsValid() throws Exception {
        // given
        CreateOrderResponseDTO fakeResponse = new CreateOrderResponseDTO();
        // Reflection or setter if you have it
        // assume DTO has setter for id
        fakeResponse.setId("2");
        when(orderService.createOrder(any())).thenReturn(fakeResponse);

        String input = "new buy EUR CHF 1.14 31.12.2025";

        // when
        command.execute(input);

        // then
        ArgumentCaptor<CreateOrderRequestDTO> captor =
                ArgumentCaptor.forClass(CreateOrderRequestDTO.class);

        verify(orderService).createOrder(captor.capture());
        CreateOrderRequestDTO dto = captor.getValue();

        assertEquals(true, dto.isBuy());
        assertEquals("EUR", dto.getInvestmentCcy());
        assertEquals("CHF", dto.getCounterCcy());
        assertEquals(1.14, dto.getLimit());
        assertEquals("31.12.2025", dto.getValidUntil());
    }

    @Test
    void execute_shouldNotCallOrderService_whenInputIsInvalid() throws Exception {
        String invalidInput = "new buy EUR CHF abc 31.12.2025";

        command.execute(invalidInput);

        verify(orderService, never()).createOrder(any());
    }
}
