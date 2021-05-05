
public class Battle {

		/**
		 * Just an example of how you can set up a fight with my classes
		 * Lets assume p1 attacks and choose attack 1
		 * p2 chooses defense 1 -Philippe
		 */
		public void Fight(Pokemon p1, Pokemon p2) {
			int healthToRemove; //is the amount of health to remove to p2 after the attack;
			// p1.getAttack(1).damage(p2, p2.getDefense(1))  <--  this returns the amount of health lost by p2 according to the type of p1 and the defense used bla bla bla...
			healthToRemove = p1.getAttack(1).damage(p2, p2.getDefense(1));
			// and then
			p2.takeDamage(healthToRemove);
		}



}
