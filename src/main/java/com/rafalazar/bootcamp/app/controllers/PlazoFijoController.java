package com.rafalazar.bootcamp.app.controllers;

import java.net.URI;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafalazar.bootcamp.app.document.PlazoFijo;
import com.rafalazar.bootcamp.app.dto.PersonalDto;
import com.rafalazar.bootcamp.app.service.PlazoFijoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/plazoFijo")
public class PlazoFijoController {
	
	private static final Logger log = LoggerFactory.getLogger(PlazoFijoController.class);
	
	@Autowired
	private PlazoFijoService service;
	
	@GetMapping("/findAll")
	Flux<PlazoFijo> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/findById/{id}")
	Mono<PlazoFijo> findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@PostMapping("/create")
	public Mono<ResponseEntity<PlazoFijo>> create(@RequestBody PlazoFijo pfijo) {
		if(pfijo.getCreateAt() == null) {
			pfijo.setCreateAt(new Date());
		}
		
		if(pfijo.getUpdateAt() == null) {
			pfijo.setUpdateAt(new Date());
		}
		
		return service.save(pfijo)
				.map(p -> ResponseEntity.created(URI.create("/plazoFijo/".concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON).body(p));
	}
	
	@DeleteMapping("/deleteById/{id}")
	Mono<PlazoFijo> deleteById(@PathVariable String id) {
		return service.delete(id);
	}
	
	@PutMapping("/update/{id}")
	Mono<PlazoFijo> update(@PathVariable String id, @RequestBody PlazoFijo pfijo) {
		return service.update(pfijo);
	}
	
	@GetMapping("/createById/{id}")
	Mono<PlazoFijo> createById(@PathVariable("id") String id){
		return service.createById(id).flatMap(p -> {
			return service.save(
					new PlazoFijo(p.getName(),"1234567",p.getDni(),"Activo",340.50)
					);
		});
	}


}
