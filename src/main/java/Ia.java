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
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				
				xRight = xLeft + 1;
				yRight = yLeft;
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						idealPositionXLeft = xLeft;
						idealPositionYLeft = yLeft;
						idealPositionXRight = xRight;
						idealPositionYRight = yRight;
					}
					else if(score_ == score) {
						try {
							xLeftTerrainUp = boardGame[xLeft][yLeft + 1].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainUp = null;
						}
						try {
							xLeftTerrainLeft = boardGame[xLeft - 1][yLeft].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainLeft = null;
						}
						try {
							xLeftTerrainBelow = boardGame[xLeft][yLeft - 1].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainBelow = null;
						}
					
						try {
							xRightTerrainUp = boardGame[xRight][yRight + 1].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainUp = null;
						}
						try {
							xRightTerrainRight = boardGame[xRight + 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainRight = null;
						}
						try {
							xRightTerrainBelow = boardGame[xRight][yRight - 1].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainBelow = null;
						}
					}						
						
					if (((xLeftTerrainUp == domino.getLeft().getTerrain()) || (xLeftTerrainLeft == domino.getLeft().getTerrain()) || (xLeftTerrainBelow == domino.getLeft().getTerrain())) && ((xRightTerrainUp == domino.getRight().getTerrain()) || (xRightTerrainRight == domino.getRight().getTerrain()) || (xRightTerrainBelow == domino.getRight().getTerrain()))) {
						idealPositionXLeft = xLeft;
						idealPositionYLeft = yLeft;
						idealPositionXRight = xRight;
						idealPositionYRight = yRight;
					}
				}
			}
		}
		
		// xLeft - 1
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				xRight = xLeft - 1;
				yRight = yLeft;
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						idealPositionXLeft = xLeft;
						idealPositionYLeft = yLeft;
						idealPositionXRight = xRight;
						idealPositionYRight = yRight;
					}
					else if(score_ == score) {
						try {
							xLeftTerrainUp = boardGame[xLeft][yLeft + 1].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainUp = null;
						}
						try {
							xLeftTerrainRight = boardGame[xLeft + 1][yLeft].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainRight = null;
						}
						try {
							xLeftTerrainBelow = boardGame[xLeft][yLeft - 1].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainBelow = null;
						}
					
						try {
							xRightTerrainUp = boardGame[xRight][yRight + 1].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainUp = null;
						}
						try {
							xRightTerrainLeft = boardGame[xRight - 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainLeft = null;
						}
						try {
							xRightTerrainBelow = boardGame[xRight][yRight - 1].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainBelow = null;
						}
						
						if (((xLeftTerrainUp == domino.getLeft().getTerrain()) || (xLeftTerrainRight == domino.getLeft().getTerrain()) || (xLeftTerrainBelow == domino.getLeft().getTerrain())) && ((xRightTerrainUp == domino.getRight().getTerrain()) || (xRightTerrainLeft == domino.getRight().getTerrain()) || (xRightTerrainBelow == domino.getRight().getTerrain()))) {
							idealPositionXLeft = xLeft;
							idealPositionYLeft = yLeft;
							idealPositionXRight = xRight;
							idealPositionYRight = yRight;
						}
					}
				}
			}
		}
						
							
		// yLeft + 1
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				xRight = xLeft;
				yRight = yLeft + 1;
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						idealPositionXLeft = xLeft;
						idealPositionYLeft = yLeft;
						idealPositionXRight = xRight;
						idealPositionYRight = yRight;
					}
					else if(score_ == score) {
						try {
							xLeftTerrainLeft = boardGame[xLeft - 1][yLeft].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainLeft = null;
						}
						try {
							xLeftTerrainRight = boardGame[xLeft + 1][yLeft].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainRight = null;
						}
						try {
							xLeftTerrainBelow = boardGame[xLeft][yLeft - 1].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainBelow = null;
						}
					
						try {
							xRightTerrainUp = boardGame[xRight][yRight + 1].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainUp = null;
						}
						try {
							xRightTerrainLeft = boardGame[xRight - 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainLeft = null;
						}
						try {
							xRightTerrainRight = boardGame[xRight + 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainRight = null;
						}	
							
						if (((xLeftTerrainLeft == domino.getLeft().getTerrain()) || (xLeftTerrainRight == domino.getLeft().getTerrain()) || (xLeftTerrainBelow == domino.getLeft().getTerrain())) && ((xRightTerrainUp == domino.getRight().getTerrain()) || (xRightTerrainLeft == domino.getRight().getTerrain()) || (xRightTerrainRight == domino.getRight().getTerrain()))) {
							idealPositionXLeft = xLeft;
							idealPositionYLeft = yLeft;
							idealPositionXRight = xRight;
							idealPositionYRight = yRight;
						}
					}
				}
			}
		}
						
								
		// yRight = yLeft - 1
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				xRight = xLeft;
				yRight = yLeft - 1;
				if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
					calculatePlayerScore(number_);
					if (score_ > score) {
						idealPositionXLeft = xLeft;
						idealPositionYLeft = yLeft;
						idealPositionXRight = xRight;
						idealPositionYRight = yRight;
					}
					else if(score_ == score) {
						try {
							xLeftTerrainUp = boardGame[xLeft][yLeft + 1].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainUp = null;
						}
						try {
							xLeftTerrainLeft = boardGame[xLeft - 1][yLeft].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainLeft = null;
						}
						try {
							xLeftTerrainRight = boardGame[xLeft + 1][yLeft].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrainRight = null;
						}
					
						try {
							xRightTerrainLeft = boardGame[xRight - 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainLeft = null;
						}
						try {
							xRightTerrainRight = boardGame[xRight + 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainRight = null;
						}
						try {
							xRightTerrainBelow = boardGame[xRight][yRight - 1].getTerrain();
						}
						catch (Exception e) {
							xRightTerrainBelow = null;
						}									
							
						if (((xLeftTerrainUp == domino.getLeft().getTerrain()) || (xLeftTerrainLeft == domino.getLeft().getTerrain()) || (xLeftTerrainRight == domino.getLeft().getTerrain())) && ((xRightTerrainLeft == domino.getRight().getTerrain()) || (xRightTerrainRight == domino.getRight().getTerrain()) || (xRightTerrainBelow == domino.getRight().getTerrain()))) {
							idealPositionXLeft = xLeft;
							idealPositionYLeft = yLeft;
							idealPositionXRight = xRight;
							idealPositionYRight = yRight;
						}
					}
				}
			}
		}	
	}
}