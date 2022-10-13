import java.util.HashMap;
import java.util.Map;

public class ActivityHoliday extends Holiday {

    private HashMap<String,Cost> activities;

    public ActivityHoliday(String destination, int days){
        super(destination, days);
        activities = new HashMap<String, Cost>(10);
    }

    public void addActivity (String name, Cost cost) {
        activities.put(name,cost);
    }

    public String toString() {
        String output =  destination + " (" + days + ")" + "\n";
        output += "Activities" + "\n";
        for (Map.Entry<String, Cost> entry: activities.entrySet()){
            System.out.print(entry);
        }
        return output;
    }
}
