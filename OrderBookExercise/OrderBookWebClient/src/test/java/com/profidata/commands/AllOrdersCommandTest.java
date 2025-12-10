/*ackage com.profidata.commands;

import com.profidata.web.dto.CreateOrderResponseDTO;
import com.profidata.web.dto.CurrencyPairDTO;
import com.profidata.web.dto.FXRateDTO;
import com.profidata.application.service.OrderApplicationService;
import com.profidata.application.service.RateApplicationService;
import com.profidata.domain.service.FXCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AllOrdersCommandTest {

    private OrderApplicationService orderApplicationService;
    private RateApplicationService rateApplicationService;
    private AllOrdersCommand command;

    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        orderApplicationService = mock(OrderApplicationService.class);
        rateApplicationService = mock(RateApplicationService.class);
        command = new AllOrdersCommand(orderApplicationService, rateApplicationService);

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    private CreateOrderResponseDTO order(String id, boolean buy, String inv, String ctr, double limit) {
        CreateOrderResponseDTO dto = new CreateOrderResponseDTO();
        dto.setId(id);
        dto.setBuy(buy);
        dto.setInvestmentCcy(inv);
        dto.setCounterCcy(ctr);
        dto.setLimit(limit);
        dto.setValidUntil("2025-12-31");
        return dto;
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
    void testExecutePrintsSortedOrders() throws Exception {
        CreateOrderResponseDTO o1 = order("1", true, "USD", "EUR", 1.10);
        CreateOrderResponseDTO o2 = order("2", false, "USD", "EUR", 1.20);

        List<FXRateDTO> rates = List.of(rate("USD", "EUR", 1.11, 1.10));

        when(orderApplicationService.getOrders()).thenReturn(new ArrayList<>(List.of(o1, o2)));
        when(rateApplicationService.getRates()).thenReturn(rates);

        try (MockedStatic<FXCalculator> mockCalc = mockStatic(FXCalculator.class)) {
            mockCalc.when(() -> FXCalculator.calculateDistance(rates, o1)).thenReturn(0.2);
            mockCalc.when(() -> FXCalculator.calculateDistance(rates, o2)).thenReturn(0.5);

            command.execute("orders");
        }

        String out = output.toString();

        verify(orderApplicationService).getOrders();
        verify(rateApplicationService).getRates();

        assertTrue(out.contains("id:2"), "Order 2 should appear first in output");
        assertTrue(out.contains("id:1"), "Order 1 should appear second");
        assertTrue(out.contains("BUY") || out.contains("SELL"));

    }
}

 */
