package com.company;

public class AverageCat extends Cat{
    public AverageCat(String name, int age, int satietyLevel, int HP, int happinessLevel) {
        super(name, age, satietyLevel, HP, happinessLevel);
        setCatStrategy(new AverageCatStrategy());
    }
}
