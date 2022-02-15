package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	private String name;
	private Character[] boat;
	private boolean[] hits;
	
	public Board() {
		this.size = DEFAULT_SIZE;
		boat = new Character[size*size];
		hits = new boolean[size*size];
		for(int i=0;i<size*size;i++){
			hits[i]=false;
		}
		for(int i=0;i<size*size;i++){
			Character ch = '.';
			boat[i] = ch;
		}
	}

	public Board(String aName, int s){
		this.name = aName;
		this.size = s;
		boat = new Character[size*size];
		hits = new boolean[size*size];
		for(int i=0;i<size*size;i++){
			hits[i]=false;
		}
		for(int i=0;i<size*size;i++){
			Character ch = '.';
			boat[i] = ch;
		}
	}

	public Board(String aName){
		this.name = aName;
		this.size = DEFAULT_SIZE;
	}

	public void print() {
		System.out.print("Navires :");
		for(int i=0; i<(size*2-7);i++){
			System.out.print(" ");
		}
		System.out.print("    ");
		System.out.println("Frappes :");
		if(size>10){
			System.out.print(" ");
		}
		System.out.print("  ");
		for(int i=0; i<size; i++){
			System.out.print((char)(i+65) + " ");
		}
		System.out.print("      ");
		if(size>10){
			System.out.print(" ");
		}
		for(int i=0; i<size; i++){
			System.out.print((char)(i+65) + " ");
		}
		System.out.print("\n");
		for(int i=0; i<size; i++){
			if(i<10 && size>10){
				System.out.print(" ");
			}
			System.out.print(i + " ");
			for(int j=0; j<size; j++){
				if(boat[i*size + j].toString()=="."){
					System.out.print(". ");
				}else{
					System.out.print(boat[i*size +j].toString() + " ");
				}
			}
			System.out.print("    ");
			if(i<10&& size>10){
				System.out.print(" ");
			}
			System.out.print(i + " ");
			for(int j=0; j<size; j++){
				if(hits[i*size + j]){
					System.out.print("x ");
				}else{
					System.out.print(". ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public boolean hasShip(Coords aCoord){
		if(boat[aCoord.getY()*size + aCoord.getX()].toString().equals(".")) return false;
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

	public Character[] getboat() {
		return boat;
	}

	public void setboat(Character[] boat) {
		this.boat = boat;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean putShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if(o==Orientation.EAST) dx = 1;
		else if(o==Orientation.WEST) dx = -1;
		else if(o==Orientation.SOUTH) dy = 1;
		else if(o==Orientation.NORTH) dy = -1;
		if(canPutShip(ship, coords)){
			Coords iCoords = new Coords(coords);
			for (int i = 0; i < ship.getLength(); ++i) {
				boat[iCoords.getY()*size + iCoords.getX()] = ship.getLabel();
				iCoords.setX(iCoords.getX() + dx);
				iCoords.setY(iCoords.getY() + dy);
			}
		}
		return false;
	}

	@Override
	public void setHit(boolean hit, Coords coords) {
		// TODO Auto-generated method stub
		hits[coords.getY()*size + coords.getX()]=hit;
	}

	@Override
	public Boolean getHit(Coords coords) {
		// TODO Auto-generated method stub
		return hits[coords.getY()*size + coords.getX()];
	}

	@Override
	public Hit sendHit(Coords res) {
		// TODO Auto-generated method stub
		return null;
	}
}
