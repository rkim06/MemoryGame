import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class MemoryGame extends JFrame implements MouseListener, MouseMotionListener {

    private Player p;
    private MemoryGameViewer window;
    private Image[] cardImgs;
    private Card[][]
    private Image cardBack;
    private Image instructions;

    private static final int MAX_WIDTH = 1000;		// Window size
    private static final int MAX_HEIGHT = 800;		// Window size

    public MemoryGame(){
        for(int i = 0; i<10; i++){
            cardImgs[i] = new ImageIcon("Resources/cd"+(i+1)+".png").getImage();
        }


        //initialize the image of card back
        cardBack = new ImageIcon("Resources/cdBack.png").getImage();
        instructions = new ImageIcon("Resources/instructions.png").getImage();
    }

    // Takes in two cards and compares them
    public boolean comparePair(int numCd1, int numCd2){
        // If the two cards are the same, then
        if(numCd1 == numCd2){
            return true;
        }
        return false;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        //
        increaseNumClicked()++;

        ();

        // For demo purposes only
        System.out.println("mousePressed event handler executed.");
    }

    //deals with all the key viewed stuff to get user input for name
    public String typeName(){
        
    }

    public void playGame(){
        p = new Player(typeName(), 0);
        instructions();
    }



    public static void main(String[] args) {
        MemoryGame mg = new MemoryGame();
        mg.playGame();
    }
}