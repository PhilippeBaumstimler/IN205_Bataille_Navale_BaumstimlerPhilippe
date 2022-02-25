# IN205_Bataille_Navale_BaumstimlerPhilippe

## Compilation 

Voici la commande a exécuter dans le terminal dans le dossier "bataille_navale" afin de compiler le code:

```bash
	mvn clean install exec:java
```

## Execution du fichier .jar
 
 On se place dans le dossier target du projet maven et on execute via le terminal la commande suivante:
 
```console
	java -jar bataille-navale-1.0-SNAPSHOT.jar
```

## Explication du programme

Il s'agit d'un programme de jeu de bataille navale, jouable selon 2 modes: Solo et Multijoueur.

Voici ce qui se produit lorsque l'on exécute le programme :

```console
  Veuillez saisir le mode de jeu: (1) Joueur Contre IA (2) Joueur Contre Joueur
```

Il suffit de saisir l'un des deux modes en entrant soit '1' soit '2' dans la console puis le jeu se lance selon le mode choisit

### Mode Joueur Contre IA

Ce mode permet de jouer à la bataille navale seul, face à une IA. Tout d'abord le joueur place ses bateaux dans la position choisie par le joueur. 

```console
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

```console
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

Une fois le placement des bateaux fini, place au jeu ! La grille "Frappes" permet d'afficher les frappes réalisées par le joueur sur la grille de l'adversaire, qui ici est l'IA. Une frappe admet plusieurs valeurs possibles, que l'on retrouve dans l'enum Hit, permettant la distinction des frappes qui touchent, manquent ou coulent les navires adverses.

```java
public enum Hit {
    MISS(-1, "manqué"),
    STRIKE(-2, "touché"),
    DESTROYER(2, "Frégate"),
    SUBMARINE(3, "Sous-marin"),
    BATTLESHIP(4, "Croiseur"),
    CARRIER(5, "Porte-avion");
  ```
La grille contient alors l'état de la case dans la classe ShipState, qui permet de définir l'existence d'un navire dans une case et si ce dernier a été touché ou non à cet endroit précis. 

```java
public class ShipState{
    private AbstractShip ship;
    private boolean struck;
```
On peut alors à chaque coup établir afficher l'état de la grille selon les coups effectués par le joueur de l'IA (Une coloration est faite selon si le tir est manqué où touché)

```console

Au tour du Joueur 1: 
où frapper?
C5
=> Frappe en C5 : manqué
Navires :                 Frappes :
  A B C D E F G H I J       A B C D E F G H I J
0 D S S B C . . . . .     0 x . . . . . . . . . 
1 D S S B C . . . . .     1 . . . . . . . . . .
2 . S S B C . . . . .     2 . . . . . x . . . .
3 . . . B C . . . . .     3 . . . . . . . . . .
4 . . . . C . . . . .     4 . . . . . . . . . .
5 . . . . . . . . . .     5 . . x . x . . . . .
6 . . . . . . . . . .     6 . . . x . . . . . .
7 . . . . . . . . . .     7 . . . . . . . . . .
8 . . . . . . . . . .     8 . . . . . . . . . .
9 . . . . . . . . . .     9 . . . . . . . . . .

Au tour de l'IA:
<= Frappe en B9 : manqué
Au tour du Joueur 1:
où frapper?
```
Comme précédemment on porte une attention particulière aux mauvaises entrées utilisateurs:

```console
Navires :                 Frappes :
  A B C D E F G H I J       A B C D E F G H I J
0 D S S B C . . . . .     0 x . . . . . . . . . 
1 D S S B C . . . . .     1 . . . . . . . . . .
2 . S S B C . . . . .     2 . . . . . x . . . .
3 . . . B C . . . . .     3 . . . . . . . . . .
4 . . . . C . . . . .     4 . . . . . . . . . .
5 . . . . . . . . . .     5 . . x . x . . . . .
6 . . . . . . . . . .     6 . . . x . . . . . .
7 . . . . . . . . . .     7 . . . . . . . . . .
8 . . . . . . . . . .     8 . . . . . . . . . .
9 . . . . . . . . . .     9 . . . . . . . . . .

Au tour de l'IA:
<= Frappe en B9 : manqué
Au tour du Joueur 1:
où frapper?
F2
Erreur. Frappe déjà réalisée
où frapper?
E10
Erreur. Mauvaises coordonnées
où frapper?
xdqx
Format incorrect! Entrez la position sous forme 'A0'
```
La partie s'effectue jusqu'à ce que l'ensemble des navires d'un des deux joueurs soit détruit !


### Mode Joueur Contre Joueur

Ce mode de jeu permet à deux joueurs de jouer sur un seul terminal. Pour cela une adapatation du fichier Game.java a été faite, (ajout d'un attribut booléen 'multiplayer'). Il s'agit du même principe que le mode de jeu Solo, mais cette fois-ci les deux boards sont controlés par des joueurs. On effectue alors un affichage séquentiel des deux boards pour permettre à chacun des joueurs de placer leurs bateaux et d'effectuer leur tir.

```java
public class Game {

	/*
	 * *** Constante
	 */
	public static final File SAVE_FILE = new File("savegame.dat");

	/*
	 * *** Attributs
	 */
	private Player player1;
	private Player player2;
	private boolean multiplayer;
	private Scanner sin;
 	/*
	 * *** Constructeurs
	 */
	public Game() {
		this.multiplayer = false;
	}
	public Game(boolean multi) {
		this.multiplayer = multi;
	}
```





