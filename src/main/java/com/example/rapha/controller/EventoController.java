package com.example.rapha.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.rapha.model.Evento;
import com.example.rapha.repository.EventoRepository;

@RestController
@RequestMapping ("/eventos")
public class EventoController {
	
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@GetMapping ("/listar")
	public List <Evento> lista(){ // listar evento
		
		return eventoRepository.findAll();
		
	}
	
	@PostMapping ("/adicionar")
	@ResponseStatus (HttpStatus.CREATED)
	public Evento adicionar (@RequestBody Evento evento) {
		
		return eventoRepository.save(evento);
		
	}
	
	 @GetMapping("/listarId/{id}")
	  public ResponseEntity<Evento> getEventoById(@PathVariable("id") long id) {
	    Optional<Evento> eventoData = eventoRepository.findById(id);

	    if (eventoData.isPresent()) {
	      return new ResponseEntity<>(eventoData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	 @DeleteMapping("/deleteEventoId/{id}")
	  public ResponseEntity<HttpStatus> deleteEventoId(@PathVariable("id") long id) {
	    try {
	      eventoRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @PutMapping("/updateEvento/{id}")
	  public ResponseEntity<Evento> updateEvento(@PathVariable("id") long id, @RequestBody Evento evento) {
	    Optional<Evento> eventoData = eventoRepository.findById(id);

	    if (eventoData.isPresent()) {
	      Evento _titulo = eventoData.get();
	      _titulo.setTitulo(evento.getTitulo());
	      
	      Evento _vagas = eventoData.get();
	      _vagas.setVagas(evento.getVagas());
	      
	      Evento _dataHoraInicio = eventoData.get();
	      _dataHoraInicio.setDatahoraInicio(evento.getDatahoraFim());
	      
	      Evento _dataHoraFim = eventoData.get();
	      _dataHoraFim.setDatahoraFim(evento.getDatahoraFim());
	      
	     
	      return new ResponseEntity<>(eventoRepository.save(evento), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	

}
