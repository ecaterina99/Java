package com.profidata.commands;

import com.profidata.DTO.FXRateDTO;
import com.profidata.service.RateService;

import java.util.List;

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
        for (FXRateDTO rate : rates) {
            System.out.printf(
                    "%-9s  %-9s  %9s\n",
                    "ccPair: " + rate.getCcyPair().getCcy1() + " - " + rate.getCcyPair().getCcy2(),
                    "ask: " + rate.getAsk(),
                    "bid: " + rate.getBid()
            );
        }
    }
}
