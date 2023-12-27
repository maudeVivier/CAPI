# CAPI - Application de planning poker
## Support
- Langage : Java
- Editeur : IntelliJ
- Bibliothèque : JFrame (pour l'affichage) et JUnit (pour les tests)
- Documentation : Doxygen

## Autrices
- RANDRIAMITANDRINA Finaritra
- VIVIER Maude

## Utilisation
1. Sur IntelliJ, ouvrir le projet *CAPI_Projet*.
2. Lancer le programme principal *Fenetre*
    Le programme principal (*main*)se trouve dans le fichier *Fenetre.java* 
    Son chemin d'accès est : *CAPI\CAPI_Projet\src\main\java\Fenetre.java*
3. Lancer une nouvelle partie de Planning Poker (ou reprenez une partie déjà sauvegardée dans un fichier JSON)

## Documentation
Le fichier html de documentation du programme a été généré avec Doxygen.

Vous le trouverez dans le fichier *index.html*

Son chemin d'accès est : *CAPI\CAPI_Projet\Doc\html\index.html*

## Tests Unitaires
Ce projet contient quatre fichiers de tests unitaires dans le répertoire *Test/java* de notre projet.

Ces fichiers de test sont conçus pour vérifier le bon fonctionnement de certaines parties du code.

Son chemin d'accès est : *CAPI\CAPI_Projet\src\test\java*

## Description
L'objectif de l'application est de permettre à des joueurs de faire une partie de planning poker, en respectant les règles vues en cours.

L'application se fait en locale : les joueurs choisissent chacun à leur tour leurs cartes sur le même écran.

Un menu permet de décider du nombre de joueurs et de rentrer un pseudo pour chacun des joueurs. Le menu permet aussi de choisir parmi différentes règles de planning poker. Nous avons choisis les règles "unanimité" et "moyenne".

On peut également entrer une liste de fonctionnalités (backlog) en JSON.

Une fois que chacun à voté, l'application valide ou non la fonctionnalité en fonction des règles choisies via le menu. Si la fonctionnalités n'est pas validée, on recommence le vote.

Lorsque tout le backlog est validé, l'application enregistre un fichier JSON avec, pour chaque fonctionnalité, la difficulté estimée par l'équipe.

#### Note :
 1. Nous avons mis en place un chronomètre pour estimer la durée de la partie du planning Poker.
 2. Si tous les joueurs utilisent la carte café, l'application enregistre un fichier JSON avec l'état d'avancement du backlog. Ce fichier JSON peut être chargé via le menu pour "reprendre une partie".
 3. Si tous les jours optent pour la carte "?" (donc s'ils ne savent pas comment estimer la difficulté) un temps de pause de 10 secondes s'enclenche. Le temps que tout le monde se concerte pour décider d'un niveau de difficulté. Puis, on reprend le tour. 
 4. Dans notre projet, nous avons utilisé un design patterns, le singleton.
