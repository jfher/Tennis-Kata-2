import main.java.TennisGame;



public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1Result = "";
    public String player2Result = "";
    private String player1Name;
    private String player2Name;
    private String score="";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        setScoreTiedOnPointsLessForty();
        setGameOnDeuce();
        setPlayerAnnotation();
        setRegularScore();
        setAdvantageScore();
        setWonScore();
        return score;
    }

	private void setScoreTiedOnPointsLessForty() {
		if (isScoreDrawUnderForty(player1Points,player2Points) && isLessToForty(player1Points))
            setTiedScoreOnLiteral(player1Points);     
	}

	private void setTiedScoreOnLiteral(int playerPoints) {
		if (playerPoints==0)
		    score = "Love";
		if (playerPoints==1)
		    score = "Fifteen";
		if (playerPoints==2)
		    score = "Thirty";
		score += "-All";
	}

	private boolean isLessToForty(int playerPoints) {
		return playerPoints < 4;
	}

	private void setWonScore() {
		if (isGamePointForPlayer(player1Points) && isEqualOrGreaterToLove(player2Points) && existDifferenceOf2Points(player1Points,player2Points))
            score = "Win for player1";
        
        if (isGamePointForPlayer(player2Points) && isEqualOrGreaterToLove(player1Points) && existDifferenceOf2Points(player2Points,player1Points))
            score = "Win for player2";
	}

	private boolean isEqualOrGreaterToLove(int playerPoints) {
		return playerPoints>=0;
	}

	private boolean isGamePointForPlayer(int playerPoints) {
		return playerPoints>=4;
	}

	private boolean existDifferenceOf2Points(int points, int points2) {
		return (points-points2)>=2;
	}

	private void setAdvantageScore() {
		if (leadingPlayerOnTheScore(player1Points,player2Points) && isGreaterOrEqualToForty(player2Points))
            score = "Advantage player1";
        
        if (leadingPlayerOnTheScore(player2Points,player1Points) && isGreaterOrEqualToForty(player1Points))
            score = "Advantage player2";
	}

	private boolean leadingPlayerOnTheScore(int player,int player2) {
		return player > player2;
	}
	
	private boolean isGreaterOrEqualToForty(int playerPoints) {
		return playerPoints >= 3;
	}

	/*Falta*/
	private void setRegularScore() {
		if (leadingPlayerOnTheScore(player1Points,player2Points) && isLessToForty(player1Points))
        {
			player1Result = setLiteralScore(player1Points);
			player2Result = setLiteralScore(player2Points);
            score = player1Result + "-" + player2Result;
        }
        if (leadingPlayerOnTheScore(player2Points,player1Points) && isLessToForty(player2Points))
        {
        	player2Result = setLiteralScore(player2Points);
			player1Result = setLiteralScore(player1Points);
            score = player1Result + "-" + player2Result;
        }
	}
	/*Falta*/
	private void setPlayerAnnotation() {
		if (player1Points > 0 && player2Points==0)
        {
            player1Result=setLiteralScore(player1Points);
            player2Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        if (player2Points > 0 && player1Points==0)
        {
        	player2Result=setLiteralScore(player2Points);
            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }
	}

	private String setLiteralScore(int playerPoints) {
		String literal="";
		if (playerPoints==0)
			literal = "Love";
		if (playerPoints==1)
			literal = "Fifteen";
		if (playerPoints==2)
			literal = "Thirty";
		if (playerPoints==3)
			literal = "Forty";
		return literal;
	}

	private void setGameOnDeuce() {
		if (isScoreDrawUnderForty(player1Points,player2Points) && isGreaterOrEqualToForty(player1Points))
            score = "Deuce";
	}

	private boolean isScoreDrawUnderForty(int playerPoints,int playerPoints2) {
		return playerPoints==playerPoints2;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            addPointsP1();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            addPointsP2();
        }
            
    }
    
    public void addPointsP1(){
        player1Points++;
    }
    
    public void addPointsP2(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            addPointsP1();
        else
            addPointsP2();
    }
}