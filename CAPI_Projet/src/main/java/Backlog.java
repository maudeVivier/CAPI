import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Backlog {
    /*
     * La méthode sauvegarderEnJSON utilise un bloc try-catch
     * pour intercepter toute exception liée à l'écriture du fichier.
     * Si une IOException se produit lors de l'écriture du fichier,
     * elle sera interceptée et traitée dans le bloc catch.
     * */
    public static void sauvegarderEnJSON() {
        String chemin = AffichageInfo.workingDirectory + "\\src\\json\\fichier.json";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Objet qui contient les données à enregistrer
        Map<String, Object> donnees = new HashMap<>();
        donnees.put("fonctionnalites", Fonctionnalite.listeFonctionnalites);
        donnees.put("joueurs", Joueur.listeJoueurs);
        donnees.put("fonctionnalitesValidees", AffichageInfo.fonctionnaliteVote);
        donnees.put("modeDeJeu", ReglesPlanningPoker.modeDeJeu);

        try {
            objectMapper.writeValue(new File(chemin), donnees);
            System.out.println("Backlog sauvegardé en JSON avec succès.");
        } catch (IOException e) {
            // Gérer les exceptions liées à l'écriture du fichier
            e.printStackTrace();
        }
    }


    public static void chargerDepuisJSON() throws IOException {
        String chemin = AffichageInfo.workingDirectory + "\\src\\json\\fichier.json";

        if (verifierSiFichierExiste(chemin)) {
            System.out.println("Le fichier existe.");
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> donnees = objectMapper.readValue(new File(chemin), Map.class);

            //Chargement des fonctionnalites
            Fonctionnalite.listeFonctionnalites = creerListeFonctionnalitesDepuisJSON(donnees);
            Fonctionnalite.afficheListeFonctionnalites();

            //Chargement des joueurs
            Joueur.listeJoueurs = creerListeJoueursDepuisJSON(donnees);
            Joueur.afficheListeJoueur();

            //Chargement du nombre de fonctionnalites deja traitees
            AffichageInfo.fonctionnaliteVote = (int) donnees.get("fonctionnalitesValidees");

            //Chargement du mode de jeu
            ReglesPlanningPoker.modeDeJeu = ModeDeJeu.valueOf((String) donnees.get("modeDeJeu"));


            System.out.println("Données chargées depuis le fichier JSON avec succès.");
        } else {
            System.out.println("Le fichier n'existe pas.");
            JOptionPane.showMessageDialog(null, "Aucune partie enregister", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Fonctionnalite> creerListeFonctionnalitesDepuisJSON(Map<String, Object> donnees) {
        List<Fonctionnalite> listeFonc = new ArrayList<>();

        List<Map<String, Object>> donneesFonctionnalite = (List<Map<String, Object>>) donnees.get("fonctionnalites");

        for (Map<String, Object> donnee : donneesFonctionnalite) {
            Fonctionnalite fonctionnalite = new Fonctionnalite( (String) donnee.get("description"));
            fonctionnalite.setDifficulte((int) donnee.get("difficulte"));
            fonctionnalite.setValidee((Boolean) donnee.get("validee"));
            listeFonc.add(fonctionnalite);
        }
        return listeFonc;
    }

    public static List<Joueur> creerListeJoueursDepuisJSON(Map<String, Object> donnees) {
        List<Joueur> listeJou = new ArrayList<>();

        List<Map<String, Object>> donneesJoueurs = (List<Map<String, Object>>) donnees.get("joueurs");

        for (Map<String, Object> donnee : donneesJoueurs) {
                int id = (int) donnee.get("id");
                String pseudo = (String) donnee.get("pseudo");
                Joueur joueur = new Joueur(id,pseudo);
                joueur.setVoteEnCours((String) donnee.get("voteCourant"));
                Joueur.listeJoueurs.add(joueur);
                listeJou.add(joueur);
        }
        return listeJou;
    }

    private static boolean verifierSiFichierExiste(String cheminFichier) {
        File fichier = new File(cheminFichier);
        return fichier.exists() && fichier.isFile();
    }
}
