public class Length {

    private int number;
    private String units;

    public Length(){
        this.number = 0;
        units = "km";
    }

    public int getNumber() {
        return number;
    }

    public String getUnits() {
        return units;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        }
    }

    public void setUnits(String units) {
        if (units.equals("km") || units.equals("miles") || units.equals("minuets")) {
            this.units = units;
        }
    }

    public void convert (String newUnits, double rate){
        if (units.equals("km") || units.equals("miles") || units.equals("minuets")){
            units = newUnits;
            number = (int)Math.round(number/rate);
        }
    }

    public String toString() {
        return number + " " + units;
    }
}
