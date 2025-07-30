package java_class_object;

public class Goblin extends Monster {
    private static final String[] ATTACK_VERBS={
        "lunges towards",
        "runs into",
        "confronts"
    };

    public Goblin() {
        super("Goblin", randHp(), 20, 3, 10);
    }
    public static int randHp(){
        return 8+new java.util.Random().nextInt(15);
    };

    @Override
    public void useSpecialAbility(Entity target) {
        System.out.println("The goblin has stolen something!");
    }

    @Override
    public void attack(Entity enemy) {
        String verb = ATTACK_VERBS[rand(0,ATTACK_VERBS.length - 1)];
        super.attack(enemy, verb);

        if (rand(1,100) <=75) {
            useSpecialAbility(enemy);
        }
    }

    // public static void main(String[] args) {
    //     class2 obj = new class2();
    //     obj.display();
    //     obj.display2();

    //     System.out.println(obj.x+obj.y);
    // }
}
