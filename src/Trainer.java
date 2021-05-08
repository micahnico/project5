import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

/**
 * @author micahnico
 */
public class Trainer implements Database {

	private String name;
	private int wins;
	private int losses;
	private int coins;
	private ArrayList<Pokemon> pokemonInv;
	private ArrayList<Item> itemInv;

	/**
	 * creates new trainer and gives them a name or finds an existing trainer in the "database"
	 * @param name String
	 */
	public Trainer(String name) {
		this.name = name;
		this.pokemonInv = new ArrayList<>();

		Object obj = load();
		// if the object is empty it won't be of type Trainer
		if (obj instanceof Trainer) {
			Trainer t = (Trainer) obj;
			this.wins = t.wins;
			this.losses = t.losses;
			this.coins = t.coins;
			for (Pokemon p : t.pokemonInv) {
				addPokemon(p);
			}
		} else {
			this.wins = 0;
			this.losses = 0;
			this.coins = Pokemon.COST;
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

	@Override
	public Gson gsonWithAdapters() {
		RuntimeTypeAdapterFactory<Item> itemAdapter = RuntimeTypeAdapterFactory.of(Item.class, "type")
						.registerSubtype(MaxRevive.class, "MaxRevive")
						.registerSubtype(Potion.class, "Potion")
						.registerSubtype(SuperPotion.class, "SuperPotion");
		RuntimeTypeAdapterFactory<Attack> attackAdapter = RuntimeTypeAdapterFactory.of(Attack.class, "type")
						.registerSubtype(BlastAttack.class, "BlastAttack")
						.registerSubtype(ChargeAttack.class, "ChargeAttack")
						.registerSubtype(StormAttack.class, "StormAttack");
		return new GsonBuilder()
						.registerTypeAdapterFactory(itemAdapter)
						.registerTypeAdapterFactory(attackAdapter)
						.create();
	}

	/**
	 * @return the name of the trainer
	 */
	@Override
	public String getName() {
		return this.name;
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
	public ArrayList<Pokemon> pokemonList() {
		return this.pokemonInv;
	}

	/**
	 * Prints the  pokemon list
	 */
	public void printPokemon(){
		for (int i = 0; i < pokemonInv.size(); i++){
			System.out.println("-" + i +  " "+ getPokemon(i).getName());
		}
	}

	/**
	 * adds the pokemon to the trainer's collection
	 * @param p pokemon object
	 */
	public void addPokemon(Pokemon p) {
		this.pokemonInv.add(new Pokemon(p));
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

}
