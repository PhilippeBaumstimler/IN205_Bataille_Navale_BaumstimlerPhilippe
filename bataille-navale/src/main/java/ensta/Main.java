package ensta;

import ensta.controller.Game;
import ensta.model.Coords;
import ensta.model.Board;
import ensta.model.ship.*;
import ensta.util.Orientation;
import ensta.ai.BattleShipsAI;
import ensta.model.Hit;
import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

    /*******************Test exercice 6*******************************/
    // Character ch = new Character('a');
    // BattleShip aShip = new BattleShip("oui", ch, 2, Orientation.EAST);
    // Board board = new Board();
    // Coords coords = new Coords(0,0);
    // board.putShip(aShip, coords);
    // board.print();
    // System.out.println(board.sendHit(0,1));
		// board.print();
    // System.out.println(board.sendHit(1,0));
    // board.print();
    // System.out.println(board.sendHit(0,0));
    // board.print();
    // System.out.println(board.sendHit(0,0));
    // board.print();
    //board.print();

    /*******************Test exercice 7*******************************/
    // Board board = new Board();
    // board.print();
    // AbstractShip[] ships = new AbstractShip[] { new Destroyer(), 
    //   new Submarine(), new BattleShip(), new Carrier() };
    // BattleShipsAI ai = new BattleShipsAI(board, board);
    // sleep(1000);
    // ai.putShips(ships);
    // board.print();
    // int compteur = 0;
    // Coords hit_coords;
    // do{
    //   hit_coords = Coords.randomCoords(board.getSize());
    //   Hit hit = ai.sendHit(hit_coords);
    //   System.out.println(hit + " aux coordonnees " + hit_coords);
    //   if (hit!= Hit.MISS && hit!=Hit.STRIKE){
    //     compteur ++;
    //   }
    //   board.print();
    //   sleep(500);
    // }while(compteur < ships.length);


    /*******************Test exercice 8 + Bonus*******************************/
    boolean multiplayer=false;
    boolean done = false;
    System.out.println("Veuillez saisir le mode de jeu: (1) Joueur Contre IA (2) Joueur Contre Joueur");
    do {
			try {
				String[] in = scanner.nextLine().toLowerCase().split(" ");
				if (in.length == 1) {
					String value = in[0];
					if (value.equals("1")) {
						multiplayer = false;
            done = true;
					}else if(value.equals("2")){
            multiplayer = true;
            done = true;
          }
				}
			} catch (Exception e) {}
			if (!done) {
				System.err.println("Format incorrect! Veuillez saisir '1' ou '2'");
			}
		} while (!done && scanner.hasNextLine());
    new Game(multiplayer).init().run();


  }

  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
}
