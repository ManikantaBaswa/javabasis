package com.reactivespring.demo.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FluxAndMonoController {
@GetMapping("/flux")
public Flux<Integer> returnFlux(){
	
	return Flux.just(1,2,3,4,5).delayElements(Duration.ofSeconds(1))
			   .log();
}


@GetMapping(value = "/fluxstream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<String> returnFluxStream(){
	
	return Flux.just("Mani","Baswa","info").delayElements(Duration.ofSeconds(1))
			   .log();
}
@GetMapping("/mono")
public Mono<Integer> returnMono() {
    return Mono.just(1).log();
}

}
