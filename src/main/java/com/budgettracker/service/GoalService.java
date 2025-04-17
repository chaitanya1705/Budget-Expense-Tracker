package com.budgettracker.service;

import com.budgettracker.model.Goal;
import com.budgettracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public void addGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }

    public void updateSavedAmount(Long id, double amount) {
        Goal goal = goalRepository.findById(id).orElse(null);
        if (goal != null) {
            goal.setSavedAmount(goal.getSavedAmount() + amount);
            goalRepository.save(goal);
        }
    }
}