public class Cost {

    private int amount;
    private String currency;

    public Cost(){
        this.amount = 0;
        currency = "pounds sterling";
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAmount(int amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }

    public void setCurrency(String currency) {
        if (currency.equals("pounds sterling") || currency.equals("US dollars") || currency.equals("euros")){
            this.currency = currency;
        }
    }

    public void convert(String newCurrency, double rate){
        if (currency.equals("pounds sterling") || currency.equals("US dollars") || currency.equals("euros")){
            amount = (int)Math.round(rate*amount);
        }
    }

    public String toString() {
        return amount + " " + currency;
    }
}
