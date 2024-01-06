package com.isge.avis.controller.rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.isge.avis.modele.Evaluation;
import com.isge.avis.repository.EvaluationRepository;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final EvaluationRepository evaluationRepository;

    public EvaluationController(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Evaluation>> getAllEvaluations() {
        Iterable<Evaluation> evaluations = evaluationRepository.findAll();
        return new ResponseEntity<>(evaluations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation savedEvaluation = evaluationRepository.save(evaluation);
        return new ResponseEntity<>(savedEvaluation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable Long id, @RequestBody Evaluation updatedEvaluation) {
        if (evaluationRepository.existsById(id)) {
            updatedEvaluation.setId(id);
            Evaluation savedEvaluation = evaluationRepository.save(updatedEvaluation);
            return new ResponseEntity<>(savedEvaluation, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        if (evaluationRepository.existsById(id)) {
            evaluationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
