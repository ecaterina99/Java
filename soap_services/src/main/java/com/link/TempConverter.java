package com.link;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

//contract
@WebService
public interface TempConverter {
    @WebMethod
    double c2f(double degrees);

    @WebMethod
    double f2c(double degrees);
}
