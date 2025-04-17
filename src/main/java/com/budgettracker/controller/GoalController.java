package com.budgettracker.controller;

import com.budgettracker.model.Goal;
import com.budgettracker.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoalController {
    @Autowired
    private GoalService goalService;

    @GetMapping("/goals")
    public String getGoals(Model model) {
        model.addAttribute("goals", goalService.getAllGoals());
        model.addAttribute("goal", new Goal());
        return "goal";
    }

    @PostMapping("/addGoal")
    public String addGoal(@ModelAttribute Goal goal) {
        goalService.addGoal(goal);
        return "redirect:/goals";
    }

    @PostMapping("/updateSaved/{id}")
    public String updateSaved(@PathVariable Long id, @RequestParam double amount) {
        goalService.updateSavedAmount(id, amount);
        return "redirect:/goals";
    }

    @GetMapping("/deleteGoal/{id}")
    public String deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
        return "redirect:/goals";
    }
}
