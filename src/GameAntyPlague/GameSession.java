package GameAntyPlague;

import java.util.HashMap;

public class GameSession implements Runnable, UsesThreadsManager {

    private String threadCategory = "game_session";
    ThreadsManager threadsManager;
    HashMap<String, Object> sessionSettings;
    UsedToSetDifficulty difficultyLevel;
    TimeTasksManager timeManager;

    ScoreKeeper scoreKeeper;

    public GameSession(ThreadsManager threadsManager, HoldsGameSessionSettings gameSessionSettings, DifficultyLevel difficulty){
        this.threadsManager = threadsManager;
        this.sessionSettings = gameSessionSettings.getGameSessionSettings();
        this.difficultyLevel = difficulty;
        this.scoreKeeper = new ScoreKeeper(difficulty);
        this.timeManager = new TimeTasksManager(threadsManager, gameSessionSettings.getTimeManagerSettings());

    }

    public void setDifficultyLevel(UsedToSetDifficulty difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        this.scoreKeeper.changeDifficultyLevel(difficultyLevel);
    }

    @Override
    public void run() {

    }

    @Override
    public String getThreadsCategory() {
        return threadCategory;
    }
}
