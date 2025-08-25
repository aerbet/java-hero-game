import java.util.Random;
import java.util.Scanner;

public class Game {
    static Random rnd = new Random();
    static int enemyChoice = rnd.nextInt(2) + 1;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Dragon dragon = new Dragon(2000, 120, 220, 0);
        Dragon hellHound = new Dragon(1500, 100, 190, 30);
        Hero hero = new Hero(10000, 100, 150, 250, 150, false);

        if (enemyChoice == 1) {
            print("Компьютер выбрал в качестве противника -- Дракона --");
            chooseEnemy(hero, dragon);
        } else {
            print("Компьютер выбрал в качестве противника -- Адскую гончую --");
            chooseEnemy(hero, hellHound);
        }

    }

    public static void chooseEnemy(Hero hero, Dragon enemy) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;

        while (true) {
            print("Выберите действие героя: a - атаковать, d - защищаться, s - ничего не делать");
            String user = sc.nextLine().trim();
            print("\nХод номер: " + counter++);
            
            switch (user) {
                case "a":
                    hero.setShieldUp(false);
                    hero.heroAttack(enemy);
                    System.out.printf("<<< У противника осталось: %s HP >>>%n%n", enemy.getHp());

                    if (enemy.getHp() <= 0) {
                        print("Противник умер, герой победил!");
                        printLabel();
                        System.exit(0);
                    }
                    break;
                case "d":
                    hero.setShieldUp(true);
                    printLabel();
                    break;
                case "s":
                    hero.setShieldUp(false);
                    printLabel();
                    print("Герой решил ничего не делать");
                    break;
                default:
                    print("Неизвестная команда, герой теряет ход");
                    break;
            }

            if (enemy.getHp() > 0) {

                if (enemyChoice == 1) {
                    enemy.fireBall(hero);
                } else {
                    enemy.dragonAttack(hero);
                }

                System.out.printf("<<< У героя осталось: %s HP >>>%n", hero.getHp());
                printLabel();
                
                if (hero.getHp() <= 0) {
                    print("Герой умер, противник победил!");
                    printLabel();
                    break;
                }
            }
        }

        sc.close();
    }
    
    public static void printLabel() {
        print("=========================================");
    }

    public static void print(String str) {
        System.out.println(str);
    }
}