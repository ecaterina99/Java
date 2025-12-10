package com.example.commands;

import com.example.dto.FXRateDTO;
import com.example.service.RateService;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Command that prints a snapshot of all FX market rates.
 * Shows currency pair, ask price, and bid price.
 */
@Component
public class AllRatesCommand implements Command {
    private final RateService rateService;

    public AllRatesCommand(RateService rateService) {
        this.rateService = rateService;
    }

    @Override
    public boolean supports(String input) {
        return input.equalsIgnoreCase("rates");
    }

    @Override
    public void execute(String input) throws Exception {
        List<FXRateDTO> rates = rateService.getRates();
        if(rates.isEmpty()){
            System.out.println("The list is empty");
        }else {
            for (FXRateDTO rate : rates) {
                System.out.printf(
                        "%-10s  %-10s  %10s\n",
                        "ccPair: " + rate.getCcyPair().getCcy1() + " - " + rate.getCcyPair().getCcy2(),
                        "ask: " + rate.getAsk(),
                        "bid: " + rate.getBid()
                );
            }
        }
    }
}
