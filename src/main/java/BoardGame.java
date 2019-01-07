import java.util.*;

public class BoardGame {
	
	private int id;
	private HalfDomino.TerrainType[][] boardGame = new HalfDomino.TerrainType[9][9];
	
	public BoardGame(int id) {
		this.id = id;
		this.boardGame = getBoardGame();
		this.boardGame[4][4] = HalfDomino.TerrainType.CASTLE;
	}

	// Verifie que la case d a cote du domino n'est pas vide
	// que ce terrain correspond au terrain de la moitie du domino qui est accole
	// que les deux moities du domino sont sur des cases vides
	// que le plateau reste de la bonne dimension
	
	public boolean checkDominoWellPlaced(Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		
		HalfDomino.TerrainType[][] boardGamePlayer = this.getBoardGame();
		
		if (boardGamePlayer[xLeft][yLeft - 1] != null && domino.getLeft().getTerrain() == boardGamePlayer[xLeft][yLeft - 1] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGamePlayer[xRight][yRight - 1] != null && domino.getRight().getTerrain() == boardGamePlayer[xRight][yRight - 1] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGamePlayer[xLeft - 1][yLeft] != null && domino.getLeft().getTerrain() == boardGamePlayer[xLeft - 1][yLeft] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGamePlayer[xRight - 1][yRight] != null && domino.getRight().getTerrain() == boardGamePlayer[xRight - 1][yRight] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGamePlayer[xLeft][yLeft + 1] != null && domino.getLeft().getTerrain() == boardGamePlayer[xLeft][yLeft + 1] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGamePlayer[xRight][yRight + 1] != null && domino.getRight().getTerrain() == boardGamePlayer[xRight][yRight + 1] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGamePlayer[xLeft + 1][yLeft] != null && domino.getLeft().getTerrain() == boardGamePlayer[xLeft + 1][yLeft] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGamePlayer[xRight + 1][yRight] != null && domino.getRight().getTerrain() == boardGamePlayer[xRight + 1][yRight] && boardGamePlayer[xLeft][yLeft] == null && boardGamePlayer[xRight][yRight] == null && checkIfInBounds(boardGamePlayer, domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		else {
			return false;
		}
	}
		
	// Verifie que le plateau reste de la bonne dimension
	public static boolean checkIfInBounds(HalfDomino.TerrainType[][] boardGamePlayer, Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		// Parcours le plateau
		int ecartDominoI = 0;
		int ecartDominoJ = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (boardGamePlayer[i][j] != null) {
					// Obtient l ecart le plus grand entre les dominos selon i
					for (int k = 9; k > i; k--)
						while (boardGamePlayer[k][j] == null)
							ecartDominoI = k - i;

					// Obtient l ecart le plus grand entre les dominos selon j
					for (int l = 9; l > j; l--)
						while (boardGamePlayer[i][l] == null)
							ecartDominoJ = l - j;
				}
			}
		}
		if (ecartDominoI <= 5 && ecartDominoJ <= 5) {
			return true;
		}
		return false;
	}
		
	public HalfDomino.TerrainType[][] getBoardGame() { return this.boardGame; }
	
}