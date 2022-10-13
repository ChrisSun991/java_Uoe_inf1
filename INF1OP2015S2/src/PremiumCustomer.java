import java.util.Collection;
import java.util.Map;

public class PremiumCustomer extends Customer{

    private Map<String,String> freeGifts;

    public PremiumCustomer(String name, Map<String, String> map) {
        super(name);
        freeGifts = map;
    }

    public void giftsFrom(String item, int quantity) {
        if (freeGifts.containsKey(item)){
            System.out.println(freeGifts.get(item) + " x " + quantity);
        }
    }

    public String toString() {
        String output =  super.toString();
        output += "Free gifts:";
        for (Map.Entry<String, String> entry : freeGifts.entrySet()){
            System.out.println(entry.getKey()+" : "+ entry.getValue());
        }

        return output;
    }

    public int chocolateGifts() {
        int count = 0;
        Collection<String> set = freeGifts.values();
        for (String str: set) {
            if (str.contains("chocolate")) {
                count++;
            }
        }

        return  count;
    }
}
