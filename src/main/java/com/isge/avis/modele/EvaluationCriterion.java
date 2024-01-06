package com.isge.avis.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class EvaluationCriterion {
    @Id
    @GeneratedValue
    private Long id;

    private String name; // Nom du critère d'évaluation (ex: Qualité de la nourriture, Service client, etc.)

    @OneToMany(targetEntity = Evaluation.class,cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;
}
