import java.util.Random;

public class Hero {
    private int hp;
    private int defense;
    private int strength;
    private int weapon;
    private int shield;
    private boolean isShieldUp;

    private static Random rnd = new Random();

    public Hero(
        int hp, 
        int defense, 
        int strength, 
        int weapon, 
        int shield, 
        boolean isShieldUp) {

        this.hp = hp;
        this.defense = defense;
        this.strength = strength;
        this.weapon = weapon;
        this.shield = shield;
        this.isShieldUp = isShieldUp;
    }

    public void heroAttack(Dragon dragon) {
        int attack = rnd.nextInt(4) + 1;

        if (attack > 3) {
            print("=========================================");
            print("Герой промазал атаку");
        } else {
            print("=========================================");
            int damage = Math.max(0, (this.strength + this.weapon) - dragon.getDefense());
            int health = dragon.getHp() - damage;

            print("Герой попал и нанёс " + damage + " урона");
            dragon.setHp(Math.max(0, health));
        }

    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setShieldUp(boolean isShieldUp) {
        this.isShieldUp = isShieldUp;
    }

    public int getHp() {
        return hp;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getShield() {
        return shield;
    }

    public boolean isShieldUp() {
        return isShieldUp;
    }

    public void print(String str) {
        System.out.println(str);
    }
}