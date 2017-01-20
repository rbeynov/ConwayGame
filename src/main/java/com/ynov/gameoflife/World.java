package com.ynov.gameoflife;

import com.ynov.gameoflife.cell.Cell;

public class World {
    /*
	 * ---------------------------------
	 *		Propriétés
	 * ---------------------------------
	 */
    /** Tableau de cellule à deux dimensions representant le monde. */
    private Cell[][] map;
    /** Numéro de la génération actuelle. */
    private int generation;

    /*
	 * ---------------------------------
	 *		Constructeurs
	 * ---------------------------------
	 */
    /**
     * Instancie un monde dans un état spécifique avec le tableau de cellule à deux dimensions spécifiée. <br>
     *
     * @param world
     * 			Tableau de cellule à deux dimensions representant le monde.
     */
    public World(Cell[][] world) {
        this.map = world;
    }

    /*
	 * ---------------------------------
	 *		Méthodes
	 * ---------------------------------
	 */
    /**
     * Passe le monde dans un nouvel état (nouvelle génération). <br>
     */
    public void newGeneration() {
        // Monde de la prochaine génération
        Cell[][] nextGenerationWorld = new Cell[map.length][map[0].length];

        // On parcours chaque cellule pour connaitre le nombre de voisins vivants et ainsi
        // ce que la cellule deviendra à la prochaine génération
        for(int row = 0; row < map.length; row++) {
            // Chaque colonne de la ligne
            final Cell[] columns = map[row];
            for(int column = 0; column < columns.length; column++) {
                Cell currentCell = map[row][column];
                int aliveCellsAround = countAliveCellsAround(row, column);
                Cell futureCell = currentCell.newGeneration(aliveCellsAround);

                // On remplace dans le monde de prochaine génération la cellule actuelle par celle de la génération prochaine
                nextGenerationWorld[row][column] = futureCell;
            }
        }

        // Le numéro de la génération augmente et la map du monde est remplacée par celle de prochaine génération
        this.generation++;
        this.map = nextGenerationWorld;
    }

    /**
     * Affiche la génération en cours et l'état actuel du monde. <br>
     */
    @Override
    public String toString() {
        String worldRepresentation = "";
        worldRepresentation += "Generation "+generation+": \n";

        // Affichage de chaque ligne
        for(Cell[] rows : map) {
            // Affiche de chaque cellule de la ligne
            for(Cell cell : rows) {
                worldRepresentation += cell.getAsString()+" ";
            }
            worldRepresentation += "\n";
        }

        return worldRepresentation;
    }

    /**
     * Compte le nombre de cellules vivantes autour de la case spécifiée.
     *
     * @param row
     * 			Numéro de la ligne de la case.
     * @param column
     * 			Numéro de la colonne de la case.
     * @return Nombre de cellules vivantes autant de la case spécifiée.
     */
    private int countAliveCellsAround(int row, int column) {
        int livingCellsCount = 0;

        // Opérateur ternaire: équivaut à un if/else
        // Syntax: (Condition ? si vrai : sinon)
        int maxRow =  map.length-1;
        int startRow = (row - 1 < 0) ? row : row-1;
        int endRow =   (row + 1 > maxRow) ? row : row+1;

        int maxCol = map[row].length-1;
        int startCol = (column - 1 < 0) ? column : column-1;
        int endCol =   (column + 1 > maxCol) ? column : column+1;

        for (int rowNum=startRow; rowNum<=endRow; rowNum++) {
            for (int colNum = startCol; colNum <= endCol; colNum++) {
                // S'l s'agit de la cellule courante, on ne la compte pas parmi les voisins
                if (rowNum == row && colNum == column) {
                    continue; // Passe au tour de boucle suivant
                }

                // On parcours la liste des cases adjacentes pour vérifier l'état des cellules
                Cell aNeighbourCell = map[rowNum][colNum];

                if (aNeighbourCell != null && aNeighbourCell.isAlive()) {
                    livingCellsCount++;
                }
            }
        }

        return livingCellsCount;
    }
}
