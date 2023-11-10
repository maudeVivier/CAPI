# CAPI
## Application de planning poker
### Description
Langage : Java
Autrices : 
- VIVIER Maude
- RANDRIAMITANDRINA Finaritra

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