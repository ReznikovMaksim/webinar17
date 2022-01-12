package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Cat> cats = List.of(
                new YoungCat("Murzik",1,30,40,45),
                new AverageCat("Vasya",8,15,20,30),
                new OldCat("Misha",14,70,1,60)
        );
        while (true){
            cats = chooseSort(cats);
            printTable(cats);
            chooseAction(cats);
        }
    }
    public static List<Cat> chooseSort(List<Cat> cats){
        try {
            Scanner sc = new Scanner(System.in);
            List<Cat> sortedCats = new ArrayList<>();
            System.out.println("choose sorting");
            int answer = sc.nextInt();
            switch (answer){
                case 1:
                    sortedCats = cats.stream()
                            .sorted(Comparator.comparingInt(Cat::getAverageLevel).reversed())
                            .collect(Collectors.toList());
                    break;
                case 2:
                    sortedCats = cats.stream()
                            .sorted(Comparator.comparing(Cat::getAge).reversed())
                            .collect(Collectors.toList());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    throw new Exception();
            }
            return sortedCats;
        }catch (Exception ex){
            System.out.println("error");
            return chooseSort(cats);
        }
    }
    public static void chooseAction(List<Cat> cats){
        String[] strs = {" feed"," play"," heel"," get new cat"," next day"};
        System.out.println("choose action");
        for (int i = 1; i <= strs.length; i++){
            System.out.println(i + strs[i-1]);
        }
        try {
            Scanner sc = new Scanner(System.in);
            int answer = sc.nextInt();
            int position = 0;
            switch (answer){
                case 1:
                    position = getCatPosition(cats);
                    cats.get(position).feed();
                    break;
                case 2:
                    position = getCatPosition(cats);
                    cats.get(position).playWithCat();
                    break;
                case 3:
                    position = getCatPosition(cats);
                    cats.get(position).heel();
                    break;
                case 4:
                    getNewCat(cats);
                    break;
                case 5:
                    cats.forEach(c -> {c.randomChangeFields(); c.setActionDone(false);});
                    break;
                default:
                    throw new Exception();
            }
            for(int i = 0; i < cats.size(); i++){
                if(cats.get(i).getHP() <= 0){
                    System.out.println("cat is dead");
                    Cat cat = cats.get(i);
                    cats.remove(cat);
                }
            }
        }catch (Exception ex){
            System.out.println("error");
            chooseAction(cats);
        }
    }
    public static int getCatPosition(List<Cat> cats){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter cat position");
            int answer = sc.nextInt();
            if(answer < 1 || answer > cats.size())
                throw new Exception();
            return answer-1;
        }catch (Exception ex){
            System.out.println("error");
            return getCatPosition(cats);
        }
    }
    public static void printTable(List<Cat> cats){
        String fmt = "%3s | %10s | %10s | %10s | %10s | %10s | %10s |";
        System.out.println(String.format(fmt,"#","name","age","HP","happiness","satiety","average"));
        AtomicInteger i = new AtomicInteger(1);
        cats.forEach(c -> {c.printCat(i.get());
            i.getAndIncrement();
        });
    }
    public static void getNewCat(List<Cat> cats){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("enter name");
            String name = sc.next();
            System.out.println("enter age");
            int age = sc.nextInt();
            if(age < 1 || age > 18)
                throw new Exception();
            Random r = new Random();
            int satiety = r.nextInt(61) + 20;
            int HP = r.nextInt(61) + 20;
            int happiness = r.nextInt(61) + 20;
            if(age <= 5){
                cats.add(new YoungCat(name,age,satiety,HP,happiness));
            }else if(age <= 10){
                cats.add(new AverageCat(name,age,satiety,HP,happiness));
            }else {
                cats.add(new OldCat(name,age,satiety,HP,happiness));
            }

        }catch (Exception ex){
            System.out.println("error");
            getNewCat(cats);
        }
    }
}
