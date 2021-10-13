package com.luizmelo.barbershop.ports.in;

import com.luizmelo.barbershop.ports.out.BarbershopRepositoryPort;
import com.luizmelo.barbershop.ports.out.BookedReservation;
import com.luizmelo.barbershop.service.BookReservationService;

public interface BookReservationUseCase {

    BookedReservation book(BookReservationCommand bookReservationCommand);

    static BookReservationUseCase getInstance(BarbershopRepositoryPort barbershopRepositoryPort) {
        return new BookReservationService(barbershopRepositoryPort);
    }
}
