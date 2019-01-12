import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener{
    private String name;
    private Image img;
    public Bouton(String str){
        super(str);
        this.name = str;
        this.setBackground(new Color(59, 89, 182));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setFont(new Font("Tahoma", Font.BOLD, 20));

        this.addMouseListener(this);
    }

    //Méthode appelée lors du clic de souris
    public void mouseClicked(MouseEvent event) {
        this.setBackground(new Color(159, 9, 2));
    }

    //Méthode appelée lors du survol de la souris
    public void mouseEntered(MouseEvent event) {
        this.setBackground(new Color(59, 189, 82));
    }

    //Méthode appelée lorsque la souris sort de la zone du bouton
    public void mouseExited(MouseEvent event) {
        this.setBackground(new Color(59, 89, 182));
    }

    //Méthode appelée lorsque l'on presse le bouton gauche de la souris
    public void mousePressed(MouseEvent event) {
        this.setBackground(new Color(159, 9, 2));
    }

    //Méthode appelée lorsque l'on relâche le clic de souris
    public void mouseReleased(MouseEvent event) {
        this.setBackground(new Color(159, 9, 2));
    }
}