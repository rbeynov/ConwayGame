package com.ynov.gameoflife.cell;

public class AliveCell implements Cell {
    /*
     * ---------------------------------
     *		Propriétés
     * ---------------------------------
     */
    private boolean newBorn;

	/*
	 * ---------------------------------
	 *		Constructeurs
	 * ---------------------------------
	 */

    /**
     * Constructeur par défault: la cellule vient juste de naitre. <br>
     */
    public AliveCell() {
        newBorn = true;
    }

	/*
	 * ---------------------------------
	 *		Méthodes
	 * ---------------------------------
	 */

    @Override
    public Cell newGeneration(int nbNeighbours) {
        Cell futureCell = this;

        // S'il y a moins de 2 ou plus de 3 cellules vivantes autour de la cellule vivante actuelle,
        // la cellule de prochaine génération sera morte
        if(nbNeighbours < 2 || nbNeighbours > 3) {
            futureCell = new DeadCell();
        }
        // S'il y a entre 2 et 3 cellules vivantes autour de la cellule vivante actuelle,
        // la cellule actuelle continue de vivre à la prochaine génération
        else {
            // A la prochaine génération, la cellule ne sera plus juste-née
            this.newBorn = false;
        }

        return futureCell;
    }

    @Override
    public String getAsString() {
        // Par défault, la representation d'une cellule vivante est "+"
        // Constante ALIVE_CELL_REPRESENTATION déclarée et définie dans
        // l'interface Cell.
        String representation = Cell.ALIVE_CELL_REPRESENTATION;

        // Si la cellule est juste-née, la representation devient "0"
        if(newBorn) {
            representation = Cell.NEWBORN_CELL_REPRESENTATION;
        }

        return representation;
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}