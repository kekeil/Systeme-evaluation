package com.isge.avis.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Evaluation {
    @Id
    @GeneratedValue
    private Long id;

    private int rating; // Note attribuée (de 0 à 5)
    private LocalDateTime date; // Utilisation de LocalDateTime pour enregistrer la date et l'heure
    private String avis; // Ajout de l'attribut avis de type String
    private String nameUser;

    @ManyToOne
    private User user;

    @ManyToOne
    private EvaluationCriterion criterion;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now(); // Cette méthode sera appelée avant la persistance pour initialiser la date
    }
}
