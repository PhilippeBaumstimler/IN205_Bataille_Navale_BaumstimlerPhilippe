package ensta.model.ship;

import ensta.util.Orientation;

public class BattleShip extends AbstractShip{
	public BattleShip(){
		super("BattleShip", 'B', 4, Orientation.EAST);
	}
    public BattleShip(String aName, Character aLabel, int aLength, Orientation anOri) {
		super(aName, aLabel, aLength, anOri);
		// TODO Auto-generated constructor stub
	}

}