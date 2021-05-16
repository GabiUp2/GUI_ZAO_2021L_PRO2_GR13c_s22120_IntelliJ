package GameAntyPlague;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;

public class SettingsManager {
    private File settings_file;
    private ArrayList<Object> settings;

    public SettingsManager(File settings_file) throws IOException {
        this.settings_file = settings_file;
        this.read_in_settings_file(settings_file);
    };

    public Object getSettings() {
        return settings;
    }

    public File getSettings_file() {
        return settings_file;
    }

    public void read_in_settings_file(File settings_file){
        try{
            InputStream inputStream = new FileInputStream(settings_file);
            Yaml yaml = new Yaml();
            Iterable<Object> all_docs = yaml.loadAll(inputStream);
            inputStream.close();

            for (Object document : all_docs) {
                this.settings.add(document);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Settings file not found!");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Settings file couldn't be closed!");
            e.printStackTrace();
        }
    }

    public void print_settings(){
        for (Object document: this.settings) {
            System.out.println(document.toString());
        }
    }
}
