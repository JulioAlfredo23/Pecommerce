package com.comercio.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private Date  fechaRecibida;
	private Date fechaCreacion;
	private double total;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToOne(mappedBy = "orden")
	private DetalleOrden detalles;
	
	@Override
	public String toString() {
		return "Orden [id=" + id + ", numero=" + numero + ", fechaRecibida=" + fechaRecibida + ", fechaCreacion="
				+ fechaCreacion + ", total=" + total + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
