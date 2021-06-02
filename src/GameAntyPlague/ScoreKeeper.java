package GameAntyPlague;

public class ScoreKeeper {

    private int currentScore=0;
    private int spendingPoints = 0;

    private String difficultyName="normal";
    private double scoreMultiplier = 1;
    private double spendingPointsMultiplier = 1;

    public ScoreKeeper(){

    }

    public ScoreKeeper(UsedToSetDifficulty difficultyLevel){
        setDifficultyName(difficultyLevel.getLevelName());
        setScoreMultiplier(difficultyLevel.getScoreMultiplier());
        setSpendingPointsMultiplier(difficultyLevel.getSpendingPointsMultiplier());
    }

    public void changeDifficultyLevel(UsedToSetDifficulty difficultyLevel){
        setDifficultyName(difficultyLevel.getLevelName());
        setScoreMultiplier(difficultyLevel.getScoreMultiplier());
        setSpendingPointsMultiplier(difficultyLevel.getSpendingPointsMultiplier());
    }

    public void setScoreMultiplier(double scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    public void setSpendingPoints(int spendingPoints) {
        this.spendingPoints = spendingPoints;
    }

    public void setSpendingPointsMultiplier(double spendingPointsMultiplier) {
        this.spendingPointsMultiplier = spendingPointsMultiplier;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }
}
