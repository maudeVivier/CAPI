import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AffichageConfiguration extends JPanel {

    /*Fonction ou on va mettre des actions avec des touches claviers,
    toucher un bouton, ect
    */
    public AffichageConfiguration(){
        this.setLayout(null);

        /* -------------------Bouton pour parametrer le nombre de joueur ainsi que les pseudos---------------------- */
        AffichageInfo.boutonNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageInfo.menu = 1;
                repaint();
            }
        });

        /* -------------------Bouton pour valider le nombre de joueurs---------------------- */
        AffichageInfo.boutonValiderNbJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageInfo.nbJoueur = (int) AffichageInfo.nb_joueur_Spinner.getValue();
                AffichageInfo.menu = 2;
                System.out.print("Nombre de joueur : " + AffichageInfo.nbJoueur);
                repaint();
            }
        });


        /* -------------------Bouton pour valider les pseudos---------------------- */
        AffichageInfo.boutonValiderPseudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageInfo.menu = 3;
                System.out.println("Nombre de joueur : " + AffichageInfo.nbJoueur);
                afficherContenuPseudos();

                /*
                if (verifierPseudosNonNuls()) {
                    System.out.println("Tous les pseudos sont valides.");
                } else {
                    System.out.println("Certains pseudos sont manquants ou identiques.");
                }*/
                repaint();
            }
        });

    }

    /*
    Fonction pour modifier l'apparence de la fenetre
    enlever bouton, rajouter bouton, ect
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 0, 50));

        if (AffichageInfo.menu == 0) { //accueil
            add(AffichageInfo.boutonNouvellePartie);
            Affichage.PageAccueil(g);
        } else if(AffichageInfo.menu == 1){ //menu pour choisir nombre de joueurs
            remove(AffichageInfo.boutonNouvellePartie);

            add(AffichageInfo.boutonValiderNbJoueur);

            setLayout(new FlowLayout());
            add(AffichageInfo.nb_joueur_Spinner);

            Affichage.MenuConfigPartie(g);
            setFocusable(true);
        } else if(AffichageInfo.menu == 2){ //menu pour choisir les pseudos
            remove(AffichageInfo.boutonValiderNbJoueur);
            remove(AffichageInfo.nb_joueur_Spinner);

            int x0 = (AffichageInfo.screenWidth/6);
            int y0 = (AffichageInfo.screenHeight/4);
            int valDecY = AffichageInfo.screenHeight/9;
            int valDecX = AffichageInfo.screenWidth/4;

            AffichageInfo.areaTabPseudo = new JTextArea[AffichageInfo.nbJoueur];

            for (int i = 0, decx = 0, decy = 0; i < AffichageInfo.nbJoueur; i++, decy+= valDecY) {
                AffichageInfo.areaTabPseudo[i] = new JTextArea();
                if(i<=5){
                    AffichageInfo.areaTabPseudo[i].setBounds(x0, y0 + decy, AffichageInfo.largeurReponse, AffichageInfo.hauteurReponse);
                }
                else{
                    if(i==6){
                        decx += AffichageInfo.largeurReponse + valDecX;
                        decy = 0;
                    }
                    AffichageInfo.areaTabPseudo[i].setBounds(x0 + decx, y0 + decy, AffichageInfo.largeurReponse, AffichageInfo.hauteurReponse);
                }
                add(AffichageInfo.areaTabPseudo[i]);
            }

            add(AffichageInfo.boutonValiderPseudo);
            Affichage.MenuConfigPartie(g);

        } else if (AffichageInfo.menu == 3) { //menu qui affiche le plateau de jeu
            remove(AffichageInfo.boutonValiderPseudo);
            for(int i=0; i<AffichageInfo.nbJoueur; i++) {
                remove(AffichageInfo.areaTabPseudo[i]);
            }


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
            System.out.println("Dans fonction pour verifier pseudo : " + pseudoTextArea.getText().trim());
            if (pseudoTextArea.getText().trim().isEmpty()) {
                return false; // Au moins un JTextArea est nul
            }
        }
        return true; // Tous les JTextArea sont non nuls
    }

    private String[] recupererValeursJTextArea() {
        String[] valeurs = new String[AffichageInfo.areaTabPseudo.length];

        for (int i = 0; i < AffichageInfo.areaTabPseudo.length; i++) {
            valeurs[i] = AffichageInfo.areaTabPseudo[i].getText();
        }

        return valeurs;
    }

    private void afficherContenuPseudos() {
        System.out.println("Contenu des pseudos : ");
        for (int i = 0; i < AffichageInfo.areaTabPseudo.length; i++) {
            System.out.println("Joueur " + (i + 1) + " : " + AffichageInfo.areaTabPseudo[i].getText().trim());
        }
    }
}