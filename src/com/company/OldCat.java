package com.company;

public class OldCat extends Cat{
    public OldCat(String name, int age, int satietyLevel, int HP, int happinessLevel) {
        super(name, age, satietyLevel, HP, happinessLevel);
        setCatStrategy(new OldCatStrategy());
    }
}
