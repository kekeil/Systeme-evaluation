package com.isge.avis.services;
import org.springframework.stereotype.Service;
import com.isge.avis.modele.Evaluation;
import com.isge.avis.repository.EvaluationRepository;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public Optional<Evaluation> getEvaluationById(Long id) {
        return evaluationRepository.findById(id);
    }

    @Override
    public Evaluation createEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public boolean updateEvaluation(Long id, Evaluation updatedEvaluation) {
        if (evaluationRepository.existsById(id)) {
            updatedEvaluation.setId(id);
            evaluationRepository.save(updatedEvaluation);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEvaluation(Long id) {
        if (evaluationRepository.existsById(id)) {
            evaluationRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Map<String, Double> calculateAverageRatingsPerCriterion() {
        List<Evaluation> evaluations = evaluationRepository.findAll(); // Récupère toutes les évaluations

        // Utilisation de Streams pour regrouper les évaluations par critère et calculer la moyenne des notes pour chaque critère
        return evaluations.stream()
                .collect(Collectors.groupingBy(
                        evaluation -> evaluation.getCriterion().getName(), // Groupement par nom du critère
                        Collectors.averagingInt(Evaluation::getRating) // Calcul de la moyenne des notes pour chaque groupe
                ));
    }
}
