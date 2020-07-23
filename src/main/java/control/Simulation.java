package control;
import entity.Item;
import entity.Rocket;
import entity.U1;
import entity.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


    public ArrayList loadItems(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        ArrayList items = new ArrayList();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner sc = new Scanner(line);
            Item item = new Item();
            sc.useDelimiter("=");
            String name = sc.next();
            item.setName(name);
            int weight = sc.nextInt();
            item.setWeight(weight);
            items.add(item);
        }
        return items;
    }


    public ArrayList loadU1 (ArrayList<Item> ar){
        ArrayList u1Rockets = new ArrayList();
        U1 u1Rocket = new U1();

        for (int i = 0; i < ar.size(); i++)
        {
            if (u1Rocket.canCarry(ar.get(i))){
                System.out.println("Można dodać przedmiot " + ar.get(i).getName() + " o wadze: "
                        + ar.get(i).getWeight() + " do rakiety");                u1Rocket.carry(ar.get(i));
            }
            else
            {
                System.out.println("Obecna rakieta jest przeładowana. Przedmiot " + ar.get(i).getName() + " o wadze: " +
                                             + ar.get(i).getWeight() + "  dodany do nowej rakiety");
                u1Rockets.add(u1Rocket);
                u1Rocket = new U1();
                u1Rocket.carry(ar.get(i));
            }
        }
        u1Rockets.add(u1Rocket);
        return u1Rockets;
    }


    public ArrayList loadU2 (ArrayList<Item> ar){
        ArrayList u2Rockets = new ArrayList();
        U2 u2Rocket = new U2();
        for (int i = 0; i < ar.size(); i++)
        {
            if (u2Rocket.canCarry(ar.get(i))){
                System.out.println("Można dodać przedmiot " + ar.get(i).getName() + " o wadze: "
                        + ar.get(i).getWeight() + " do rakiety");
                u2Rocket.carry(ar.get(i));
            }
            else
            {
                System.out.println("Obecna rakieta jest przeładowana. Przedmiot " + ar.get(i).getName() + " o wadze: " +
                        + ar.get(i).getWeight() + "  dodany do nowej rakiety");
                u2Rockets.add(u2Rocket);
                u2Rocket = new U2();
                System.out.println(u2Rocket.toString());
                u2Rocket.carry(ar.get(i));
            }

        }
        u2Rockets.add(u2Rocket);
        return u2Rockets;
    }

    public int runSimulation(ArrayList<Rocket> ar){
        int totalBudget = 0;
        int rocketCount = 0;
        System.out.println("Rozpoczynamy misję...");
        for (int i = 0 ; i < ar.size(); i++)
        {
            rocketCount++;
            Rocket rocket = ar.get(i);
            System.out.println("Rakieta " + rocket + " przygotowana do wystrzelenia..");

            if (rocket.launch())
            {
                System.out.println("Rakieta wystrzelona! Czekamy na lądowanie...");
                System.out.println("....");
                if(rocket.land())
                {
                    System.out.println("Rakieta wylądowała!");
                    totalBudget = totalBudget +  rocket.getRocketCosts();
                }
               else {
                    System.out.println("Rakieta się rozbiła..");
                    totalBudget = totalBudget +  rocket.getRocketCosts();
                    i--;
            }
            }
            else
            {
                System.out.println("Rakieta uległa eksplozji..");
                totalBudget = totalBudget +  rocket.getRocketCosts();
                i--;
            }

            System.out.println();


        }
        System.out.println("Wystrzelono łącznie " + rocketCount +" rakiet. Koszt łączny rakiet typu " +
                ar.get(0).getClass().getSimpleName() + " wyniósł: " + totalBudget);
        return totalBudget;
    }

}
