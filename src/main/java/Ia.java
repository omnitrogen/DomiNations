import java.util.*;
import java.awt.Color;
import java.util.Random;

public class Ia extends Player(){
	
	private int xLeft;
	private int xRight;
	private int yLeft;
	private int yRight;
	private int gameBoardSize = 9;
	
	public Ia(int number) {
		super(number);
	}

	public boolean playIa(){
		for(xLeft = 0; xLeft <= gameBoardSize; xLeft++){
			for(yLeft = 0; yLeft <= gameBoardSize; yLeft++){
				for(xRight = xLeft - 1; xRight <= xLeft + 1; xRight++){
					for(yRight = xRight - 1; yRight <= xRight + 1; yRight++){
						if(BoardGame.checkDominoWellPlaced(domino, xLeft, yLeft, xRight, yRight) == true){
							return true;
						}
						return false;
					}
				}
			}
		}
	}
}