import java.util.*;
import java.awt.Color;
import java.util.Random;

public class Ia extends@ Player() {
	
	private int xLeft;
	private int xRight;
	private int yLeft;
	private int yRight;
	private int gameBoardSize = 9;
	private int score = 0;
	int idealPositionXLeft;
	int idealPositionYLeft;
	int idealPositionXRight;
	int idealPositionYRight;
	
	public Ia(int number) {
		super(number);
	}

	public void playIa(Domino domino) {
		for(xLeft = 0; xLeft < gameBoardSize; xLeft++){
			for(yLeft = 0; yLeft < gameBoardSize; yLeft++){
				for(xRight = xLeft - 1; xRight <= xLeft + 1; xRight++){
					for(yRight = xRight - 1; yRight <= xRight + 1; yRight++){
						if(BoardGame.checkDominoWellPlaced(domino, xLeft, yLeft, xRight, yRight) == true){
							if (getScore() > score) {
								idealPositionXLeft = xLeft;
								idealPositionYLeft = yLeft;
								idealPositionXRight = xRight;
								idealPositionYRight = yRight;
							}
							else if((getScore() = score) {
								if ((domino.getRight().getTerrain() == boardGamePlayer[xRight + 1][yRight] && domino.getLeft().getTerrain() == boardGamePlayer[xLeft + 1][yLeft]) || (domino.getRight().getTerrain() == boardGamePlayer[xRight][yRight + 1] && domino.getLeft().getTerrain() == boardGamePlayer[xLeft][yLeft + 1]) || (domino.getRight().getTerrain() == boardGamePlayer[xRight - 1][yRight] && domino.getLeft().getTerrain() == boardGamePlayer[xLeft - 1][yLeft]) || (domino.getRight().getTerrain() == boardGamePlayer[xRight][yRight - 1] && domino.getLeft().getTerrain() == boardGamePlayer[xLeft][yLeft - 1])) {
									idealPositionXLeft = xLeft;
									idealPositionYLeft = yLeft;
									idealPositionXRight = xRight;
									idealPositionYRight = yRight;
								}
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