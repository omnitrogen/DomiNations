import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private JFrame window;
    private JPanel boardAndDeckContainer;
    private JPanel box_layout;
    private JPanel tiles_map;
    private BoardGameWindow boardGameWindow;

    //FIXME: Change BoardGameWindow with DominoDeckWindow (or equivalent class)
    private BoardGameWindow dominoDeckWindow;

    //FIXME: Change BoardGameWindow with ConsoleWindow (or equivalent class)
    private BoardGameWindow consoleWindow;

    public GameWindow() {
        initialize();
    }

    private void initialize() {
        window = new JFrame("DomiNations");
        window.setMinimumSize(new Dimension(500, 500));

        boardGameWindow = new BoardGameWindow();

        //FIXME: Change with corresponding constructors
        dominoDeckWindow = new BoardGameWindow();
        consoleWindow = new BoardGameWindow();

        boardAndDeckContainer = new JPanel();
        boardAndDeckContainer.setLayout(new GridLayout(1, 2));
        boardAndDeckContainer.add(boardGameWindow.getBoardsFrame());
        boardAndDeckContainer.add(dominoDeckWindow.getBoardsFrame());

        window.setLayout(new GridLayout(2, 1));
        window.add(boardAndDeckContainer);
        window.add(consoleWindow.getBoardsFrame());

        window.setVisible(true);
    }

    public static void main(String[] args) {
        GameWindow game = new GameWindow();
    }
}
