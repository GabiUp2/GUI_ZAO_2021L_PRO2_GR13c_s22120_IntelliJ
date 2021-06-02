package GameAntyPlague;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SettingsManager implements HoldsGameLogicSettings{
    private File settings_file;
    private Map<String, Object> settings;
    private DifficultyLevelParser difficultyLevelParser = new DifficultyLevelParser();

    public SettingsManager(File settings_file) throws IOException {
        this.settings_file = settings_file;
        this.read_in_settings_file(settings_file);
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public File getSettings_file() {
        return settings_file;
    }

    public void read_in_settings_file(File settings_file){
        try{
            InputStream inputStream = new FileInputStream(settings_file);
            Yaml yaml = new Yaml();
            this.settings = (Map<String, Object>) yaml.load(inputStream);
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Settings file not found!");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Settings file couldn't be closed!");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("Settings file not read in!");
        }
    }

    public void print_settings(){
        System.out.println(settings.toString());
    }

    @Override
    public HashMap<String, Object> getGameSessionSettings() {
        return null;
    }

    @Override
    public HashMap<String, Object> getTimeManagerSettings() {
        return null;
    }

    @Override
    public Map<String, DifficultyLevel> getSettingsForLevelsOfDifficulty() {
        Map


        return
    }
}
