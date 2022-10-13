import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class FruitySmartPhone extends Phone{
	
	private HashMap<String,Integer> installedApps = new HashMap<String,Integer>();
	private int cpuSpeed;
	private int freeMemory;

	public int getCpuSpeed() {
		return cpuSpeed;
	}

	public int getFreeMemory() {
		return freeMemory;
	}

	public FruitySmartPhone(String name, int memory, int cpuspeed) {
		super(name);
		this.freeMemory = memory;
		this.cpuSpeed = cpuSpeed;
	}
	
	public boolean installApp(App app) {
		if (installedApps.containsKey(app.getName()) || app.getMemoryReq() > freeMemory
				|| app.getCpuReq() > cpuSpeed) {
			return false;
		}
		installedApps.put(app.getName(), app.getMemoryReq());
		freeMemory -= app.getMemoryReq();
		return true;
	}
	
	public boolean uninstallApp(App app) {
		boolean output = true;
		if (!installedApps.containsKey(app.getName())){
			output = false;
		}else {
			installedApps.remove(app.getName());
			freeMemory += app.getMemoryReq();
			output = true;
		}
		return output;
	}
	
	public boolean useApp(String name) {
		boolean output = true;
		if (!installedApps.containsKey(name) || installedApps.get(name) > freeMemory) {
			output = false;
		}else {
			installedApps.put(name, installedApps.get(name) + 1);
			freeMemory -= 1;
			output = true;
		}
		return output;
	}
	
	public ArrayList<String> getInstalledApps(){
		ArrayList<String> result = new ArrayList<String>();
		Integer[] value = installedApps.values().toArray(new Integer[installedApps.size()]);
		
		Arrays.sort(value);
		
		for (int i = value.length-1; i >= 0; i--) {
			for (String str : installedApps.keySet()) {
				if (installedApps.get(str) == value[i]) {
					result.add(str);
				}
			}
		}
		return result;
	}
}
