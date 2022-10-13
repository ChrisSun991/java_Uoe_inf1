import java.util.Map;

public class PremiumCustomer extends Customer{

    private Map<String, String> freeGifts;

    public PremiumCustomer(String name, Map<String, String> map){
        super(name);
        this.freeGifts = map;
    }

    public void giftsFrom(String item, int quantity) {
        if (freeGifts.containsKey(item)){
            System.out.println(freeGifts.get(item) + " x " + quantity);
        }
    }

    public String toString() {
        String output = super.toString() + "\n";
        output += "Free gifts:" +  "\n";
        for (Map.Entry<String,String>entry : freeGifts.entrySet()){
            System.out.println(
                    entry.getKey() + " on ordering " + entry.getValue()
            );
        }
        return output.trim();
    }

    public int chocolateGifts(){
        int count = 0;
        for (String value : freeGifts.values()){
            if (value.contains("chocolate")){
                count++;
            }
        }return count;
    }
}
