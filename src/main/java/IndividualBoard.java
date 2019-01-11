import javax.swing.*;
import java.awt.*;

public class IndividualBoard extends JPanel {
    private JPanel boardFrame;

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
                boardFrame.add(label);
            }
        }

        boardFrame.setVisible(true);
        boardFrame.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public JPanel getBoardFrame() {
        return boardFrame;
    }
}
