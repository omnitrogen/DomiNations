import java.awt.Color;
import java.util.Random;

public class Player {
    private int number_;
    private int score_;
    private Color color_;
    private BoardGame boardGamePlayer_;

    public Player(int number) {
        number_ = number;
        score_ = 0;
        boardGamePlayer_ = new BoardGame(number);

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
    
    public void calculatePlayerScore(int id) {
    	for (int i = 0; i < BoardGame.gameBoardSize; i++) {
			for (int j = 0; j < BoardGame.gameBoardSize; j++) {
				HalfDomino[][] boardGame = boardGamePlayer_.getBoardGame();
				if (boardGame[i][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
					
				}
			}
    	}
    }
}
