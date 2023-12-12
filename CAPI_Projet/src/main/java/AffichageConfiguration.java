import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
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
                setMenu(1, false);
            }
        });

        /* -------------------Bouton pour reprendre une partie si possible---------------------- */
        AffichageInfo.boutonReprendrePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                add(plateauPanel);
                setMenu(4, true);
                //JOptionPane.showMessageDialog(null, "Bouton reprendre une partie appuyer", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        /* -------------------Bouton pour valider le nombre de joueurs---------------------- */
        AffichageInfo.boutonValiderNbJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageInfo.nbJoueur = (int) AffichageInfo.spinnerNbJoueur.getValue();
                Affichage.pagePseudoPerso(pseudoPanel);
                add(pseudoPanel);
                setMenu(2, false);
            }
        });

        /* -------------------Bouton pour valider les pseudos---------------------- */
        AffichageInfo.boutonValiderPseudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verifierPseudosNonNuls() && verifierPseudosUniques()) {
                    Affichage.pageChoixMode(modePanel);
                    add(modePanel);
                    setMenu(3, false);
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
                    Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                    add(plateauPanel);
                    setMenu(4, true);
                    System.out.println("CHECK MOYENNE VALIDÉ");
                } else if (unanimiteSelected && !moyenneSelected) {
                    Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                    add(plateauPanel);
                    setMenu(4, true);
                    System.out.println("CHECK UNANIMITÉ VALIDÉ");
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un mode de jeu.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /* -------------------Bouton pour sauvegarder la partie---------------------- */
        AffichageInfo.boutonSauvegarderPartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bouton sauvegarder une partie appuyer", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    /* -------------------Ecouteur pour savoir quand on a cliqué sur une carte---------------------- */
    private final MouseListener carteClickListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Réagissez au clic sur la carte ici
            JLabel carteCliquee = (JLabel) e.getComponent();
            String numeroCarte = (String) carteCliquee.getClientProperty("valeur");
            System.out.println("Carte cliquée : " + numeroCarte);
        }
    };
    public void setMenu(int menu, boolean ajouterEcouteursCartes) {
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

                // Ajout ou retrait des écouteurs de clic sur les cartes
                if (ajouterEcouteursCartes) {
                    AffichageInfo.labelCarte0.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte1.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte2.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte3.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte5.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte8.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte13.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte20.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte40.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarte100.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarteCafe.addMouseListener(carteClickListener);
                    AffichageInfo.labelCarteInterro.addMouseListener(carteClickListener);
                } else {
                    // Retirez les écouteurs de clic sur les cartes
                    AffichageInfo.labelCarte0.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte1.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte2.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte3.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte5.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte8.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte13.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte20.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte40.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarte100.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarteCafe.removeMouseListener(carteClickListener);
                    AffichageInfo.labelCarteInterro.removeMouseListener(carteClickListener);
                }
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