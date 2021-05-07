import java.util.Scanner;
import java.util.Random;

public class Battle {

		public Battle(){

		}

		public boolean Fight(Pokemon p1, Pokemon p2) {
			while(p1.getCurrentHealth() > 0 || p2.getCurrentHealth() > 0){
				Random rnd = new Random();// genrates random number for the computer's moves
				Scanner scn = new Scanner(System.in);// Scanner
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
					choice = scn.nextInt();
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
					choice = scn.nextInt();
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
				System.out.println(p1.getName() + "won");
				return true;
			}
			else{
				System.out.println(p2.getName() + "won");
				return false;
			}

		}

}
