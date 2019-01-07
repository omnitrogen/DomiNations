import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame {

    private Panneau pan = new Panneau();
    // private Bouton bouton = new Bouton("Play");
    private JButton bouton = new JButton("Play");
    private JButton bouton2 = new JButton("Info");
    private Integer[] nombreJoueursList = {2, 3, 4};
    private JComboBox<Integer> combo = new JComboBox<Integer>(nombreJoueursList);
    private JPanel container = new JPanel();
    private JPanel containerBouton = new JPanel();
    JLabel label = new JLabel("Mon deuxième JLabel");

    private int compteur = 0;

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

        combo.setPreferredSize(new Dimension(100, 20));

        containerBouton.setBackground(Color.white);
        containerBouton.add(nombreJoueursLabel);
        containerBouton.add(combo);
        containerBouton.add(bouton);
        containerBouton.add(bouton2);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);
        container.add(label, BorderLayout.NORTH);
        container.add(containerBouton, BorderLayout.SOUTH);

        bouton.addActionListener(new BoutonListener());
        bouton2.addActionListener(new Bouton2Listener());

        this.setContentPane(container);

        this.setVisible(true);
    }

    class BoutonListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {
            label.setText("Vous avez cliqué sur le bouton 1");
        }
    }

    //Classe écoutant notre second bouton
    class Bouton2Listener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            label.setText("Vous avez cliqué sur le bouton 2");
        }
    }
}