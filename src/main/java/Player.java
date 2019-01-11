import java.awt.Color;
import java.util.Random;

public class Player {
    protected int number_;
    protected int score_;
    private Color color_;
    protected BoardGame boardGamePlayer_;
    private boolean[][] verificationBoardGame_;
    private int fieldsCrown;
    private int forestCrown;
    private int meadowCrown;
    private int mineCrown;
    private int mountainCrown;
    private int seaCrown;
    private int numberFields;
    private int numberForest;
    private int numberMeadow;
    private int numberMine;
    private int numberMountain;
    private int numberSea;

    public Player(int number) {
        number_ = number;
        score_ = 0;
        boardGamePlayer_ = new BoardGame(number);

        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        color_ = new Color(r, g, b);
    }

    public int getScore() {
        return score_;
    }

    public void setScore(int score_) {
        this.score_ = score_;
    }

    public Color getColor() {
        return color_;
    }

    public int getNumber() {
        return number_;
    }
    
    public void calculatePlayerScore(int id) {
    	score_ = 0;
    	
    	for (int k = 0; k < BoardGame.gameBoardSize; k++) {
			for (int l = 0; l < BoardGame.gameBoardSize; l++) {
				verificationBoardGame_[k][l] = false;
			}
    	}
    	
    	for (int i = 0; i < BoardGame.gameBoardSize; i++) {
			for (int j = 0; j < BoardGame.gameBoardSize; j++) {
				HalfDomino[][] boardGame = boardGamePlayer_.getBoardGame();
				if (verificationBoardGame_[i][j] == false && boardGame[i][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
					verificationBoardGame_[i][j] = true;
					numberFields = 1;
					fieldsCrown = fieldsCrown + boardGame[i][j].getNbCrowns();
					verifyIfNeighbourFields(i, j, boardGame, verificationBoardGame_);
					score_ = score_ + (numberFields * fieldsCrown);					
				}
				else if (verificationBoardGame_[i][j] == false && boardGame[i][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
					verificationBoardGame_[i][j] = true;
					numberForest = 1;
					forestCrown = forestCrown + boardGame[i][j].getNbCrowns();
					verifyIfNeighbourForest(i, j, boardGame, verificationBoardGame_);
					score_ = score_ + (numberForest * forestCrown);					
				}
				else if (verificationBoardGame_[i][j] == false && boardGame[i][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
					verificationBoardGame_[i][j] = true;
					numberMeadow = 1;
					meadowCrown = meadowCrown + boardGame[i][j].getNbCrowns();
					verifyIfNeighbourMeadow(i, j, boardGame, verificationBoardGame_);
					score_ = score_ + (numberMeadow * meadowCrown);					
				}
				else if (verificationBoardGame_[i][j] == false && boardGame[i][j].getTerrain() == HalfDomino.TerrainType.MINE) {
					verificationBoardGame_[i][j] = true;
					numberMine = 1;
					mineCrown = mineCrown + boardGame[i][j].getNbCrowns();
					verifyIfNeighbourMine(i, j, boardGame, verificationBoardGame_);
					score_ = score_ + (numberMine * mineCrown);					
				}
				else if (verificationBoardGame_[i][j] == false && boardGame[i][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
					verificationBoardGame_[i][j] = true;
					numberMountain = 1;
					mountainCrown = mountainCrown + boardGame[i][j].getNbCrowns();
					verifyIfNeighbourMountain(i, j, boardGame, verificationBoardGame_);
					score_ = score_ + (numberMountain * mountainCrown);					
				}
				else if (verificationBoardGame_[i][j] == false && boardGame[i][j].getTerrain() == HalfDomino.TerrainType.SEA) {
					verificationBoardGame_[i][j] = true;
					numberSea = 1;
					seaCrown = seaCrown + boardGame[i][j].getNbCrowns();
					verifyIfNeighbourSea(i, j, boardGame, verificationBoardGame_);
					score_ = score_ + (numberSea * seaCrown);					
				}
				else {
					break;
				}
			}
    	}
    }
    
    public void verifyIfNeighbourFields(int i, int j, HalfDomino[][] boardGame, boolean[][] verificationBoardGame) {
    	try {
    		if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
        		verificationBoardGame[i + 1][j] = true;
        		numberFields = numberFields + 1;
        		fieldsCrown = fieldsCrown + boardGame[i + 1][j].getNbCrowns();
        		verifyIfNeighbourFields(i + 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
        		verificationBoardGame[i - 1][j] = true;
        		numberFields = numberFields + 1;
        		fieldsCrown = fieldsCrown + boardGame[i - 1][j].getNbCrowns();
        		verifyIfNeighbourFields(i - 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
        		verificationBoardGame[i][j + 1] = true;
        		numberFields = numberFields + 1;
        		fieldsCrown = fieldsCrown + boardGame[i][j + 1].getNbCrowns();
        		verifyIfNeighbourFields(i, j + 1, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
        		verificationBoardGame[i][j - 1] = true;
        		numberFields = numberFields + 1;
        		fieldsCrown = fieldsCrown + boardGame[i][j - 1].getNbCrowns();
        		verifyIfNeighbourFields(i, j - 1, boardGame, verificationBoardGame);
        	}
    		else {
    			return;
    		}
    	}
    	catch (Exception e) {
    		try {
    			if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
            		verificationBoardGame[i - 1][j] = true;
            		numberFields = numberFields + 1;
            		fieldsCrown = fieldsCrown + boardGame[i - 1][j].getNbCrowns();
            		verifyIfNeighbourFields(i - 1, j, boardGame, verificationBoardGame);
            	}
    			if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
            		verificationBoardGame[i + 1][j] = true;
            		numberFields = numberFields + 1;
            		fieldsCrown = fieldsCrown + boardGame[i + 1][j].getNbCrowns();
            		verifyIfNeighbourFields(i + 1, j, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
            		verificationBoardGame[i][j + 1] = true;
            		numberFields = numberFields + 1;
            		fieldsCrown = fieldsCrown + boardGame[i][j + 1].getNbCrowns();
            		verifyIfNeighbourFields(i, j + 1, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
            		verificationBoardGame[i][j - 1] = true;
            		numberFields = numberFields + 1;
            		fieldsCrown = fieldsCrown + boardGame[i][j - 1].getNbCrowns();
            		verifyIfNeighbourFields(i, j - 1, boardGame, verificationBoardGame);
            	}
        		else {
        			return;
        		}
    		}
    		catch (Exception f) {
   				try {
   					if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
   		        		verificationBoardGame[i][j + 1] = true;
   		        		numberFields = numberFields + 1;
   		        		fieldsCrown = fieldsCrown + boardGame[i][j + 1].getNbCrowns();
   		        		verifyIfNeighbourFields(i, j + 1, boardGame, verificationBoardGame);
   		        	}
   					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
   		        		verificationBoardGame[i + 1][j] = true;
   		        		numberFields = numberFields + 1;
   		        		fieldsCrown = fieldsCrown + boardGame[i + 1][j].getNbCrowns();
   		        		verifyIfNeighbourFields(i + 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
   		        		verificationBoardGame[i - 1][j] = true;
   		        		numberFields = numberFields + 1;
   		        		fieldsCrown = fieldsCrown + boardGame[i - 1][j].getNbCrowns();
   		        		verifyIfNeighbourFields(i - 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
   		        		verificationBoardGame[i][j - 1] = true;
   		        		numberFields = numberFields + 1;
   		        		fieldsCrown = fieldsCrown + boardGame[i][j - 1].getNbCrowns();
   		        		verifyIfNeighbourFields(i, j - 1, boardGame, verificationBoardGame);
   		        	}
   		    		else {
   		    			return;
   		    		}
    			}
    			catch (Exception g) {
    				try {
    					if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
    		        		verificationBoardGame[i][j - 1] = true;
    		        		numberFields = numberFields + 1;
    		        		fieldsCrown = fieldsCrown + boardGame[i][j - 1].getNbCrowns();
    		        		verifyIfNeighbourFields(i, j - 1, boardGame, verificationBoardGame);
    		        	}
    					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
    		        		verificationBoardGame[i + 1][j] = true;
    		        		numberFields = numberFields + 1;
    		        		fieldsCrown = fieldsCrown + boardGame[i + 1][j].getNbCrowns();
    		        		verifyIfNeighbourFields(i + 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FIELDS) {
    		        		verificationBoardGame[i - 1][j] = true;
    		        		numberFields = numberFields + 1;
    		        		fieldsCrown = fieldsCrown + boardGame[i - 1][j].getNbCrowns();
    		        		verifyIfNeighbourFields(i - 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FIELDS) {
    		        		verificationBoardGame[i][j + 1] = true;
    		        		numberFields = numberFields + 1;
    		        		fieldsCrown = fieldsCrown + boardGame[i][j + 1].getNbCrowns();
    		        		verifyIfNeighbourFields(i, j + 1, boardGame, verificationBoardGame);
    		        	}
    		    		else {
    		    			return;
    		    		}
    				}
    				catch (Exception h) {
    					return;
    				}
    			}
   			}
   		}		
   	}
    
    public void verifyIfNeighbourForest(int i, int j, HalfDomino[][] boardGame, boolean[][] verificationBoardGame) {
    	try {
    		if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
        		verificationBoardGame[i + 1][j] = true;
        		numberForest = numberForest + 1;
        		forestCrown = forestCrown + boardGame[i + 1][j].getNbCrowns();
        		verifyIfNeighbourForest(i + 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
        		verificationBoardGame[i - 1][j] = true;
        		numberForest = numberForest + 1;
        		forestCrown = forestCrown + boardGame[i - 1][j].getNbCrowns();
        		verifyIfNeighbourForest(i - 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
        		verificationBoardGame[i][j + 1] = true;
        		numberForest = numberForest + 1;
        		forestCrown = forestCrown + boardGame[i][j + 1].getNbCrowns();
        		verifyIfNeighbourForest(i, j + 1, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
        		verificationBoardGame[i][j - 1] = true;
        		numberForest = numberForest + 1;
        		forestCrown = forestCrown + boardGame[i][j - 1].getNbCrowns();
        		verifyIfNeighbourForest(i, j - 1, boardGame, verificationBoardGame);
        	}
    		else {
    			return;
    		}
    	}
    	catch (Exception e) {
    		try {
    			if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
            		verificationBoardGame[i - 1][j] = true;
            		numberForest = numberForest + 1;
            		forestCrown = forestCrown + boardGame[i - 1][j].getNbCrowns();
            		verifyIfNeighbourForest(i - 1, j, boardGame, verificationBoardGame);
            	}
    			if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
            		verificationBoardGame[i + 1][j] = true;
            		numberForest = numberForest + 1;
            		forestCrown = forestCrown + boardGame[i + 1][j].getNbCrowns();
            		verifyIfNeighbourForest(i + 1, j, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
            		verificationBoardGame[i][j + 1] = true;
            		numberForest = numberForest + 1;
            		forestCrown = forestCrown + boardGame[i][j + 1].getNbCrowns();
            		verifyIfNeighbourForest(i, j + 1, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
            		verificationBoardGame[i][j - 1] = true;
            		numberForest = numberForest + 1;
            		forestCrown = forestCrown + boardGame[i][j - 1].getNbCrowns();
            		verifyIfNeighbourForest(i, j - 1, boardGame, verificationBoardGame);
            	}
        		else {
        			return;
        		}
    		}
    		catch (Exception f) {
   				try {
   					if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
   		        		verificationBoardGame[i][j + 1] = true;
   		        		numberForest = numberForest + 1;
   		        		forestCrown = forestCrown + boardGame[i][j + 1].getNbCrowns();
   		        		verifyIfNeighbourForest(i, j + 1, boardGame, verificationBoardGame);
   		        	}
   					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
   		        		verificationBoardGame[i + 1][j] = true;
   		        		numberForest = numberForest + 1;
   		        		forestCrown = forestCrown + boardGame[i + 1][j].getNbCrowns();
   		        		verifyIfNeighbourForest(i + 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
   		        		verificationBoardGame[i - 1][j] = true;
   		        		numberForest = numberForest + 1;
   		        		forestCrown = forestCrown + boardGame[i - 1][j].getNbCrowns();
   		        		verifyIfNeighbourForest(i - 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
   		        		verificationBoardGame[i][j - 1] = true;
   		        		numberForest = numberForest + 1;
   		        		forestCrown = forestCrown + boardGame[i][j - 1].getNbCrowns();
   		        		verifyIfNeighbourForest(i, j - 1, boardGame, verificationBoardGame);
   		        	}
   		    		else {
   		    			return;
   		    		}
    			}
    			catch (Exception g) {
    				try {
    					if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
    		        		verificationBoardGame[i][j - 1] = true;
    		        		numberForest = numberForest + 1;
    		        		forestCrown = forestCrown + boardGame[i][j - 1].getNbCrowns();
    		        		verifyIfNeighbourForest(i, j - 1, boardGame, verificationBoardGame);
    		        	}
    					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
    		        		verificationBoardGame[i + 1][j] = true;
    		        		numberForest = numberForest + 1;
    		        		forestCrown = forestCrown + boardGame[i + 1][j].getNbCrowns();
    		        		verifyIfNeighbourForest(i + 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.FOREST) {
    		        		verificationBoardGame[i - 1][j] = true;
    		        		numberForest = numberForest + 1;
    		        		forestCrown = forestCrown + boardGame[i - 1][j].getNbCrowns();
    		        		verifyIfNeighbourForest(i - 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.FOREST) {
    		        		verificationBoardGame[i][j + 1] = true;
    		        		numberForest = numberForest + 1;
    		        		forestCrown = forestCrown + boardGame[i][j + 1].getNbCrowns();
    		        		verifyIfNeighbourForest(i, j + 1, boardGame, verificationBoardGame);
    		        	}
    		    		else {
    		    			return;
    		    		}
    				}
    				catch (Exception h) {
    					return;
    				}
    			}
   			}
   		}		
   	}
    
    public void verifyIfNeighbourMeadow(int i, int j, HalfDomino[][] boardGame, boolean[][] verificationBoardGame) {
    	try {
    		if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
        		verificationBoardGame[i + 1][j] = true;
        		numberMeadow = numberMeadow + 1;
        		meadowCrown = meadowCrown + boardGame[i + 1][j].getNbCrowns();
        		verifyIfNeighbourMeadow(i + 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
        		verificationBoardGame[i - 1][j] = true;
        		numberMeadow = numberMeadow + 1;
        		meadowCrown = meadowCrown + boardGame[i - 1][j].getNbCrowns();
        		verifyIfNeighbourMeadow(i - 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
        		verificationBoardGame[i][j + 1] = true;
        		numberMeadow = numberMeadow + 1;
        		meadowCrown = meadowCrown + boardGame[i][j + 1].getNbCrowns();
        		verifyIfNeighbourMeadow(i, j + 1, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
        		verificationBoardGame[i][j - 1] = true;
        		numberMeadow = numberMeadow + 1;
        		meadowCrown = meadowCrown + boardGame[i][j - 1].getNbCrowns();
        		verifyIfNeighbourMeadow(i, j - 1, boardGame, verificationBoardGame);
        	}
    		else {
    			return;
    		}
    	}
    	catch (Exception e) {
    		try {
    			if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
            		verificationBoardGame[i - 1][j] = true;
            		numberMeadow = numberMeadow + 1;
            		meadowCrown = meadowCrown + boardGame[i - 1][j].getNbCrowns();
            		verifyIfNeighbourMeadow(i - 1, j, boardGame, verificationBoardGame);
            	}
    			if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
            		verificationBoardGame[i + 1][j] = true;
            		numberMeadow = numberMeadow + 1;
            		meadowCrown = meadowCrown + boardGame[i + 1][j].getNbCrowns();
            		verifyIfNeighbourMeadow(i + 1, j, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
            		verificationBoardGame[i][j + 1] = true;
            		numberMeadow = numberMeadow + 1;
            		meadowCrown = meadowCrown + boardGame[i][j + 1].getNbCrowns();
            		verifyIfNeighbourMeadow(i, j + 1, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
            		verificationBoardGame[i][j - 1] = true;
            		numberMeadow = numberMeadow + 1;
            		meadowCrown = meadowCrown + boardGame[i][j - 1].getNbCrowns();
            		verifyIfNeighbourMeadow(i, j - 1, boardGame, verificationBoardGame);
            	}
        		else {
        			return;
        		}
    		}
    		catch (Exception f) {
   				try {
   					if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
   		        		verificationBoardGame[i][j + 1] = true;
   		        		numberMeadow = numberMeadow + 1;
   		        		meadowCrown = meadowCrown + boardGame[i][j + 1].getNbCrowns();
   		        		verifyIfNeighbourMeadow(i, j + 1, boardGame, verificationBoardGame);
   		        	}
   					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
   		        		verificationBoardGame[i + 1][j] = true;
   		        		numberMeadow = numberMeadow + 1;
   		        		meadowCrown = meadowCrown + boardGame[i + 1][j].getNbCrowns();
   		        		verifyIfNeighbourMeadow(i + 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
   		        		verificationBoardGame[i - 1][j] = true;
   		        		numberMeadow = numberMeadow + 1;
   		        		meadowCrown = meadowCrown + boardGame[i - 1][j].getNbCrowns();
   		        		verifyIfNeighbourMeadow(i - 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
   		        		verificationBoardGame[i][j - 1] = true;
   		        		numberMeadow = numberMeadow + 1;
   		        		meadowCrown = meadowCrown + boardGame[i][j - 1].getNbCrowns();
   		        		verifyIfNeighbourMeadow(i, j - 1, boardGame, verificationBoardGame);
   		        	}
   		    		else {
   		    			return;
   		    		}
    			}
    			catch (Exception g) {
    				try {
    					if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
    		        		verificationBoardGame[i][j - 1] = true;
    		        		numberMeadow = numberMeadow + 1;
    		        		meadowCrown = meadowCrown + boardGame[i][j - 1].getNbCrowns();
    		        		verifyIfNeighbourMeadow(i, j - 1, boardGame, verificationBoardGame);
    		        	}
    					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
    		        		verificationBoardGame[i + 1][j] = true;
    		        		numberMeadow = numberMeadow + 1;
    		        		meadowCrown = meadowCrown + boardGame[i + 1][j].getNbCrowns();
    		        		verifyIfNeighbourMeadow(i + 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MEADOW) {
    		        		verificationBoardGame[i - 1][j] = true;
    		        		numberMeadow = numberMeadow + 1;
    		        		meadowCrown = meadowCrown + boardGame[i - 1][j].getNbCrowns();
    		        		verifyIfNeighbourMeadow(i - 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MEADOW) {
    		        		verificationBoardGame[i][j + 1] = true;
    		        		numberMeadow = numberMeadow + 1;
    		        		meadowCrown = meadowCrown + boardGame[i][j + 1].getNbCrowns();
    		        		verifyIfNeighbourMeadow(i, j + 1, boardGame, verificationBoardGame);
    		        	}
    		    		else {
    		    			return;
    		    		}
    				}
    				catch (Exception h) {
    					return;
    				}
    			}
   			}
   		}		
   	}
    
    public void verifyIfNeighbourMine(int i, int j, HalfDomino[][] boardGame, boolean[][] verificationBoardGame) {
    	try {
    		if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
        		verificationBoardGame[i + 1][j] = true;
        		numberMine = numberMine + 1;
        		mineCrown = mineCrown + boardGame[i + 1][j].getNbCrowns();
        		verifyIfNeighbourMine(i + 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
        		verificationBoardGame[i - 1][j] = true;
        		numberMine = numberMine + 1;
        		mineCrown = mineCrown + boardGame[i - 1][j].getNbCrowns();
        		verifyIfNeighbourMine(i - 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MINE) {
        		verificationBoardGame[i][j + 1] = true;
        		numberMine = numberMine + 1;
        		mineCrown = mineCrown + boardGame[i][j + 1].getNbCrowns();
        		verifyIfNeighbourMine(i, j + 1, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MINE) {
        		verificationBoardGame[i][j - 1] = true;
        		numberMine = numberMine + 1;
        		mineCrown = mineCrown + boardGame[i][j - 1].getNbCrowns();
        		verifyIfNeighbourMine(i, j - 1, boardGame, verificationBoardGame);
        	}
    		else {
    			return;
    		}
    	}
    	catch (Exception e) {
    		try {
    			if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
            		verificationBoardGame[i - 1][j] = true;
            		numberMine = numberMine + 1;
            		mineCrown = mineCrown + boardGame[i - 1][j].getNbCrowns();
            		verifyIfNeighbourMine(i - 1, j, boardGame, verificationBoardGame);
            	}
    			if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
            		verificationBoardGame[i + 1][j] = true;
            		numberMine = numberMine + 1;
            		mineCrown = mineCrown + boardGame[i + 1][j].getNbCrowns();
            		verifyIfNeighbourMine(i + 1, j, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MINE) {
            		verificationBoardGame[i][j + 1] = true;
            		numberMine = numberMine + 1;
            		mineCrown = mineCrown + boardGame[i][j + 1].getNbCrowns();
            		verifyIfNeighbourMine(i, j + 1, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MINE) {
            		verificationBoardGame[i][j - 1] = true;
            		numberMine = numberMine + 1;
            		mineCrown = mineCrown + boardGame[i][j - 1].getNbCrowns();
            		verifyIfNeighbourMine(i, j - 1, boardGame, verificationBoardGame);
            	}
        		else {
        			return;
        		}
    		}
    		catch (Exception f) {
   				try {
   					if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MINE) {
   		        		verificationBoardGame[i][j + 1] = true;
   		        		numberMine = numberMine + 1;
   		        		mineCrown = mineCrown + boardGame[i][j + 1].getNbCrowns();
   		        		verifyIfNeighbourMine(i, j + 1, boardGame, verificationBoardGame);
   		        	}
   					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
   		        		verificationBoardGame[i + 1][j] = true;
   		        		numberMine = numberMine + 1;
   		        		mineCrown = mineCrown + boardGame[i + 1][j].getNbCrowns();
   		        		verifyIfNeighbourMine(i + 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
   		        		verificationBoardGame[i - 1][j] = true;
   		        		numberMine = numberMine + 1;
   		        		mineCrown = mineCrown + boardGame[i - 1][j].getNbCrowns();
   		        		verifyIfNeighbourMine(i - 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MINE) {
   		        		verificationBoardGame[i][j - 1] = true;
   		        		numberMine = numberMine + 1;
   		        		mineCrown = mineCrown + boardGame[i][j - 1].getNbCrowns();
   		        		verifyIfNeighbourMine(i, j - 1, boardGame, verificationBoardGame);
   		        	}
   		    		else {
   		    			return;
   		    		}
    			}
    			catch (Exception g) {
    				try {
    					if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MINE) {
    		        		verificationBoardGame[i][j - 1] = true;
    		        		numberMine = numberMine + 1;
    		        		mineCrown = mineCrown + boardGame[i][j - 1].getNbCrowns();
    		        		verifyIfNeighbourMine(i, j - 1, boardGame, verificationBoardGame);
    		        	}
    					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
    		        		verificationBoardGame[i + 1][j] = true;
    		        		numberMine = numberMine + 1;
    		        		mineCrown = mineCrown + boardGame[i + 1][j].getNbCrowns();
    		        		verifyIfNeighbourMine(i + 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MINE) {
    		        		verificationBoardGame[i - 1][j] = true;
    		        		numberMine = numberMine + 1;
    		        		mineCrown = mineCrown + boardGame[i - 1][j].getNbCrowns();
    		        		verifyIfNeighbourMine(i - 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MINE) {
    		        		verificationBoardGame[i][j + 1] = true;
    		        		numberMine = numberMine + 1;
    		        		mineCrown = mineCrown + boardGame[i][j + 1].getNbCrowns();
    		        		verifyIfNeighbourMine(i, j + 1, boardGame, verificationBoardGame);
    		        	}
    		    		else {
    		    			return;
    		    		}
    				}
    				catch (Exception h) {
    					return;
    				}
    			}
   			}
   		}		
   	}
    
    public void verifyIfNeighbourMountain(int i, int j, HalfDomino[][] boardGame, boolean[][] verificationBoardGame) {
    	try {
    		if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
        		verificationBoardGame[i + 1][j] = true;
        		numberMountain = numberMountain + 1;
        		mountainCrown = mountainCrown + boardGame[i + 1][j].getNbCrowns();
        		verifyIfNeighbourMountain(i + 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
        		verificationBoardGame[i - 1][j] = true;
        		numberMountain = numberMountain + 1;
        		mountainCrown = mountainCrown + boardGame[i - 1][j].getNbCrowns();
        		verifyIfNeighbourMountain(i - 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
        		verificationBoardGame[i][j + 1] = true;
        		numberMountain = numberMountain + 1;
        		mountainCrown = mountainCrown + boardGame[i][j + 1].getNbCrowns();
        		verifyIfNeighbourMountain(i, j + 1, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
        		verificationBoardGame[i][j - 1] = true;
        		numberMountain = numberMountain + 1;
        		mountainCrown = mountainCrown + boardGame[i][j - 1].getNbCrowns();
        		verifyIfNeighbourMountain(i, j - 1, boardGame, verificationBoardGame);
        	}
    		else {
    			return;
    		}
    	}
    	catch (Exception e) {
    		try {
    			if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
            		verificationBoardGame[i - 1][j] = true;
            		numberMountain = numberMountain + 1;
            		mountainCrown = mountainCrown + boardGame[i - 1][j].getNbCrowns();
            		verifyIfNeighbourMountain(i - 1, j, boardGame, verificationBoardGame);
            	}
    			if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
            		verificationBoardGame[i + 1][j] = true;
            		numberMountain = numberMountain + 1;
            		mountainCrown = mountainCrown + boardGame[i + 1][j].getNbCrowns();
            		verifyIfNeighbourMountain(i + 1, j, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
            		verificationBoardGame[i][j + 1] = true;
            		numberMountain = numberMountain + 1;
            		mountainCrown = mountainCrown + boardGame[i][j + 1].getNbCrowns();
            		verifyIfNeighbourMountain(i, j + 1, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
            		verificationBoardGame[i][j - 1] = true;
            		numberMountain = numberMountain + 1;
            		mountainCrown = mountainCrown + boardGame[i][j - 1].getNbCrowns();
            		verifyIfNeighbourMountain(i, j - 1, boardGame, verificationBoardGame);
            	}
        		else {
        			return;
        		}
    		}
    		catch (Exception f) {
   				try {
   					if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
   		        		verificationBoardGame[i][j + 1] = true;
   		        		numberMountain = numberMountain + 1;
   		        		mountainCrown = mountainCrown + boardGame[i][j + 1].getNbCrowns();
   		        		verifyIfNeighbourMountain(i, j + 1, boardGame, verificationBoardGame);
   		        	}
   					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
   		        		verificationBoardGame[i + 1][j] = true;
   		        		numberMountain = numberMountain + 1;
   		        		mountainCrown = mountainCrown + boardGame[i + 1][j].getNbCrowns();
   		        		verifyIfNeighbourMountain(i + 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
   		        		verificationBoardGame[i - 1][j] = true;
   		        		numberMountain = numberMountain + 1;
   		        		mountainCrown = mountainCrown + boardGame[i - 1][j].getNbCrowns();
   		        		verifyIfNeighbourMountain(i - 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
   		        		verificationBoardGame[i][j - 1] = true;
   		        		numberMountain = numberMountain + 1;
   		        		mountainCrown = mountainCrown + boardGame[i][j - 1].getNbCrowns();
   		        		verifyIfNeighbourMountain(i, j - 1, boardGame, verificationBoardGame);
   		        	}
   		    		else {
   		    			return;
   		    		}
    			}
    			catch (Exception g) {
    				try {
    					if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
    		        		verificationBoardGame[i][j - 1] = true;
    		        		numberMountain = numberMountain + 1;
    		        		mountainCrown = mountainCrown + boardGame[i][j - 1].getNbCrowns();
    		        		verifyIfNeighbourMountain(i, j - 1, boardGame, verificationBoardGame);
    		        	}
    					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
    		        		verificationBoardGame[i + 1][j] = true;
    		        		numberMountain = numberMountain + 1;
    		        		mountainCrown = mountainCrown + boardGame[i + 1][j].getNbCrowns();
    		        		verifyIfNeighbourMountain(i + 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
    		        		verificationBoardGame[i - 1][j] = true;
    		        		numberMountain = numberMountain + 1;
    		        		mountainCrown = mountainCrown + boardGame[i - 1][j].getNbCrowns();
    		        		verifyIfNeighbourMountain(i - 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.MOUNTAIN) {
    		        		verificationBoardGame[i][j + 1] = true;
    		        		numberMountain = numberMountain + 1;
    		        		mountainCrown = mountainCrown + boardGame[i][j + 1].getNbCrowns();
    		        		verifyIfNeighbourMountain(i, j + 1, boardGame, verificationBoardGame);
    		        	}
    		    		else {
    		    			return;
    		    		}
    				}
    				catch (Exception h) {
    					return;
    				}
    			}
   			}
   		}		
   	}
    
    public void verifyIfNeighbourSea(int i, int j, HalfDomino[][] boardGame, boolean[][] verificationBoardGame) {
    	try {
    		if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
        		verificationBoardGame[i + 1][j] = true;
        		numberSea = numberSea + 1;
        		seaCrown = seaCrown + boardGame[i + 1][j].getNbCrowns();
        		verifyIfNeighbourSea(i + 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
        		verificationBoardGame[i - 1][j] = true;
        		numberSea = numberSea + 1;
        		seaCrown = seaCrown + boardGame[i - 1][j].getNbCrowns();
        		verifyIfNeighbourSea(i - 1, j, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.SEA) {
        		verificationBoardGame[i][j + 1] = true;
        		numberSea = numberSea + 1;
        		seaCrown = seaCrown + boardGame[i][j + 1].getNbCrowns();
        		verifyIfNeighbourSea(i, j + 1, boardGame, verificationBoardGame);
        	}
    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.SEA) {
        		verificationBoardGame[i][j - 1] = true;
        		numberSea = numberSea + 1;
        		seaCrown = seaCrown + boardGame[i][j - 1].getNbCrowns();
        		verifyIfNeighbourSea(i, j - 1, boardGame, verificationBoardGame);
        	}
    		else {
    			return;
    		}
    	}
    	catch (Exception e) {
    		try {
    			if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
            		verificationBoardGame[i - 1][j] = true;
            		numberSea = numberSea + 1;
            		seaCrown = seaCrown + boardGame[i - 1][j].getNbCrowns();
            		verifyIfNeighbourSea(i - 1, j, boardGame, verificationBoardGame);
            	}
    			if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
            		verificationBoardGame[i + 1][j] = true;
            		numberSea = numberSea + 1;
            		seaCrown = seaCrown + boardGame[i + 1][j].getNbCrowns();
            		verifyIfNeighbourSea(i + 1, j, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.SEA) {
            		verificationBoardGame[i][j + 1] = true;
            		numberSea = numberSea + 1;
            		seaCrown = seaCrown + boardGame[i][j + 1].getNbCrowns();
            		verifyIfNeighbourSea(i, j + 1, boardGame, verificationBoardGame);
            	}
        		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.SEA) {
            		verificationBoardGame[i][j - 1] = true;
            		numberSea = numberSea + 1;
            		seaCrown = seaCrown + boardGame[i][j - 1].getNbCrowns();
            		verifyIfNeighbourSea(i, j - 1, boardGame, verificationBoardGame);
            	}
        		else {
        			return;
        		}
    		}
    		catch (Exception f) {
   				try {
   					if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.SEA) {
   		        		verificationBoardGame[i][j + 1] = true;
   		        		numberSea = numberSea + 1;
   		        		seaCrown = seaCrown + boardGame[i][j + 1].getNbCrowns();
   		        		verifyIfNeighbourSea(i, j + 1, boardGame, verificationBoardGame);
   		        	}
   					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
   		        		verificationBoardGame[i + 1][j] = true;
   		        		numberSea = numberSea + 1;
   		        		seaCrown = seaCrown + boardGame[i + 1][j].getNbCrowns();
   		        		verifyIfNeighbourSea(i + 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
   		        		verificationBoardGame[i - 1][j] = true;
   		        		numberSea = numberSea + 1;
   		        		seaCrown = seaCrown + boardGame[i - 1][j].getNbCrowns();
   		        		verifyIfNeighbourSea(i - 1, j, boardGame, verificationBoardGame);
   		        	}
   		    		if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.SEA) {
   		        		verificationBoardGame[i][j - 1] = true;
   		        		numberSea = numberSea + 1;
   		        		seaCrown = seaCrown + boardGame[i][j - 1].getNbCrowns();
   		        		verifyIfNeighbourSea(i, j - 1, boardGame, verificationBoardGame);
   		        	}
   		    		else {
   		    			return;
   		    		}
    			}
    			catch (Exception g) {
    				try {
    					if (verificationBoardGame[i][j - 1] == false && boardGame[i][j - 1].getTerrain() == HalfDomino.TerrainType.SEA) {
    		        		verificationBoardGame[i][j - 1] = true;
    		        		numberSea = numberSea + 1;
    		        		seaCrown = seaCrown + boardGame[i][j - 1].getNbCrowns();
    		        		verifyIfNeighbourSea(i, j - 1, boardGame, verificationBoardGame);
    		        	}
    					if (verificationBoardGame[i + 1][j] == false && boardGame[i + 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
    		        		verificationBoardGame[i + 1][j] = true;
    		        		numberSea = numberSea + 1;
    		        		seaCrown = seaCrown + boardGame[i + 1][j].getNbCrowns();
    		        		verifyIfNeighbourSea(i + 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i - 1][j] == false && boardGame[i - 1][j].getTerrain() == HalfDomino.TerrainType.SEA) {
    		        		verificationBoardGame[i - 1][j] = true;
    		        		numberSea = numberSea + 1;
    		        		seaCrown = seaCrown + boardGame[i - 1][j].getNbCrowns();
    		        		verifyIfNeighbourSea(i - 1, j, boardGame, verificationBoardGame);
    		        	}
    		    		if (verificationBoardGame[i][j + 1] == false && boardGame[i][j + 1].getTerrain() == HalfDomino.TerrainType.SEA) {
    		        		verificationBoardGame[i][j + 1] = true;
    		        		numberSea = numberSea + 1;
    		        		seaCrown = seaCrown + boardGame[i][j + 1].getNbCrowns();
    		        		verifyIfNeighbourSea(i, j + 1, boardGame, verificationBoardGame);
    		        	}
    		    		else {
    		    			return;
    		    		}
    				}
    				catch (Exception h) {
    					return;
    				}
    			}
   			}
   		}		
   	}
}
