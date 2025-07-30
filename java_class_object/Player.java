package java_class_object;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Player extends Entity {
    private int experience;
    private int level;
    private int gold;
    private List<String> inventory;


    public Player(String name) {
        super(name, 100);
        this.experience =0;
        this.level = 1;
        this.gold = 0;
        this.inventory = new ArrayList<>();

    }
    protected int rand(int a, int b) {
        Random rng = new Random();
        return rng.nextInt(b-a+1)+a;
    }

    public void attack(Monster target) {
        int damage = calculateDamage();
        System.out.printf("%s attacks the %s for %d damage!%n", this.getName(), target.getName(), damage);
        target.take_dmg(damage);
    }

    private int calculateDamage() {
        return this.level*2 + rand(3,9);
    }

    public void gainExp(int xp) {
        this.experience+=xp;
        checkLevelUp();
    }

    private void checkLevelUp() {
        int xpNeeded = 100*level;
        if (experience >=xpNeeded) {
            this.level++;
            this.experience -= xpNeeded;
            System.out.printf("%s leveled up to level %d!%n",getName(),level);
        }
    }

    public void addGold(int amount) {
        this.gold +=amount;
        System.out.printf("Obtained %d gold! (Total: %d)%n", amount, gold);
    }
    public void displayStatus() {
        System.out.println("\n=== Player Status ===");
        System.out.println("Name: "+getName());
        System.out.println("HP: " + getCurrentHP() + "/" + getMaxHP());
        System.out.println("Level: "+ level);
        System.out.println("EXP: " + experience + "/" + (level * 100));
        System.out.println("Gold: "+gold);
    }
}
