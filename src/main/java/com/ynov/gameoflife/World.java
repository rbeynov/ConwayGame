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
}
