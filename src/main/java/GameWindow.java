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
        boardGameWindow = new BoardGameWindow(consoleWindow, currentGame.getPlayerList());
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
    }

    private void startGame() {
        consoleWindow.log("Lancement du jeu !");
        step();
    }

    private void step() {
        if (currentGame.endOfTurn())
            refreshDominoDeck();

        callForNextPlayer();
    }

    private void callForNextPlayer() {
        King next = currentGame.getNextKingToPlay();
        consoleWindow.log("Joueur " + next.getNbPlayer() + ", choisissez un domino parmi ceux de la pioche.");
    }

    private void refreshDominoDeck() {
        boardAndDeckContainer.remove(dominoDeckWindow);

        ArrayList<Domino> deck = currentGame.pickDominosAtBeginningOfTurn();
        if (deck != null) {
            dominoDeckWindow = new DeckPanel(deck);

            boardAndDeckContainer.add(dominoDeckWindow);
            boardAndDeckContainer.revalidate();
            boardAndDeckContainer.repaint();
        }
        else {
            consoleWindow.log("Il n'y a plus de pioche, le jeu est fini !");
        }
    }
}
