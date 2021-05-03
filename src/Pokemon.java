import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

	public class Pokemon {

	private int maxHealth;
	private String typePokemon;
	private int currentHealth;
	private int baseDamage;
	private int critDamage;
	private String name;

	//There is an inheritance three of attacks
	//Lists of attacks of the pokemon
	//Collections need to be checked on that - Philippe
	private ArrayList<Attack> attacks;
	private ArrayList<Defense> defenses;

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
		attacks = new ArrayList<>();
		defenses = new ArrayList<>();
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

	//I should not need this anymore - Philippe
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

	//I should not need this also - Philippe
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

	//I need this simple take damage. I manage the number of health taken elsewhere (in function of type etc ...)
	// Is that ok? -Philippe
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


