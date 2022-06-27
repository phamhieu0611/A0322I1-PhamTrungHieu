package clean_code_refactoring.bai_tap;

public class TennisGame {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    public static String getScore(String player1Name, String player2Name, int score1, int score2) {
        String score = "";
        int tempScore=0;
        if (score1==score2)
        {
            score = getScore(score1);
        }
        else if (score1>=4 || score2>=4)
        {
            score = getAdvantageOrWin(score1, score2);
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = score1;
                else { score+="-"; tempScore = score2;}
                score = getPoint(score, tempScore);
            }
        }
        return score;
    }

    private static String getPoint(String score, int tempScore) {
        switch (tempScore)
        {
            case ZERO:
                score+="Love";
                break;
            case ONE:
                score+="Fifteen";
                break;
            case TWO:
                score+="Thirty";
                break;
            case THREE:
                score+="Forty";
                break;
        }return score;
    }

    private static String getAdvantageOrWin(int score1, int score2) {
        String score;
        int minusResult = score1 - score2;
        boolean advatagePlayer1 = minusResult == 1;
        boolean winForPlayer1 = minusResult >= 2;
        boolean advantagePlayer2 = minusResult ==  -1;

        if (advatagePlayer1) score ="Advantage player1";
        else if (advantagePlayer2) score ="Advantage player2";
        else if (winForPlayer1) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String getScore(int m_score1) {
        String score;
        switch (m_score1){
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }return score;
    }
    
}