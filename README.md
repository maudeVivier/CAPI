# CAPI - Application de planning poker
## Support
- Langage : Java
- Editeur : IntelliJ
- Bibliothèque : JFrame
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

Vous le trouverez dans le fichier index.html

Son chemin d'accès est : *CAPI\CAPI_Projet\Doc\html\index.html*

## Tests Unitaires
Ce projet contient quatre fichiers de tests unitaires dans le répertoire *Test/java* de notre projet.

Ces fichiers de test sont conçus pour vérifier le bon fonctionnement de certaines parties du code.

Son chemin d'accès est : *CAPI\CAPI_Projet\src\test\java*

## Description
L'objectif de l'application est de permettre à des joueurs de faire une partie de planning poker, en respectant les règles vues en cours.

L'application peut être à distance (chaque joueur utilise son propre dispositif) ou locale (les joueurs choisissent chacun à leur tour leurs cartes).

Un menu permet de décider du nombre de joueurs et de rentrer un pseudo pour chacun des joueurs. Le menu doit aussi permettre de choisir parmi différentes règles de planning poker (règles strictes, moyenne, médiane, etc.)

On doit pouvoir entrer une liste de fonctionnalités (backlog) en JSON (vous êtes libre d'utiliser la structure que vous souhaitez).

Une fois que chacun à voté, l'application valide ou non la fonctionnalité en fonction des règles choisies via le menu. Si la fonctionnalités n'est pas validée, on recommence le vote.

Lorsque tout le backlog est validé, l'application enregistre un fichier JSON avec, pour chaque fonctionnalité, la difficulté estimée par l'équipe.

#### Note :
 Si tous les joueurs utilisent la carte café, l'application doit enregistrer un fichier JSON avec l'état d'avancement du backlog. Ce fichier JSON doit pouvoir être chargé via le menu pour "reprendre" une partie.

 Vous êtres très fortement encouragés à ajouter des fonctionnalités qui vous semblent utiles au bon déroulement du planning poker (chronomètre, espace de discussion, etc.)

Vous devez, dans votre projet, utiliser au moins trois des design patterns présentés en cours. Vous devez justifier l'utilisation de ces designs patterns dans votre rapport, ainsi que de la façon dont vous les avez implémenté dans votre projet.
