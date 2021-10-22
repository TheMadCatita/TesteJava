package com.example.rapha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rapha.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
