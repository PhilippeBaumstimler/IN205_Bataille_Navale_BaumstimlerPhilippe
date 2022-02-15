package ensta.model;

public class Coords{
    private int x;
    private int y;


    public Coords(int nx, int ny){
        this.x = nx;
        this.y = ny;
    }
    public Coords(Coords nCoords){
        this.x = nCoords.getX();
        this.y = nCoords.getY();
    }
    public Coords() {
		this.x = 0;
        this.y = 0;
	}
	public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x_value){
        this.x = x_value;
    }
    public void setY(int y_value){
        this.y = y_value;
    }
    public void setCoords(Coords nCoords){
        this.x = nCoords.getX();
        this.y = nCoords.getY();
    }
    public boolean isInBoard(int aValue){
        return true;
    }
    public static Coords randomCoords(int size){
        return null;
    }

}