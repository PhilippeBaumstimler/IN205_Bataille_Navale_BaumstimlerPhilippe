package ensta.model.ship;

import ensta.util.Orientation;

public class Destroyer extends AbstractShip{
	public Destroyer(){
		this.setOrientation(Orientation.EAST);
	}
    public Destroyer(String aName, String aLabel, int aLength, Orientation anOri) {
		super(aName, aLabel, aLength, anOri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSunk(){
        return true;
    }
}