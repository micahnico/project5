import java.util.ArrayList;
import java.util.HashSet;

public class Trainer implements Database {

	private String name;
	private int wins;
	private int losses;
	private int coins;
	// TODO: see what type of collections we need
	private ArrayList<Pokemon> pokemonInv;
	private ArrayList<Item> itemInv;

	/**
	 * creates new trainer and gives them a name or finds an existing trainer in the "database"
	 * @param name String
	 */
	public Trainer(String name) {
		this.name = name;
		this.itemInv = new ArrayList<>();
		this.pokemonInv = new ArrayList<>();

		Object obj = load();
		// if the object is empty it won't be of type Trainer
		if (obj instanceof Trainer) {
			Trainer t = (Trainer) obj;
			this.wins = t.wins;
			this.losses = t.losses;
			this.coins = t.coins;
			for (Item item : t.itemInv) {
				addItem(new Item(item.getName(), item.getPrice()));
			}
			for (Pokemon p : t.pokemonInv) {
				addPokemon(p);
			}
		} else {
			this.wins = 0;
			this.losses = 0;
			this.coins = 0;
		}
	}

	/**
	 * prints out player stats
	 * @return wins and losses
	 */
	public String printStats() {
		return "Wins: " + getWins() + "\nLosses: " + getLosses();
	}

	@Override
	public Object getData() {
		return this;
	}

	/**
	 * @return number of wins the current trainer has
	 */
	public int getWins() {
		return this.wins;
	}

	/**
	 * adds a win to the current trainer's count
	 */
	public void addWin() {
		this.wins++;
	}

	/**
	 * @return number of losses the trainer has
	 */
	public int getLosses() {
		return this.losses;
	}

	/**
	 * adds a loss to the trainer's count
	 */
	public void addLoss() {
		this.losses++;
	}

	/**
	 * @return the name of the trainer
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * sets the name of the trainer
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return number of coins the trainer has
	 */
	public int getCoins() {
		return this.coins;
	}

	/**
	 * add coins to the trainer's current total
	 * @param coins int
	 */
	public void addCoins(int coins) {
		this.coins += coins;
	}

	/**
	 * removes coins from the trainer's current total
	 * @param coins int
	 */
	public void removeCoins(int coins) {
		this.coins -= coins;
	}

	/**
	 * @return the trainer's inventory of pokemon
	 */
	public ArrayList<Pokemon> pokemon() {
		return this.pokemonInv;
	}

	/**
	 * adds the pokemon to the trainer's collection
	 * @param p pokemon object
	 */
	public void addPokemon(Pokemon p) {
		this.pokemonInv.add(p);
	}

	/**
	 * removes the trainer's pokemon at index i
	 * @param i index of pokemon
	 */
	public void removePokemon(int i) {
		this.pokemonInv.remove(i);
	}

	/**
	 * finds and removes the specified trainer's pokemon
	 * @param p pokemon object
	 */
	public void removePokemon(Pokemon p) {
		this.pokemonInv.remove(p);
	}

	/**
	 * @param i int
	 * @return the pokemon at index i
	 */
	public Pokemon getPokemon(int i) {
		return this.pokemonInv.get(i);
	}

	/**
	 * @return the trainer's inventory of pokemon
	 */
	public ArrayList<Item> items() {
		return this.itemInv;
	}

	/**
	 * adds the item to the trainer's inventory
	 * @param item item object
	 */
	public void addItem(Item item) {
		this.itemInv.add(item);
	}

	/**
	 * removes the trainer's item at index i
	 * @param i index of item
	 */
	public void removeItem(int i) {
		this.itemInv.remove(i);
	}

	/**
	 * removes the specified trainer's item
	 * @param item item object
	 */
	public void removeItem(Item item) {
		this.itemInv.remove(item);
	}

	/**
	 * @param i int
	 * @return the item at index i
	 */
	public Item getItem(int i) {
		return this.itemInv.get(i);
	}
}
