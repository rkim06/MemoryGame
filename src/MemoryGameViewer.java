import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class MemoryGameViewer extends JFrame implements MouseListener {
    private Image[] cardImgs;
    private Card[][] allCards;
    private Image instructions;
    private Image blank;
    private int first;
    private int windowWidth;
    private int windowHeight;
    private MemoryGame mGame;

    public MemoryGameViewer(int width, int height, Image cardBack, Image instructions, Image blank, Card[][] allCards, MemoryGame mGame) {
        // Initialize the image references so it shares the images with the Back-End
        windowWidth = width;
        windowHeight = height;

        this.mGame = mGame;

        this.cardImgs = cardImgs;
        this.blank = blank;
        this.instructions = instructions;

        // Initialize the JFrame.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MEMORY GAME");
        this.setSize(1000, 800);
        this.setVisible(true);

        this.allCards = allCards;
        addMouseListener(this);

        first = 1;
    }

    public boolean isFirstTime(){
        if(first == 1){
            return true;
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        int xMouse = e.getX();
        int yMouse = e.getY();

        // When the card is clicked, call the method that changes the card img
        mGame.whenCardClicked(xMouse, yMouse);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, windowWidth, windowHeight);

        // Prints the instructions only first time repaint is called
        if(isFirstTime() == true){
            g.drawImage(instructions, 100, 200, 800,400,this);
            // The instructions will appear on screen for 20 sec
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Covers instructions with a white block/erase
            g.fillRect(0, 0, windowWidth, windowHeight);
            first++;
        }

        // Prints all the cards
        for(int row = 0; row<allCards.length; row++){
            for(int col = 0; col<allCards[row].length; col++){
                allCards[row][col].printImg(g);
            }
        }

    }


}
