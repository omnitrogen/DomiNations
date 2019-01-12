import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class IndividualBoard extends JPanel implements MouseListener {
    private JPanel boardFrame;
    private ConsolePanel console;
    private Player owner;
    private boolean isActive;
    private Domino toPlace;
    private ArrayList<JLabel> layout;

    public IndividualBoard(Player player) {
        initialize(player);
    }

    private void initialize(Player player) {
        owner = player;
        isActive = false;

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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //FIXME: verifications au placement
        if (isActive) {
            JLabel label = (JLabel) mouseEvent.getComponent();
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(toPlace.getPathToImg()));

                BufferedImage resized = new BufferedImage(mouseEvent.getComponent().getWidth(), mouseEvent.getComponent().getHeight(), img.getType());
                Graphics2D graphics = resized.createGraphics();
                graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                graphics.drawImage(img, 0, 0, mouseEvent.getComponent().getWidth(), mouseEvent.getComponent().getHeight(), 0, 0, img.getWidth() / 2, img.getHeight(), null);
                graphics.dispose();
                label.setOpaque(true);
                label.setIcon(new ImageIcon(resized));

                JLabel secondHalf = layout.get(layout.indexOf(label) + 1);

                resized = new BufferedImage(mouseEvent.getComponent().getWidth(), mouseEvent.getComponent().getHeight(), img.getType());
                graphics = resized.createGraphics();
                graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                graphics.drawImage(img, 0, 0, mouseEvent.getComponent().getWidth(), mouseEvent.getComponent().getHeight(), img.getWidth() / 2, 0, img.getWidth(), img.getHeight(), null);
                graphics.dispose();
                secondHalf.setOpaque(true);
                secondHalf.setIcon(new ImageIcon(resized));

            } catch (Exception e) {
                console.log("Error loading image: image not found.");
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
