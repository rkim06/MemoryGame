import java.awt.*;
import javax.swing.*;
public class MemoryGameViewer extends JFrame{
    private Image cardBack;
    private Image[] cardImgs;
    private Image[][] cardLayoutImgs;
    private Image instructions;

    private int windowWidth;
    private int windowHeight;

    public MemoryGameViewer(int width, int height, Image cardBack, Image[] cardImgs) {
        // Initialize the image references so it shares the images with the Back-End
        windowWidth = width;
        windowHeight = height;

        this.cardBack = cardBack;
        this.cardImgs = cardImgs;

        // Initialize the JFrame.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MEMORY GAME");
        this.setSize(1000, 800);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, windowWidth, windowHeight);



    }

    //paints the instructions onto screen first
    public void instructions(Graphics g) {
        g.drawImage(instructions, );
    }

}
