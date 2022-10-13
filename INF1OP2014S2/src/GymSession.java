import java.util.HashMap;
import java.util.Map;

public class GymSession extends ExerciseSession {

    private HashMap<String, Length> machines;

    public GymSession(String type, String place) {
        super(type, place);
        machines = new HashMap<String, Length>(8);
    }

    public void addMachine(String name, Length use){
        machines.put(name,use);
    }

    @Override
    public String toString() {
        String output = type + " (" + place + ")";
        output += "Machines";
        for(Map.Entry<String, Length> entry : machines.entrySet()) {
            System.out.println(entry);
        }

        return output;
    }
}
