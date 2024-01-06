package com.isge.avis.repository;

import com.isge.avis.modele.EvaluationCriterion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EvaluationCriterionRepository extends JpaRepository<EvaluationCriterion, Long> {
    // Récupère tous les critères d'évaluation enregistrés
    List<EvaluationCriterion> findAll();
}
