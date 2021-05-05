public class MaxRevive extends Item {
	
	/**
	 * creates an item called max revive
	 * @param name
	 * @param price
	 * JoshSpicher
	 */
	public MaxRevive(String name, int price) {
		super(name, price);
	}
	/**
	 * creates a use method for max revive that restores a pokemon of your choices health back to max after it has fainted by reaching 0
	 * JoshSpicher
	 */
	@Override
	public void use(Pokemon p) {
		if(p.getCurrentHealth() == 0) {
			p.setToMaxHealth();
		}
		else {
			System.out.println("Pokemon must have health of 0 to use Max Revive.");
		}
	}

}