package ensta.model;

public class HitCoords{
    private Hit hit;
    private Coords coords;

    public HitCoords(Hit h, Coords c){
        this.hit = h;
        this.coords = c;
    }
    public Hit getHit(){
        return hit;
    }
    public Coords getCoords(){
        return coords;
    } 

}