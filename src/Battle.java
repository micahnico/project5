import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 * runs the battle until a winner
 * @author prince
 */
public class Battle {
		final private static int MAX_ITEM_USES = 3;
		public static boolean fight(Pokemon p1, Pokemon p2, Trainer t, ArrayList<Item> items) {
			Scanner scn = new Scanner(System.in);// Scanner
			int itemUsesLeft = MAX_ITEM_USES;
			// p1 is the player pokemon
			while(p1.getCurrentHealth() > 0 && p2.getCurrentHealth() > 0){
				System.out.println("Current Health of " + p1.getName() + ": " + p1.getCurrentHealth());
				System.out.println("Current Health of " + p2.getName() + ": " + p2.getCurrentHealth());
				System.out.println();

				// give player option to heal before each turn if needed
				if (p1.getCurrentHealth() < p1.getMaxHealth() && t.getCoins() > Game.ITEM_COST && itemUsesLeft > 0) {
					int itemOpt = -1;
					boolean ok = false;

					System.out.println("Pick an item to use (100 coins)");
					System.out.println("you have " + (itemUsesLeft) + " uses left in this battle");
					System.out.println("0. None");
					for (int i = 0; i < items.size(); i++) {
						System.out.println((i+1) + ". " + items.get(i).getName() + " " + items.get(i).getPrice() + " coins");
					}
					while (itemOpt < 0 || itemOpt > items.size() || !ok) {
						try {
							itemOpt = scn.nextInt();
						} catch (Exception e) {
							System.out.println("That's not a viable number");
							scn.nextLine();
							continue;
						}
						if (itemOpt > 0 && itemOpt <= items.size()) {
							// adjust for 0 indexing and use the item
							ok = items.get(itemOpt-1).use(p1);
							if (ok) {
								t.removeCoins(items.get(itemOpt-1).getPrice());
								itemUsesLeft--;
							}
						} else if (itemOpt == 0) {
							ok = true;
						}
					}
					System.out.println("Current Health is now: " + p1.getCurrentHealth());
					System.out.println();
				}

				Random rnd = new Random();// genrates random number for the computer's moves
				int choice = 0; //Stores user option
				int healthToRemove;
				int rand = rnd.nextInt(3); //random defense for the computer

				//Attack
				//Prompt
				System.out.println("It's your turn");
				System.out.println("Choose attack:");
				System.out.print("1-" + p1.getAttack(0).getName() + "\t");
				System.out.print("2-" + p1.getAttack(1).getName() + "\t");
				System.out.print("3-" + p1.getAttack(2).getName() + "\t");
				//Checks for user input
				while(choice !=  1 && choice != 2 && choice != 3) {
					try {
						choice = scn.nextInt();
					} catch (Exception e) {
						System.out.println("That's not a viable number");
						scn.nextLine();
					}
				}
				//Health removal process
				healthToRemove = p1.getAttack(choice - 1).damage(p2, p2.getDefense(rand));
				p2.takeDamage(healthToRemove);
				//Final Prompt
				System.out.println(p1.getAttack(choice - 1).getName() + " on " + p2.getName());
				System.out.println(p2.getName() + " defends with " + p2.getDefense(rand).getName());
				System.out.println(p2.getAttack(choice - 1).getName() + " lose " + healthToRemove);

				//breaks the loop if someone wins
				if(p1.getCurrentHealth() <= 0 || p2.getCurrentHealth() <= 0){
					break;
				}

				//Defense
				choice = 0;
				rand = rnd.nextInt(3);
				//Prompt
				System.out.println(p2.getName() + " attacks");
				System.out.println("Choose a defense:");
				System.out.print("1-" + p1.getDefense(0).getName() + "\t");
				System.out.print("2-" + p1.getDefense(1).getName() + "\t");
				System.out.print("3-" + p1.getDefense(2).getName() + "\t");
				//Checks for user input
				while(choice !=  1 && choice != 2 && choice != 3) {
					try {
						choice = scn.nextInt();
					} catch (Exception e) {
						System.out.println("That's not a viable number");
						scn.nextLine();
					}
				}
				//Health removal process
				healthToRemove = p2.getAttack(rand).damage(p1, p1.getDefense(choice -  1));
				p1.takeDamage(healthToRemove);
				//Final prompt
				System.out.println(p2.getAttack(choice - 1).getName() + " on " + p1.getName());
				System.out.println(p1.getName() + " defends with " + p1.getDefense(rand).getName());
				System.out.println(p1.getAttack(choice - 1).getName() + " lose " + healthToRemove);
			}

			if (p1.getCurrentHealth() > 0){
				System.out.println(p1.getName() + " won");
				return true;
			}
			else{
				System.out.println(p2.getName() + " won");
				return false;
			}

		}

}
