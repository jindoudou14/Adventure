import java_class_object.Goblin;
import java_class_object.Orc;
import java_class_object.Slime;
import java_class_object.Monster;
import java_class_object.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main extends Slime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Hero");
        List<Monster> dungeonEnemies = new ArrayList<>();
        Random rando = new Random();


        // Add different enemy types to the list
        dungeonEnemies.add(new Slime());
        dungeonEnemies.add(new Goblin());
        dungeonEnemies.add(new Orc());

        Monster randomEnemy = dungeonEnemies.get(rando.nextInt(dungeonEnemies.size()));
        System.out.println("You encountered a(n) " +randomEnemy.getClass().getSimpleName()+"!");

        while (randomEnemy.alive()){
            System.out.println(player.getName() + ": HP " + player.getCurrentHP() + "/" + player.getMaxHP());
            System.out.println(randomEnemy.getClass().getSimpleName() + ": HP " + randomEnemy.getCurrentHP() + "/" + randomEnemy.getMaxHP());

            // Player turn
            System.out.println("\nChoose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Use Item");
            System.out.println("3. Run Away");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.attack(randomEnemy);
                    break;
                case 2:
                    System.out.println("You don't have any items yet!");
                    continue;
                case 3:
                    if (rando.nextBoolean()) {
                        System.out.println("You successfully ran away!");
                        //return;
                    }
                    else {
                        System.out.println("you failed to run away!");
                    }

            }

            if (!randomEnemy.alive()) {
                System.out.println("\nYou defeated the " + randomEnemy.getClass().getSimpleName() + "!");
                int gold = randomEnemy.loot();
                player.addGold(gold);
                System.out.println("Obtained " + gold + " gold!");
                break;

            }

            randomEnemy.attack(player);

            if (!player.alive()) {
                System.out.println("\nYou were defeated by the " + randomEnemy.getClass().getSimpleName() + "!");
                System.out.println("Game Over!");
                break;
            }
        }
        scanner.close();
    }
}