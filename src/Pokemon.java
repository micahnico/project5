import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
	final static int COST = 200;

	final private int maxHealth;
	final private String typePokemon;
	private int currentHealth;
	final private String name;

	//There is an inheritance three of attacks
	//Lists of attacks of the pokemon
	final private ArrayList<Attack> attacks;
	final private ArrayList<Defense> defenses;

	public Pokemon(String type, String newName, int maxHealth) {
		this.typePokemon = type;
		this.name = newName;
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		attacks = new ArrayList<>();
		defenses = new ArrayList<>();
	}

	public Pokemon(Pokemon other) {
		this.typePokemon = other.typePokemon;
		this.name = other.name;
		this.maxHealth = other.maxHealth;
		this.currentHealth = other.maxHealth;
		// don't have to worry about referencing the same place in memory since we shouldn't ever modify these
		attacks = other.attacks;
		defenses = other.defenses;
	}

	public String getName() {
		return this.name;
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

	// sets current health to max health
	public void setToMaxHealth() {
		currentHealth = maxHealth;
	}

	public void takeDamage(int damage) {
		currentHealth -= damage;
	}

	public Defense getDefense(int i) {
		return defenses.get(i);
	}

	public Attack getAttack(int i) {
		return attacks.get(i);
	}

	public void addHealth(int amt) {
		this.currentHealth += amt;
		if (this.currentHealth > this.maxHealth) {
			this.currentHealth = maxHealth;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Pokemon)) {
			return false;
		}
		Pokemon m = (Pokemon) o;
		return this.typePokemon.equals(m.typePokemon) && this.maxHealth == m.maxHealth && this.name.equals(m.name) && this.attacks.equals(m.attacks) && this.defenses.equals(m.defenses);
	}

}





