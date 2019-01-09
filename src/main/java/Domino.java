import java.io.*;
import java.util.ArrayList;

public class Domino {
    private int number_;
    private HalfDomino left_;
    private HalfDomino right_;
    private King linkedKing_;

    public Domino(String line) {
        String[] splitted_line = line.split(",");
        left_ = new HalfDomino(Integer.parseInt(splitted_line[0]), splitted_line[1]);
        right_ = new HalfDomino(Integer.parseInt(splitted_line[2]), splitted_line[3]);
        number_ = Integer.parseInt(splitted_line[4]);
        linkedKing_ = null;
        
        left_.setParentNumber(number_);
        right_.setParentNumber(number_);
    }

    public int getNumber() {
        return number_;
    }

    public void setNumber(int number_) {
        this.number_ = number_;
    }

    public HalfDomino getLeft() {
        return left_;
    }

    public HalfDomino getRight() {
        return right_;
    }

    public King getLinkedKing() {
        return linkedKing_;
    }

    public void setLinkedKing(King king) {
        linkedKing_ = king;
    }

    public static ArrayList<Domino> getDominosFromCSV() {
        ArrayList<Domino> dominosList = new ArrayList<>();

        try {
            FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "/dominos.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            //Discard first line (header)
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                dominosList.add(new Domino(line));
            }
            
            return dominosList;
        } catch (Exception e) {
            System.out.println("Error: file not found");
        }

        return dominosList;
    }
}
