package ensta.model;

public class Coords{
    public Coords(int nx, int ny){}
    public Coords(Coords nCoords){}
    public Coords() {
		// TODO Auto-generated constructor stub
	}
	public int getX(){
        return 0;
    }
    public int getY(){
        return 0;
    }
    public void setX(int x_value){}
    public void setY(int y_value){}
    public void setCoords(Coords nCoords){}
    public boolean isInBoard(int aValue){
        return true;
    }
    public static Coords randomCoords(int size){
        return null;
    }

}