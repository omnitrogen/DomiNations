import javax.swing.*; 

public class Main {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("yo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome to DomiNations");
        frame.add(label);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
		// commentaire
            }
        });
    }
}
