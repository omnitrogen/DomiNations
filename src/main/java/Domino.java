import java.io.*;
import java.util.ArrayList;

public class Domino {
    private int number_;
    private HalfDomino left_;
    private HalfDomino right_;

    public Domino(String line) {
        String[] splitted_line = line.split(",");
        left_ = new HalfDomino(Integer.parseInt(splitted_line[0]), splitted_line[1]);
        right_ = new HalfDomino(Integer.parseInt(splitted_line[2]), splitted_line[3]);
        number_ = Integer.parseInt(splitted_line[4]);
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

            for (Domino domino : dominosList) {
                System.out.println("Numero: " + domino.getNumber() + ", left: " + domino.left_.getTerrain().toString() + ", right: " + domino.right_.getTerrain().toString());
            }

            return dominosList;
        } catch (Exception e) {
            System.out.println("Error: file not found");
        }

        return dominosList;
    }
}
