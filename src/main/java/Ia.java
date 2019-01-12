import java.util.*;
import java.awt.Color;
import java.util.Random;

public class Ia extends Player {

	private int xLeft;
	private int xRight;
	private int yLeft;
	private int yRight;
	private int score;
	private int idealPositionXLeft;
	private int idealPositionYLeft;
	private int idealPositionXRight;
	private int idealPositionYRight;
	private HalfDomino.TerrainType xLeftTerrainUp;
	private HalfDomino.TerrainType xLeftTerrainLeft;
	private HalfDomino.TerrainType xLeftTerrainRight;
	private HalfDomino.TerrainType xLeftTerrainBelow;
	private HalfDomino.TerrainType xRightTerrainUp;
	private HalfDomino.TerrainType xRightTerrainLeft;
	private HalfDomino.TerrainType xRightTerrainRight;
	private HalfDomino.TerrainType xRightTerrainBelow;
	
	public Ia(int number) {
		super(number, "IA " + number);
	}
	
	public void playIa(Domino domino) {
		HalfDomino[][] boardGame = boardGamePlayer_.getBoardGame();
		score = 0;
		
		// Cas ou la partie droite du domino est a droite de la partie gauche
		
		// Parcourt le plateau de jeu
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				
				xRight = xLeft + 1;
				yRight = yLeft;
				
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						putIdealPosition();
					}
					else if(score_ == score) {
						xLeftTerrainUp(boardGame);
						xLeftTerrainBelow(boardGame);
						xLeftTerrainLeft(boardGame);					
						xRightTerrainUp(boardGame);
						xRightTerrainBelow(boardGame);
						xRightTerrainRight(boardGame);						
					}						
						
					if (((xLeftTerrainUp == domino.getLeft().getTerrain()) || (xLeftTerrainLeft == domino.getLeft().getTerrain()) || (xLeftTerrainBelow == domino.getLeft().getTerrain())) && ((xRightTerrainUp == domino.getRight().getTerrain()) || (xRightTerrainRight == domino.getRight().getTerrain()) || (xRightTerrainBelow == domino.getRight().getTerrain()))) {
						putIdealPosition();
					}
				}
			}
		}
		
		// Cas ou la partie droite du domino est a gauche de la partie gauche
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				
				xRight = xLeft - 1;
				yRight = yLeft;
				
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						putIdealPosition();
					}
					else if(score_ == score) {
						xLeftTerrainUp(boardGame);
						xLeftTerrainBelow(boardGame);
						xLeftTerrainRight(boardGame);					
						xRightTerrainUp(boardGame);
						xRightTerrainBelow(boardGame);
						xRightTerrainLeft(boardGame);
						
						if (((xLeftTerrainUp == domino.getLeft().getTerrain()) || (xLeftTerrainRight == domino.getLeft().getTerrain()) || (xLeftTerrainBelow == domino.getLeft().getTerrain())) && ((xRightTerrainUp == domino.getRight().getTerrain()) || (xRightTerrainLeft == domino.getRight().getTerrain()) || (xRightTerrainBelow == domino.getRight().getTerrain()))) {
							putIdealPosition();
						}
					}
				}
			}
		}
						
							
		// Cas ou la partie droite du domino est au-dessus de la partie gauche
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				
				xRight = xLeft;
				yRight = yLeft + 1;
				
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						putIdealPosition();
					}
					else if(score_ == score) {
						xLeftTerrainBelow(boardGame);
						xLeftTerrainLeft(boardGame);
						xLeftTerrainRight(boardGame);					
						xRightTerrainUp(boardGame);
						xRightTerrainLeft(boardGame);
						xRightTerrainRight(boardGame);
							
						if (((xLeftTerrainLeft == domino.getLeft().getTerrain()) || (xLeftTerrainRight == domino.getLeft().getTerrain()) || (xLeftTerrainBelow == domino.getLeft().getTerrain())) && ((xRightTerrainUp == domino.getRight().getTerrain()) || (xRightTerrainLeft == domino.getRight().getTerrain()) || (xRightTerrainRight == domino.getRight().getTerrain()))) {
							putIdealPosition();
						}
					}
				}
			}
		}
						
								
		// Cas ou la partie droite du domino est en-dessous de la partie gauche
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				
				xRight = xLeft;
				yRight = yLeft - 1;
				
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						putIdealPosition();
					}
					else if(score_ == score) {
						xLeftTerrainUp(boardGame);
						xLeftTerrainLeft(boardGame);
						xLeftTerrainRight(boardGame);					
						xRightTerrainBelow(boardGame);
						xRightTerrainLeft(boardGame);
						xRightTerrainRight(boardGame);							
							
						if (((xLeftTerrainUp == domino.getLeft().getTerrain()) || (xLeftTerrainLeft == domino.getLeft().getTerrain()) || (xLeftTerrainRight == domino.getLeft().getTerrain())) && ((xRightTerrainLeft == domino.getRight().getTerrain()) || (xRightTerrainRight == domino.getRight().getTerrain()) || (xRightTerrainBelow == domino.getRight().getTerrain()))) {
							putIdealPosition();
						}
					}
				}
			}
		}	
	}
	
	public void xLeftTerrainUp(HalfDomino[][] boardGame) {
		try {
			xLeftTerrainUp = boardGame[xLeft][yLeft + 1].getTerrain();
		}
		catch (Exception e) {
			xLeftTerrainUp = null;
		}
	}
	
	public void xLeftTerrainBelow(HalfDomino[][] boardGame) {
		try {
			xLeftTerrainBelow = boardGame[xLeft][yLeft - 1].getTerrain();
		}
		catch (Exception e) {
			xLeftTerrainBelow = null;
		}
	}
	
	public void xLeftTerrainLeft(HalfDomino[][] boardGame) {
		try {
			xLeftTerrainLeft = boardGame[xLeft - 1][yLeft].getTerrain();
		}
		catch (Exception e) {
			xLeftTerrainLeft = null;
		}
	}
	
	public void xLeftTerrainRight(HalfDomino[][] boardGame) {
		try {
			xLeftTerrainRight = boardGame[xLeft + 1][yLeft].getTerrain();
		}
		catch (Exception e) {
			xLeftTerrainRight = null;
		}
	}
	
	public void xRightTerrainUp(HalfDomino[][] boardGame) {
		try {
			xRightTerrainUp = boardGame[xLeft][yLeft + 1].getTerrain();
		}
		catch (Exception e) {
			xRightTerrainUp = null;
		}
	}
	
	public void xRightTerrainBelow(HalfDomino[][] boardGame) {
		try {
			xRightTerrainBelow = boardGame[xLeft][yLeft - 1].getTerrain();
		}
		catch (Exception e) {
			xRightTerrainBelow = null;
		}
	}
	
	public void xRightTerrainLeft(HalfDomino[][] boardGame) {
		try {
			xRightTerrainLeft = boardGame[xLeft - 1][yLeft].getTerrain();
		}
		catch (Exception e) {
			xRightTerrainLeft = null;
		}
	}
	
	public void xRightTerrainRight(HalfDomino[][] boardGame) {
		try {
			xRightTerrainRight = boardGame[xLeft + 1][yLeft].getTerrain();
		}
		catch (Exception e) {
			xRightTerrainRight = null;
		}
	}
	
	public void putIdealPosition() {
		idealPositionXLeft = xLeft;
		idealPositionYLeft = yLeft;
		idealPositionXRight = xRight;
		idealPositionYRight = yRight;
	}
}