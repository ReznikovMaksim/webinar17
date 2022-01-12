package com.company;

public class YoungCat extends Cat{
    public YoungCat(String name, int age, int satietyLevel, int HP, int happinessLevel) {
        super(name, age, satietyLevel, HP, happinessLevel);
        setCatStrategy(new YoungCatStrategy());
    }
}
