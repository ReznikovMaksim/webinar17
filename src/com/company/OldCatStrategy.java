package com.company;

public class OldCatStrategy implements CatStrategy{
    @Override
    public void changeFields(Cat cat, String action) {
        switch (action){
            case "feed":
                cat.setSatietyLevel(cat.getSatietyLevel()+4);
                cat.setHappinessLevel(cat.getHappinessLevel()+4);
                break;
            case "play":
                cat.setHappinessLevel(cat.getHappinessLevel()+4);
                cat.setHP(cat.getHP()+4);
                cat.setSatietyLevel(cat.getSatietyLevel() - 6);
                break;
            case "heel":
                cat.setSatietyLevel(cat.getSatietyLevel() - 6);
                cat.setHappinessLevel(cat.getHappinessLevel() - 6);
                cat.setHP(cat.getHP()+4);
                break;
        }
        cat.updateAverageLevel();
    }
}
