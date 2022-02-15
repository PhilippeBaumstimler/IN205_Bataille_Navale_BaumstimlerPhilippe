package ensta.model.ship;

import ensta.util.Orientation;

public class BattleShip extends AbstractShip{
    public BattleShip(String aName, String aLabel, int aLength, Orientation anOri) {
		super(aName, aLabel, aLength, anOri);
		// TODO Auto-generated constructor stub
	}

	public boolean isSunk(){
        return true;
    }

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orientation getOrientation() {
		// TODO Auto-generated method stub
		return null;
	}
    
}