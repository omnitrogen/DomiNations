import java.awt.Color;
import java.util.Random;

public class Player {
	protected String name_;
    protected int number_;
    protected int score_;
    private Color color_;
    protected BoardGame boardGamePlayer_;
    private boolean[][] verificationBoardGame_;

    private int nbCrown;
    private int nbTerrain;

    public Player(int number, String name) {
        number_ = number;
        name_ = name;
        score_ = 0;
        boardGamePlayer_ = new BoardGame(number);
        verificationBoardGame_ = new boolean[9][9];

        if (number == 1)
            color_ = Color.MAGENTA;
        else if (number == 2)
            color_ = Color.RED;
        else if (number == 3)
            color_ = Color.PINK;
        else if (number == 4)
            color_ = Color.DARK_GRAY;
    }

    public String getName() { return name_; }

    public void setName(String name) { this.name_ = name; }

    public int getScore() { return score_; }

    public void setScore(int score_) { this.score_ = score_; }

    public Color getColor() { return color_; }

    public int getNumber() { return number_; }

    public BoardGame getBoardGame() { return boardGamePlayer_; }

    public void calculatePlayerScore() {
    	score_ = 0;
    	
    	// Initialize the verificationBoardGame
    	for (int k = 0; k < BoardGame.gameBoardSize; k++) {
			for (int l = 0; l < BoardGame.gameBoardSize; l++) {
				verificationBoardGame_[k][l] = false;
			}
    	}

        HalfDomino[][] boardGame = boardGamePlayer_.getBoardGame();

        // Read through the boardgame
    	for (int i = 0; i < BoardGame.gameBoardSize; i++) {
			for (int j = 0; j < BoardGame.gameBoardSize; j++) {
				if (verificationBoardGame_[i][j] == false && boardGame[i][j] != null && boardGame[i][j].getTerrain() != HalfDomino.TerrainType.CASTLE) {
					verificationBoardGame_[i][j] = true;

                    nbCrown = boardGame[i][j].getNbCrowns();
					nbTerrain = 1;

					verifyIfNeighbour(i, j, boardGame, verificationBoardGame_);
					score_ = score_ + (nbTerrain * nbCrown);
				}
			}
    	}
    }
    
    // Check if the neighbors of half of the domino are of the same type
    public void verifyIfNeighbour(int i, int j, HalfDomino[][] boardGame, boolean[][] verificationBoardGame) {
        if (i < 8 && verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j] != null && boardGame[i][j] != null && boardGame[i + 1][j].getTerrain() == boardGame[i][j].getTerrain()) {
            verificationBoardGame[i + 1][j] = true;
            nbTerrain = nbTerrain + 1;
            nbCrown = nbCrown + boardGame[i + 1][j].getNbCrowns();
            verifyIfNeighbour(i + 1, j, boardGame, verificationBoardGame);
        }
        if (i > 0 && verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j] != null && boardGame[i][j] != null && boardGame[i - 1][j].getTerrain() == boardGame[i][j].getTerrain()) {
            verificationBoardGame[i - 1][j] = true;
            nbTerrain = nbTerrain + 1;
            nbCrown = nbCrown + boardGame[i - 1][j].getNbCrowns();
            verifyIfNeighbour(i - 1, j, boardGame, verificationBoardGame);
        }
        if (j < 8 && verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1] != null && boardGame[i][j] != null && boardGame[i][j + 1].getTerrain() == boardGame[i][j].getTerrain()) {
            verificationBoardGame[i][j + 1] = true;
            nbTerrain = nbTerrain + 1;
            nbCrown = nbCrown + boardGame[i][j + 1].getNbCrowns();
            verifyIfNeighbour(i, j + 1, boardGame, verificationBoardGame);
        }
        if (j > 0 && verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1] != null && boardGame[i][j] != null && boardGame[i][j - 1].getTerrain() == boardGame[i][j].getTerrain()) {
            verificationBoardGame[i][j - 1] = true;
            nbTerrain = nbTerrain + 1;
            nbCrown = nbCrown + boardGame[i][j - 1].getNbCrowns();
            verifyIfNeighbour(i, j - 1, boardGame, verificationBoardGame);
        }
    }
}
