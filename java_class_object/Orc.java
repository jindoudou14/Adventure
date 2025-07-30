package java_class_object;

public class Orc extends Monster {
    private static final String[] ATTACK_VERBS ={
            "charges into",
            "roars at",
            "smashes"
    };
    public Orc() {
        super("Orc", randHp(), 12, 8, 12);
    }

    private static int randHp() {
        return 28+new java.util.Random().nextInt(13);
    }

    @Override
    public void useSpecialAbility(Entity target) {

        System.out.println("The Orc flies into a rage! Damage increased!");
        this.minDmg += 3;
        this.maxDmg += 5;
        //System.out.printf("min: %d, max: %d %n",minDmg,maxDmg);

    }

    @Override
    public void attack(Entity enemy) {
        if (getCurrentHP() <=getMaxHP()/2) {
            useSpecialAbility(enemy);
        }
        if (rng.nextDouble() <0.5) {
            System.out.println(name + " swings wide and misses!");
        } else {
            String verb = ATTACK_VERBS[rand(0, ATTACK_VERBS.length - 1)];
            super.attack(enemy, verb);


        }
    }


}
