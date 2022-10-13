import java.util.HashMap;
import java.util.Map;

public class BonusSeller extends Seller {

    private HashMap<String, Double> sales;

    public BonusSeller(String n){
        super(n);
        this.sales = new HashMap<String, Double>( 10);
    }

    public void sale(String name, double bought) {
        super.sale(bought);
        if(sales.containsKey(name)){
            sales.put(name, sales.get(name) + bought);
        }else{
            sales.put(name,bought);
        }
    }

    public String toString() {
        String output = super.toString() + "\n";
        output += "Sales per customer:" + "\n";
        for (Map.Entry<String,Double> entry : sales.entrySet()){
            System.out.println(
                    entry.getKey() + ":" + entry.getValue()
            );
        }
        return output.trim();
    }

    public int calculateBonus(){
        int count = 0;
        for (String key: sales.keySet()){
            if (sales.get(key) >= 20.0) {
                count++;
            }
        }
        if (count < 5) {
            return 0;
        }else if (5 >= count && count < 10){
            return 5;
        }else{
            return 7;
        }
    }

}
