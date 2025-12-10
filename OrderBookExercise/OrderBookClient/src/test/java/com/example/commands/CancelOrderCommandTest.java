package com.example.commands;

import com.example.dto.CreateOrderResponseDTO;
import com.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CancelOrderCommandTest {

    private OrderService orderService;
    private CancelOrderCommand command;

    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        orderService = mock(OrderService.class);
        command = new CancelOrderCommand(orderService);

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    private CreateOrderResponseDTO realOrder(String id) {
        CreateOrderResponseDTO dto = new CreateOrderResponseDTO();
        dto.setId(id);
        return dto;
    }

    @Test
    void testValidCancelDeletesOrder() throws Exception {
        when(orderService.getOrders()).thenReturn(List.of(realOrder("1")));
        when(orderService.deleteOrder("1")).thenReturn(true);

        command.execute("cancel 1");

        verify(orderService).deleteOrder("1");
        assertTrue(output.toString().contains("is deleted successfully"));
    }

    @Test
    void testInvalidOrderIdDoesNotCallDelete() throws Exception {
        when(orderService.getOrders()).thenReturn(List.of(realOrder("214")));

        command.execute("cancel 12");

        verify(orderService, never()).deleteOrder(anyString());
        assertTrue(output.toString().contains("This order does not exist"));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "cancel 12",
            "CANCEL 12",
            " CANCEL 12"
    })
    void supportsReturnsTrueForValidPatterns(String input) {
        assertTrue(command.supports(input));
    }

    @Test
    void supportsReturnsFalseForInvalidPatterns() {
        String input = "delete";
        assertFalse(command.supports(input));
    }

    @Test
    void validateReturnFalseWhenInputDoesNotHaveTwoParts() throws Exception {
        command.execute("cancel order 12");
        verify(orderService, never()).deleteOrder(anyString());
    }

    @Test
    void validateReturnFalseWhenInputHasTwoParts() throws Exception {
        command.execute("cancel 12");
        verify(orderService, never()).deleteOrder(anyString());
    }

}