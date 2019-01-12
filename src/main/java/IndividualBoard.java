import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IndividualBoard extends JPanel implements MouseListener {
    private JPanel boardFrame;
    private ConsolePanel console;

    public IndividualBoard() {
        initialize();
    }

    private void initialize() {
        int sizeX = 9;
        int sizeY = 9;

        boardFrame = new JPanel();
        boardFrame.setLayout(new GridLayout(sizeY, sizeX));

        for (int i = 0; i < sizeX; ++i)
        {
            for (int j = 0; j < sizeY; ++j)
            {
                JLabel label = new JLabel();
                label.setVisible(true);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.addMouseListener(this);
                boardFrame.add(label);
            }
        }

        boardFrame.setVisible(true);
        boardFrame.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public JPanel getBoardFrame() {
        return boardFrame;
    }

    public void setConsole(ConsolePanel console) {
        this.console = console;
        console.log("Click");
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JLabel label = (JLabel)mouseEvent.getComponent();
        label.setOpaque(true);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/dd1.png"));
            label.setIcon(new ImageIcon(img));
        }
        catch (Exception e)
        {
            console.log("Error loading image: image not found.");
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}