package com.rafalazar.bootcamp.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rafalazar.bootcamp.app.document.PlazoFijo;

public interface PlazoFijoRepository extends ReactiveMongoRepository<PlazoFijo, String>{

}
