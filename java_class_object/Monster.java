package java_class_object;
import java.util.Random;

public abstract class Monster extends Entity {
    protected int lootValue;
    protected int minDmg, maxDmg;
    protected final Random rng = new Random();

    public Monster(String name, int maxHp, int loot, int minD, int maxD) {   //Constructor
        super(name, maxHp);
        this.lootValue = loot;
        minDmg = minD;
        maxDmg = maxD;
    }

    protected int rand(int a, int b) {
        return rng.nextInt(b-a+1)+a;
    }

    public void attack(Entity enemy, String verb) {
        if (!enemy.alive()) return;
        int dmg = rand(minDmg, maxDmg);
        System.out.println(name+ " "+ verb+ " "+enemy.getName()+"!");
        enemy.take_dmg(dmg);
    }

    public void attack(Entity enemy) {
        attack(enemy, "attacks");
    }
    public int loot() {
        System.out.println(name+" dropped "+lootValue+" gold!");
        return lootValue;
    }
    public abstract void useSpecialAbility(Entity target);
}
