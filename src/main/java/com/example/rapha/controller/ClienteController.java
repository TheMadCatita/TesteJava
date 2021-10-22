package com.example.rapha.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rapha.model.Cliente;
import com.example.rapha.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/listar")
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();
		
	}
	
	 @GetMapping("/ListarId/{id}")
	  public ResponseEntity<Cliente> getClienteById(@PathVariable("id") long id) {
	    Optional<Cliente> clienteData = clienteRepository.findById(id);

	    if (clienteData.isPresent()) {
	      return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	

	@PostMapping("/adicionar")
	@ResponseStatus (HttpStatus.CREATED)
	public Cliente adicionar (@RequestBody Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	
	 @DeleteMapping("/deleteClienteId/{id}")
	  public ResponseEntity<HttpStatus> deleteClienteId(@PathVariable("id") long id) {
	    try {
	      clienteRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @PutMapping("/updateCliente/{id}")
	  public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
	    Optional<Cliente> clienteData = clienteRepository.findById(id);

	    if (clienteData.isPresent()) {
	      Cliente _name = clienteData.get();
	      _name.setNome(cliente.getNome());
	     
	      return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}
