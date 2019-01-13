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

	// Verifie que la case d a cote du domino n'est pas vide
	// que ce terrain correspond au terrain de la moitie du domino qui lui est accole ou a un chateau
	// que les deux moities du domino sont sur des cases vides
	// que le plateau reste de la bonne dimension
	
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
	
	public static boolean dominoWellplacedTrue(HalfDomino[][] boardGame, Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		boardGame[xLeft][yLeft] = domino.getLeft();
		boardGame[xRight][yRight] = domino.getRight();
		return true;
	}
		
	// Verifie que le plateau reste de la bonne dimension
	public static boolean checkIfInBounds(HalfDomino boardGame[][], Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		// Parcours le plateau
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

		/*for (int i = 0; i < gameBoardSize; ++i) {
		    for (int j = 0; j < gameBoardSize; ++j) {
		        if (boardGame[i][j] != null) {
		            for (int k = i + 1; k < gameBoardSize; ++k)
                    {
                        if (boardGame[k][j] == null) {
                            if (ecartDominoI < k - i - 1)
                                ecartDominoI = k - i - 1;
                            break;
                        }
                        else if (k == gameBoardSize - 1)
                            if (ecartDominoI < k - i)
                                ecartDominoI = k - i;
                    }
                    for (int l = j + 1; l < gameBoardSize; ++l)
                    {
                        if (boardGame[i][l] == null) {
                            if (ecartDominoJ < l - j - 1)
                                ecartDominoJ = l - j - 1;
                            break;
                        }
                        else if (l == gameBoardSize - 1)
                            if (ecartDominoJ < l - j)
                                ecartDominoJ = l - j;
                    }
                }
            }
        }*/

		if (ecartDominoI < maxSizeField && ecartDominoJ < maxSizeField) {
			return true;
		}
		return false;
	}
	
	public HalfDomino[][] getBoardGame() {
		return this.boardGame;
	}
}