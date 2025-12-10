package com.example.commands;

import com.example.dto.CreateOrderResponseDTO;
import com.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SummaryCommandTest {

    private OrderService orderService;
    private SummaryCommand summaryCommand;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        orderService = Mockito.mock(OrderService.class);
        summaryCommand = new SummaryCommand(orderService);
        System.setOut(new PrintStream(output));
    }

    /*  private CreateOrderResponseDTO createOrder(boolean buy, String inv, String counter, double limit) {
          CreateOrderResponseDTO dto = Mockito.mock(CreateOrderResponseDTO.class);
          when(dto.isBuy()).thenReturn(buy);
          when(dto.getInvestmentCcy()).thenReturn(inv);
          when(dto.getCounterCcy()).thenReturn(counter);
          when(dto.getLimit()).thenReturn(limit);
          return dto;
      }

     */
    private CreateOrderResponseDTO createOrder( boolean buy, String inv, String ctr, double limit) {
        CreateOrderResponseDTO dto = new CreateOrderResponseDTO();
        dto.setBuy(buy);
        dto.setInvestmentCcy(inv);
        dto.setCounterCcy(ctr);
        dto.setLimit(limit);
        dto.setValidUntil("2025-12-31");
        return dto;
    }



    @Test
    void testSupports() {
        assertTrue(summaryCommand.supports("summary"));
        assertTrue(summaryCommand.supports("SUMMARY"));
        assertFalse(summaryCommand.supports("wrongCommand"));
    }

    @Test
    void testExecuteGroupsAndSortsCorrectly() throws Exception {
        List<CreateOrderResponseDTO> orders = Arrays.asList(createOrder(true, "USD", "EUR", 1.10), createOrder(true, "USD", "EUR", 1.20), createOrder(false, "USD", "EUR", 1.50), createOrder(true, "EUR", "USD", 0.90));

        when(orderService.getOrders()).thenReturn(orders);
        summaryCommand.execute("summary");
        String out = output.toString().trim();

        String expected = "buy   EUR   USD   1 0.90\n" + "buy   USD   EUR   2 1.15\n" + "sell  USD   EUR   1 1.50";
        String normalizedOut = out.replaceAll("\\s+", " ").trim();
        String normalizedExpected = expected.replaceAll("\\s+", " ").trim();

        assertEquals(normalizedExpected, normalizedOut);
    }
}
