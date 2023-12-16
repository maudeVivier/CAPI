import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class AffichageConfiguration extends JPanel {
    private final JPanel accueilPanel = new JPanel();
    private final JPanel nbJoueurPanel = new JPanel();
    private final JPanel pseudoPanel = new JPanel();
    private final JPanel modePanel = new JPanel();
    private final JPanel fonctionnalitePanel = new JPanel();
    private final JPanel plateauPanel = new JPanel();
    private String numeroCarte;


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
                Affichage.pageFonctionnalite(fonctionnalitePanel);
                add(fonctionnalitePanel);
                setMenu(AffichageInfo.MENU_FONCTIONNALITE, false);
                /*Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                add(plateauPanel);
                setMenu(AffichageInfo.MENU_PLATEAU, true);*/
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
                if (Joueur.verifierPseudosNonNuls() && Joueur.verifierPseudosUniques()) {
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
                    Affichage.pageFonctionnalite(fonctionnalitePanel);
                    add(fonctionnalitePanel);
                    setMenu(AffichageInfo.MENU_FONCTIONNALITE, false);
                    System.out.println("CHECK MOYENNE VALIDÉ");
                    PlanningPoker.planningPoker = new PlanningPoker(Joueur.listeJoueurs, ReglesPlanningPoker.monModeDeJeu);
                } else if (unanimiteSelected && !moyenneSelected) {
                    ReglesPlanningPoker.monModeDeJeu = ModeDeJeu.UNANIMITE;
                    Affichage.pageFonctionnalite(fonctionnalitePanel);
                    add(fonctionnalitePanel);
                    setMenu(AffichageInfo.MENU_FONCTIONNALITE, false);
                    System.out.println("CHECK UNANIMITÉ VALIDÉ");
                    PlanningPoker.planningPoker = new PlanningPoker(Joueur.listeJoueurs, ReglesPlanningPoker.monModeDeJeu);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un mode de jeu.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /* -------------------Bouton pour enregistrer la tache---------------------- */
        AffichageInfo.boutonValiderTache.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fonctionnalite.ajouterFonctionnalite();
            }
        });

        /* -------------------Bouton pour aller sur le plateau une fois les fonctionnalites ecrites---------------------- */
        AffichageInfo.boutonPasserPlateau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fonctionnalite.afficherListe();
                if(!AffichageInfo.listeTache.isEmpty()) {
                    Fonctionnalite.listeFonctionnalites = Fonctionnalite.ajouterFonctionnalites();
                    Fonctionnalite.afficheListeFonctionnalite(Fonctionnalite.listeFonctionnalites);
                    Affichage.pagePlateau(plateauPanel, AffichageConfiguration.class);
                    add(plateauPanel);
                    setMenu(AffichageInfo.MENU_PLATEAU, true);
                    PlanningPoker.planningPoker = new PlanningPoker(Joueur.listeJoueurs, ReglesPlanningPoker.monModeDeJeu);
                }else{
                    JOptionPane.showMessageDialog(null, "Veuillez entrez au moins une fonctionnalité, avant de lancer la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
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

        /* -------------------Bouton pour sauvegarder la carte cliqué par le joueur---------------------- */
        AffichageInfo.boutonChoixCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Joueur.ajouterVoteAuJoueur(numeroCarte);
                Affichage.changerPseudo();
                if(AffichageInfo.nbJoueur == AffichageInfo.joueurVote) {
                    boolean res = ReglesPlanningPoker.appliquerRegles(ReglesPlanningPoker.monModeDeJeu);
                    System.out.println("RESULTAT dans config : "+res);
                    if(res){
                        JOptionPane.showMessageDialog(null, "VALIDE", "Erreur", JOptionPane.ERROR_MESSAGE);
                        clearBorders("-1");
                        AffichageInfo.joueurVote = 0;
                        AffichageInfo.tour = 1;
                        AffichageInfo.regleVote += 1;
                        Affichage.changerRegle();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Refuser", "Erreur", JOptionPane.ERROR_MESSAGE);
                        clearBorders("-1");
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
                clearBorders(numeroCarte);

                // Ajoutez un contour à la carte cliquée
                carteCliquee.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }
        }
    };

    private void clearBorders(String numeroCarte) {
        String numCarte;
        System.out.println("DANS CLEARBORDERS Carte cliquée : " + numeroCarte);
        for (int i = 0; i < AffichageInfo.valeursCartes.length; i++) {
            numCarte =  AffichageInfo.valeursCartes[i];
            if (!numCarte.equals(numeroCarte)) {
                AffichageInfo.labelsCartes[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
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
                fonctionnalitePanel.setVisible(false);
                break;
            case 1:
                // Affichage du menu pour choisir le nombre de joueurs
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(true);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(false);
                fonctionnalitePanel.setVisible(false);
                plateauPanel.setVisible(false);
                break;
            case 2:
                // Affichage du menu pour choisir les pseudos
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(true);
                modePanel.setVisible(false);
                fonctionnalitePanel.setVisible(false);
                plateauPanel.setVisible(false);
                break;
            case 3:
                // Affichage du menu pour choisir le mode de jeu
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(true);
                fonctionnalitePanel.setVisible(false);
                plateauPanel.setVisible(false);
                break;
            case 4:
                // Affichage du menu pour entrer les fonctionnalites
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(false);
                fonctionnalitePanel.setVisible(true);
                plateauPanel.setVisible(false);
                break;
            case 5:
                // Affichage du plateau de vote
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(false);
                modePanel.setVisible(false);
                fonctionnalitePanel.setVisible(false);
                plateauPanel.setVisible(true);
                // Ajout ou retrait des écouteurs de clic sur les cartes
                if (ajouterEcouteursCartes) {
                    ajouterEcouteursCartes();
                } else {
                    retirerEcouteursCartes();
                }break;
        }
    }

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
}