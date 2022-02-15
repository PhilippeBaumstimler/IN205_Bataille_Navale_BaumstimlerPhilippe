package ensta.model.ship;

import ensta.util.Orientation;

public class Carrier extends AbstractShip{
	public Carrier(){
		this.setOrientation(Orientation.EAST);
	}
    public Carrier(String aName, String aLabel, int aLength, Orientation anOri) {
		super(aName, aLabel, aLength, anOri);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSunk(){
        return true;
    }

}