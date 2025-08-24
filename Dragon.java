import java.util.Random;

public class Dragon {
    private int hp;
    private int defense;
    private int strength;
    private int weapon;

    private static Random rnd = new Random();
    
    public Dragon(int hp, int defense, int strength, int weapon) {
        this.hp = hp;
        this.defense = defense;
        this.strength = strength;
        this.weapon = weapon;
    }

    public void dragonAttack(Hero hero) {
        int damage;
        int health;
        int attack = rnd.nextInt(2) + 1;

        if (attack == 1) {
            print("Противник не стал атаковать героя");
        } else {

            if(hero.isShieldUp()) {
                damage = Math.max(0, (this.strength + this.weapon) - (hero.getDefense() + hero.getShield()));

                health = hero.getHp() - damage;
                print("Противник попал и нанёс " + damage + " урона");
                hero.setHp(Math.max(0, health));
            } else {
                damage = Math.max(0, (this.strength + this.weapon) - (hero.getDefense()));
                health = hero.getHp() - damage;

                print("Противник попал и нанёс " + damage + " урона");
                hero.setHp(Math.max(0, health));
            }
        }

    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public void print(String str) {
        System.out.println(str);
    }
}