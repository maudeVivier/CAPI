/**
 * @file AffichageConfiguration.java
 * @brief Elle représente la fenêtre d'interface graphique
 * pour la configuration du Planning Poker. Elle gère l'affichage des différents
 *  menus et la gestion des actions utilisateur.
 */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import java.io.IOException;

/**
 * @class AffichageConfiguration
 * @brief Classe gérant l'affichage des différentes pages de l'interface graphique.
 * Cette classe hérite de JPanel et offre des méthodes pour afficher les différentes
 * pages de configuration ainsi que la gestion des éléments d'interface utilisateur.
 */

public class AffichageConfiguration extends JPanel {
    private final JPanel accueilPanel = new JPanel();
    private final JPanel nbJoueurPanel = new JPanel();
    private final JPanel pseudoPanel = new JPanel();
    private final JPanel modePanel = new JPanel();
    private final JPanel fonctionnalitePanel = new JPanel();
    private final JPanel plateauPanel = new JPanel();
    private static String numeroCarte;


    /**
     * Constructeur par défaut de la classe AffichageConfiguration.
     * Initialise les différents panneaux et configure les écouteurs d'événements.
     */
    public AffichageConfiguration(){
        Affichage.pageAccueil(accueilPanel);
        add(accueilPanel);

        /* -------------------Bouton pour configurer une nouvelle partie---------------------- */
        AffichageInfo.boutonNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Affichage.pageNbPerso(nbJoueurPanel);
                add(nbJoueurPanel);
                setMenu(AffichageInfo.MENU_NB_JOUEUR);
            }
        });

        /* -------------------Bouton pour reprendre une partie si possible---------------------- */
        AffichageInfo.boutonReprendrePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PlanningPoker.chargerPartie();
                    ChronoTemps.tempsPartie();
                    Affichage.pagePlateau(plateauPanel);
                    add(plateauPanel);
                    setMenu(AffichageInfo.MENU_PLATEAU);
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
                setMenu(AffichageInfo.MENU_PSEUDO);
            }
        });

        /* -------------------Bouton pour valider les pseudos---------------------- */
        AffichageInfo.boutonValiderPseudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Joueur.verifierPseudosNonNuls() && Joueur.verifierPseudosUniques()) {
                    Affichage.pageChoixMode(modePanel);
                    add(modePanel);
                    setMenu(AffichageInfo.MENU_MODE);
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
                    setMenu(AffichageInfo.MENU_FONCTIONNALITE);

                } else if (unanimiteSelected && !moyenneSelected) {
                    ReglesPlanningPoker.modeDeJeu = ModeDeJeu.UNANIMITE;
                    Affichage.pageFonctionnalite(fonctionnalitePanel);
                    add(fonctionnalitePanel);
                    setMenu(AffichageInfo.MENU_FONCTIONNALITE);

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
                if(!AffichageInfo.fieldFonctionnalite.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Le champ n'est pas vide,veuillez le valider avant de lancer la partie au risque de le perdre", "Information", JOptionPane.INFORMATION_MESSAGE);
                }else if(!AffichageInfo.listeFonctionnalite.isEmpty()) {
                    Fonctionnalite.listeFonctionnalites = Fonctionnalite.creerListeFonctionnalites();
                    AffichageInfo.nbFonctionnalite = Fonctionnalite.listeFonctionnalites.size();
                    Affichage.pagePlateau(plateauPanel);
                    add(plateauPanel);
                    setMenu(AffichageInfo.MENU_PLATEAU);
                    AffichageInfo.planningPoker = PlanningPoker.getInstance(Fonctionnalite.listeFonctionnalites, Joueur.listeJoueurs, ReglesPlanningPoker.modeDeJeu);
                    ChronoTemps.tempsPartie = 0;
                    ChronoTemps.tempsPartie();
                }
                else{
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
                    if (!res.equals("-1") && !res.equals("interro")) { //Fonctionnalite Validee
                        clearBorders("-1");
                        if(!res.equals("cafe")) {//Affiche le message seulement si le resultat est différent de café
                            Fonctionnalite.listeFonctionnalites.get(AffichageInfo.fonctionnaliteVote).setDifficulte(res);
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
                    } else if(res.equals("interro")){
                        //On enleve les ecouteurs des cartes et du bouton
                        //Comme ça on ne peux voter pendant le temps de reflexion
                        retirerEcouteursCartes();
                        retirerEcouteurs(AffichageInfo.boutonChoixCarte);

                        ChronoTemps.mettreEnPauseTimerPartie();
                        int optionAppuye = JOptionPane.showOptionDialog(
                                null,
                                "Le résultat est indéterminé. Vous avez du temps pour discuter et revoter la tâche. Cliquez pour démarrer le timer",
                                "Information",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                new Object[]{"Démarrer Timer"},
                                null
                        );
                        if(optionAppuye == 0){ // Le chrono se lance une fois qu'on a appuier sur le bouton du message qui s'affiche
                            ChronoTemps.partieEnPauseInterro();
                        }
                    } else {//Fonctionnalité refusée
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
    private static final MouseListener carteClickListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Component source = e.getComponent();

            if (source instanceof JLabel) {
                JLabel carteCliquee = (JLabel) source;
                numeroCarte = (String) carteCliquee.getClientProperty("valeur");

                // Retirez le contour des autres cartes
                clearBorders(numeroCarte);

                // Ajoutez un contour à la carte cliquée
                carteCliquee.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
        }
    };

    /**
     * @brief Efface les contours des cartes, sauf celle spécifiée.
     *
     * Cette méthode parcourt les cartes et supprime les contours de celles qui ne correspondent
     * pas à la carte spécifiée par le paramètre "numeroCarte".
     *
     * @param numeroCarte La carte pour laquelle le contour doit être préservé.
     */
    private static void clearBorders(String numeroCarte) {
        String numCarte;

        for (int i = 0; i < AffichageInfo.valeursCartes.length; i++) {
            numCarte =  AffichageInfo.valeursCartes[i];
            if (!numCarte.equals(numeroCarte)) {
                AffichageInfo.labelsCartes[i].setBorder(BorderFactory.createLineBorder(AffichageInfo.couleurFond, 2));
            }
        }
    }

    /**
     * @brief Affiche la page correspondant au menu spécifié.
     *
     * @param menu Le numéro du menu à afficher.
     */
    public void setMenu(int menu) {
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
                ajouterEcouteursCartes();
                break;
        }
    }

    /**
     * @brief Méthode publique qui ajoute des écouteurs aux cartes de vote.
     */
    public static void ajouterEcouteursCartes() {
        for (JLabel carteLabel : AffichageInfo.labelsCartes) {
            carteLabel.addMouseListener(carteClickListener);
        }
    }

    /**
     * @brief Méthode privée qui retire des écouteurs aux cartes de vote.
     */
    private void retirerEcouteursCartes() {
        for (JLabel carteLabel : AffichageInfo.labelsCartes) {
            carteLabel.removeMouseListener(carteClickListener);
        }
    }

    /**
     * @brief Méthode publique qui ajoute des écouteurs à des composants spécifiques.
     *
     * @param components Liste variable de composants auxquels ajouter les écouteurs.
     */
    public static void ajouterEcouteurs(JComponent... components) {
        for (JComponent component : components) {
            component.setEnabled(true);        }
    }

    /**
     * @brief Méthode privée qui enlève des écouteurs à des composants spécifiques.
     *
     * @param components Liste variable de composants auxquels ajouter les écouteurs.
     */
    private void retirerEcouteurs(JComponent ... components) {
        for (JComponent component : components) {
            component.setEnabled(false);
        }
    }
}