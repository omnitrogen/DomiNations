import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image image;
    private Domino domino;

    public ImagePanel(Domino domino) {
        this.domino = domino;

        try {
            image = ImageIO.read(new File(domino.getPathToImg()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Domino getDomino() {
        return this.domino;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}