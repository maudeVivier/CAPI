import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

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
                try {
                    PlanningPoker.chargerPartie();

                    Affichage.pagePlateau(plateauPanel);
                    add(plateauPanel);
                    setMenu(AffichageInfo.MENU_PLATEAU, true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
                } else {
                    JOptionPane.showMessageDialog(null, "Certains pseudos sont manquants ou identiques.", "Information", JOptionPane.INFORMATION_MESSAGE);
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
                    ReglesPlanningPoker.modeDeJeu = ModeDeJeu.MOYENNE;
                    ReglesPlanningPoker.moyenne = AffichageInfo.nbJoueur % 2;
                    Affichage.pageFonctionnalite(fonctionnalitePanel);
                    add(fonctionnalitePanel);
                    setMenu(AffichageInfo.MENU_FONCTIONNALITE, false);
                    AffichageInfo.planningPoker = PlanningPoker.getInstance(Fonctionnalite.listeFonctionnalites, Joueur.listeJoueurs, ReglesPlanningPoker.modeDeJeu);
                } else if (unanimiteSelected && !moyenneSelected) {
                    ReglesPlanningPoker.modeDeJeu = ModeDeJeu.UNANIMITE;
                    Affichage.pageFonctionnalite(fonctionnalitePanel);
                    add(fonctionnalitePanel);
                    setMenu(AffichageInfo.MENU_FONCTIONNALITE, false);
                    AffichageInfo.planningPoker = PlanningPoker.getInstance(Fonctionnalite.listeFonctionnalites, Joueur.listeJoueurs, ReglesPlanningPoker.modeDeJeu);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un mode de jeu.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        /* -------------------Bouton pour enregistrer la fonctionnalite---------------------- */
        AffichageInfo.boutonValiderFonctionnalite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fonctionnalite.ajouterFonctionnalite();
            }
        });

        /* -------------------Bouton pour aller sur le plateau une fois les fonctionnalites ecrites---------------------- */
        AffichageInfo.boutonPasserPlateau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!AffichageInfo.listeFonctionnalite.isEmpty()) {
                    Fonctionnalite.listeFonctionnalites = Fonctionnalite.creerListeFonctionnalites();
                    AffichageInfo.nbFonctionnalite = Fonctionnalite.listeFonctionnalites.size();
                    Affichage.pagePlateau(plateauPanel);
                    add(plateauPanel);
                    setMenu(AffichageInfo.MENU_PLATEAU, true);
                    AffichageInfo.planningPoker = PlanningPoker.getInstance(Fonctionnalite.listeFonctionnalites, Joueur.listeJoueurs, ReglesPlanningPoker.modeDeJeu);
                }else{
                    JOptionPane.showMessageDialog(null, "Veuillez entrez au moins une fonctionnalité, avant de lancer la partie", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        /* -------------------Bouton pour sauvegarder la carte cliqué par le joueur---------------------- */
        AffichageInfo.boutonChoixCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Joueur.ajouterVoteAuJoueur(numeroCarte);
                clearBorders("-1");
                Affichage.changerPseudo();
                if (AffichageInfo.nbJoueur == AffichageInfo.joueurVote) {
                    String res = ReglesPlanningPoker.appliquerRegles(ReglesPlanningPoker.modeDeJeu);
                    if (!res.equals("-1")) { //Fonctionnalite Validee
                        clearBorders("-1");
                        if(!res.equals("cafe")) {//Affiche le message seulement si le resultat est différent de café
                            Fonctionnalite.listeFonctionnalites.get(AffichageInfo.fonctionnaliteVote).setDifficulte(res);
                            Fonctionnalite.listeFonctionnalites.get(AffichageInfo.fonctionnaliteVote).setValidee(true);
                            AffichageInfo.joueurVote = 0;
                            AffichageInfo.tour = 1;
                            AffichageInfo.fonctionnaliteVote += 1;
                            JOptionPane.showMessageDialog(null, "Fonctionnalité validée", "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (AffichageInfo.fonctionnaliteVote == AffichageInfo.nbFonctionnalite){ //Fin de partie
                            PlanningPoker.partieFinie();
                        }else {//Partie qui continue
                            Affichage.changerRegle();
                        }
                    } else{//Fonctionnalité refusée
                        JOptionPane.showMessageDialog(null, "Fonctionnalité non validée", "Information", JOptionPane.INFORMATION_MESSAGE);
                        clearBorders("-1");
                        AffichageInfo.joueurVote = 0;
                        AffichageInfo.tour += 1;
                        Affichage.changerTour();
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

                // Retirez le contour des autres cartes
                clearBorders(numeroCarte);

                // Ajoutez un contour à la carte cliquée
                carteCliquee.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }
        }
    };

    private void clearBorders(String numeroCarte) {
        String numCarte;

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