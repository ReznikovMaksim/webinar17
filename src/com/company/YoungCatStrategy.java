package com.company;

public class YoungCatStrategy implements CatStrategy{
    @Override
    public void changeFields(Cat cat, String action) {
        switch (action){
            case "feed":
                cat.setSatietyLevel(cat.getSatietyLevel()+7);
                cat.setHappinessLevel(cat.getHappinessLevel()+7);
                break;
            case "play":
                cat.setHappinessLevel(cat.getHappinessLevel()+7);
                cat.setHP(cat.getHP()+7);
                cat.setSatietyLevel(cat.getSatietyLevel() - 3);
                break;
            case "heel":
                cat.setSatietyLevel(cat.getSatietyLevel() - 3);
                cat.setHappinessLevel(cat.getHappinessLevel() - 3);
                cat.setHP(cat.getHP()+7);
                break;
        }
        cat.updateAverageLevel();
    }
}
