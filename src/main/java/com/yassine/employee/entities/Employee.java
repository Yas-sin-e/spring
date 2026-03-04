package com.yassine.employee.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmp;
	private String nomEmp;
	private LocalDate dateNaiss;
	private Double salaire;
	@ManyToOne
	private Grade grade;
	public Employee(String nomEmp, LocalDate dateNaiss, Double salaire) {
		this.nomEmp = nomEmp;
		this.dateNaiss = dateNaiss;
		this.salaire = salaire;
	}

}
