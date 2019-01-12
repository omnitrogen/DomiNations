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
    private ConsolePanel consoleWindow;

    private King next;

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
        boardGameWindow = new BoardGameWindow(this, currentGame.getPlayerList());
        dominoDeckWindow = new DeckPanel(new ArrayList<>(), this);

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
        next = currentGame.getNextKingToPlay();

        if (currentGame.isPlacementPhase()) {
            consoleWindow.log("Joueur " + next.getNbPlayer() + ", placez la premiere moitié de votre domino.");
            boardGameWindow.updateBoards(next.getNbPlayer(), next.getLocation());
        }
        else
            consoleWindow.log("Joueur " + next.getNbPlayer() + ", choisissez un domino parmi ceux de la pioche.");
    }

    public void askForSecondHalf() {
        consoleWindow.log("Joueur " + next.getNbPlayer() + ", placez la seconde moitié de votre domino.");
    }

    private void refreshDominoDeck() {
        boardAndDeckContainer.remove(dominoDeckWindow);

        ArrayList<Domino> deck = currentGame.pickDominosAtBeginningOfTurn();
        if (deck != null) {
            dominoDeckWindow = new DeckPanel(deck, this);

            boardAndDeckContainer.add(dominoDeckWindow);
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
        step();
    }

    public ConsolePanel getConsolePanel() {
        return consoleWindow;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        ImagePanel dominoPanel = (ImagePanel)mouseEvent.getComponent();

        if (dominoPanel.getDomino().getLinkedKing() == null) {
            dominoPanel.setBorder(BorderFactory.createLineBorder(currentGame.getPlayerList().get(next.getNbPlayer() - 1).getColor()));
            dominoPanel.getDomino().setLinkedKing(next);
            next.setLocation(dominoPanel.getDomino());
            currentGame.addDominoWithKing(dominoPanel.getDomino());
            step();
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
