import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardGameWindow extends JPanel {
    private JPanel boardsFrame;
    private ConsolePanel console;

    public BoardGameWindow(ConsolePanel console, ArrayList<Player> players) {
        this.console = console;
        initialize(players);
    }

    private void initialize(ArrayList<Player> players) {
        int sizeX = 2;
        int sizeY = 2;

        boardsFrame = new JPanel();
        boardsFrame.setLayout(new GridLayout(sizeY, sizeX));

        for (int i = 0; i < players.size(); ++i) {
            IndividualBoard board = new IndividualBoard(players.get(i));
            board.setConsole(console);
            boardsFrame.add((board.getBoardFrame()));
        }
    }

    public JPanel getBoardsFrame() {
        return boardsFrame;
    }
}
