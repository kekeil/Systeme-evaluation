package com.isge.avis.controller.web;

import com.isge.avis.modele.Evaluation;
import com.isge.avis.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EvaluationHistoryController {

    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationHistoryController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/evaluationHistory")
    public String showEvaluationHistory(Model model) {
        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
        model.addAttribute("evaluations", evaluations);
        return "evaluationHistory";
    }
}
