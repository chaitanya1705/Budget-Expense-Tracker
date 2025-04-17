package com.budgettracker.model;

import jakarta.persistence.*;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;
    private double targetAmount;
    private double savedAmount;

    public Goal() {}

    public Goal(String goalName, double targetAmount) {
        this.goalName = goalName;
        this.targetAmount = targetAmount;
        this.savedAmount = 0.0;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getGoalName() { return goalName; }
    public void setGoalName(String goalName) { this.goalName = goalName; }
    public double getTargetAmount() { return targetAmount; }
    public void setTargetAmount(double targetAmount) { this.targetAmount = targetAmount; }
    public double getSavedAmount() { return savedAmount; }
    public void setSavedAmount(double savedAmount) { this.savedAmount = savedAmount; }
}