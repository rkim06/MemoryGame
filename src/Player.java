public class Player {
    private String name;
    private int numPoints;
    private double time;

    public Player(String name){
        this.name = name;
    }
    public Player(String name, int numPoints){
        this.name = name;
        this.numPoints = numPoints;
    }

    public String getName(){
        return name;
    }

    public void increasePoint(){
        numPoints++;
    }
}
