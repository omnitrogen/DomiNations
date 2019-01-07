import java.util.*;
import java.awt.Color;
import java.util.Random;

public class Ia {
	
	private int xLeft;
	private int xRight;
	private int yLeft;
	private int yRight;

	private int number_;
    private int score_;
    private Color color_;

    public Ia(int number) {
        number_ = number;
        score_ = 0;

        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        color_ = new Color(r, g, b);
    }

    public int getScore() {
        return score_;
    }

    public void setScore(int score_) {
        this.score_ = score_;
    }

    public Color getColor() {
        return color_;
    }

    public int getNumber() {
        return number_;
    }

	public boolean playIa(){
		for(xLeft = 0; xLeft <= 9; xLeft++){
			for(yLeft = 0; yLeft <= 9; yLeft++){
				for(xRight = xLeft - 1; xRight <= xLeft + 1; xRight++){
					for(yRight = xRight - 1; yRight <= xRight + 1; yRight++){
						if(BoardGame.checkDominoWellPlaced(domino, xLeft, yLeft, xRight, yRight) == true){
							return true;
						}
						return false;
					}
				}
			}
		}
	}
}