package com.company;

public class AverageCatStrategy implements CatStrategy{
    @Override
    public void changeFields(Cat cat, String action) {
        switch (action){
            case "feed":
                cat.setSatietyLevel(cat.getSatietyLevel()+5);
                cat.setHappinessLevel(cat.getHappinessLevel()+5);
                break;
            case "play":
                cat.setHappinessLevel(cat.getHappinessLevel()+5);
                cat.setHP(cat.getHP()+5);
                cat.setSatietyLevel(cat.getSatietyLevel() - 5);
                break;
            case "heel":
                cat.setSatietyLevel(cat.getSatietyLevel() - 5);
                cat.setHappinessLevel(cat.getHappinessLevel() - 5);
                cat.setHP(cat.getHP()+5);
                break;
        }
        cat.updateAverageLevel();
    }
}
