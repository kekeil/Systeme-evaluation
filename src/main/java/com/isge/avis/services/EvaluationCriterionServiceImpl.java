package com.isge.avis.services;
import com.isge.avis.modele.Evaluation;
import org.springframework.stereotype.Service;
import com.isge.avis.modele.EvaluationCriterion;
import com.isge.avis.repository.EvaluationCriterionRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationCriterionServiceImpl implements EvaluationCriterionService {

    private final EvaluationCriterionRepository evaluationCriterionRepository;

    public EvaluationCriterionServiceImpl(EvaluationCriterionRepository evaluationCriterionRepository) {
        this.evaluationCriterionRepository = evaluationCriterionRepository;
    }

    @Override
    public List<EvaluationCriterion> getAllEvaluationCriteria() {
        return evaluationCriterionRepository.findAll();
    }

    @Override
    public Optional<EvaluationCriterion> getEvaluationCriterionById(Long id) {
        return evaluationCriterionRepository.findById(id);
    }

    @Override
    public EvaluationCriterion createEvaluationCriterion(EvaluationCriterion criterion) {
        return evaluationCriterionRepository.save(criterion);
    }

    @Override
    public boolean updateEvaluationCriterion(Long id, EvaluationCriterion updatedCriterion) {
        if (evaluationCriterionRepository.existsById(id)) {
            updatedCriterion.setId(id);
            evaluationCriterionRepository.save(updatedCriterion);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEvaluationCriterion(Long id) {
        if (evaluationCriterionRepository.existsById(id)) {
            evaluationCriterionRepository.deleteById(id);
            return true;
        }
        return false;
    }
    // Nouvelle méthode pour récupérer toutes les évaluations associées à un critère
    public List<Evaluation> getAllEvaluationsForCriterion(Long criterionId) {
        Optional<EvaluationCriterion> criterionOptional = evaluationCriterionRepository.findById(criterionId);
        if (criterionOptional.isPresent()) {
            EvaluationCriterion criterion = criterionOptional.get();
            return criterion.getEvaluations();
        }
        return Collections.emptyList();
    }
}
