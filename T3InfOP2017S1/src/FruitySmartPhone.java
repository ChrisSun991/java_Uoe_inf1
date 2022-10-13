import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class FruitySmartPhone extends Phone{

    private HashMap<String,Integer> installedApps= new HashMap<String,Integer>();
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

    public boolean installApp(App app){
        if (installedApps.containsKey(app.getName()) || app.getCpuReq() > cpuSpeed
        || app.getMemoryReq() > freeMemory){
            return false;
        }
        installedApps.put(app.getName(),app.getMemoryReq());
        freeMemory -= app.getMemoryReq();
        return true;
    }

    public boolean uninstallApp(App app){
        if (!installedApps.containsKey(app.getName())){
            return false;
        }
        installedApps.remove(app.getName());
        freeMemory += app.getMemoryReq();
        return true;
    }

    public boolean useApp (String name){
        if (!installedApps.containsKey(name) || installedApps.get(name) > freeMemory){
            return false;
        }
        installedApps.put(name,installedApps.get(name) + 1);
        freeMemory -= 1;
        return true;
    }

    public ArrayList<String> getInstalledApps() {
        ArrayList<String> result = new ArrayList<String>();
        Integer[] value = installedApps.values().toArray(new Integer[installedApps.size()]);

        Arrays.sort(value);

        for (int i = value.length - 1; i > 0; i++){
            for (String str : installedApps.keySet()){
                if (installedApps.get(str) == value[i]){
                    result.add(str);
                }
            }
        }
        return result;
    }

}
