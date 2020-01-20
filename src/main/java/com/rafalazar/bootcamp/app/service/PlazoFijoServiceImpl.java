package com.rafalazar.bootcamp.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafalazar.bootcamp.app.client.PersonalClient;
import com.rafalazar.bootcamp.app.document.PlazoFijo;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.repository.PlazoFijoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlazoFijoServiceImpl implements PlazoFijoService{
	
	private static final Logger log = LoggerFactory.getLogger(PlazoFijoServiceImpl.class);
	
	@Autowired
	private PersonalClient client;
	
	@Autowired
	private PlazoFijoRepository repo;

	@Override
	public Flux<PlazoFijo> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<PlazoFijo> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<PlazoFijo> update(PlazoFijo pfijo) {
		return repo.findById(pfijo.getId())
				.map(p -> pfijo)
				.flatMap(repo::save);
	}

	@Override
	public Mono<PlazoFijo> delete(String id) {
		return repo.findById(id)
				.flatMap(p -> {
					p.getId();
					p.getNameAccount();
					p.getNumAccount();
					p.getDniOwner();
					p.setStatus("Inactive - Deleted");
					p.getMonto();
					return update(p);
				});
	}

	@Override
	public Mono<PlazoFijo> save(PlazoFijo pfijo) {
		return repo.save(pfijo);
	}

	@Override
	public Mono<PersonalDto> createById(String id) {
		return client.createById(id);
	}

}
