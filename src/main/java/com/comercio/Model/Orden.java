package com.comercio.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orden {
	
	private Long id;
	private String numero;
	private Date  fechaRecibida;
	private Date fechaCreacion;
	private double total;
	
	
	@Override
	public String toString() {
		return "Orden [id=" + id + ", numero=" + numero + ", fechaRecibida=" + fechaRecibida + ", fechaCreacion="
				+ fechaCreacion + ", total=" + total + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
