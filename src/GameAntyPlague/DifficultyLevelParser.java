package GameAntyPlague;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifficultyLevelParser {

    public DifficultyLevelParser(){
    }

    public List<DifficultyLevel> parseMany(HashMap raw_settings){

        List<DifficultyLevel> _parsed_difficulty_levels = null;

        raw_settings.forEach((key,value) -> _parsed_difficulty_levels.add(parseOne((HashMap) value)));

        return _parsed_difficulty_levels;
    }

    private DifficultyLevel parseOne(HashMap one_level_setting) {

        DifficultyLevel _difficulty_level = new DifficultyLevel((String) one_level_setting.get("name"),
                (double) one_level_setting.get("time_count_modifier"),
                (double) one_level_setting.get("basic_virus_spread_probability"),
                (double) one_level_setting.get("score_multiplier"),
                (double) one_level_setting.get("spendingPointsMultiplier")
                );

        return _difficulty_level;
    }

}
