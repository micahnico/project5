import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {

	private int maxHealth;
	private String typePokemon;
	private int currentHealth;
	private String name;

	//There is an inheritance three of attacks
	//Lists of attacks of the pokemon
	private ArrayList<Attack> attacks;
	private ArrayList<Defense> defenses;

	public Pokemon(String type, String newName, int maxHealth) {
		this.typePokemon = type;
		this.name = newName;
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		attacks = new ArrayList<>();
		defenses = new ArrayList<>();
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

}





