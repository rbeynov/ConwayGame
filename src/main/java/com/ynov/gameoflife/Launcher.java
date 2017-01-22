package com.ynov.gameoflife;

import com.ynov.gameoflife.cell.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        int nbCol = 0, nbRow = 0;

        // Lecture nombre de colonnes
        while(nbCol < World.NB_MIN_COL || nbCol > World.NB_MAX_COL) {

            System.out.println("Please enter the number of columns " +
                    "(between "+World.NB_MIN_COL+" and "+World.NB_MAX_COL+").");

            nbCol = askUserForAnInteger();
        }

        // Lecture nombre de lignes
        while(nbRow < World.NB_MIN_ROW || nbRow > World.NB_MAX_ROW) {

            System.out.println("\nPlease enter the number of rows " +
                    "(between "+World.NB_MIN_ROW+" and "+World.NB_MAX_ROW+").");

            nbRow = askUserForAnInteger();
        }

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
        int readInt = 0;

        try {
            // Création d'un scanner pour lire les entrées sur l'entrée standard (console)
            Scanner sc = new Scanner(System.in);
            readInt = sc.nextInt();

        } catch(InputMismatchException ime) {
            System.err.println("L'entrée n'est pas entier.\n");
        }

        return readInt;
    }
}
