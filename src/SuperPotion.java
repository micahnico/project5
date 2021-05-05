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
	public void use(Pokemon p) {
		if(p.getCurrentHealth() > 0) {
			p.addHealth(25);
		}
		else {
			System.out.println("Sorry, Pokemon must be revived in order to use Super Potion.");
		}
	}

}
