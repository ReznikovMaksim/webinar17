package com.company;

import java.util.Random;

public class Cat {
    private String name;
    private int age;
    private int satietyLevel;
    private int HP;
    private int happinessLevel;
    private int averageLevel;
    private CatStrategy catStrategy;
    private boolean isActionDone;

    public Cat(String name, int age, int satietyLevel, int HP, int happinessLevel) {
        this.name = name;
        this.age = age;
        this.satietyLevel = satietyLevel;
        this.HP = HP;
        this.happinessLevel = happinessLevel;
        updateAverageLevel();
        isActionDone = false;
    }

    public void randomChangeFields(){
        Random r = new Random();
        satietyLevel -= r.nextInt(5)+1;
        happinessLevel += r.nextInt(7) - 3;
        HP += r.nextInt(7) - 3;
        checkFields();
        updateAverageLevel();
    }

    public void feed(){
        if(isActionDone){
            System.out.println("alredy done action with this cat");
        }else {
            if(new Random().nextInt(3) == 1){
                System.out.println("cat found meatBall under table");
                happinessLevel += 20;
                satietyLevel += 10;
                HP -= 5;
                isActionDone = true;
            }else {
                System.out.println("feeding cat");
                catStrategy.changeFields(this,"feed");
                isActionDone = true;
            }
            checkFields();
        }
    }
    public void playWithCat(){
        if(isActionDone){
            System.out.println("alredy done action with this cat");
        }else {
            System.out.println("playing with cat");
            catStrategy.changeFields(this,"play");
            isActionDone = true;
            checkFields();
        }
    }
    public void heel(){
        if(isActionDone){
            System.out.println("alredy done action with this cat");
        }else {
            System.out.println("heeling cat");
            catStrategy.changeFields(this,"heel");
            isActionDone = true;
            checkFields();
        }
    }
    public void checkFields(){
        if(satietyLevel > 100)
            satietyLevel = 100;
        if (HP > 100)
            HP = 100;
        if(happinessLevel > 100)
            happinessLevel = 100;
        if (satietyLevel < 0)
            satietyLevel = 0;
        if(happinessLevel < 0)
            happinessLevel = 0;
        if (HP < 0)
            HP = 0;
    }
    public void updateAverageLevel(){
        averageLevel = (satietyLevel + HP + happinessLevel) / 3;
    }

    public void printCat(int i){
        String fmt = "%3s | %10s | %10s | %10s | %10s | %10s | %10s |";
        if (isActionDone){
            System.out.println(String.format(fmt,i,"* "+name,age,HP,happinessLevel,satietyLevel,averageLevel));
        }else {
            System.out.println(String.format(fmt,i,name,age,HP,happinessLevel,satietyLevel,averageLevel));
        }
    }

    public String getName() {
        return name;
    }

    public void setActionDone(boolean actionDone) {
        isActionDone = actionDone;
    }

    public void setCatStrategy(CatStrategy catStrategy) {
        this.catStrategy = catStrategy;
    }

    public int getAge() {
        return age;
    }

    public int getSatietyLevel() {
        return satietyLevel;
    }

    public int getHP() {
        return HP;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public int getAverageLevel() {
        return averageLevel;
    }

    public void setSatietyLevel(int satietyLevel) {
        this.satietyLevel = satietyLevel;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }
}
