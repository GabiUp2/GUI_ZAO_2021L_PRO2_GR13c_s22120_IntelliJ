package GameAntyPlague;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class GameLogicManager implements UsesThreadsManager, StartsNewGame{
    // Controls game sessions and their threads
    private static final String thread_category = "game_logic";

    private ThreadsManager threadsManager;
    private HoldsGameLogicSettings gameLogicSettings;
    private GUIManager guiManager;

    private Map<String, DifficultyLevel> possible_levels_of_difficulty;
    private String selected_level_of_difficulty;

    private GameSession currentGame;
    private Thread currentGameSessionThread;

    public GameLogicManager(ThreadsManager threadsManager, HoldsGameLogicSettings gameLogicSettings, GUIManager guiManager){
        this.threadsManager = threadsManager;
        this.gameLogicSettings = gameLogicSettings;
        this.guiManager = guiManager;
        this.possible_levels_of_difficulty = gameLogicSettings.getSettingsForLevelsOfDifficulty();

    }

    @Override
    public void startNewGame() {

        setSelectedLevelOfDifficulty(guiManager.AskForDifficultyLevel((List<String>) possible_levels_of_difficulty.keySet()));
        currentGame = new GameSession(threadsManager, gameLogicSettings, possible_levels_of_difficulty.get(selected_level_of_difficulty));
        currentGameSessionThread = threadsManager.generateNewThread(getThreadsCategory(), currentGame);
    }

    @Override
    public String getThreadsCategory() {
        return GameLogicManager.thread_category;
    }

    public void setSelectedLevelOfDifficulty(String level_of_difficulty) {
        this.selected_level_of_difficulty = level_of_difficulty;
    }

    public Map<String, DifficultyLevel> getPossibleLevelsOfDifficulty() {
        return possible_levels_of_difficulty;
    }

    public GameSession getCurrentGame() {
        return currentGame;
    }


}
