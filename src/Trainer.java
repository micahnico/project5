import java.util.ArrayList;

public class Trainer {

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
		// TODO: get data from file and if none matches the name, then do a default initialize
		// else initialize to the data found
		this.name = name;
		this.wins = 0;
		this.losses = 0;
		this.coins = 0;
		this.pokemonInv = new ArrayList<>();
		this.itemInv = new ArrayList<>();
	}

	/**
	 * prints out player stats
	 * @return wins and losses
	 */
	public String printStats() {
		return "Wins: " + getWins() + "\nLosses: " + getLosses();
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

	// TODO: add methods to get a pokemon and item

	/**
	 * finds and removes the specified trainer's item
	 * @param item item object
	 */
	public void removePokemon(Item item) {
		this.itemInv.remove(item);
	}

	public void saveDataToFile(String filename) {
		// TODO: write this method to be called on program start and end
	}

	public void getTrainerFromFile(String filename) {
		// TODO: add a trainer from database; save and query it in JSON
	}
}
