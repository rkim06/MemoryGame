import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class MemoryGame extends JFrame implements MouseListener {

    private Player p;
    private MemoryGameViewer window;
    private Image[] cardImgs;
    private Card[][] allCards;
    private static Image cardBack;
    private static Image blank;
    private Image instructions;
    private int xMouse, yMouse;
    private Queue<Integer> queueClickedCards;

    private static final int MAX_WIDTH = 1000;		// Window size
    private static final int MAX_HEIGHT = 800;		// Window size

    public MemoryGame(){
        cardImgs = new Image[10];
        allCards = new Card[4][5];
        queueClickedCards = new LinkedList<Integer>();

        for(int i = 0; i<10; i++){
            cardImgs[i] = new ImageIcon("Resources/cd"+(i+1)+".png").getImage();
        }

        //initialize the image of card back, instructions, and blank
        cardBack = new ImageIcon("Resources/cdBack.png").getImage();
        instructions = new ImageIcon("Resources/instructions.png").getImage();
        blank = new ImageIcon("Resources/blank.png").getImage();

        // Initialize the User Interface
        setSize(MAX_WIDTH, MAX_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window = new MemoryGameViewer(MAX_WIDTH, MAX_HEIGHT, cardBack, instructions, blank, allCards);

        addMouseListener(this);
    }

    // Sets up the grid of 4 by 5 cards in the beginning
    // There are two of each card in the set of 20 and all in a random configuration
    // New random order each time playgame is called
    public void initializeCards(){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        // Creates an arraylist of ints from 0-9 double
        for (int i = 0; i<20; i++){
            nums.add(i/2);
        }

        // Java class existing algorithm to shuffle nums
        Collections.shuffle(nums);

        int xCoord = 48;
        int yCoord = 45;

        int count = 0;
        for(int row = 0; row<allCards.length; row++){
            for(int col = 0; col<allCards[row].length; col++){
                // New card is created and added to the 4 by 5 2D array
                allCards[row][col] = new Card(cardImgs[nums.get(count)], cardBack, xCoord, yCoord);
                count++;

                xCoord += 195;
                yCoord += 195;
            }
        }
    }

    // Takes in two cards and compares them
    public void comparePair(Card cd1, Card cd2){;
        // If the two cards are the same, then
        if(cd1 == cd2){
            cd1.setBlank(blank);
            cd2.setBlank(blank);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked event handler executed");
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        xMouse = e.getX();
        yMouse = e.getY();

        if(xMouse)

        System.out.println("mousePressed event handler executed.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased event handler executed.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered event handler executed.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited event handler executed.");
    }

    public void oneRound(){

    }

    public void playGame(){
        p = new Player(0);

        initializeCards();
        window.repaint();

        while(p.getNumPoints() < 10){

        }

    }



    public static void main(String[] args) {
        MemoryGame mg = new MemoryGame();
        mg.playGame();
    }
}