public class SuperPotion extends Item{
	
	/**
	 * creates a item called SuperPotion
	 * @param name 
	 * @param price
	 * JoshSpicher
	 */ 
	public SuperPotion(String name, int price) {
		super(name, price);
	}
	/**
	 * creates use method for super potion that restores 25 health to pokemon of your choice
	 * JoshSpicher
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
