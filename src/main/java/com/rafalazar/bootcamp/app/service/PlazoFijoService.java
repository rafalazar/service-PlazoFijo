package com.rafalazar.bootcamp.app.service;

import com.rafalazar.bootcamp.app.document.PlazoFijo;
import com.rafalazar.bootcamp.app.dto.PersonalDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlazoFijoService {
	
	public Flux<PlazoFijo> findAll();
	public Mono<PlazoFijo> findById(String id);
	public Mono<PlazoFijo> update(PlazoFijo pfijo);
	public Mono<PlazoFijo> delete(String id);
	public Mono<PlazoFijo> save(PlazoFijo pfijo);
	
	// --------------------------------------------
	
	public Mono<PersonalDto> createById(String id);

}
