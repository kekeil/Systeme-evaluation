package com.isge.avis.services;
import com.isge.avis.modele.Evaluation;
import java.util.List;
import java.util.Optional;
import java.util.Map;
public interface EvaluationService {
    List<Evaluation> getAllEvaluations();
    Optional<Evaluation> getEvaluationById(Long id);
    Evaluation createEvaluation(Evaluation evaluation);
    boolean updateEvaluation(Long id, Evaluation updatedEvaluation);
    boolean deleteEvaluation(Long id);
    Map<String, Double> calculateAverageRatingsPerCriterion();
}

