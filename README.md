# IN205_Bataille_Navale_BaumstimlerPhilippe

## Execution du fichier .jar
 
 On se place dans le dossier target du projet maven et on execute via le terminal la commande suivante:
 
```bash
  java -cp bataille-navale-1.0-SNAPSHOT.jar ensta.Main
```

## Explication du programme

Il s'agit d'un programme de jeu de bataille navale, jouable selon 2 modes: Solo et Multijoueur.

Voici ce qui se produit lorsque l'on exécute le programme :

```bash
  Veuillez saisir le mode de jeu: (1) Joueur Contre IA (2) Joueur Contre Joueur
```

Il suffit de saisir l'un des deux modes en entrant soit '1' soit '2' dans la console puis le jeu se lance selon le mode choisit

### Mode Joueur Contre IA

Ce mode permet de jouer à la bataille navale seul, face à une IA. Tout d'abord le joueur place ses bateaux dans la position choisie par le joueur. 

```bash
Veuillez saisir le mode de jeu: (1) Joueur Contre IA (2) Joueur Contre Joueur
1
Bienvenu dans le mode: Joueur Contre IA
Navires :                 Frappes :
  A B C D E F G H I J       A B C D E F G H I J
0 . . . . . . . . . .     0 . . . . . . . . . .
1 . . . . . . . . . .     1 . . . . . . . . . .
2 . . . . . . . . . .     2 . . . . . . . . . .
3 . . . . . . . . . .     3 . . . . . . . . . .
4 . . . . . . . . . .     4 . . . . . . . . . .
5 . . . . . . . . . .     5 . . . . . . . . . .
6 . . . . . . . . . .     6 . . . . . . . . . .
7 . . . . . . . . . .     7 . . . . . . . . . .
8 . . . . . . . . . .     8 . . . . . . . . . .
9 . . . . . . . . . .     9 . . . . . . . . . .

Veuillez placer vos bateaux sur la grille
placer 1 : Destroyer(2)
A0 south
Navires :                 Frappes :
  A B C D E F G H I J       A B C D E F G H I J
0 D . . . . . . . . .     0 . . . . . . . . . .
1 D . . . . . . . . .     1 . . . . . . . . . .
2 . . . . . . . . . .     2 . . . . . . . . . .
3 . . . . . . . . . .     3 . . . . . . . . . .
4 . . . . . . . . . .     4 . . . . . . . . . .
5 . . . . . . . . . .     5 . . . . . . . . . .
6 . . . . . . . . . .     6 . . . . . . . . . .
7 . . . . . . . . . .     7 . . . . . . . . . .
8 . . . . . . . . . .     8 . . . . . . . . . .
9 . . . . . . . . . .     9 . . . . . . . . . .
```

On porte une attention toute particulière à la validité des coordonnées entrées pour ne pas interrompre le programme et permettre au joueur de rectifier ses choix:

```bash
placer 2 : Submarine(3)
A1
Format incorrect! Entrez la position sous forme 'A0 north'
B1 east
Navires :                 Frappes :
  A B C D E F G H I J       A B C D E F G H I J 
0 D . . . . . . . . .     0 . . . . . . . . . . 
1 D S S S . . . . . .     1 . . . . . . . . . . 
2 . . . . . . . . . .     2 . . . . . . . . . . 
3 . . . . . . . . . .     3 . . . . . . . . . . 
4 . . . . . . . . . .     4 . . . . . . . . . . 
5 . . . . . . . . . .     5 . . . . . . . . . . 
6 . . . . . . . . . .     6 . . . . . . . . . . 
7 . . . . . . . . . .     7 . . . . . . . . . . 
8 . . . . . . . . . .     8 . . . . . . . . . . 
9 . . . . . . . . . .     9 . . . . . . . . . . 

placer 3 : Submarine(3)
B1 south
Mauvais placement. Veuillez resaisir les informations de placement.
Navires :                 Frappes :
  A B C D E F G H I J       A B C D E F G H I J
0 D . . . . . . . . .     0 . . . . . . . . . .
1 D S S S . . . . . .     1 . . . . . . . . . .
2 . . . . . . . . . .     2 . . . . . . . . . .
3 . . . . . . . . . .     3 . . . . . . . . . .
4 . . . . . . . . . .     4 . . . . . . . . . .
5 . . . . . . . . . .     5 . . . . . . . . . .
6 . . . . . . . . . .     6 . . . . . . . . . .
7 . . . . . . . . . .     7 . . . . . . . . . .
8 . . . . . . . . . .     8 . . . . . . . . . .
9 . . . . . . . . . .     9 . . . . . . . . . .

placer 3 : Submarine(3)

```






