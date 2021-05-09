/**
 * @author JoshSpicher
 */
public class SuperPotion extends Item{

	/**
	 * creates a item called SuperPotion
	 * @param price
	 */ 
	public SuperPotion(int price) {
		super(price);
	}
	/**
	 * creates use method for super potion that restores 25 health to pokemon of your choice
	 */
	@Override
	public boolean use(Pokemon p) {
		if(p.getCurrentHealth() > 0) {
			p.addHealth(25);
			return true;
		}
		else {
			System.out.println("Sorry, Pokemon must be revived in order to use Super Potion.");
			return false;
		}
	}

}
