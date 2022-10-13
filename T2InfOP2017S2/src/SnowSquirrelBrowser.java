import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SnowSquirrelBrowser extends Browser {

    private HashMap<String,Double> installedPlugins= new HashMap<String,Double>();
    private String version;
    private double availableQuota;

    public String getVersion() {
        return version;
    }

    public double getQuota() {
        return availableQuota;
    }

    public SnowSquirrelBrowser(String name, Double quota, String version){
        super(name);
        this.availableQuota = quota;
        this.version = version;
    }

    public boolean installPlugin (Plugin plugin){
        if(installedPlugins.containsKey(plugin) || plugin.getQuotaReq() > availableQuota
        || !plugin.getVersionReq().equals(version)){
            return false;
        }
        installedPlugins.put(plugin.getName(),plugin.getQuotaReq());
        availableQuota -= plugin.getQuotaReq();
        return true;
    }

    public boolean uninstallPlugin (Plugin plugin){
        if (!installedPlugins.containsKey(plugin)){
            return false;
        }
        installedPlugins.remove(plugin);
        availableQuota += plugin.getQuotaReq();
        return true;
    }

    public boolean usePlugin ( String name){
        if (!installedPlugins.containsKey(name) || installedPlugins.get(name) > availableQuota){
            return false;
        }
        installedPlugins.put(name,installedPlugins.get(name)+1);
        availableQuota -= 1;
        return true;
    }

    public ArrayList<String> getInstalledPlugins(){
        ArrayList<String> result = new ArrayList<String>();
        Double[] value = installedPlugins.values().toArray(new Double[installedPlugins.size()]);

        Arrays.sort(value);

        for (int i = value.length -1 ; i > 0; i--){
            for (String str : installedPlugins.keySet()){
                if (installedPlugins.get(str) == value[i]){
                    result.add(str);
                }
            }
        }
        return result;
    }

}
