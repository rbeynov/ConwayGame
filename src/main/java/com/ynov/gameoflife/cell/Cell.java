package com.ynov.gameoflife.cell;

public interface Cell {

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
     * 			- Cellule morte: - <br>
     * 			- Cellule vivante: + <br>
     * 			- Cellule juste-née: 0 <br>
     *
     * @return Une chaine de charactère representante la cellule.
     */
    String getAsString();

    /**
     * @return TRUE si la cellule est vivante, FALSE sinon.
     */
    boolean isAlive();
}
