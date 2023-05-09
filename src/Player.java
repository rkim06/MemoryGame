public class Player {
    private String name;
    private int numPoints;
    private double time;

    public Player(int numPoints){
        // Figure out whole user input sitch
        this.name = "player 1";
        this.numPoints = numPoints;
    }

    public String getName(){
        return name;
    }

    public void increasePoint(){
        numPoints++;
    }

    public int getNumPoints(){
        return numPoints;
    }
}


