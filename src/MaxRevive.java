public class MaxRevive extends Item {
	
	public MaxRevive(String name, int price) {
		super(name, price);
	}
	
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
