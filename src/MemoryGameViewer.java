import java.awt.*;
import javax.swing.*;
public class MemoryGameViewer extends JFrame{
    private Image[] cardImgs;
    private Card[][] allCards;
    private Image instructions;
    private Image blank;
    private int first;

    private int windowWidth;
    private int windowHeight;

    public MemoryGameViewer(int width, int height, Image cardBack, Image instructions, Image blank, Card[][] allCards) {
        // Initialize the image references so it shares the images with the Back-End
        windowWidth = width;
        windowHeight = height;

        this.cardImgs = cardImgs;
        this.blank = blank;

        // Initialize the JFrame.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MEMORY GAME");
        this.setSize(1000, 800);
        this.setVisible(true);

        this.allCards = new Card[allCards.length][allCards[0].length];
        for(int row = 0; row<allCards.length; row++){
            for(int col = 0; col<allCards[row].length; col++){
                this.allCards[row][col] = allCards[row][col];
            }
        }

        first = 1;
    }

    public boolean isFirstTime(){
        if(first == 1){
            return true;
        }
        return false;
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, windowWidth, windowHeight);

        System.out.print("break");

        // Prints the instructions only first time repaint is called
        if(isFirstTime()){
            g.drawImage(instructions, 250, 250, this);
            // The instructions will appear on screen for 10 sec
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Covers instructions with a white block/erase
            g.fillRect(0, 0, windowWidth, windowHeight);
        }

        // Prints all the cards
        for(int row = 0; row<allCards.length; row++){
            for(int col = 0; col<allCards[row].length; col++){
                allCards[row][col].printImg(g);
            }
        }

    }


}
