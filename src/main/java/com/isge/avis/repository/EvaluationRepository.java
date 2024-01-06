package com.isge.avis.repository;

import com.isge.avis.modele.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isge.avis.modele.EvaluationCriterion;
import com.isge.avis.modele.User;
import java.util.List;
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    // Récupère les évaluations liées à un utilisateur spécifique
    List<Evaluation> findByUser(User user);

    // Récupère les évaluations liées à un critère d'évaluation spécifique
    List<Evaluation> findByCriterion(EvaluationCriterion criterion);
}
