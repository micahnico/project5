import java.util.ArrayList;

abstract public class Pokemon {

	private int maxHealth;
	private String typePokemon;
	private int currentHealth;
	private int baseDamage;
	private int critDamage;
	private String name;

	public Pokemon(String type, String newName) {
		name = newName;
		maxHealth = 100;
		this.currentHealth = maxHealth;
		baseDamage = 0;
		critDamage = 0;
		if(type != "Air" || type != "Earth" || type != "Fire" || type != "Water") {
			System.out.println("Please enter a valid Pokemon type of Air, Earth, Fire, or Water.");
		}
		else {
			typePokemon = type;
		}
	}

	// returns type of Pokemon
	public String getTypePokemon() {
		return typePokemon;
	}

	// returns Pokemons possible max health
	public int getMaxHealth() {
		return maxHealth;
	}

	// returns Pokemons current health
	public int getCurrentHealth() {
		return currentHealth;
	}

	// grabs attack for specific Pokemon
	abstract public void attack();

	// attack deals base damage to opposing Pokemon
	public void dealBaseDamage() {
		baseDamage = ((int) (Math.random() * (20-10))) + 10;
		if(currentHealth - baseDamage < 0) {
			currentHealth = 0;
		}
		else {
			currentHealth -= baseDamage;
		}
	}

	// attack deals crit damage to opposing Pokemon
	public void dealCritDamage() {
		critDamage = ((int) (Math.random() * (40-30))) + 30;
		if(currentHealth - critDamage < 0) {
			currentHealth = 0;
		}
		else {
			currentHealth -= critDamage;
		}
	}

	// sets current health to max health
	public void setToMaxHealth() {
		currentHealth = maxHealth;
	}


}

