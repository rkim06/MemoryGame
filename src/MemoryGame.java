import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class MemoryGame {

    private Player p;
    private MemoryGameViewer window;
    private Image[] cardImgs;
    private Card[][] allCards;
    private static Image cardBack;
    private static Image blank;
    private Image instructions;
    private int xMouse, yMouse;
    private Queue<Card> queueClickedCards;
    private final int NONE_FLIPPED = 1;
    private final int ONE_FLIPPED = 2;
    private static final int TWO_FLIPPED = 3;
    private static int state;

    private static final int MAX_WIDTH = 1000;		// Window size
    private static final int MAX_HEIGHT = 800;		// Window size

    public MemoryGame(){
        cardImgs = new Image[10];
        allCards = new Card[4][5];
        queueClickedCards = new LinkedList<Card>();
        state = 1;

        for(int i = 0; i<10; i++){
            cardImgs[i] = new ImageIcon("Resources/cd"+(i+1)+".png").getImage();
        }

        //initialize the image of card back, instructions, and blank
        cardBack = new ImageIcon("Resources/cdBack.png").getImage();
        instructions = new ImageIcon("Resources/instructions.png").getImage();
        blank = new ImageIcon("Resources/blank.png").getImage();

        // Initialize the player and the 2D array of cards
        p = new Player(0);
        initializeCards();

        window = new MemoryGameViewer(MAX_WIDTH, MAX_HEIGHT, cardBack, instructions, blank, allCards, this);
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

        int xCoord = 55;
        int yCoord = 50;

        int count = 0;
        for(int row = 0; row<allCards.length; row++){
            for(int col = 0; col<allCards[row].length; col++){
                // New card is created and added to the 4 by 5 2D array
                allCards[row][col] = new Card(cardImgs[nums.get(count)], cardBack, xCoord, yCoord);
                count++;

                xCoord += 165;
            }
            // Reset the X coordinate to the start of the row
            xCoord = 55;
            yCoord += 165;
        }
    }

    // When the card is clicked, change the card image to the front ver
    // The one that is clicked should be the one changed, based on the coordinates of the mousePressed
    public void whenCardClicked(int xMouse, int yMouse)
    {
        int minX = 55;
        int maxX = 200;
        int minY = 50;
        int maxY = 190;

        // If the mouse is clicked in a certain area (on the card)
        // switch the card from back to front and print
        for (int i = 0; i<allCards.length; i++){
            for(int j = 0; j<allCards[i].length; j++){
                if((xMouse >= minX && xMouse <= maxX) && (yMouse >= minY && yMouse <= maxY)){
                    // Changes the card's current image to the front face
                    // And repaints the cards to the faceUp ver
                    allCards[i][j].setFront();
                    // Adds the clicked card to a queue
                    queueClickedCards.add(allCards[i][j]);
                    window.repaint();

                    // Check to see if the card clicked is of a pair
                    // Can't check for a pair if only one card has been clicked
                    if(queueClickedCards.size() > 1) {
                        Card cd1 = queueClickedCards.remove();
                        Card cd2 = queueClickedCards.peek();
                        if(comparePair(cd1, cd2)){
                            // Increase the number of points to signify a pair found
                            p.increasePoints();
                        }
                    }

                    return;
                }

                minX += 165;
                maxX += 165;
            }
            // Reset the min and max X coordinates to the start of the row
            minX = 55;
            maxX = 200;
            minY += 165;
            maxY += 165;
        }

        // Repaint the window after the card has either been found as a pair or
        window.repaint();
    }

    // Takes in two cards and compares them
    public boolean comparePair(Card cd1, Card cd2){;
        // If the two cards are the same, then the card becomes blank and covered
        if(cd1 == cd2){
            cd1.setFront();
            // Show the paired cards for 2 sec
            window.repaint();

            cd1.setBlank(blank);
            cd2.setBlank(blank);
            // Remove the second card of the pair from the queue
            queueClickedCards.remove();
            return true;
        }
        return false;
    }

    public void playGame(){
        window.repaint();

        // Run loop until all the cards are turned over
        while(p.getNumPoints() < 10){

        }

    }



    public static void main(String[] args) {
        MemoryGame mg = new MemoryGame();
        mg.playGame();
    }
}