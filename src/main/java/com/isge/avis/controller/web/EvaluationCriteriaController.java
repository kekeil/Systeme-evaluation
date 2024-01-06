package com.isge.avis.controller.web;

import com.isge.avis.modele.EvaluationCriterion;
import com.isge.avis.services.EvaluationCriterionService;
import com.isge.avis.services.EvaluationCriterionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EvaluationCriteriaController {

    private final EvaluationCriterionService evaluationCriterionService;

    @Autowired
    public EvaluationCriteriaController(EvaluationCriterionService evaluationCriterionService) {
        this.evaluationCriterionService = evaluationCriterionService;
    }

    @GetMapping("/evaluationCriteria")
    public String showEvaluationCriteria(Model model) {
        List<EvaluationCriterion> criteria = evaluationCriterionService.getAllEvaluationCriteria();
        model.addAttribute("criteria", criteria);
        return "evaluationCriteria"; // Correspond au nom de votre fichier HTML (sans l'extension)
    }

    @PostMapping("/createCriterion")
    public String createCriterion(@RequestParam("criterionName") String criterionName) {
        // Création d'une nouvelle instance d'EvaluationCriterion
        EvaluationCriterion newCriterion = new EvaluationCriterion();
        newCriterion.setName(criterionName); // Définition du nom du critère
        // Appel du service pour créer le critère
        evaluationCriterionService.createEvaluationCriterion(newCriterion);

        return "redirect:/evaluationCriteria"; // Redirection vers la page de liste des critères après la création
    }
}
