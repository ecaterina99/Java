/*package com.profidata.commands;

import com.profidata.web.dto.CreateOrderResponseDTO;
import com.profidata.application.service.OrderApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class SummaryCommandTest {

    private OrderApplicationService orderApplicationService;
    private SummaryCommand summaryCommand;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        orderApplicationService = Mockito.mock(OrderApplicationService.class);
        summaryCommand = new SummaryCommand(orderApplicationService);
        System.setOut(new PrintStream(output));
    }

    private CreateOrderResponseDTO createOrder(boolean buy, String inv, String counter, double limit) {
        CreateOrderResponseDTO dto = Mockito.mock(CreateOrderResponseDTO.class);
        when(dto.isBuy()).thenReturn(buy);
        when(dto.getInvestmentCcy()).thenReturn(inv);
        when(dto.getCounterCcy()).thenReturn(counter);
        when(dto.getLimit()).thenReturn(limit);
        return dto;
    }

    @Test
    void testSupports() {
        assertTrue(summaryCommand.supports("summary"));
        assertTrue(summaryCommand.supports("SUMMARY"));
        assertFalse(summaryCommand.supports("wrongCommand"));
    }

    @Test
    void testExecuteGroupsAndSortsCorrectly()  {
        List<CreateOrderResponseDTO> orders = Arrays.asList(createOrder(true, "USD", "EUR", 1.10), createOrder(true, "USD", "EUR", 1.20), createOrder(false, "USD", "EUR", 1.50), createOrder(true, "EUR", "USD", 0.90));

        when(orderApplicationService.getOrders()).thenReturn(orders);
        summaryCommand.execute("summary");
        String out = output.toString().trim();

        String expected = "buy   EUR   USD   1 0.90\n" + "buy   USD   EUR   2 1.15\n" + "sell  USD   EUR   1 1.50";
        String normalizedOut = out.replaceAll("\\s+", " ").trim();
        String normalizedExpected = expected.replaceAll("\\s+", " ").trim();

        assertEquals(normalizedExpected, normalizedOut);
    }
}


 */