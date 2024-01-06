package com.isge.avis.controller.web;

import com.isge.avis.modele.Evaluation;
import com.isge.avis.modele.EvaluationCriterion;
import com.isge.avis.modele.User;
import com.isge.avis.services.EvaluationService;
import com.isge.avis.services.EvaluationCriterionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EvaluationSubmissionController {

    private final EvaluationService evaluationService;
    private final EvaluationCriterionService evaluationCriterionService;

    @Autowired
    public EvaluationSubmissionController(EvaluationService evaluationService, EvaluationCriterionService evaluationCriterionService) {
        this.evaluationService = evaluationService;
        this.evaluationCriterionService = evaluationCriterionService;
    }

    @GetMapping("/submitEvaluation")
    public String showEvaluationForm(Model model) {
        model.addAttribute("evaluation", new Evaluation());

        // Ajouter la liste des critères disponibles au modèle
        List<EvaluationCriterion> criteria = evaluationCriterionService.getAllEvaluationCriteria();
        model.addAttribute("criteria", criteria);

        return "submitEvaluation"; // Correspond au nom de votre fichier HTML (sans l'extension)
    }

    // Autres méthodes du contrôleur pour la soumission et l'affichage des évaluations...

    @PostMapping("/submitEvaluation")
    public String submitEvaluation(@ModelAttribute Evaluation evaluation, @RequestParam("criterionId") Long criterionId, @RequestParam("avis") String avis,  @RequestParam("nom") String nom) {

        // Récupérer le critère sélectionné en fonction de l'ID
        Optional<EvaluationCriterion> optionalSelectedCriterion = evaluationCriterionService.getEvaluationCriterionById(criterionId);

        if (optionalSelectedCriterion.isPresent()) {
            EvaluationCriterion selectedCriterion = optionalSelectedCriterion.get();

            // Associer le critère sélectionné à l'évaluation
            evaluation.setCriterion(selectedCriterion);

            // Associer l'avis à l'évaluation
            evaluation.setAvis(avis);

            // Associer le nom de l'utilisateur à l'évaluation
            evaluation.setNameUser(nom); // <-- Assigner le nom récupéré du formulaire à l'attribut nameUser


            // Enregistrement de l'évaluation en utilisant le service EvaluationService
            evaluationService.createEvaluation(evaluation);

            // Redirection vers une page de confirmation ou toute autre page souhaitée
            return "redirect:/submitEvaluation"; // Remplacez par le chemin de la page de confirmation
        } else {
            // Gérer le cas où le critère n'a pas été trouvé (par exemple, rediriger vers une page d'erreur)
            return "redirect:/erreurCritereNonTrouve"; // Remplacez par le chemin de la page d'erreur appropriée
        }
    }


}
