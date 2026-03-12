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
    private Long idGrad; // Corrigé : idGrad au lieu de idgrad
    private String nomGrade;
    private String descriptionGrade;

    @JsonIgnore
    @OneToMany(mappedBy = "grade")
    private List<Employee> employees; // Plus clair que "produits"

    @Override
    public String toString() {
        return "Grade{" +
                "idGrad=" + idGrad +
                ", nomGrade='" + nomGrade + '\'' +
                ", descriptionGrade='" + descriptionGrade + '\'' +

                '}';
    }
}