package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.model.ship.ShipState;
import ensta.util.Orientation;
import ensta.util.ColorUtil;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	private String name;
	private ShipState[] boat;
	private Boolean[] hits;
	
	public Board() {
		this.size = DEFAULT_SIZE;
		boat = new ShipState[size*size];
		hits = new Boolean[size*size];
		for(int i=0;i<size*size;i++){
			this.hits[i]=null;
		}
		for(int i=0;i<size*size;i++){
			ShipState ch = new ShipState();
			boat[i] = ch;
		}
	}

	public Board(String aName, int s){
		this.name = aName;
		this.size = s;
		boat = new ShipState[size*size];
		hits = new Boolean[size*size];
		for(int i=0;i<size*size;i++){
			this.hits[i]=null;
		}
		for(int i=0;i<size*size;i++){
			ShipState ch = new ShipState();
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
				if(boat[i*size + j].getShip()==null){
					System.out.print(". ");
				}else{
					if(boat[i*size + j].isStruck()){
						System.out.print(ColorUtil.colorize(boat[i*size +j].toString(),ColorUtil.Color.RED));
					}else{
						System.out.print(boat[i*size +j].toString());
					}
					System.out.print(" ");
				}
			}
			System.out.print("    ");
			if(i<10&& size>10){
				System.out.print(" ");
			}
			System.out.print(i + " ");
			for(int j=0; j<size; j++){
				if(hits[i*size + j]!=null){
					if(hits[i*size + j]){
						System.out.print(ColorUtil.colorize("x ",ColorUtil.Color.RED));
					}else{
						System.out.print("x ");
					}
				}else{
					System.out.print(". ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public boolean hasShip(Coords aCoord){
		if(boat[aCoord.getY()*size + aCoord.getX()].getShip() == null) return false;
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

	public ShipState[] getboat() {
		return boat;
	}

	public void setboat(ShipState[] boat) {
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
				ShipState state = new ShipState(ship);
				boat[iCoords.getY()*size + iCoords.getX()] = state;
				iCoords.setX(iCoords.getX() + dx);
				iCoords.setY(iCoords.getY() + dy);
			}
		}
		return false;
	}

	@Override
	public void setHit(boolean hit, Coords coords) {
		hits[coords.getY()*size + coords.getX()]=hit;
	}

	@Override
	public Boolean getHit(Coords coords) {
		return hits[coords.getY()*size + coords.getX()];
	}

	@Override
	public Hit sendHit(Coords res) {
		setHit(true, res);
		if(boat[res.getY()*size + res.getX()].getShip()==null){
			return Hit.MISS;
		}else{
			if(!boat[res.getY()*size + res.getX()].isStruck()){
				boat[res.getY()*size + res.getX()].addStrike();
				if(boat[res.getY()*size + res.getX()].isSunk()){
					return Hit.fromInt(boat[res.getY()*size + res.getX()].getShip().getLength());
				}else{
					return Hit.STRIKE;
				}
			}else{
				return null;
			}
		}
	}

	@Override
	public Hit sendHit(int x, int y) {
		Coords coords = new Coords(x,y);
		return sendHit(coords);
	}


}
