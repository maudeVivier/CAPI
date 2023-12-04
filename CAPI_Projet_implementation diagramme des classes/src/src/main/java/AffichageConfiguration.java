import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AffichageConfiguration extends JPanel {
    private JPanel accueilPanel = new JPanel();
    private JPanel nbJoueurPanel = new JPanel();
    private JPanel pseudoPanel = new JPanel();

    public AffichageConfiguration(){
        accueilPanel.setLayout(new BoxLayout(accueilPanel, BoxLayout.Y_AXIS));

        // Titre
        AffichageInfo.labelTitreAccueil.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
        AffichageInfo.labelTitreAccueil.setForeground(Color.WHITE);
        AffichageInfo.labelTitreAccueil.setAlignmentX(Component.CENTER_ALIGNMENT);
        accueilPanel.add(AffichageInfo.labelTitreAccueil);

        // Ajouter un espace vertical
        accueilPanel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 5));

        // Bouton
        AffichageInfo.boutonNouvellePartie.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonNouvellePartie.setBackground(Color.darkGray);
        AffichageInfo.boutonNouvellePartie.setForeground(Color.WHITE);
        AffichageInfo.boutonNouvellePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
        accueilPanel.add(AffichageInfo.boutonNouvellePartie);

        accueilPanel.setBackground(new Color(0, 0, 50));
        accueilPanel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
        add(accueilPanel);

        /* -------------------Bouton pour parametrer le nombre de joueur ainsi que les pseudos---------------------- */
        AffichageInfo.boutonNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nbJoueurPanel.setLayout(new BoxLayout(nbJoueurPanel, BoxLayout.Y_AXIS));
                // Menu pour choisir le nombre de joueurs
                AffichageInfo.labelTitreNbJoueur.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
                AffichageInfo.labelTitreNbJoueur.setForeground(Color.white);
                AffichageInfo.labelTitreNbJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
                nbJoueurPanel.add(AffichageInfo.labelTitreNbJoueur);

                // Ajouter un espace vertical
                nbJoueurPanel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 5));

                AffichageInfo.labelNbJoueur.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
                AffichageInfo.labelNbJoueur.setForeground(Color.white);
                AffichageInfo.labelNbJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
                nbJoueurPanel.add(AffichageInfo.labelNbJoueur);

                AffichageInfo.boutonValiderNbJoueur.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
                AffichageInfo.boutonValiderNbJoueur.setBackground(Color.darkGray);
                AffichageInfo.boutonValiderNbJoueur.setForeground(Color.WHITE);
                AffichageInfo.boutonValiderNbJoueur.setAlignmentX(Component.RIGHT_ALIGNMENT);
                nbJoueurPanel.add(AffichageInfo.boutonValiderNbJoueur);

                //nbJoueurPanel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 10));

                JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) AffichageInfo.nb_joueur_Spinner.getEditor();
                editor.getTextField().setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
                AffichageInfo.nb_joueur_Spinner.setEnabled(true);
                nbJoueurPanel.add(AffichageInfo.nb_joueur_Spinner);

                //nbJoueurPanel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 5));

                nbJoueurPanel.setBackground(new Color(0, 0, 50));
                nbJoueurPanel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
                add(nbJoueurPanel);

                setMenu(1);
            }
        });

        /* -------------------Bouton pour valider le nombre de joueurs---------------------- */
        AffichageInfo.boutonValiderNbJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageInfo.nbJoueur = (int) AffichageInfo.nb_joueur_Spinner.getValue();

                pseudoPanel.setLayout(new BorderLayout());

                AffichageInfo.labelTitrePseudoJoueur.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
                AffichageInfo.labelTitrePseudoJoueur.setForeground(Color.WHITE);
                AffichageInfo.labelTitrePseudoJoueur.setHorizontalAlignment(JLabel.CENTER);
                pseudoPanel.add(AffichageInfo.labelTitrePseudoJoueur, BorderLayout.NORTH);

                JPanel textAreaPanel = new JPanel();
                initialiserComposants(textAreaPanel);

                textAreaPanel.setBackground(new Color(0, 0, 50));
                // Ajouter le panneau de JTextArea au centre du BorderLayout
                pseudoPanel.add(textAreaPanel, BorderLayout.CENTER);

                AffichageInfo.boutonValiderPseudo.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
                AffichageInfo.boutonValiderPseudo.setBackground(Color.darkGray);
                AffichageInfo.boutonValiderPseudo.setForeground(Color.WHITE);

                pseudoPanel.add(AffichageInfo.boutonValiderPseudo,BorderLayout.WEST);

                pseudoPanel.setBackground(new Color(0, 0, 50));
                pseudoPanel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
                add(pseudoPanel);
                setMenu(2);
            }
        });

        /* -------------------Bouton pour valider les pseudos---------------------- */
        AffichageInfo.boutonValiderPseudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherContenuPseudos();
                if (verifierPseudosNonNuls() && verifierPseudosUniques()) {
                    System.out.println("Tous les pseudos sont valides.");
                    setMenu(3);
                } else {
                    System.out.println("Certains pseudos sont manquants ou identiques.");
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
                break;
            case 1:
                // Affichage du menu pour choisir le nombre de joueurs
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(true);
                pseudoPanel.setVisible(false);
                break;
            case 2:
                // Affichage du menu pour choisir les pseudos
                accueilPanel.setVisible(false);
                nbJoueurPanel.setVisible(false);
                pseudoPanel.setVisible(true);
                break;
        }
    }

    private void initialiserComposants(JPanel panel) {
        panel.setLayout(new GridLayout(0, 2, 20, 20)); // 2 colonnes, espacement de 20 pixels

        AffichageInfo.areaTabPseudo = new JTextArea[AffichageInfo.nbJoueur];

        for (int i = 0; i < AffichageInfo.nbJoueur; i++) {
            JTextArea areaPseudo = new JTextArea(1, 1); // 1 ligne, 20 colonnes
            areaPseudo.setFont(new Font("Arial", Font.BOLD, AffichageInfo.sizeTexte));

            // Ajoutez la JTextArea au GridLayout
            panel.add(areaPseudo);

            AffichageInfo.areaTabPseudo[i] = areaPseudo;
        }
    }
    /*
    Fonction pour modifier l'apparence de la fenetre
    enlever bouton, rajouter bouton, ect

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 0, 50));

        if (AffichageInfo.menu == 0) { //accueil
            //add(AffichageInfo.boutonNouvellePartie);
            Affichage.PageAccueil(g);
        } else if (AffichageInfo.menu == 1) { //menu pour choisir nombre de joueurs
            //remove(AffichageInfo.boutonNouvellePartie);

            //add(AffichageInfo.boutonValiderNbJoueur);

            //setLayout(new FlowLayout());
            //add(AffichageInfo.nb_joueur_Spinner);

            Affichage.MenuConfigPartie(g);
            //setFocusable(true);
        } else if (AffichageInfo.menu == 2) { //menu pour choisir les pseudos
            remove(AffichageInfo.boutonValiderNbJoueur);
            remove(AffichageInfo.nb_joueur_Spinner);

            add(AffichageInfo.boutonValiderPseudo);

            // Assurez-vous de n'initialiser les composants qu'une seule fois
            if (AffichageInfo.areaTabPseudo == null) {
                //initialiserComposants();            }

            Affichage.MenuConfigPartie(g);
        } else if (AffichageInfo.menu == 3) { //menu qui affiche le plateau de jeu
            for (int i = 0; i < AffichageInfo.nbJoueur; i++) {
                remove(AffichageInfo.areaTabPseudo[i]);
            }
            remove(AffichageInfo.boutonValiderPseudo);
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
        System.out.println("NOmbre de joueur : "+ AffichageInfo.nbJoueur);
        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            System.out.println("Dans fonction pour verifier pseudo : " + pseudoTextArea.getText().trim());
            if (pseudoTextArea.getText().trim().isEmpty()) {
                return false; // Au moins un JTextArea est nul
            }
        }
        return true; // Tous les JTextArea sont non nuls
    }

    private void afficherContenuPseudos() {
        System.out.println("Contenu des pseudos : ");
        for (int i = 0; i < AffichageInfo.nbJoueur; i++) {
            //Récuper les noms des pseudos
            String texte = AffichageInfo.areaTabPseudo[i].getText();
            System.out.println("Joueur " + (i + 1) + ": " + texte);
        }
    }
}