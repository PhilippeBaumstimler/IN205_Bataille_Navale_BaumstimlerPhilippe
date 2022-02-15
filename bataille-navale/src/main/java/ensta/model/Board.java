package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	private String name;
	private char[] boat;
	private boolean[] hit;
	
	public Board() {
		this.size = DEFAULT_SIZE;
	}

	public Board(String aName, int s){
		this.name = aName;
		this.size = s;
	}

	public Board(String aName){
		this.name = aName;
		this.size = DEFAULT_SIZE;
	}

	public void print() {
		System.out.println("Navires : ");
		System.out.print("  ");
		for(int i=0; i<size; i++){
			System.out.print((char)(i+65) + " ");
		}
		System.out.print("\n");
		for(int i=0; i<size; i++){
			System.out.print(i + " ");
			for(int j=0; j<size; j++){
				System.out.print(". ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println("hit : ");
		System.out.print("  ");
		for(int i=0; i<size; i++){
			System.out.print((char) (i+65) + " ");
		}
		System.out.print("\n");
		for(int i=0; i<size; i++){
			System.out.print(i + " ");
			for(int j=0; j<size; j++){
				System.out.print(". ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public boolean hasShip(Coords aCoord){
		return true;
	}

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char[] getboat() {
		return boat;
	}

	public void setboat(char[] boat) {
		this.boat = boat;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean putShip(AbstractShip ship, Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHit(boolean hit, Coords coords) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getHit(Coords coords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hit sendHit(Coords res) {
		// TODO Auto-generated method stub
		return null;
	}
}
