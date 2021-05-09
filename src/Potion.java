/**
 * @author JoshSpicher
 */
public class Potion extends Item {
	/**
	 * creates a item called potion
	 * @param price
	 */
	public Potion(int price) {
		super(price);
	}

	/**
	 * creates a use method for potion that restores 10 health to a pokemon of your choice
	 */
	@Override
	public boolean use(Pokemon p) {
		if(p.getCurrentHealth() > 0) {
			p.addHealth(10);
			return true;
		}
		else {
			System.out.println("Sorry, Pokemon must be revived in order to use Potion.");
			return false;
		}
	}
	

}
