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

    public void fireBall(Hero hero) {
        int fireBall = rnd.nextInt(2) + 1;

        if(fireBall == 1) {
            dragonAttack(hero);
        } else {
            int baseDamage = this.strength * 2;
            calcDamage(hero, baseDamage, true);
        }
    }

    public void dragonAttack(Hero hero) {
        int attack = rnd.nextInt(2) + 1;
        
        if (attack == 1) {
            print("Противник не стал атаковать героя");
        } else {
            int baseDamage = this.strength + this.weapon;

            calcDamage(hero, baseDamage, false);
        }
    }
    
    public void calcDamage(Hero hero, int baseDamage, boolean isFireBall) {
        int damage;
        int health;

        if (isFireBall) {
            if (hero.isShieldUp()) {
                print("Герой поднял щит и отразил огненный шар");
                damage = 0;
            } else {
                print("Дракон плюется огненным шаром!");
                damage = Math.max(0, baseDamage);
            }
        } else {
            if(hero.isShieldUp()) {
                print("Герой поднял щит");
                damage = Math.max(0, baseDamage - (hero.getDefense() + hero.getShield()));
                if (damage == 0) {
                    print("Противник попал и нанёс " + damage + " урона");
                }
            } else {
                damage = Math.max(0, baseDamage - (hero.getDefense()));
            }
        }

        health = hero.getHp() - damage;
        
        if (damage > 0) {
            print("Противник попал и нанёс " + damage + " урона");
        }

        hero.setHp(Math.max(0, health));
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