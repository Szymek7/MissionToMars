package control;

import entity.Item;
import entity.Rocket;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File phase1 = new File("src/phase-1.txt");
        File phase2 = new File("src/phase-2.txt");

        Simulation sim = new Simulation();
        ArrayList<Item> itemForPhase1 = sim.loadItems(phase1);
        ArrayList<Item> itemForPhase2 = sim.loadItems(phase2);

        ArrayList<Rocket> u1Rockets = sim.loadU1(itemForPhase1);
        u1Rockets.addAll(sim.loadU1(itemForPhase2));
        ArrayList<Rocket> u2Rockets = sim.loadU2(itemForPhase1);
        u2Rockets.addAll(sim.loadU2(itemForPhase2));

        int budgetU1 = sim.runSimulation(u1Rockets);
        int budgetU2 = sim.runSimulation(u2Rockets);

        System.out.println("Koszt rakiet U1:" + budgetU1);
        System.out.println("Koszt rakiet U2:" + budgetU2);





    }
}
