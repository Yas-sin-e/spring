package com.yassine.employee.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmp;

	@NotNull
	@Size(min = 3, max = 20)
	private String nomEmp;
	@NotNull
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaiss;
	@NotNull
	@Min(value = 500)
	@Max(value = 20000)
	private Double salaire;

	@ManyToOne
	private Grade grade;

	public Employee(String nomEmp, LocalDate dateNaiss, Double salaire) {
		this.nomEmp = nomEmp;
		this.dateNaiss = dateNaiss;
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"idEmp=" + idEmp +
				", nomEmp='" + nomEmp + '\'' +
				", dateNaiss=" + dateNaiss +
				", salaire=" + salaire +

				'}';
	}
}