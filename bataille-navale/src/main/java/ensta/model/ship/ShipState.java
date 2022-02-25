
package ensta.model.ship;

public class ShipState{
    private AbstractShip ship;
    private boolean struck;
    
    public ShipState(){
        this.struck = false;
    }
    public ShipState(AbstractShip aShip){
        this.ship = aShip;
        this.struck = false;
    }

    public void addStrike(){
        if(!struck){
            ship.addStrike();
            struck = true;
        }
    }
    public boolean isStruck(){
        return struck;
    }
    public String toString(){
        return ship.getLabel().toString();
    }
    public boolean isSunk(){
        return ship.isSunk();
    }
    public AbstractShip getShip(){
        return ship;
    }
}