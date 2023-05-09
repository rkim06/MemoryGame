import javax.swing.*;
import java.awt.*;

public class Card extends JFrame {
    private int xCoord, yCoord;
    private int row, col;
    private Image cardImg;
    private Image currentImg;
    private static Image cardBack;

    // When the num of times clicked is odd, it is the back of card
    int numClicked = 1;

    public Card (Image img, Image backImg, int xCoord, int yCoord){
        cardImg = img;
        currentImg = backImg;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    // Sets Images to blank
    public void setBlank(Image blank){
        cardImg = blank;
        cardBack = blank;
    }

    public Image getCurrentCard(){
        return currentImg;
    }

    public void cardClicked(){
        currentImg = cardImg;
    }
    public void switchCardImg(){

    }

    // If the card is turned over, then isClicked = true
    public boolean isClicked(){
        if(currentImg == cardImg){
            return true;
        }
        return false;
    }
    // If the card's pair has been found, return true
    // Used to then clear off the screen (aka cover with white rectangle)
    public boolean solved(){
        return true;
    }

    public void printImg(Graphics g){
        g.drawImage(currentImg, xCoord, yCoord, this);
    }

}
