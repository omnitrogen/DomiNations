import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardGameWindow extends JPanel {
    private JPanel boardsFrame;
    private ConsolePanel console;
    private ArrayList<IndividualBoard> boards;

    public BoardGameWindow(ConsolePanel console, ArrayList<Player> players) {
        this.console = console;
        initialize(players);
    }

    private void initialize(ArrayList<Player> players) {
        boards = new ArrayList<>();

        int sizeX = 2;
        int sizeY = 2;

        boardsFrame = new JPanel();
        boardsFrame.setLayout(new GridLayout(sizeY, sizeX));

        for (int i = 0; i < players.size(); ++i) {
            IndividualBoard board = new IndividualBoard(players.get(i));
            board.setConsole(console);
            boards.add(board);
            boardsFrame.add((board.getBoardFrame()));
        }
    }

    public void updateBoards(int currentPlayer, Domino toPlace) {
        for (IndividualBoard board : boards)
            board.updateBoard(currentPlayer, toPlace);
    }

    public JPanel getBoardsFrame() {
        return boardsFrame;
    }
}
