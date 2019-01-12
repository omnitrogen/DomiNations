import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class IndividualBoard extends JPanel implements MouseListener {
    private JPanel boardFrame;
    private ConsolePanel console;
    private Player owner;
    private boolean isActive;
    private Domino toPlace;
    private ArrayList<JLabel> layout;
    private GameWindow gameWindow;
    private boolean firstClick;
    private JLabel firstClickLabel;

    public IndividualBoard(Player player) {
        initialize(player);
    }

    private void initialize(Player player) {
        owner = player;
        isActive = false;
        firstClick = true;

        int sizeX = 9;
        int sizeY = 9;

        boardFrame = new JPanel();
        layout = new ArrayList<>();
        boardFrame.setLayout(new GridLayout(sizeY, sizeX));

        for (int i = 0; i < sizeX; ++i)
        {
            for (int j = 0; j < sizeY; ++j)
            {
                JLabel label = new JLabel();
                label.setVisible(true);
                if (i == sizeX / 2 && j == sizeY / 2) {
                    label.setBackground(player.getColor());
                    label.setOpaque(true);
                }
                else
                    label.setBorder(BorderFactory.createLineBorder(player.getColor()));
                label.addMouseListener(this);
                layout.add(label);
                boardFrame.add(label);
            }
        }

        boardFrame.setVisible(true);
    }

    public JPanel getBoardFrame() {
        return boardFrame;
    }

    public void setConsole(ConsolePanel console) {
        this.console = console;
    }

    public void setGameWindow(GameWindow window) {
        this.gameWindow = window;
    }

    public void updateBoard(int currentPlayer, Domino toPlace) {
        if (currentPlayer == owner.getNumber()) {
            isActive = true;
            this.toPlace = toPlace;
        }
        else {
            isActive = false;
            this.toPlace = null;
        }
    }

    public boolean areAdjacent(JLabel label1, JLabel label2) {
        int index1 = layout.indexOf(label1);
        int index2 = layout.indexOf(label2);

        //label 2 left of label 1
        if ((index1 % 9) > 0 && index1 - index2 == 1)
            return true;

        //label 2 right of label 1
        if ((index1 % 9 < 8 && index2 - index1 == 1))
            return true;

        //label 2 under label 1
        if ((index1 / 9 < 8) && index2 - index1 == 9)
            return true;

        //label 2 above label 1
        if ((index1 / 9 > 0 && index1 - index2 == 9))
            return true;

        return false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //FIXME: verifications au placement
        if (isActive) {
            JLabel label = (JLabel) mouseEvent.getComponent();

            if (firstClick || (!firstClick && areAdjacent(label, firstClickLabel))) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(toPlace.getPathToImg()));

                    BufferedImage resized = new BufferedImage(mouseEvent.getComponent().getWidth(), mouseEvent.getComponent().getHeight(), img.getType());
                    Graphics2D graphics = resized.createGraphics();
                    graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    if (firstClick)
                        graphics.drawImage(img, 0, 0, mouseEvent.getComponent().getWidth(), mouseEvent.getComponent().getHeight(), 0, 0, img.getWidth() / 2, img.getHeight(), null);
                    else
                        graphics.drawImage(img, 0, 0, mouseEvent.getComponent().getWidth(), mouseEvent.getComponent().getHeight(), img.getWidth() / 2, 0, img.getWidth(), img.getHeight(), null);
                    graphics.dispose();
                    label.setOpaque(true);
                    label.setIcon(new ImageIcon(resized));

                    firstClick = !firstClick;
                    if (firstClick) {
                        isActive = false;
                        firstClickLabel = null;
                        gameWindow.endOfPlacement();
                    } else {
                        firstClickLabel = label;
                        gameWindow.askForSecondHalf();
                    }
                } catch (IOException e) {
                    console.log("Error loading image: image not found.");
                }
            }
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
