package com.isge.avis.controller.rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.isge.avis.modele.EvaluationCriterion;
import com.isge.avis.repository.EvaluationCriterionRepository;

@RestController
@RequestMapping("/api/evaluation-criteria")
public class EvaluationCriterionController {

    private final EvaluationCriterionRepository evaluationCriterionRepository;

    public EvaluationCriterionController(EvaluationCriterionRepository evaluationCriterionRepository) {
        this.evaluationCriterionRepository = evaluationCriterionRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<EvaluationCriterion>> getAllEvaluationCriteria() {
        Iterable<EvaluationCriterion> criteria = evaluationCriterionRepository.findAll();
        return new ResponseEntity<>(criteria, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EvaluationCriterion> createEvaluationCriterion(@RequestBody EvaluationCriterion evaluationCriterion) {
        EvaluationCriterion savedCriterion = evaluationCriterionRepository.save(evaluationCriterion);
        return new ResponseEntity<>(savedCriterion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluationCriterion> updateEvaluationCriterion(@PathVariable Long id, @RequestBody EvaluationCriterion updatedCriterion) {
        if (evaluationCriterionRepository.existsById(id)) {
            updatedCriterion.setId(id);
            EvaluationCriterion savedCriterion = evaluationCriterionRepository.save(updatedCriterion);
            return new ResponseEntity<>(savedCriterion, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluationCriterion(@PathVariable Long id) {
        if (evaluationCriterionRepository.existsById(id)) {
            evaluationCriterionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
