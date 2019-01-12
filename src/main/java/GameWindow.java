import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private JFrame window;
    private JPanel boardAndDeckContainer;
    private JPanel box_layout;
    private JPanel tiles_map;
    private BoardGameWindow boardGameWindow;

    //FIXME: Change BoardGameWindow with DominoDeckWindow (or equivalent class)
    private JLabel dominoDeckWindow;

    private ConsolePanel consoleWindow;

    public GameWindow() {
        initialize();
    }

    private void initialize() {
        window = new JFrame("DomiNations");
        window.setMinimumSize(new Dimension(500, 500));
        window.setMaximumSize(new Dimension(500, 500));
        window.setResizable(false);

        consoleWindow = new ConsolePanel();
        boardGameWindow = new BoardGameWindow(consoleWindow);

        //FIXME: Change with corresponding constructors
        dominoDeckWindow = new JLabel("coucou");

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

    public static void main(String[] args) {
        GameWindow game = new GameWindow();
    }
}
