package ensta.model.ship;

import ensta.util.Orientation;


public abstract class AbstractShip{
    private String label;
    private String name;
    private int length;
    private Orientation ori;

    public AbstractShip(String aName, String aLabel, int aLength, Orientation anOri ){
        this.name = aName;
        this.label = aLabel;
        this.length = aLength;
        this.ori = anOri;
    }

    public abstract String getLabel();
    public abstract String getName();
    public abstract int getLength();
    public abstract Orientation getOrientation();
    public abstract boolean isSunk();
}