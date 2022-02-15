package ensta.model.ship;

import ensta.util.Orientation;


public abstract class AbstractShip{
    private String label;
    private String name;
    private int length;
    private Orientation ori;
    public AbstractShip(){}
    public AbstractShip(String aName, String aLabel, int aLength, Orientation anOri ){
        this.name = aName;
        this.label = aLabel;
        this.length = aLength;
        this.ori = anOri;
    }

    public String getLabel(){
        return label;
    }
    public String getName(){
        return name;
    }
    public int getLength(){
        return length;
    }
    public Orientation getOrientation(){
        return ori;
    }
    public void setOrientation(Orientation anOri){
        this.ori = anOri;
    }
    public abstract boolean isSunk();
}