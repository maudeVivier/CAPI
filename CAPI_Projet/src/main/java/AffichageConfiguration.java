import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


public class AffichageConfiguration extends JPanel {
    private final JPanel accueilPanel = new JPanel();
    private final JPanel nbJoueurPanel = new JPanel();
    private final JPanel pseudoPanel = new JPanel();
    private final JPanel modePanel = new JPanel();
    private final JPanel plateauPanel = new JPanel();

    private String numeroCarte;

    private PlanningPoker planningPoker;


    public AffichageConfiguration(){
        Affichage.pageAccueil(accueilPanel);
        add(accueilPanel);

        /* -------------------Bouton pour configurer une nouvelle partie---------------------- */
        AffichageInfo.boutonNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Affichage.pageNbPerso(nbJoueurPanel);
                add(nbJoueurPanel);
                setMenu(AffichageInfo.MENU_NB_JOUEUR, false);
            }
        });

        /* -------------------Bouton pour reprendre une partie si possible---------------------- */
        AffichageInfo.boutonReprendrePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                add(plateauPanel);
                setMenu(AffichageInfo.MENU_PLATEAU, true);
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
                setMenu(AffichageInfo.MENU_PSEUDO, false);
            }
        });

        /* -------------------Bouton pour valider les pseudos---------------------- */
        AffichageInfo.boutonValiderPseudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verifierPseudosNonNuls() && verifierPseudosUniques()) {
                    Affichage.pageChoixMode(modePanel);
                    add(modePanel);
                    setMenu(AffichageInfo.MENU_MODE, false);
                    Joueur.listeJoueurs = Joueur.creerListeDeJoueurs();
                    Joueur.afficheListeJoueur(Joueur.listeJoueurs);
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
                    ReglesPlanningPoker.monModeDeJeu = ModeDeJeu.MOYENNE;
                    Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                    add(plateauPanel);
                    setMenu(AffichageInfo.MENU_PLATEAU, true);
                    System.out.println("CHECK MOYENNE VALIDÉ");
                    planningPoker = new PlanningPoker(Joueur.listeJoueurs, ReglesPlanningPoker.monModeDeJeu);
                } else if (unanimiteSelected && !moyenneSelected) {
                    ReglesPlanningPoker.monModeDeJeu = ModeDeJeu.UNANIMITE;
                    Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                    add(plateauPanel);
                    setMenu(AffichageInfo.MENU_PLATEAU, true);
                    System.out.println("CHECK UNANIMITÉ VALIDÉ");
                    planningPoker = new PlanningPoker(Joueur.listeJoueurs, ReglesPlanningPoker.monModeDeJeu);
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

        AffichageInfo.boutonChoixCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterVoteAuJoueur(numeroCarte);
                changerPseudo();
                if(AffichageInfo.nbJoueur == AffichageInfo.joueurVote) {
                    boolean res = ReglesPlanningPoker.appliquerRegles(ReglesPlanningPoker.monModeDeJeu);
                    System.out.println("RESULTAT dans config : "+res);
                    if(res){
                        JOptionPane.showMessageDialog(null, "VALIDE", "Erreur", JOptionPane.ERROR_MESSAGE);
                        AffichageInfo.joueurVote = 0;
                        AffichageInfo.tour = 1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Refuser", "Erreur", JOptionPane.ERROR_MESSAGE);
                        AffichageInfo.joueurVote = 0;
                        AffichageInfo.tour += 1;
                    }
                }
            }
        });

    }

    /* -------------------Ecouteur pour savoir quand on a cliqué sur une carte---------------------- */
    private final MouseListener carteClickListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Component source = e.getComponent();

            if (source instanceof JLabel) {
                JLabel carteCliquee = (JLabel) source;
                numeroCarte = (String) carteCliquee.getClientProperty("valeur");
                System.out.println("Carte cliquée : " + numeroCarte);


                // Retirez le contour des autres cartes
                //clearBorders();

                // Ajoutez un contour à la carte cliquée
                carteCliquee.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

            }
        }

        private void clearBorders() {
            // Parcourez tous les composants sur votre plateau pour retirer les contours
            for (Component component : plateauPanel.getComponents()) {
                if (component instanceof JPanel) {
                    for (Component internalComponent : ((JPanel) component).getComponents()) {
                        if (internalComponent instanceof JLabel) {
                            JLabel carteLabel = (JLabel) internalComponent;
                            numeroCarte = (String) carteLabel.getClientProperty("valeur");
                            System.out.println("Carte dans supprimer contour: " + numeroCarte);
                            if (numeroCarte != null && !numeroCarte.isEmpty()) {
                                carteLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                            }
                        }
                    }
                } else if (component instanceof JLabel) {
                    JLabel carteLabel = (JLabel) component;
                    numeroCarte = (String) carteLabel.getClientProperty("valeur");
                    System.out.println("Carte choix 2 : " + numeroCarte);
                    if (numeroCarte != null && !numeroCarte.isEmpty()) {
                        carteLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    }
                }
            }
        }
    };

    private void ajouterVoteAuJoueur(String carte) {
        if (AffichageInfo.joueurVote == 0) {
            AffichageInfo.cartesVotees.clear();
        }
        for (Joueur joueur : Joueur.listeJoueurs) {
            if (joueur.getMonId() == (AffichageInfo.joueurVote + 1)) {
                System.out.println("Joueur " + (AffichageInfo.joueurVote + 1) + " ajoute la carte " + carte);
                joueur.setVoteEnCours(carte);
                AffichageInfo.joueurVote += 1;
                AffichageInfo.cartesVotees.add(carte);
                break;
            }
        }
    }
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
                    ajouterEcouteursCartes();
                } else {
                    retirerEcouteursCartes();
                }break;
        }
    }

    /*private void ajouterEcouteursCartes() {
        for (Component component : Arrays.asList(
                AffichageInfo.labelCarte0, AffichageInfo.labelCarte1, AffichageInfo.labelCarte2,
                AffichageInfo.labelCarte3, AffichageInfo.labelCarte5, AffichageInfo.labelCarte8,
                AffichageInfo.labelCarte13, AffichageInfo.labelCarte20, AffichageInfo.labelCarte40,
                AffichageInfo.labelCarte100, AffichageInfo.labelCarteCafe, AffichageInfo.labelCarteInterro)) {
            if (component instanceof JLabel) {
                JLabel carteLabel = (JLabel) component;
                carteLabel.addMouseListener(carteClickListener);
            }
        }
    }*/
    private void ajouterEcouteursCartes() {
        for (JLabel carteLabel : AffichageInfo.labelsCartes) {
            carteLabel.addMouseListener(carteClickListener);
        }
    }

    private void retirerEcouteursCartes() {
        for (JLabel carteLabel : AffichageInfo.labelsCartes) {
            carteLabel.removeMouseListener(carteClickListener);
        }
    }

    private void changerRegle(){

    }
    private void changerPseudo() {
        // Change le pseudo en fonction de l'index actuel
        int indexPseudoCourant = (AffichageInfo.joueurVote) % Joueur.listeJoueurs.size();
        AffichageInfo.labelPseudo.setText("Joueur : " + Joueur.listeJoueurs.get(indexPseudoCourant).getMonPseudo());
    }


    /*private void retirerEcouteursCartes() {
        for (Component component : Arrays.asList(
                AffichageInfo.labelCarte0, AffichageInfo.labelCarte1, AffichageInfo.labelCarte2,
                AffichageInfo.labelCarte3, AffichageInfo.labelCarte5, AffichageInfo.labelCarte8,
                AffichageInfo.labelCarte13, AffichageInfo.labelCarte20, AffichageInfo.labelCarte40,
                AffichageInfo.labelCarte100, AffichageInfo.labelCarteCafe, AffichageInfo.labelCarteInterro)) {
            if (component instanceof JLabel) {
                JLabel carteLabel = (JLabel) component;
                carteLabel.removeMouseListener(carteClickListener);
            }
        }
    }*/

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