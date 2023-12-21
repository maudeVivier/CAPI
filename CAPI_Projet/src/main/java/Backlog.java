/**
 * @file Backlog.java
 * @brief Définition de la classe Backlog pour la gestion du backlog en JSON.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @class Backlog
 * @brief Classe pour la gestion du backlog en JSON.
 */
public class Backlog {

    /**
     * @brief Sauvegarde le backlog en JSON lorsque la partie est terminée.
     */
    public static void sauvegarderEnJSONFini() {
        String chemin = AffichageInfo.workingDirectory + "\\src\\json\\backlog.json";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Objet qui contient les données à enregistrer
        Map<String, Object> donnees = new HashMap<>();
        donnees.put("fonctionnalites", PlanningPoker.getListeFonctionnalites());
        donnees.put("joueurs", PlanningPoker.getListeJoueurs());
        donnees.put("modeDeJeu", PlanningPoker.getModeDeJeu());
        donnees.put("tempsEcoule", ChronoTemps.tempsPartie);

        try {
            objectMapper.writeValue(new File(chemin), donnees);
            System.out.println("Backlog sauvegardé en JSON avec succès.");
        } catch (IOException e) {
            // Gérer les exceptions liées à l'écriture du fichier
            e.printStackTrace();
        }
    }

    /**
     * @brief Sauvegarde le backlog en JSON pendant une pause de partie.
     **/
    public static void sauvegarderEnJSONPause() {
        String chemin = AffichageInfo.workingDirectory + "\\src\\json\\backlog.json";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Objet qui contient les données à enregistrer
        Map<String, Object> donnees = new HashMap<>();
        donnees.put("fonctionnalites", PlanningPoker.getListeFonctionnalites());
        donnees.put("joueurs", PlanningPoker.getListeJoueurs());
        donnees.put("fonctionnalitesValidees", AffichageInfo.fonctionnaliteVote);
        donnees.put("modeDeJeu", PlanningPoker.getModeDeJeu());
        donnees.put("tempsEcoule", ChronoTemps.tempsPartie);

        try {
            objectMapper.writeValue(new File(chemin), donnees);
            System.out.println("Backlog sauvegardé en JSON avec succès.");
        } catch (IOException e) {
            // Gérer les exceptions liées à l'écriture du fichier
            e.printStackTrace();
        }
    }

    /**
     * @brief Charge les données du backlog depuis un fichier JSON lors d'une pause de partie.
     * @throws IOException En cas d'erreur lors de la lecture du fichier.
     */
    public static void chargerDepuisJSONPause() throws IOException {
        String chemin = AffichageInfo.workingDirectory + "\\src\\json\\backlog.json";

        if (verifierSiFichierExiste(chemin)) {
            System.out.println("Le fichier existe.");
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> donnees = objectMapper.readValue(new File(chemin), Map.class);

            //Chargement des fonctionnalites
            Fonctionnalite.listeFonctionnalites = creerListeFonctionnalitesDepuisJSON(donnees);
            AffichageInfo.nbFonctionnalite = Fonctionnalite.listeFonctionnalites.size();

            //Chargement des joueurs
            Joueur.listeJoueurs = creerListeJoueursDepuisJSON(donnees);
            AffichageInfo.nbJoueur = Joueur.listeJoueurs.size();

            //Chargement du nombre de fonctionnalites deja traitees
            AffichageInfo.fonctionnaliteVote = (int) donnees.get("fonctionnalitesValidees");

            //Chargement du mode de jeu
            ReglesPlanningPoker.modeDeJeu = ModeDeJeu.valueOf((String) donnees.get("modeDeJeu"));

            //Chargement du temps déjà écoulée
            ChronoTemps.tempsPartie = (int) donnees.get("tempsEcoule");


            System.out.println("Données chargées depuis le fichier JSON avec succès.");
        } else {
            System.out.println("Le fichier n'existe pas.");
            JOptionPane.showMessageDialog(null, "Aucune partie enregister", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @brief Créer une liste de fonctionnalités à partir des données JSON.
     * @param donnees Les données JSON à convertir.
     * @return La liste de fonctionnalités créée.
     */
    public static List<Fonctionnalite> creerListeFonctionnalitesDepuisJSON(Map<String, Object> donnees) {
        List<Fonctionnalite> listeFonc = new ArrayList<>();

        List<Map<String, Object>> donneesFonctionnalite = (List<Map<String, Object>>) donnees.get("fonctionnalites");

        for (Map<String, Object> donnee : donneesFonctionnalite) {
            Fonctionnalite fonctionnalite = new Fonctionnalite( (String) donnee.get("description"));
            fonctionnalite.setDifficulte((String) donnee.get("difficulte"));
            listeFonc.add(fonctionnalite);
        }
        return listeFonc;
    }

    /**
     * @brief Créer une liste de joueurs à partir des données JSON.
     * @param donnees Les données JSON à convertir.
     * @return La liste de joueurs créée.
     */
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

    /**
     * @brief Vérifie si un fichier existe.
     * @param cheminFichier Le chemin du fichier à vérifier.
     * @return True si le fichier existe, sinon False.
     */
    private static boolean verifierSiFichierExiste(String cheminFichier) {
        File fichier = new File(cheminFichier);
        return fichier.exists() && fichier.isFile();
    }
}
