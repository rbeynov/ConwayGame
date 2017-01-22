package com.ynov.gameoflife;

import com.ynov.gameoflife.cell.AliveCell;
import com.ynov.gameoflife.cell.Cell;
import com.ynov.gameoflife.cell.DeadCell;

import java.util.Random;

public class World {
    /*
	 * ---------------------------------
	 *		Constantes
	 * ---------------------------------
	 */
    /** Nombre minimum de colonnes pour le monde. */
    public static final int NB_MIN_COL = 3;
    /** Nombre minimum de lignes pour le monde. */
    public static final int NB_MIN_ROW = 3;
    /** Nombre maximum de colonnes pour le monde. */
    public static final int NB_MAX_COL = 10;
    /** Nombre maximum de lignes pour le monde. */
    public static final int NB_MAX_ROW = 10;

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
        initMap(world, false);
    }

    /**
     * Initialise un monde aléatoire avec une dimension spécifique. <br>
     *
     * @param nbColumn
     * 			Nombre de colonnes dans le monde.
     * @param nbRow
     * 			Nombre de lignes dans le monde.
     */
    public World(int nbColumn, int nbRow) {
        checkDimensions(nbColumn, nbRow);
        // Création d'une nouvelle map
        Cell[][] world = new Cell[nbRow][nbColumn];
        initMap(world, true);
    }

    /*
	 * ---------------------------------
	 *		Méthodes
	 * ---------------------------------
	 */
    /**
     * Initialise la map passée en paramètre en la remplissant avec des données aléatoires si elle est vide.<br>
     *
     * @param map
     * 			Map à initialiser.
     * @param randomValues
     * 			TRUE si la map doit être remplie avec des valeurs aléatoires, FALSE sinon.
     */
    private void initMap(Cell[][] map, boolean randomValues) {
        if(randomValues) {
            this.map = fillMapWithRandomCells(map);
        } else {
            this.map = map;
        }

        this.generation = 1;
    }

    /**
     * @param nbColumn
     * 			Nombre de colonnes dans le monde.
     * @param nbRow
     * 			Nombre de lignes dans le monde.
     */
    private void checkDimensions(int nbColumn, int nbRow) {
        boolean isTooTight = (nbRow < NB_MIN_ROW || nbColumn < NB_MIN_COL);
        boolean isTooStretch = (nbRow > NB_MAX_ROW || nbColumn > NB_MAX_COL);

        // Dimensions erronées
        if(isTooTight || isTooStretch) {
            String message = "La taille de la carte doit être comprise entre "+NB_MIN_ROW+"x"+NB_MIN_COL+" et "+NB_MAX_ROW+"x"+NB_MAX_COL+".";
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Remplie une carte avec des cellules aléatoires. <br>
     *
     * @param map
     * 			Map à remplir.
     * @return Map remplie de cellules aléatoires.
     */
    private Cell[][] fillMapWithRandomCells(Cell[][] map) {
        // Chaque ligne
        for(int row = 0; row < map.length; row++) {
            // Chaque colonne de la ligne
            Cell[] columns = map[row];
            for(int column = 0; column < columns.length; column++) {
                // Valorise la case avec une cellule aléatoire
                Random random = new Random();
                if(random.nextBoolean()) {
                    map[row][column] = new DeadCell();
                } else {
                    map[row][column] = new AliveCell();
                }
            }
        }

        return map;
    }

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
