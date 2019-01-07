import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JPanel;


public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
        Font font = new Font("Courrier", Font.PLAIN, 40);
        g.setFont(font);
        g.drawString("Welcome to DomiNations", 270, 50);
        try {
            Image img = ImageIO.read(new File("img.jpg"));
            g.drawImage(img, 370, 100, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}