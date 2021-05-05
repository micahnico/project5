public class Potion extends Item {
	/**
	 * creates a item called potion
	 * @param name
	 * @param price
	 * JoshSpicher
	 */
	public Potion(String name, int price) {
		super(name, price);
	}
	/**
	 * creates a use method for potion that restores 10 health to a pokemon of your choice
	 * JoshSpicher
	 */
	@Override
	public void use(Pokemon p) {
		if(p.getCurrentHealth() > 0) {
			p.addHealth(10);
		}
		else {
			System.out.println("Sorry, Pokemon must be revived in order to use Potion.");
		}
	}
	

}
