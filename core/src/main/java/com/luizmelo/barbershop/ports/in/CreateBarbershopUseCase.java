package com.luizmelo.barbershop.ports.in;

import com.luizmelo.barbershop.ports.out.BarbershopRepositoryPort;
import com.luizmelo.barbershop.ports.out.CreatedBarbershop;
import com.luizmelo.barbershop.service.CreateBarbershopService;

public interface CreateBarbershopUseCase {

    CreatedBarbershop create(CreateBarbershopCommand createBarbershopCommand);

    static CreateBarbershopUseCase getInstance(BarbershopRepositoryPort barbershopRepositoryPort) {
        return new CreateBarbershopService(barbershopRepositoryPort);
    }
}
