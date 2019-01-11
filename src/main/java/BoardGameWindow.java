import javax.swing.*;
import java.awt.*;

public class BoardGameWindow extends JPanel {
    private JPanel boardsFrame;

    public BoardGameWindow() {
        initialize();
    }

    private void initialize() {
        int sizeX = 2;
        int sizeY = 2;

        boardsFrame = new JPanel();
        boardsFrame.setLayout(new GridLayout(sizeY, sizeX));

        for (int i = 0; i < sizeX; ++i)
            for (int j = 0; j < sizeY; ++j)
                boardsFrame.add((new IndividualBoard()).getBoardFrame());
    }

    public JPanel getBoardsFrame() {
        return boardsFrame;
    }
}
