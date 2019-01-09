import javax.swing.*;
import java.awt.*;

public class ConsolePanel extends JPanel {
    private JPanel consoleFrame;
    private JScrollPane scroll;
    private JTextArea console;

    public ConsolePanel() {
        initialize();
    }

    private void initialize() {
        consoleFrame = new JPanel();
        console = new JTextArea();
        console.setEditable(false);
        console.setLineWrap(true);
        console.setWrapStyleWord(true);
        console.setRows(7);
        console.setColumns(60);

        scroll = new JScrollPane(console);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        consoleFrame.add(scroll);
        consoleFrame.setVisible(true);
    }

    public JPanel getConsoleFrame() {
        return consoleFrame;
    }

    public void log(String string) {
        console.append("\n");
        console.append(string);
        console.update(console.getGraphics());
    }
}
