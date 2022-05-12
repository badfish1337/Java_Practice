import java.util.LinkedHashMap;
import java.util.Map;

public class TimeFormatter {
    public static String formatDuration(int seconds){
        if(seconds == 0){
            return "now";
        }
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();

        int years = seconds / 31536000;
        seconds %= 31536000;
        int days = seconds / 86400;
        seconds %= 86400;
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;

        map.put("year", years);
        map.put("day", days);
        map.put("hour", hours);
        map.put("minute", minutes);
        map.put("second", seconds);

        int mapSize = 0;
        int units = 0;
        for(Map.Entry<String, Integer> unit:map.entrySet()){
            units += (unit.getValue() > 0) ? 1:0;
        }

        StringBuilder time = new StringBuilder();
        for(Map.Entry<String, Integer> unit:map.entrySet()){
            if(unit.getValue() >= 1){
                time.append(unit.getValue()).append(" ");
                time.append(unit.getKey());
                time.append((unit.getValue() > 1) ? "s": "");
                units--;
            }
                if(unit.getValue() > 0 && units > 0){
                    time.append((units == 1) ? " and ": ",  ");
                }
        }
        return time.toString();
    }

}
