package com.ynov.gameoflife.cell;

public interface Cell {


    /*
     * ---------------------------------
     *		Constantes
     * ---------------------------------
     */

    /*
     * Dans une interface, il n'est pas possible d'avoir des attributs d'instance, les valeurs ci-dessous sont donc toutes des variables STATIC et FINAL = des constantes.
     * Puisqu'il n'y aurait pas d'intérêt d'avoir des constantes qui ne peuvent être utilisées nul part, ces variables sont donc PUBLIC implicitement.
     * Note: Il est donc possible de se passer des mot-clés "public static final" puisqu'ils sont implicites.
     */

    /** Representation d'une cellule morte. */
    String DEAD_CELL_REPRESENTATION 	= "-";
    /** Representation d'une cellule juste-née. */
    String NEWBORN_CELL_REPRESENTATION = "0";
    /** Representation d'une cellule vivante. */
    String ALIVE_CELL_REPRESENTATION 	= "+";

    /*
     * ---------------------------------
     *		Méthodes
     * ---------------------------------
     */

    /*
     * Dans une interface, on définie des comportements qui doivent obligatoirement être re-définie dans les classes qui implémentent cette interface.
     * Ces méthodes sont donc toutes ABSTRACT et PUBLIC.
     * Note: Il est donc possible de se passer des mot-clés (public abstract) puisqu'ils sont implicites.
     */

    /**
     * Evolution de la cellule vers un nouvel état lors du passage de génération.<br>
     *
     * @param nbNeighbours
     * 			Nombre de voisins vivants pour la génération actuelle.
     * @return Cellule de prochaine génération.
     */
    Cell newGeneration(int nbNeighbours);

    /**
     * Representation de la cellule sous forme de chaine de charactères: <br>
     * 			- Cellule morte: {@link Cell#DEAD_CELL_REPRESENTATION} <br>
     * 			- Cellule vivante: {@link Cell#ALIVE_CELL_REPRESENTATION} <br>
     * 			- Cellule juste-née: {@link Cell#NEWBORN_CELL_REPRESENTATION} <br>
     *
     * @return Une chaine de charactère representante la cellule.
     */
    String getAsString();

    /**
     * @return TRUE si la cellule est vivante, FALSE sinon.
     */
    boolean isAlive();
}
