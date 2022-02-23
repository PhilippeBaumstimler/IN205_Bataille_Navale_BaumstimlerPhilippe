package ensta.model.ship;

import ensta.util.Orientation;

public class Carrier extends AbstractShip{
	public Carrier(){
		super("Carrier", 'C', 5, Orientation.EAST);
	}
    public Carrier(String aName, Character aLabel, int aLength, Orientation anOri) {
		super(aName, aLabel, aLength, anOri);
		// TODO Auto-generated constructor stub
	}
}