import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;


public class Fenetre extends JFrame {

    // private Panneau pan = new Panneau();
    private Bouton bouton = new Bouton("Play");
    private Integer[] nombreJoueursList = {2, 3, 4};
    private JComboBox<Integer> combo = new JComboBox<Integer>(nombreJoueursList);
    private JPanel container = new JPanel();
    private JPanel containerJoueursNom = new JPanel();
    private JLabel label = new JLabel("DomiNations");
    private JLabel label2 = new JLabel("Nombre de joueurs:");

    private JTextField joueurUnNom = new JTextField();
    private JLabel joueurUnLabel = new JLabel("Nom du joueur 1: ");
    private JTextField joueurDeuxNom = new JTextField();
    private JLabel joueurDeuxLabel = new JLabel("Nom du joueur 2: ");
    private JTextField joueurTroisNom = new JTextField();
    private JLabel joueurTroisLabel = new JLabel("Nom du joueur 3: ");
    private JTextField joueurQuatreNom = new JTextField();
    private JLabel joueurQuatreLabel = new JLabel("Nom du joueur 4: ");


    public Fenetre(){
        this.setTitle("DomiNations");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Font font = new Font("Courrier", Font.PLAIN, 40);
        label.setFont(font);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);

        JLabel nombreJoueursLabel = new JLabel("Choisissez le nombre de joueurs: ");

        combo.setPreferredSize(new Dimension(100, 30));
        combo.addActionListener(new ItemAction());

        container.setBackground(Color.white);

        GridBagLayout containerLayout = new GridBagLayout();
        GridBagLayout containerJoueursNomLayout = new GridBagLayout();

        GridBagConstraints gbc = new GridBagConstraints();

        container.setLayout(containerLayout);
        containerJoueursNom.setLayout(containerJoueursNomLayout);

        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 1;

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
        containerLayout.setConstraints(label2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        containerLayout.setConstraints(combo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        containerLayout.setConstraints(containerJoueursNom, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        containerLayout.setConstraints(bouton, gbc);

        container.add(label);
        container.add(label2);
        container.add(combo);
        container.add(containerJoueursNom);
        container.add(bouton);

        bouton.addActionListener(new BoutonListener());

        this.setContentPane(container);

        this.setVisible(true);
    }

    class BoutonListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            // label.setText("Vous avez cliqué sur le bouton 1");
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