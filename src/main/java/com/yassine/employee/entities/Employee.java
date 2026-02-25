package com.yassine.employee.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmp;
	private String nomEmp;
	private LocalDate dateNaiss;
	private Double salaire;

	public Employee() {
		super();
	}

	public Employee(String nomEmp, LocalDate dateNaiss, Double salaire) {
		super();
		this.nomEmp = nomEmp;
		this.dateNaiss = dateNaiss;
		this.salaire = salaire;
	}

	public Long getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(Long idEmp) {
		this.idEmp = idEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public LocalDate getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employee [idEmp=" + idEmp + ", nomEmp=" + nomEmp + ", dateNaiss=" + dateNaiss + ", salaire=" + salaire
				+ "]";
	}

}
