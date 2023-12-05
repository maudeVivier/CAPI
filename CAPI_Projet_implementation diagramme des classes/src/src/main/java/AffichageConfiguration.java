package src.main.java;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class AffichageConfiguration extends JPanel {
    private final JPanel accueilPanel = new JPanel();
    private final JPanel nbJoueurPanel = new JPanel();
    private final JPanel pseudoPanel = new JPanel();
    private final JPanel modePanel = new JPanel();
    private final JPanel plateauPanel = new JPanel();

    public AffichageConfiguration(){
        Affichage.pageAccueil(accueilPanel);
        add(accueilPanel);

        /* -------------------Bouton pour configurer une nouvelle partie---------------------- */
        AffichageInfo.boutonNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Affichage.pageNbPerso(nbJoueurPanel);
                add(nbJoueurPanel);
                setMenu(1);
            }
        });

        /* -------------------Bouton pour reprendre une partie si possible---------------------- */
        AffichageInfo.boutonReprendrePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bouton reprendre une partie appuyer", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        /* -------------------Bouton pour valider le nombre de joueurs---------------------- */
        AffichageInfo.boutonValiderNbJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageInfo.nbJoueur = (int) AffichageInfo.spinnerNbJoueur.getValue();
                Affichage.pagePseudoPerso(pseudoPanel);
                add(pseudoPanel);
                setMenu(2);
            }
        });

        /* -------------------Bouton pour valider les pseudos---------------------- */
        AffichageInfo.boutonValiderPseudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verifierPseudosNonNuls() && verifierPseudosUniques()) {
                    Affichage.pageChoixMode(modePanel);
                    add(modePanel);
                    setMenu(3);
                } else {
                    JOptionPane.showMessageDialog(null, "Certains pseudos sont manquants ou identiques.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /* -------------------Bouton pour choisir le mode de jeu---------------------- */
        AffichageInfo.boutonValiderMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean unanimiteSelected = AffichageInfo.checkUnanimate.isSelected();
                boolean moyenneSelected = AffichageInfo.checkMoyenne.isSelected();

                if (moyenneSelected && !unanimiteSelected) {
                    Affichage.pagePlateau(plateauPanel);
                    add(plateauPanel);
                    setMenu(4);
                    System.out.println("CHECK MOYENNE VALIDÉ");
                } else if (unanimiteSelected && !moyenneSelected) {
                    Affichage.pagePlateau(plateauPanel);
                    add(plateauPanel);
                    setMenu(4);
                    System.out.println("CHECK UNANIMITÉ VALIDÉ");
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un mode de jeu.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public void setMenu(int menu) {
        switch (menu) {
            case 0:
                // Affichage de l'accueil
                accueilPanel.setVisible(true);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(false);
                plateauPanel.setVisible(false);
                break;
            case 1:
                // Affichage du menu pour choisir le nombre de joueurs
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(true);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(false);
                plateauPanel.setVisible(false);
                break;
            case 2:
                // Affichage du menu pour choisir les pseudos
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(true);
                modePanel.setVisible(false);
                plateauPanel.setVisible(false);
                break;
            case 3:
                // Affichage du menu pour choisir le mode de jeu
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(true);
                plateauPanel.setVisible(false);
                break;
            case 4:
                // Affichage du plateau de jeu
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(false);
                plateauPanel.setVisible(true);
                break;
        }
    }

    /*Fonction pour verifier si tous les pseudos sont differents*/
    private boolean verifierPseudosUniques() {
        Set<String> pseudosSet = new HashSet<>();

        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            String pseudo = pseudoTextArea.getText().trim();
            if (!pseudosSet.add(pseudo)) {
                return false; // Pseudo déjà rencontré, n'est pas unique
            }
        }
        return true; // Tous les pseudos sont uniques
    }

    private boolean verifierPseudosNonNuls() {
        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            if (pseudoTextArea.getText().trim().isEmpty()) {
                return false; // Au moins un JTextArea est nul
            }
        }
        return true; // Tous les JTextArea sont non nuls
    }
}