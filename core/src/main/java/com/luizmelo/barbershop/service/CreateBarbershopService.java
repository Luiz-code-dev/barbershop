package com.luizmelo.barbershop.service;

import com.luizmelo.barbershop.domain.Availability;
import com.luizmelo.barbershop.domain.Barbershop;
import com.luizmelo.barbershop.exception.BarbershopAlreadyRegisteredException;
import com.luizmelo.barbershop.ports.in.AvailabilityCommand;
import com.luizmelo.barbershop.ports.in.CreateBarbershopCommand;
import com.luizmelo.barbershop.ports.in.CreateBarbershopUseCase;
import com.luizmelo.barbershop.ports.out.BarbershopRepositoryPort;
import com.luizmelo.barbershop.ports.out.CreatedBarbershop;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateBarbershopService implements CreateBarbershopUseCase {

    private BarbershopRepositoryPort barbershopRepositoryPort;

    @Override
    public CreatedBarbershop create(CreateBarbershopCommand command) {
        barbershopRepositoryPort.load(command.getName())
                .ifPresent(barbershop -> { throw new BarbershopAlreadyRegisteredException(barbershop.getName());} );

        Availability availability = createAvailability(command);
        Barbershop barbershop = createBarberhop(command, availability);

        Barbershop savedBarbershop = barbershopRepositoryPort.save(barbershop);

        return CreatedBarbershop.of(savedBarbershop);
    }

    private Availability createAvailability(CreateBarbershopCommand command) {
        AvailabilityCommand availabilityCommand = command.getAvailabilityCommand();

        Availability availability = Availability.of(availabilityCommand.getDaysOfWeek(),
                availabilityCommand.getOpenTime(),
                availabilityCommand.getCloseTime(),
                availabilityCommand.getDuration());
        return availability;
    }

    private Barbershop createBarberhop(CreateBarbershopCommand command, Availability availability) {
        return Barbershop.builder()
                .name(command.getName())
                .address(command.getAddress())
                .city(command.getCity())
                .availability(availability)
                .build();
    }
}
