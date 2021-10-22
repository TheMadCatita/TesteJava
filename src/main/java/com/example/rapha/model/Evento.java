package com.example.rapha.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO ) // o próprio banco que gera e incrementa o id
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private Long vagas;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date datahoraInicio;
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date datahoraFim;

	
	// getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getVagas() {
		return vagas;
	}

	public void setVagas(Long vagas) {
		this.vagas = vagas;
	}
	public Date getDatahoraInicio() {
		return datahoraInicio;
	}

	public void setDatahoraInicio(Date datahoraInicio) {
		this.datahoraInicio = datahoraInicio;
	}

	public Date getDatahoraFim() {
		return datahoraFim;
	}

	public void setDatahoraFim(Date datahoraFim) {
		this.datahoraFim = datahoraFim;
	}

	
	
	// hash and equals

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titulo=" + titulo + ", vagas=" + vagas + ", datahoraInicio=" + datahoraInicio
				+ ", datahoraFim=" + datahoraFim + "]";
	}
	
	

}
