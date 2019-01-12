import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Game {

    private int numberOfPlayers;
    private ArrayList<Domino> deck;
    private ArrayList<Domino> deckWithKings;
    private ArrayList<Domino> turnDeck;
    private ArrayList<Player> playerList;
    private HashMap<Integer, Domino> selectionBoard;
    private ArrayList<King> kingList;
    public static Random rand = new Random();

    public Game () {}

    public Game(ArrayList<String> playerNames) {
        this.numberOfPlayers = playerNames.size();
        this.deck = Domino.getDominosFromCSV();
        turnDeck = new ArrayList<>();
        playerList = new ArrayList<>();
        kingList = new ArrayList<>();
        deckWithKings = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            this.playerList.add(new Player(i + 1, playerNames.get(i)));
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

        Collections.shuffle(kingList);

        int amountToThrow = 0;
        if (numberOfPlayers == 2)
            amountToThrow = 24;
        else if (numberOfPlayers == 3)
            amountToThrow = 12;

        for (int i = 0; i < amountToThrow; ++i)
        {
            int index = rand.nextInt(deck.size());
            deck.remove(index);
        }
    }

    /**
     * Pick n random elements from the deck and return them in an ArrayList
     * @param  n {@code int} the number of element to pick from the deck
     * @return an ArrayList {@code ArrayList} with n elements picked randomly in the deck and delete them from the deck
     */
    public ArrayList<Domino> pickNDominos(int n) {
        ArrayList<Domino> newDeck = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = rand.nextInt(deck.size());
            newDeck.add(deck.get(number));
            deck.remove(number);
        }
        return newDeck;
    }

    /**
     * Pick numberOfKings elements from the deck and place them in turnDeck
     */
    public ArrayList<Domino> pickDominosAtBeginningOfTurn() {
        if (turnDeck.size() != 0)
        {
            deckWithKings.clear();
            deckWithKings.addAll(turnDeck);
            turnDeck.clear();
        }

        turnDeck = pickNDominos(kingList.size());

        return turnDeck;
    }

    /**
     * @return the next king to play (and thus the number of the next player to play)
     */
    public King getNextKingToPlay() {
        //If not the 1st turn (some dominos are picked, and thus placed in deckWithKings)
        if (deckWithKings.size() > 0)
        {
            Domino minimum = null;

            for (Domino d : deckWithKings)
            {
                if (d.getLinkedKing() != null && (minimum == null || d.getNumber() < minimum.getNumber()))
                    minimum = d;
            }

            return minimum.getLinkedKing();
        }
        else
        {
            for (King k : kingList)
            {
                if (k.getLocation() == null)
                    return k;
            }
        }

        //Should not happen
        return null;
    }
}