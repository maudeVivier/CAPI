/**
 * @file ModeDeJeu.java
 * @brief Définition de l'énumération ModeDeJeu.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @enum ModeDeJeu
 * @brief Représente les modes de jeu disponibles.
 */
public enum ModeDeJeu {
    /**
     * Mode de jeu "UNANIMITE".
     */
    @JsonProperty("UNANIMITE")
    UNANIMITE,

    /**
     * Mode de jeu "MOYENNE".
     */
    @JsonProperty("MOYENNE")
    MOYENNE
}

