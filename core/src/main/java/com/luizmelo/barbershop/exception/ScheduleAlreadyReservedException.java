package com.luizmelo.barbershop.exception;

import com.luizmelo.barbershop.domain.Customer;

public class ScheduleAlreadyReservedException extends BusinessException {

    public ScheduleAlreadyReservedException(Customer customer) {
        super(String.format("Schedule informed by customer %s is already registered", customer), 400);
    }
}
