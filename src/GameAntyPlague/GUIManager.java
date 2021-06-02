package GameAntyPlague;

import javax.swing.*;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class GUIManager implements UsesThreadsManager {
    static final String threadCategory = "GUI";
    private ThreadsManager threadsManager;
    private SettingsManager settingsManager;

    private JFrame currentlyShownFrame;
    private Thread currentFrameThread;

    private Map<String, JFrame> frames = Map.ofEntries(entry("MainFrame", new MainFrame()));

    public GUIManager(ThreadsManager threadsManager, SettingsManager settingsManager) {
        this.threadsManager = threadsManager;
        this.settingsManager = settingsManager;

    }

    public void showFrame(String frameName) {
        if (currentlyShownFrame != null){
            currentlyShownFrame.setVisible(false);
        }

        currentlyShownFrame = frames.get(frameName);
        currentlyShownFrame.setVisible(true);
    }

    public String AskForDifficultyLevel(List<String> list_of_difficulty_levels){
        String _result;
        _result = (String)JOptionPane.showInputDialog(currentlyShownFrame,
                "Select game difficulty level",
                "Game Difficulty",
                JOptionPane.PLAIN_MESSAGE,
                null,
                new List[]{list_of_difficulty_levels},
                list_of_difficulty_levels.get(0)
                );
        return _result;
    }

    @Override
    public String getThreadsCategory() {
        return threadCategory;
    }
}
