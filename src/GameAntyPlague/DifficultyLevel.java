package GameAntyPlague;

public class DifficultyLevel implements UsedToSetDifficulty{
    private String levelName;
    private double timeCountModifier;
    private double basicVirusSpreadProbability;
    private double scoreMultiplier;
    private double spendingPointsMultiplier;

    public DifficultyLevel(String level_name, double time_count_modifier, double basic_virus_spread_probability, double score_multiplier, double points_multiplier){
        this.levelName = level_name;
        this.timeCountModifier = time_count_modifier;
        this.basicVirusSpreadProbability = basic_virus_spread_probability;
        this.scoreMultiplier = score_multiplier;
        this.spendingPointsMultiplier = points_multiplier;

    }

    public String getLevelName() {
        return levelName;
    }

    public double getScoreMultiplier() {
        return scoreMultiplier;
    }

    public double getSpendingPointsMultiplier() {
        return spendingPointsMultiplier;
    }

    @Override
    public String toString() {
        return "DifficultyLevel{" +
                "levelName='" + levelName + '\'' +
                ", scoreMultiplier=" + scoreMultiplier +
                ", pointsMultiplier=" + spendingPointsMultiplier +
                '}';
    }
}
