package ensta;

//import ensta.controller.Game;
import ensta.model.Coords;
import ensta.model.Board;
import ensta.model.ship.*;
import ensta.util.Orientation;
import ensta.ai.BattleShipsAI;
import ensta.model.Hit;

public class Main {

	public static void main(String args[]) {
    //new Game().init().run();

    //Test exercice 6
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

    //Test exercice 7
    Board board = new Board();
    board.print();
    AbstractShip[] ships = new AbstractShip[] { new Destroyer(), 
      new Submarine(), new BattleShip(), new Carrier() };
    BattleShipsAI ai = new BattleShipsAI(board, board);
    sleep(1000);
    ai.putShips(ships);
    board.print();
    int compteur = 0;
    Coords hit_coords;
    do{
      hit_coords = Coords.randomCoords(board.getSize());
      Hit hit = ai.sendHit(hit_coords);
      System.out.println(hit + " aux coordonnees " + hit_coords);
      if (hit!= Hit.MISS && hit!=Hit.STRIKE){
        compteur ++;
      }
      board.print();
      sleep(500);
    }while(compteur < ships.length);

  }

  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
}
