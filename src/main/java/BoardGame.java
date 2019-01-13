public class BoardGame {
	
	private int id;
	public static int gameBoardSize = 9;
	private static int maxSizeField = 5;
	private HalfDomino[][] boardGame = new HalfDomino[9][9];
	
	public BoardGame(int id) {
		this.id = id;
		HalfDomino Castle = new HalfDomino(0, "Chateau");
		this.boardGame[4][4] = Castle;
	}

	/* Check that the box next to the domino is not empty
	Check that this land corresponds to the land of half of the domino that is attached to it or to a castle
	Check that both halves of the domino are on empty squares
	Check that the board remains of the correct dimension */
	
	public static boolean checkDominoWellPlaced(HalfDomino[][] boardGame, Domino domino, int xLeft, int yLeft, int xRight, int yRight) {

		if ((yLeft > 0 && boardGame[xLeft][yLeft - 1] != null && (domino.getLeft().getTerrain() == boardGame[xLeft][yLeft - 1].getTerrain() || boardGame[xLeft][yLeft - 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)
		|| (yRight > 0 && boardGame[xRight][yRight - 1] != null && (domino.getRight().getTerrain() == boardGame[xRight][yRight - 1].getTerrain() || boardGame[xRight][yRight - 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)
        || (xLeft > 0 && boardGame[xLeft - 1][yLeft] != null && (domino.getLeft().getTerrain() == boardGame[xLeft - 1][yLeft].getTerrain() || boardGame[xLeft - 1][yLeft].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)
        || (xRight > 0 && boardGame[xRight - 1][yRight] != null && (domino.getRight().getTerrain() == boardGame[xRight - 1][yRight].getTerrain() || boardGame[xRight - 1][yRight].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)
		|| (yLeft < 8 && boardGame[xLeft][yLeft + 1] != null && (domino.getLeft().getTerrain() == boardGame[xLeft][yLeft + 1].getTerrain() || boardGame[xLeft][yLeft + 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)
        || (yRight < 8 && boardGame[xRight][yRight + 1] != null && (domino.getRight().getTerrain() == boardGame[xRight][yRight + 1].getTerrain() || boardGame[xRight][yRight + 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)
        || (xLeft < 8 && boardGame[xLeft + 1][yLeft] != null && (domino.getLeft().getTerrain() == boardGame[xLeft + 1][yLeft].getTerrain() || boardGame[xLeft + 1][yLeft].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)
        || (xRight < 8 && boardGame[xRight + 1][yRight] != null && (domino.getRight().getTerrain() == boardGame[xRight + 1][yRight].getTerrain() || boardGame[xRight + 1][yRight].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null)) {

		    boardGame[xLeft][yLeft] = domino.getLeft();
            boardGame[xRight][yRight] = domino.getRight();

            if (!checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight))
		    {
                boardGame[xLeft][yLeft] = null;
                boardGame[xRight][yRight] = null;
                return false;
		    }

		    return true;
		}

		return false;
	}
		
	// Check that the board remains of the correct dimension
	public static boolean checkIfInBounds(HalfDomino boardGame[][], Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		// Read through the boardgame
		int ecartDominoI = 0;
		int ecartDominoJ = 0;

		//Vertical check
		int i = 0;
		int j = 0;

		while (boardGame[i][j] == null)
        {
            if (j == gameBoardSize - 1) {
                j = 0;
                ++i;
            }

            ++j;
        }

        if (gameBoardSize - 1 - i >= maxSizeField)
        {
            for (int k = 0; k < gameBoardSize; ++k)
                if (boardGame[i + maxSizeField][k] != null) {
                    ecartDominoI = 10;
                    break;
                }
        }

        i = 0;
		j = 0;

        while (boardGame[i][j] == null)
        {
            if (i == gameBoardSize - 1) {
                i = 0;
                ++j;
            }

            ++i;
        }

        if (gameBoardSize - 1 - j >= maxSizeField)
        {
            for (int k = 0; k < gameBoardSize; ++k)
                if (boardGame[k][j + maxSizeField] != null) {
                    ecartDominoJ = 10;
                    break;
                }
        }

		if (ecartDominoI < maxSizeField && ecartDominoJ < maxSizeField) {
			return true;
		}
		return false;
	}
	
	public HalfDomino[][] getBoardGame() {
		return this.boardGame;
	}
}