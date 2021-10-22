package com.example.rapha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inscricao {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO ) // o próprio banco que gera e incrementa o id
	private Long id;
	
	@Column
	private Long idUsuario;
	@Column
	private Long idEvento;
	
	// Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "Inscricao [id=" + id + ", idUsuario=" + idUsuario + ", idEvento=" + idEvento + "]";
	}
	
	
	
	
	

}
