import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SnowSquirrelBrowser extends Browser {

    private HashMap<String, Double> installedPlugins;
    private String version;
    private double availableQuota;

    public String getVersion() {
        return version;
    }

    public double getQuota() {
        return availableQuota;
    }

    public SnowSquirrelBrowser(String name, double quota, String version){
        super(name);
        this.availableQuota = quota;
        this.version = version;
    }

    public boolean installPlugin (Plugin plugin){
        if (installedPlugins.containsKey(plugin.getName()) == true && plugin.getQuotaReq() > availableQuota && version == plugin.getVersionReq()) {
            return false;
        }else{
            installedPlugins.put(plugin.getName(),plugin.getQuotaReq());
            availableQuota -= plugin.getQuotaReq();
            return true;
        }
    }

    public boolean uninstallPlugin (Plugin plugin) {
        if (installedPlugins.containsKey(plugin.getName()) == false) {
            return false;
        }else{
            installedPlugins.remove(plugin);
            availableQuota += plugin.getQuotaReq();
            return true;
        }
    }

    public boolean usePlugin(String name) {
        if (installedPlugins.containsKey(name) == false && availableQuota < 1) {
            return false;
        }else{
            installedPlugins.put(name, installedPlugins.get(name) + 1);
            availableQuota -= 1;
            return true;
        }
    }

    public ArrayList<String> getInstalledPlugins (){
        ArrayList<String> output = new ArrayList<String>();

        Integer[] valueset = installedPlugins.values().toArray(new Integer[installedPlugins.size()]);

        Arrays.sort(valueset);

        for (int i = valueset.length-1 ; i >= 0; i--) {
            for (String str: installedPlugins.keySet()){
                if (installedPlugins.get(str).equals(valueset[i])){
                    output.add(str);
                }
            }
        }return output;
    }

}
