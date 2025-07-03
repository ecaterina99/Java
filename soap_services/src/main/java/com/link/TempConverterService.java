package com.link;

import jakarta.jws.WebService;
//Service implementation bean
@WebService(endpointInterface = "com.link.TempConverter")
public class TempConverterService implements TempConverter {

    @Override
    public double c2f(double degrees) {
        return degrees * 9.0 / 5.0 + 32;
    }

    @Override
    public double f2c(double degrees) {
        return (degrees - 32) * 5.0 / 9.0;
    }
}
