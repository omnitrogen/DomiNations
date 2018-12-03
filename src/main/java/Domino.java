import java.awt.*;

public class Domino {
    private int number_;
    private HalfDomino left_;
    private HalfDomino right_;

    public Domino()
    {

    }

    public int getNumber() {
        return number_;
    }

    public void setNumber(int number_) {
        this.number_ = number_;
    }

}
