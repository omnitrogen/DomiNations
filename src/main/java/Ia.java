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
	private HalfDomino.TerrainType xLeftTerrain;
	private HalfDomino.TerrainType xRightTerrain;
	private HalfDomino.TerrainType yLeftTerrain;
	private HalfDomino.TerrainType yRightTerrain;
	
	public Ia(int number) {
		super(number);
	}
	
	public void playIa(Domino domino) {
		HalfDomino[][] boardGame = boardGamePlayer_.getBoardGame();
		score = 0;
		
		for(yLeft = 0; yLeft < BoardGame.gameBoardSize; yLeft++){
			for(xLeft = 0; xLeft < BoardGame.gameBoardSize; xLeft++){
				xRight = xLeft - 1;
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
							xLeftTerrain = boardGame[xRight - 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xLeftTerrain = null;
						}
						try {
							xRightTerrain = boardGame[xRight + 1][yRight].getTerrain();
						}
						catch (Exception e) {
							xRightTerrain = null;
						}
						try {
							yLeftTerrain = boardGame[xRight][yRight - 1].getTerrain();
						}
						catch (Exception e) {
							yLeftTerrain = null;
						}
						try {
							yRightTerrain = boardGame[xRight][yRight + 1].getTerrain();
						}
						catch (Exception e) {
							yRightTerrain = null;
						}						
						
						if ((domino.getLeft().getTerrain() ==   && domino.getLeft().getTerrain() == boardGame[xLeft + 1][yLeft].getTerrain()) || (domino.getRight().getTerrain() == boardGame[xRight][yRight + 1].getTerrain() && domino.getLeft().getTerrain() == boardGame[xLeft][yLeft + 1].getTerrain()) || (domino.getRight().getTerrain() == boardGame[xRight - 1][yRight].getTerrain() && domino.getLeft().getTerrain() == boardGame[xLeft - 1][yLeft].getTerrain()) || (domino.getRight().getTerrain() == boardGame[xRight][yRight - 1].getTerrain() && domino.getLeft().getTerrain() == boardGame[xLeft][yLeft - 1].getTerrain())) {
							idealPositionXLeft = xLeft;
							idealPositionYLeft = yLeft;
							idealPositionXRight = xRight;
							idealPositionYRight = yRight;
						}
					}
					
					for(yRight = yLeft + 1; yRight < yRight; yRight++){
						if(BoardGame.checkDominoWellPlaced(boardGame, domino, xLeft, yLeft, xRight, yRight) == true){
							if (score_ > score) {
								idealPositionXLeft = xLeft;
								idealPositionYLeft = yLeft;
								idealPositionXRight = xRight;
								idealPositionYRight = yRight;
							}
							
						}
						else {
							// Defausse le domino
						}
					}
				}
			}
		}	
	}
}