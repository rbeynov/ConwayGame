package com.ynov.gameoflife;

import com.ynov.gameoflife.cell.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        // Lecture nombre de colonnes
        System.out.println("Please enter the number of columns of the world: ");
        int nbCol = askUserForAnInteger();


        // Lecture nombre de lignes
        System.out.println("\nPlease enter the number of rows of the world: ");
        int nbRow = askUserForAnInteger();


        System.out.println("---------- Exemple avec map aléatoire ----------");
        World randomWorld = new World(nbCol, nbRow);

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

    /**
     * Lis un entier sur l'entree standard.
     * @return
     * 			Entier saisi par l'utilisateur.
     */
    private static int askUserForAnInteger() {
        // Création d'un scanner pour lire les entrées sur l'entrée standard (console)
        Scanner sc = new Scanner(System.in);
        int readInt = sc.nextInt();

        return readInt;
    }
}
