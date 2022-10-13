public class Cost {

    private int amount;
    private String currency;

    public Cost() {
        this.amount = 0;
        currency = "pounds sterling";
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount( Integer amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if(currency.equals("pounds sterling") || currency.equals("US dollars") || currency.equals("euros")) {
            this.currency = currency;
        }
    }

    public void convert (String newCurrency, double rate) {
        if(currency.equals("pounds sterling") || currency.equals("US dollars") || currency.equals("euros")){
            currency = newCurrency;
            amount = (int)((amount/rate) + 0.5);
        }
    }

    public String toString(){
        return amount + " " + currency;
    }

}
