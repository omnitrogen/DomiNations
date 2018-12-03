import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game {

    public static ArrayList<Domino> deck;
    public static ArrayList<Player> playerList;
    public static HashMap<Integer, Domino> selectionBoard = new HashMap<Integer, Domino>();
    public static int n;
    public static Random rand;

    public Game () {}

    public Game(ArrayList<Domino> deck, ArrayList<Player> playerList, HashMap<Integer, Domino> selectionBoard) {
        this.deck = deck;
        this.playerList = playerList;
        this.selectionBoard = selectionBoard;
    }


    /**
     * Initialize a Game.
     */
    public static void initGame() {

    }

    public static void readDominosFromCSV() {

    }

    /**
     * Pick n random element from the deck and return them in an ArrayList
     *
     * @param  n {@code int} the number of element to pick from the deck
     * @param  deck {@code ArrayList} the deck from which to pick the elements
     * @return an ArrayList {@code ArrayList} with n elements picked randomly in the deck and delete them from the deck
     */
    public static ArrayList<Domino> pickNDominos(int n, ArrayList<Domino> deck) {
        rand = new Random();
        ArrayList<Domino> nDominos = new ArrayList<Domino>();
        for (int i = 0; i < n; i++) {
            int number = rand.nextInt(deck.size());
            nDominos.add(deck.get(number));
            deck.remove(number);
        }
        return nDominos;
    }



    public static void main(String[] args) {
        // ...
    }
}