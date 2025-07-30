package java_class_object;

public class Entity {
    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected String lastAction = "";
    protected boolean defending = false;

    public Entity(String name, int maxHp) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
    }

    public void heal(int amount) {
        currentHp = Math.min(currentHp+amount,maxHp);
    }
    public void take_dmg(int damage) {
        this.currentHp -= damage;
        if (this.currentHp < 0) this.currentHp = 0;
        System.out.println(name+ " takes "+damage+" damage!");
    }
    public boolean alive() {
        return currentHp >0;
    }

    public String getName() {
        return name;
    }
    public int getCurrentHP() {
        return currentHp;
    }public int getMaxHP() {
        return maxHp;
    }

}

