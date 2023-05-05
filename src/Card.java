import java.awt.*;

public class Card {
    int windowHeight, windowLength;
    int x, y;
    Image cardImg;

    // When the num of times clicked is odd, it is the back of card
    int numClicked = 1;
    MemoryGameViewer game;

    public int getNumClicked(){
        return numClicked;
    }

    public void increaseNumClicked(){
        numClicked++;
    }

}
