package com.barbershop.adapter.out.repository;

import com.luizmelo.barbershop.domain.Barbershop;
import com.luizmelo.barbershop.ports.out.BarbershopRepositoryPort;

import java.util.Optional;

public class MockBarbershopRepositoryPortImpl implements BarbershopRepositoryPort {

    @Override
    public Optional<Barbershop> load(String barbershopName) {
//        return Optional.of(BarbershopUtils.createBarbershop());
        return Optional.empty();
    }

    @Override
    public Barbershop save(Barbershop barbershop) {
        return MockBarbershopUtils.createBarbershop();
    }
}
