package com.ynov.gameoflife;

import com.ynov.gameoflife.cell.*;

public class Launcher {
    public static void main(String[] args) {
        Cell[][] pptMap = new Cell[][]{{new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell(), new DeadCell()}, {new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new AliveCell()}, {new AliveCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell()}, {new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new AliveCell(), new DeadCell(), new DeadCell(), new AliveCell(), new AliveCell(), new DeadCell()}, {new AliveCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new DeadCell(), new AliveCell(), new DeadCell(), new AliveCell(), new DeadCell()}};

        World world = new World(pptMap);
        System.out.println(world);

        for(int i=0; i<6; i++) {
            world.newGeneration();
            System.out.println(world);
        }
    }
}
