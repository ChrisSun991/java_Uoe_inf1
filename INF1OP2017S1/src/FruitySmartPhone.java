import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class FruitySmartPhone extends Phone{

    private HashMap<String,Integer> installedApps;
    private int cpuSpeed;
    private int freeMemory;

    public int getCpuSpeed() {
        return cpuSpeed;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public FruitySmartPhone(String name, int freeMemory, int cpuSpeed){
        super(name);
        this.cpuSpeed = cpuSpeed;
        this.freeMemory = freeMemory;
    }

    public boolean installApp(App app) {
        if (app.getMemoryReq() > getFreeMemory() && app.getMemoryReq() > getCpuSpeed() && installedApps.containsKey(app.getName()) == false) {
            return false;
        }else {
            installedApps.put(app.getName(),app.getMemoryReq());
            freeMemory -= app.getMemoryReq();
            return true;
        }

    }

    public boolean uninstallApp (App app) {
        if (!installedApps.containsKey(app.getName())){
            return false;
        }else{
            installedApps.remove(app);
            freeMemory += app.getMemoryReq();
            return true;
        }
    }

    public boolean useApp ( String name) {
        if (installedApps.containsKey(name)== false && freeMemory < 1) {
            return false;
        }else{
            installedApps.put(name,installedApps.get(name)+1);
            freeMemory -= 1;
            return true;
        }
    }

    public ArrayList<String> getInstalledApps ( ){
        ArrayList<String> output = new ArrayList<String>();

        Integer[] valueset = installedApps.values().toArray(new Integer[installedApps.size()]);

        Arrays.sort(valueset);

        for (int i = valueset.length-1 ; i >= 0; i--) {
            for (String str: installedApps.keySet()){
                if (installedApps.get(str) == valueset[i]){
                    output.add(str);
                }
            }
        }return output;
    }



}
