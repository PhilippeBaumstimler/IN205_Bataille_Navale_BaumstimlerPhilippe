package ensta;

//import ensta.controller.Game;
import ensta.model.Coords;
import ensta.model.Board;
import ensta.model.ship.BattleShip;
import ensta.util.Orientation;

public class Main {

	public static void main(String args[]) {
    //new Game().init().run();
    Character ch = new Character('a');
    BattleShip aShip = new BattleShip("oui", ch, 2, Orientation.EAST);
    Board board = new Board();
    Coords coords = new Coords(0,0);
    board.putShip(aShip, coords);
    board.print();

    board.setHit(true, coords);
		board.print();
    //board.print();

    }

}
