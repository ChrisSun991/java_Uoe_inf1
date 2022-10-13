import java.util.HashMap;
import java.util.Map;

public class GymSession extends ExerciseSession {

    private HashMap<String, Length> machines;

    public GymSession(String type,String place){
        super(type,place);
        this.machines = new HashMap<String, Length>(8);
    }

    public void addMachine(String name, Length used) {
        machines.put(name,used);
    }

    public String toString() {
        String output = super.toString() + "\n";
        output += "Machines:" + "\n";
        for (Map.Entry<String,Length> entry : machines.entrySet()){
            System.out.println(entry.getKey() + "" + entry.getValue());
        }
        return output.trim();
    }
}
