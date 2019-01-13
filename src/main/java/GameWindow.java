import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameWindow implements MouseListener {
    private JFrame window;
    private JPanel boardAndDeckContainer;
    private BoardGameWindow boardGameWindow;

    private Game currentGame;
    private DeckPanel dominoDeckWindow;
    private DeckPanel dominoDeckWindowBis;
    private ArrayList<DeckPanel> deckQueue;
    private ConsolePanel consoleWindow;

    private King next;

    public GameWindow(Game game) {
        currentGame = game;
        initialize();
        startGame();
    }

    private void initialize() {
        window = new JFrame("DomiNations");
        window.setMinimumSize(new Dimension(900, 900));
        window.setMaximumSize(new Dimension(900, 900));
        window.setResizable(false);

        consoleWindow = new ConsolePanel();
        boardGameWindow = new BoardGameWindow(this, currentGame.getPlayerList());
        dominoDeckWindow = new DeckPanel(new ArrayList<>(), this);
        dominoDeckWindowBis = new DeckPanel(new ArrayList<>(), this);
        deckQueue = new ArrayList<>();
        deckQueue.add(dominoDeckWindow);
        deckQueue.add(dominoDeckWindowBis);

        boardAndDeckContainer = new JPanel();
        boardAndDeckContainer.setLayout(new GridLayout(1, 2));
        boardAndDeckContainer.add(boardGameWindow.getBoardsFrame());
        boardAndDeckContainer.add(dominoDeckWindow);
        boardAndDeckContainer.add(dominoDeckWindowBis);

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
        if (currentGame.endOfTurn()) {
            refreshDominoDeck();
        }

        callForNextPlayer();
    }

    private void callForNextPlayer() {
        next = currentGame.getNextKingToPlay();

        if (currentGame.isPlacementPhase()) {
            consoleWindow.log(currentGame.getPlayerList().get(next.getNbPlayer() - 1).getName() + ", placez la premiere moitié de votre domino.");
            boardGameWindow.updateBoards(next.getNbPlayer(), next.getLocation());
        }
        else
            consoleWindow.log(currentGame.getPlayerList().get(next.getNbPlayer() - 1).getName() +  ", choisissez un domino parmi ceux de la pioche.");
    }

    public void askForSecondHalf() {
        consoleWindow.log(currentGame.getPlayerList().get(next.getNbPlayer() - 1).getName() +  ", placez la seconde moitié de votre domino.");
    }

    private void refreshDominoDeck() {
        boardAndDeckContainer.remove(deckQueue.get(0));
        deckQueue.remove(0);

        ArrayList<Domino> deck = currentGame.pickDominosAtBeginningOfTurn();
        if (deck != null) {
            DeckPanel current = new DeckPanel(deck, this);

            deckQueue.add(current);
            boardAndDeckContainer.add(current);
            boardAndDeckContainer.revalidate();
            boardAndDeckContainer.repaint();
        }
        else {
            consoleWindow.log("Il n'y a plus de pioche, le jeu est fini !");

            Player winner = null;

            for (Player p : currentGame.getPlayerList()) {
                p.calculatePlayerScore();
                if (winner == null || (p.getScore() > winner.getScore()))
                    winner = p;
            }

            consoleWindow.log("Le gagnant est: " + winner.getName());
        }
    }

    public void endOfPlacement() {
        currentGame.removeDominoWithKing(next.getLocation());
        next.getLocation().setLinkedKing(null);
        next.setLocation(null);
        currentGame.enqueueKing(next);
        step();
    }

    public ConsolePanel getConsolePanel() {
        return consoleWindow;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getComponent().getX() >= 142) {
            ImagePanel dominoPanel = (ImagePanel)mouseEvent.getComponent();

            if (dominoPanel.getDomino().getLinkedKing() == null) {
                dominoPanel.setBorder(BorderFactory.createLineBorder(currentGame.getPlayerList().get(next.getNbPlayer() - 1).getColor()));
                dominoPanel.getDomino().setLinkedKing(next);
                next.setLocation(dominoPanel.getDomino());
                currentGame.addDominoWithKing(dominoPanel.getDomino());
                step();
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
