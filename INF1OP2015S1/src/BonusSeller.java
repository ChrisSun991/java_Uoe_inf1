import java.util.HashMap;
import java.util.Map;

public class BonusSeller extends Seller{

    private HashMap<String, Double> sales;

    public BonusSeller(String n) {
        super(n);
        sales = new HashMap<String, Double>(10);
    }

    public void sale(String name, double d) {
        super.sale(d);
        if (sales.containsKey(name)) {
            sales.put(name, sales.get(name) + d);
        }else{
            sales.put(name,d);
        }
    }

    @Override
    public String toString() {
        String output = super.toString() + "\n";
        output += "Sales per customer:" + "\n";
        for (String key : sales.keySet()) {
            for (Double value : sales.values()){
                System.out.println(key + " : " + (Math.round(value)));
            }
        }
        return output;
    }

    public int calculateBonus () {
        int count = 0;
        for (String key : sales.keySet()) {
            if (sales.get(key) >= 20.0){
                count++;
            }
        }
        if (count < 5) {
            return 0;
        }else if (count >= 5 && count < 10){
            return 5;
        }else{
            return 7;
        }
    }
}
