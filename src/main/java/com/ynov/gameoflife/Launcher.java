package com.ynov.gameoflife;

import com.ynov.gameoflife.cell.*;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("---------- Exemple avec map aléatoire ----------");
        World randomWorld = new World(5, 5);

        // Nouvelles générations
        for(int i = 0; i < 4; i++) {
            System.out.println(randomWorld); // Grâce à la surcharge de toString() de la classe World
            randomWorld.newGeneration();
        }

        System.out.println("---------- Exemple avec map ppt ----------");
        Cell[][] pptMap = new Cell[][]{{new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell(), new DeadCell()}, {new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell()}, {new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell()}, {new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}};

        World world = new World(pptMap);

        for(int i=0; i<6; i++) {
            System.out.println(world);
            world.newGeneration();
        }
    }
}
