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

import com.example.rapha.model.Inscricao;
import com.example.rapha.repository.InscricaoRepository;


@RestController
@RequestMapping ("/inscricao")
public class InscricaoController {
	

	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	@GetMapping("/listar")
	public List<Inscricao> listar() {
		
		return inscricaoRepository.findAll();
		
	}
	
	 @GetMapping("/ListarId/{id}")
	  public ResponseEntity<Inscricao> getClienteById(@PathVariable("id") long id) {
	    Optional<Inscricao> clienteData = inscricaoRepository.findById(id);

	    if (clienteData.isPresent()) {
	      return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	

	@PostMapping("/adicionar")
	@ResponseStatus (HttpStatus.CREATED)
	public Inscricao adicionar (@RequestBody Inscricao inscricao) {
		
		return inscricaoRepository.save(inscricao);
		
	}
	
	 @DeleteMapping("/deleteInscricaoId/{id}")
	  public ResponseEntity<HttpStatus> deleteClienteId(@PathVariable("id") long id) {
	    try {
	      inscricaoRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @PutMapping("/updateInscricao/{id}")
	  public ResponseEntity<Inscricao> updateCliente(@PathVariable("id") long id, @RequestBody Inscricao inscricao) {
	    Optional<Inscricao> clienteData = inscricaoRepository.findById(id);

	    if (clienteData.isPresent()) {
	      Inscricao _id = clienteData.get();
	      _id.setId(inscricao.getId());
	     
	      return new ResponseEntity<>(inscricaoRepository.save(inscricao), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }


}
