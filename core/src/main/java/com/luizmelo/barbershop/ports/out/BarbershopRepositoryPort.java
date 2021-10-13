package com.luizmelo.barbershop.ports.out;

import com.luizmelo.barbershop.domain.Barbershop;

import java.util.Optional;

public interface BarbershopRepositoryPort {

    Optional<Barbershop> load(String barbershopName);

    Barbershop save(Barbershop barbershop);

}
