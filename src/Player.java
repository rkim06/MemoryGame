public class Player {
    private String name;
    private static int numPoints;
    private double time;

    public Player(int numPoints){
        // Figure out whole user input sitch
        this.name = "player 1";
        this.numPoints = numPoints;
    }

    public String getName(){
        return name;
    }

    public void increasePoints(){
        numPoints++;
    }

    public int getNumPoints(){
        return numPoints;
    }
}


