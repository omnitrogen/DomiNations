import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.*;


/**
 * On créer à chaque tour un deck, qui prend en entrée la liste turnDeck qui est le deck associé au tour.
 */
public class DeckPanel extends JPanel {
    public DeckPanel(ArrayList<Domino> deck, MouseListener mouseListener) {
        GridBagLayout containerLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        this.setLayout(containerLayout);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 1;

        int i = 0;
        for (Domino domino: deck) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.ipadx = 146;
            gbc.ipady = 62;
            ImagePanel image = new ImagePanel(domino);
            image.addMouseListener(mouseListener);
            containerLayout.setConstraints(image, gbc);
            this.add(image);
            i++;
        }

    }
}