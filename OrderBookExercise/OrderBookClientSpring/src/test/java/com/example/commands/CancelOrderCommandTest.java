package com.example.commands;

import com.example.dto.CreateOrderResponseDTO;
import com.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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

}