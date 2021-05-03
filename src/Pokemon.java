
abstract public class Pokemon {
	
	private int maxhealth;
	private String name;
	private int currenthealth;


	// grabs attack for specific pokemon
	abstract public void attack();

	
	// subtracts damage from current health
	public void takeDamage(int damage) {
	}
	
	// adds health to current health
	public void heal(int h) {
	}
	
	// sets current health to max health
	public void setToMaxHealth() {
	}
	
		
	}


