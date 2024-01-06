package com.isge.avis.controller.web;

import com.isge.avis.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AverageByCriterionController {

    private final EvaluationService evaluationService;

    @Autowired
    public AverageByCriterionController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/averageByCriterion")
    public String showAveragesByCriterion(Model model) {
        model.addAttribute("averages", evaluationService.calculateAverageRatingsPerCriterion());
        return "averageByCriterion"; // Correspond au nom de votre fichier HTML (sans l'extension)
    }
}
