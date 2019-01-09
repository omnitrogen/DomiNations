import javax.swing.*;
import java.awt.*;

public class BoardGameWindow extends JPanel {
    private JPanel boardsFrame;

    private JLabel board1;
    private JLabel board2;
    private JLabel board3;
    private JLabel board4;

    public BoardGameWindow() {
        initialize();
    }

    private void initialize() {
        boardsFrame = new JPanel();
        boardsFrame.setLayout(new GridLayout(2, 2));

        board1 = new JLabel("Board1");
        board2 = new JLabel("Board2");
        board3 = new JLabel("Board3");
        board4 = new JLabel("Board4");

        boardsFrame.add(board1);
        boardsFrame.add(board2);
        boardsFrame.add(board3);
        boardsFrame.add(board4);
    }

    public JPanel getBoardsFrame() {
        return boardsFrame;
    }
}
