package ensta.model;

import java.io.Serializable;
import java.util.List;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.view.InputHelper;

public class Player {
	/*
	 * ** Attributs
	 */
	private Board board;
	protected Board opponentBoard;
	private int destroyedCount;
	protected AbstractShip[] ships;
	private boolean lose;

	/*
	 * ** Constructeur
	 */
	public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
		this.setBoard(board);
		this.ships = ships.toArray(new AbstractShip[0]);
		this.opponentBoard = opponentBoard;
	}

	/*
	 * ** Méthodes
	 */

	/**
	 * Read keyboard input to get ships coordinates. Place ships on given
	 * coodrinates.
	 */
	public void putShips() {
		boolean done = false;
		int i = 0;

		do {
			AbstractShip ship = ships[i];
			String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getLength());
			System.out.println(msg);
			InputHelper.ShipInput res = InputHelper.readShipInput();
			// TODO set ship orientation
			// TODO put ship at given position
			// TODO when ship placement successful
			Coords coords = new Coords(res.x, res.y);
			if(res.orientation.compareToIgnoreCase("east")==0) ship.setOrientation(Orientation.EAST);
			else if(res.orientation.compareToIgnoreCase("west")==0) ship.setOrientation(Orientation.WEST);
			else if(res.orientation.compareToIgnoreCase("north")==0) ship.setOrientation(Orientation.NORTH);
			else if(res.orientation.compareToIgnoreCase("south")==0) ship.setOrientation(Orientation.SOUTH);
			if(board.putShip(ship, coords)){
				++i;
			}
			else System.out.println("Mauvais placement. Veuillez resaisir les informations de placement.");

			done = i == 5;
			board.print();
		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		Coords res = new Coords();
		boolean done = false;
		Hit hit = null;
		do {
			System.out.println("où frapper?");
			InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
			res.setX(hitInput.x);
			res.setY(hitInput.y);
			if(res.isInBoard(board.getSize())){
				hit = this.opponentBoard.sendHit(res);
				if(board.getHit(res)!=null){
					System.out.println("Erreur. Frappe déjà réalisée");
					hit = null;
				}
			}else{
				System.out.println("Erreur. Mauvaises coordonnées");
			}
			// TODO call sendHit on this.opponentBoard

			// TODO : Game expects sendHit to return BOTH hit result & hit coords.
			// return hit is obvious. But how to return coords at the same time ?
			done = hit != null;
		} while (!done);
		coords.setCoords(res);
		return hit;
	}

	public AbstractShip[] getShips() {
		return ships;
	}

	public void setShips(AbstractShip[] ships) {
		this.ships = ships;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDestroyedCount() {
		return destroyedCount;
	}

	public void setDestroyedCount(int destroyedCount) {
		this.destroyedCount = destroyedCount;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
}
