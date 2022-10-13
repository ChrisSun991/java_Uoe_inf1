public class Boss extends Monster{

    private int stage;
    private final int initialHealth;

    public Boss (int health, int power){
        super(health, power);
        this.initialHealth = health;
        this.stage = 1;
    }

    public String toString(){
        String output = super.toString() + "\n";
        output += "Power: " + power;
        return output;
    }

    @Override
    public void takeDamage(int damage){
        health -= damage;
        if (health/initialHealth <= 0.5){
            power *= 2;
            stage += 1;
        }
        if (health/initialHealth <= 0.2){
            power *= 2;
            stage += 1;
        }
    }

}
