import java.util.Scanner;

public class Menu {

    private int numberOfPlayers;

    public Menu () {}

    public void chooseNumberOfPlayers() {
        Scanner sc = new Scanner(System.in);
        setNumberOfPlayers(sc.nextInt());
    }

    public int getNumberOfPlayers() { return this.numberOfPlayers; }

    public void setNumberOfPlayers(int number) { this.numberOfPlayers = number; }

    public static void main(String[] args) {
        // insert game here ¯\_(ツ)_/¯
        Fenetre fen = new Fenetre();
    }

}
