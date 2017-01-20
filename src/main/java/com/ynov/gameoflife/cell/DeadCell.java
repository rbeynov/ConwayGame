package com.ynov.gameoflife.cell;

public class DeadCell implements Cell {

	/*
	 * ---------------------------------
	 *		Constructeurs
	 * ---------------------------------
	 */

    /**
     * Constructeur par défault. <br>
     */
    public DeadCell() {
		/*
		 *  Note: il est facultatif de déclarer un constructeur par défault (sans argument) si celui-ci
		 *  ne défini aucun comportement spécifique.
		 *  En effet, si la classe n'implémente dans le code AUCUN constructeur, un constructeur par défault
		 *  sera ajouté par le compilateur.
		 */
    }

	/*
	 * ---------------------------------
	 *		Méthodes
	 * ---------------------------------
	 */

    @Override
    public Cell newGeneration(int nbNeighbours) {
        // Par défault, la prochaine cellule générée à partir d'une cellule morte
        // sera morte également (on considère donc qu'il s'agit de la cellule courante)
        Cell futureCell = this;

        // S'il y a exactement 3 cellules vivantes autour de la cellule morte actuelle,
        // la cellule de prochaine génération sera vivante
        if(nbNeighbours == 3) {
            futureCell = new AliveCell();
        }

        return futureCell;
    }

    @Override
    public String getAsString() {
        return DEAD_CELL_REPRESENTATION;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

}