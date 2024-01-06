package com.isge.avis.services;

import com.isge.avis.modele.EvaluationCriterion;
import java.util.List;
import java.util.Optional;

public interface EvaluationCriterionService {
    List<EvaluationCriterion> getAllEvaluationCriteria();
    Optional<EvaluationCriterion> getEvaluationCriterionById(Long id);
    EvaluationCriterion createEvaluationCriterion(EvaluationCriterion criterion);
    boolean updateEvaluationCriterion(Long id, EvaluationCriterion updatedCriterion);
    boolean deleteEvaluationCriterion(Long id);
}
