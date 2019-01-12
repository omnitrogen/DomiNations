import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Fenetre extends JFrame {

    private JFrame fenetre = new JFrame();
    private Bouton bouton = new Bouton("Play");
    private Integer[] nombreJoueursList = {2, 3, 4};
    private JComboBox<Integer> combo = new JComboBox<Integer>(nombreJoueursList);
    private Container container = new Container();
    private JPanel containerSelectNumber = new JPanel();
    private JPanel containerJoueursNom = new JPanel();
    private JLabel label = new JLabel("DomiNations");
    private JLabel label2 = new JLabel("Choisissez le nombre de joueurs:");

    private JTextField joueurUnNom = new JTextField();
    private JLabel joueurUnLabel = new JLabel("Nom du joueur 1: ");
    private JTextField joueurDeuxNom = new JTextField();
    private JLabel joueurDeuxLabel = new JLabel("Nom du joueur 2: ");
    private JTextField joueurTroisNom = new JTextField();
    private JLabel joueurTroisLabel = new JLabel("Nom du joueur 3: ");
    private JTextField joueurQuatreNom = new JTextField();
    private JLabel joueurQuatreLabel = new JLabel("Nom du joueur 4: ");


    public Fenetre(){
        fenetre.setTitle("DomiNations");
        fenetre.setSize(1000, 800);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);

        Font font = new Font("Courrier", Font.PLAIN, 50);
        label.setFont(font);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);
        Font font2 = new Font("Courrier", Font.PLAIN, 25);
        label2.setFont(font2);
        label2.setHorizontalAlignment(JLabel.CENTER);
        joueurUnLabel.setFont(font2);
        joueurUnLabel.setHorizontalAlignment(JLabel.CENTER);
        joueurDeuxLabel.setFont(font2);
        joueurDeuxLabel.setHorizontalAlignment(JLabel.CENTER);
        joueurTroisLabel.setFont(font2);
        joueurTroisLabel.setHorizontalAlignment(JLabel.CENTER);
        joueurQuatreLabel.setFont(font2);
        joueurQuatreLabel.setHorizontalAlignment(JLabel.CENTER);

        combo.setPreferredSize(new Dimension(100, 30));
        combo.addActionListener(new ItemAction());

        container.setBackground(new Color(0,0,0,0));
        containerSelectNumber.setBackground(new Color(0,0,0,0));
        containerJoueursNom.setBackground(new Color(0,0,0,0));

        GridBagLayout containerLayout = new GridBagLayout();
        GridBagLayout containerSelectNumberLayout = new GridBagLayout();
        GridBagLayout containerJoueursNomLayout = new GridBagLayout();

        GridBagConstraints gbc = new GridBagConstraints();

        container.setLayout(containerLayout);
        containerSelectNumber.setLayout(containerSelectNumberLayout);
        containerJoueursNom.setLayout(containerJoueursNomLayout);

        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 20;
        containerSelectNumberLayout.setConstraints(label2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        containerSelectNumberLayout.setConstraints(combo, gbc);

        containerSelectNumber.add(label2);
        containerSelectNumber.add(combo);

        gbc.ipadx = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        containerJoueursNomLayout.setConstraints(joueurUnLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        containerJoueursNomLayout.setConstraints(joueurUnNom, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        containerJoueursNomLayout.setConstraints(joueurDeuxLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        containerJoueursNomLayout.setConstraints(joueurDeuxNom, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        containerJoueursNomLayout.setConstraints(joueurTroisLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        containerJoueursNomLayout.setConstraints(joueurTroisNom, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        containerJoueursNomLayout.setConstraints(joueurQuatreLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        containerJoueursNomLayout.setConstraints(joueurQuatreNom, gbc);
        gbc.fill = GridBagConstraints.NONE;

        containerJoueursNom.add(joueurUnLabel);
        containerJoueursNom.add(joueurUnNom);
        containerJoueursNom.add(joueurDeuxLabel);
        containerJoueursNom.add(joueurDeuxNom);
        containerJoueursNom.add(joueurTroisLabel);
        containerJoueursNom.add(joueurTroisNom);
        containerJoueursNom.add(joueurQuatreLabel);
        containerJoueursNom.add(joueurQuatreNom);

        joueurTroisLabel.setVisible(false);
        joueurTroisNom.setVisible(false);
        joueurQuatreLabel.setVisible(false);
        joueurQuatreNom.setVisible(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        containerLayout.setConstraints(label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        containerLayout.setConstraints(containerSelectNumber, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        containerLayout.setConstraints(containerJoueursNom, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        containerLayout.setConstraints(bouton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        //containerLayout.setConstraints(deck, gbc);

        container.add(label);
        container.add(containerSelectNumber);
        container.add(containerJoueursNom);
        container.add(bouton);
        //container.add(deck);

        bouton.addActionListener(new BoutonListener());

        fenetre.setContentPane(container);

        fenetre.setVisible(true);
    }

    class BoutonListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            ArrayList<String> playerNames = new ArrayList<>();
            playerNames.add((joueurUnNom.getText().isEmpty()) ? "Joueur 1" : joueurUnNom.getText());
            playerNames.add((joueurDeuxNom.getText().isEmpty()) ? "Joueur 2" : joueurDeuxNom.getText());

            if ((Integer)combo.getSelectedItem() >= 3)
                playerNames.add((joueurTroisNom.getText().isEmpty()) ? "Joueur 3" : joueurTroisNom.getText());

            if ((Integer)combo.getSelectedItem() == 4)
                playerNames.add((joueurQuatreNom.getText().isEmpty()) ? "Joueur 4" : joueurQuatreNom.getText());

            Game game = new Game(playerNames);
            GameWindow window = new GameWindow(game);

            fenetre.setVisible(false);
            fenetre.dispose();

        }
    }

    class ItemAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ((Integer)combo.getSelectedItem() == 3) {
                joueurTroisLabel.setVisible(true);
                joueurTroisNom.setVisible(true);
                joueurQuatreLabel.setVisible(false);
                joueurQuatreNom.setVisible(false);
            } else if ((Integer)combo.getSelectedItem() == 4) {
                joueurTroisLabel.setVisible(true);
                joueurTroisNom.setVisible(true);
                joueurQuatreLabel.setVisible(true);
                joueurQuatreNom.setVisible(true);
            } else {
                joueurTroisLabel.setVisible(false);
                joueurTroisNom.setVisible(false);
                joueurQuatreLabel.setVisible(false);
                joueurQuatreNom.setVisible(false);
            }
        }
    }

}