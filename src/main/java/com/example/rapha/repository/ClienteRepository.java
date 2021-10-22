package com.example.rapha.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.rapha.model.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	

}
