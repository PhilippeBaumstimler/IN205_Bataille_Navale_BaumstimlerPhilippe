package ensta.model.ship;

import ensta.util.Orientation;

public class Destroyer extends AbstractShip{
	public Destroyer(){
		super("Destroyer", 'D', 2, Orientation.EAST);
	}
    public Destroyer(String aName, Character aLabel, int aLength, Orientation anOri) {
		super(aName, aLabel, aLength, anOri);
		// TODO Auto-generated constructor stub
	}
}