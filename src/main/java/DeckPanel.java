import javax.swing.*;
import java.awt.*;
import java.util.*;


/**
 * On créer à chaque tour un deck, qui prend en entrée la liste turnDeck qui est le deck associé au tour.
 */
public class DeckPanel extends JPanel {
    public DeckPanel(ArrayList<Domino> deck) {
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
            //TODO: Find a way to link a Domino Object to his image
            JLabel image = new JLabel( new ImageIcon( "../res/d1.png"));
            containerLayout.setConstraints(image, gbc);
            this.add(image);
            i ++;
        }

    }
}