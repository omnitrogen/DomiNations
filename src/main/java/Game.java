import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game {

    private int numberOfPlayers;
    private ArrayList<Domino> deck;
    private ArrayList<Player> playerList;
    private HashMap<Integer, Domino> selectionBoard;
    private ArrayList<King> kingList;
    public static Random rand = new Random();

    public Game () {}

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.deck = Domino.getDominosFromCSV();
        for (int i = 0; i < numberOfPlayers; i++) {
            this.playerList.add(new Player(i + 1));
        }
        if (numberOfPlayers == 2) {
            for (int i = 1; i < 5; i++) {
                this.kingList.add(new King((i % 2) + 1));
            }
        } else {
            for (int i = 1; i < numberOfPlayers; i++) {
                this.kingList.add(new King(i));
            }
        }
//        this.selectionBoard = ;
    }


    /**
     * Initialize a Game.
     */
    public void initGame() {

    }

    /**
     * Pick n random element from the deck and return them in an ArrayList
     *
     * @param  n {@code int} the number of element to pick from the deck
     * @param  deck {@code ArrayList} the deck from which to pick the elements
     * @return an ArrayList {@code ArrayList} with n elements picked randomly in the deck and delete them from the deck
     */
    public ArrayList<Domino> pickNDominos(int n, ArrayList<Domino> deck) {
        ArrayList<Domino> nDominos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = rand.nextInt(deck.size());
            nDominos.add(deck.get(number));
            deck.remove(number);
        }
        return nDominos;
    }


//    public int[] chooseKingsOrder(ArrayList<King> kingList) {
//        ArrayList<Domino> nDominos = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int number = rand.nextInt(deck.size());
//            nDominos.add(deck.get(number));
//            deck.remove(number);
//        }
//        return nDominos;
//    }



    public static void main(String[] args) {
        // ...
    }
}