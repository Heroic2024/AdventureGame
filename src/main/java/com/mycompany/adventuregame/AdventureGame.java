
import com.mycompany.adventuregame.GameEngine;
import com.mycompany.adventuregame.Player;
import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the adventure game!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name, brave adventurer: ");
        String name = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("1. Explore Cave\n2. Enter Forest");
        int choice = new java.util.Scanner(System.in).nextInt();

        if (choice == 1) {
            GameEngine.exploreCave(player);
        }
        else if (choice == 2){
            GameEngine.enterForest(player);
        }
        else{
            System.out.println("Invalid choice. Game Over!");
        }
    }
}
