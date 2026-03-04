package com.yassine.employee.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idgrad;
    private String nomGrade;
    private String descriptionGra;
    @JsonIgnore // Pour éviter les boucles infinies lors de l'affichage JSON
    @OneToMany(mappedBy = "grade")//ici on peut enlever mais il ecirt un nouveau table
    private List<Employee> produits;


}
