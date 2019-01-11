import java.util.*;

public class BoardGame {
	
	private int id;
	public static int gameBoardSize = 9;
	private int maxSizeField = 5;
	private HalfDomino[][] boardGame = new HalfDomino[9][9];
	
	public BoardGame(int id) {
		this.id = id;
		HalfDomino Castle = new HalfDomino(0, "Chateau");
		this.boardGame[4][4] = Castle;
	}

	// Verifie que la case d a cote du domino n'est pas vide
	// que ce terrain correspond au terrain de la moitie du domino qui est accole ou que le terrain accole est le chateau
	// que les deux moities du domino sont sur des cases vides
	// que le plateau reste de la bonne dimension
	
	public boolean checkDominoWellPlaced(HalfDomino[][] boardGame, Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		
		try {
			if (boardGame[xLeft][yLeft - 1] != null && (domino.getLeft().getTerrain() == boardGame[xLeft][yLeft - 1].getTerrain() || boardGame[xLeft][yLeft - 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			if (boardGame[xRight][yRight - 1] != null && (domino.getRight().getTerrain() == boardGame[xRight][yRight - 1].getTerrain() || boardGame[xRight][yRight - 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			if (boardGame[xLeft - 1][yLeft] != null && (domino.getLeft().getTerrain() == boardGame[xLeft - 1][yLeft].getTerrain() || boardGame[xLeft - 1][yLeft].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			if (boardGame[xRight - 1][yRight] != null && (domino.getRight().getTerrain() == boardGame[xRight - 1][yRight].getTerrain() || boardGame[xRight - 1][yRight].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			if (boardGame[xLeft][yLeft + 1] != null && (domino.getLeft().getTerrain() == boardGame[xLeft][yLeft + 1].getTerrain() || boardGame[xLeft][yLeft + 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			if (boardGame[xRight][yRight + 1] != null && (domino.getRight().getTerrain() == boardGame[xRight][yRight + 1].getTerrain() || boardGame[xRight][yRight + 1].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			if (boardGame[xLeft + 1][yLeft] != null && (domino.getLeft().getTerrain() == boardGame[xLeft + 1][yLeft].getTerrain() || boardGame[xLeft + 1][yLeft].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			if (boardGame[xRight + 1][yRight] != null && (domino.getRight().getTerrain() == boardGame[xRight + 1][yRight].getTerrain() || boardGame[xRight + 1][yRight].getTerrain() == HalfDomino.TerrainType.CASTLE) && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkIfInBounds(boardGame, domino, xLeft, yLeft, xRight, yRight) == true) {
				boardGame[xLeft][yLeft] = domino.getLeft();
				boardGame[xRight][yRight] = domino.getRight();
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e){
			return false;
		}		
	}
		
	// Verifie que le plateau reste de la bonne dimension
	public boolean checkIfInBounds(HalfDomino boardGame[][], Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		// Parcours le plateau
		int ecartDominoI = 0;
		int ecartDominoJ = 0;

		for (int i = 0; i < gameBoardSize; i++) {
			for (int j = 0; j < gameBoardSize; j++) {
				if (boardGame[i][j] != null) {
					// Obtient l ecart le plus grand entre les dominos selon i
					for (int k = gameBoardSize; k > i; k--)
						while (boardGame[k][j] == null)
							ecartDominoI = k - i;

					// Obtient l ecart le plus grand entre les dominos selon j
					for (int l = gameBoardSize; l > j; l--)
						while (boardGame[i][l] == null)
							ecartDominoJ = l - j;
				}
			}
		}
		if (ecartDominoI <= maxSizeField && ecartDominoJ <= maxSizeField) {
			return true;
		}
		return false;
	}
	
	public HalfDomino[][] getBoardGame() {
		return this.boardGame;
	}
}