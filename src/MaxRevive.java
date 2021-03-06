/**
 * @author JoshSpicher
 */
public class MaxRevive extends Item {

	/**
	 * creates an item called max revive
	 * @param price
	 */
	public MaxRevive(int price) {
		super(price);
	}

	/**
	 * creates a use method for max revive that restores a pokemon of your choices health back to max after it has fainted by reaching 0
	 */
	@Override
	public boolean use(Pokemon p) {
		if(p.getCurrentHealth() <= 10) {
			p.setToMaxHealth();
			return true;
		}
		else {
			System.out.println("Pokemon must have health of 10 or less to use Max Revive.");
			return false;
		}
	}

}
