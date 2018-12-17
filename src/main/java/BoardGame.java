
public class BoardGame {
	
	static int ID;
	static HalfDomino.TerrainType boardGame[][] = new HalfDomino.TerrainType[9][9];
	
	public static void main(String[] args)
	{
		// Initialise le plateau
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				boardGame[i][j] = null;
			}
		}
		boardGame[4][4] = HalfDomino.TerrainType.CASTLE;	
		
	}
	
	// Verifie que la case à cote du domino n'est pas vide
	// que ce terrain correspond au terrain de la moitié du domino qui est accole
	// que les deux moities du domino sont sur des cases vides
	// que le plateau reste de la bonne dimension
	
	public static boolean checkDominoWellPlaced(Domino domino, int xLeft, int yLeft, int xRight, int yRight) {
		if (boardGame[xLeft][yLeft - 1] != null && domino.getLeft().getTerrain() == boardGame[xLeft][yLeft - 1] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGame[xRight][yRight - 1] != null && domino.getRight().getTerrain() == boardGame[xRight][yRight - 1] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGame[xLeft - 1][yLeft] != null && domino.getLeft().getTerrain() == boardGame[xLeft - 1][yLeft] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGame[xRight - 1][yRight] != null && domino.getRight().getTerrain() == boardGame[xRight - 1][yRight] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGame[xLeft][yLeft + 1] != null && domino.getLeft().getTerrain() == boardGame[xLeft][yLeft + 1] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGame[xRight][yRight + 1] != null && domino.getRight().getTerrain() == boardGame[xRight][yRight + 1] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGame[xLeft + 1][yLeft] != null && domino.getLeft().getTerrain() == boardGame[xLeft + 1][yLeft] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		if (boardGame[xRight + 1][yRight] != null && domino.getRight().getTerrain() == boardGame[xRight + 1][yRight] && boardGame[xLeft][yLeft] == null && boardGame[xRight][yRight] == null && checkBoardGame(domino, xLeft, yLeft, xRight, yRight) == true) {
			return true;
		}
		else {
			return false;
		}
	}
		
	// Verifie que le plateau reste de la bonne dimension
	public static boolean checkBoardGame(Domino domino, int xLeft, int yLeft, int xRight, int yRight){
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				boardGame[i][j] = null;
			}
		return false;
		}
	}
}