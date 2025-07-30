package java_class_object;

public class Slime extends Monster {
    private static final String[] ATTACK_VERBS = {
            "splashes onto",
            "engulfs",
            "jumps at"
    };
    public Slime() {
        super("Green Slime", randHp(), 10, 2 ,5);
    }

    private static int randHp() {
        return 12+new java.util.Random().nextInt(20);
    }
    @Override
    public void useSpecialAbility(Entity target) {
        System.out.println("The slime has split into two smaller slimes!");

    }

    @Override
    public void attack(Entity enemy) {
        String verb = ATTACK_VERBS[rand(0,ATTACK_VERBS.length - 1)];
        super.attack(enemy, verb);

        if (rand(1,100) <=25) {
            useSpecialAbility(enemy);
        }
    }


    // method overriding - overriding the display2 method from class2. Polymorphism at the run-time
//    @Override
//    void display2() {
//        System.out.println("Hello World for class3");
//    }

    // method overloading - overloading the print method. Allow the same method name to be used with different parameters at the compile-time
    // Original method takes a integer input as parameter
//    void print(int num) {
//        System.out.println("Integer: " + num);
//    }
    // Take a string input as parameter
    // overloaded the print method I define above
//    void print(String str) {
//        System.out.println("String: " + str);
//    }


//    public static void main(String[] args) {
//        Slime obj = new Slime();
//        // obj.display(); // Calls the display method from class2
//        obj.display2(); // Cannot call this method because it is private in class2
//
//        Goblin obj2 = new Goblin();
//        obj2.display2();
//
//        obj.print(76);
//        obj.print("ABC");
//    }
}
