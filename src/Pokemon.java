import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parent class for all pokemon
 */
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

	/**
	 * constructor for a  new pokemon object
	 * @param type
	 * @param newName
	 * @param maxHealth
	 */
	public Pokemon(String type, String newName, int maxHealth) {
		this.typePokemon = type;
		this.name = newName;
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		attacks = new ArrayList<>();
		defenses = new ArrayList<>();
	}

	/**
	 * deep copy constructor for pokemon
	 * @param other
	 */
	public Pokemon(Pokemon other) {
		this.typePokemon = other.typePokemon;
		this.name = other.name;
		this.maxHealth = other.maxHealth;
		this.currentHealth = other.maxHealth;
		// don't have to worry about referencing the same place in memory since we shouldn't ever modify these
		attacks = other.attacks;
		defenses = other.defenses;
	}

	/**
	 * prints the info of the individual pokemon
	 */
	public void getInfo(){
		System.out.println("Name: " + getName());
		System.out.println("Type: " + getTypePokemon());
		System.out.println("Max Health: " + getMaxHealth());
		System.out.println("Attacks:");
		for(Attack a : attacks){
			System.out.println(a.getName());
		}
		System.out.println("Defenses:");
		for(Defense d : defenses){
			System.out.println(d.getName() + " - " + d.getType());
		}

	}

	/**
	 * @return pokemon name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return type of pokemon
	 */
	public String getTypePokemon() {
		return typePokemon;
	}

	/**
	 * @return Pokemon's possible max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @return Pokemon's current health
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * sets current health to max health
	 */
	public void setToMaxHealth() {
		currentHealth = maxHealth;
	}

	/**
	 * removes health from pokemon
	 * @param damage health to remove from pokemon
	 */
	public void takeDamage(int damage) {
		currentHealth -= damage;
	}

	/**
	 * gets the defense at index i of pokemon's defenses
	 * @param i index
	 * @return Defense object
	 */
	public Defense getDefense(int i) {
		return defenses.get(i);
	}

	/**
	 * adds defense to pokemon
	 * @param d Defense to add
	 */
	public void addDefense(Defense d){
		defenses.add(d);
	}

	/**
	 * gets the Attack at index i of pokemon's attacks
	 * @param i index
	 * @return Attack object
	 */
	public Attack getAttack(int i) {
		return attacks.get(i);
	}

	/**
	 * adds attack to pokemon
	 * @param a Attack to add
	 */
	public void addAttack(Attack a){
		attacks.add(a);
	}

	/**
	 * adds health to the pokemon's currentHealth
	 * @param amt health to add
	 */
	public void addHealth(int amt) {
		this.currentHealth += amt;
		if (this.currentHealth > this.maxHealth) {
			this.currentHealth = maxHealth;
		}
	}

	/**
	 * checks if pokemon are equal to each other
	 * @param o pokemon
	 * @return boolean
	 */
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





