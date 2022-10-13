public class Purchase {
    double value;
    String category; //Such as "Food", "Drink".
    String mode; //Contactless purchase mode "RobotPay","DroidCard"
    public Purchase(String c, String t, double v) {
        value     = v;
        category  = c;
        mode      = t;
    }
    public double getValue() { return value; }
    public String getMode() { return mode; }
    public String getCategory() { return category;}
    public String toString() { return "[ " + category + ", " + mode + ", " + value + " ]"; }
}