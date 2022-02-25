package ensta.model.ship;

import ensta.util.Orientation;

public class Submarine  extends AbstractShip{
	public Submarine(){
		super("Submarine", 'S', 3, Orientation.EAST);
	}
    public Submarine(String aName, Character aLabel, int aLength, Orientation anOri) {
		super(aName, aLabel, aLength, anOri);
		// TODO Auto-generated constructor stub
	}

}