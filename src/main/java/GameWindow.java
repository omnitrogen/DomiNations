import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow {
    private JFrame window;
    private JPanel boardAndDeckContainer;
    private JPanel box_layout;
    private JPanel tiles_map;
    private BoardGameWindow boardGameWindow;

    private Game currentGame;

    private DeckPanel dominoDeckWindow;

    private ConsolePanel consoleWindow;

    public GameWindow(Game game) {
        currentGame = game;
        initialize();
        startGame();
    }

    private void initialize() {
        window = new JFrame("DomiNations");
        window.setMinimumSize(new Dimension(500, 500));
        window.setMaximumSize(new Dimension(500, 500));
        window.setResizable(false);

        consoleWindow = new ConsolePanel();
        boardGameWindow = new BoardGameWindow(consoleWindow);
        dominoDeckWindow = new DeckPanel(new ArrayList<>());

        boardAndDeckContainer = new JPanel();
        boardAndDeckContainer.setLayout(new GridLayout(1, 2));
        boardAndDeckContainer.add(boardGameWindow.getBoardsFrame());
        boardAndDeckContainer.add(dominoDeckWindow);

        window.setLayout(new BorderLayout());
        window.add(boardAndDeckContainer, BorderLayout.CENTER);
        window.add(consoleWindow.getConsoleFrame(), BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);

        startGame();
    }

    private void startGame() {
        ArrayList<Domino> deck = currentGame.pickDominosAtBeginningOfTurn();
        dominoDeckWindow = new DeckPanel(deck);
        dominoDeckWindow.update(dominoDeckWindow.getGraphics());
    }
}
