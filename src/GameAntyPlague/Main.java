package GameAntyPlague;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        SettingsManager settingsManager = new SettingsManager(new File("settings.yaml"));
        settingsManager.print_settings();

        ThreadsManager threadsManager = new ThreadsManager();

        //i want only managers to work in main thread
        GUIManager guiManager = new GUIManager(threadsManager, settingsManager);
        GameLogicManager gameLogicManager = new GameLogicManager(threadsManager, settingsManager, guiManager);

        //app starts with main window
        guiManager.showFrame("MainFrame");

    }

}
