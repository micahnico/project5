import java.util.ArrayList;

public class Trainer {
	
	private int wins;
	private int losses;
	private int name;
	private ArrayList<Pokemon> pokeinventory;
	private int coins;
	private ArrayList<Item> iteminventory;

	// creates new trainer and gives them a name
	public Trainer(String name) {
	}

	// prints out player stats
	public String printStats() {
		return "";
	}

	// returns # of wins
	public int getWins() {
		return wins;
	}

	// adds wins to win integer
	public void addWins() {
	}

	// returns # of losses
	public int getLosses() {
		return losses;
	}

	// adds loses to loses integer
	public void addLosses() {
	}

	// returns name of trainer
	public int getName() {
		return name;
	}

	// sets name for trainer
	public void setName(int name) {
		this.name = name;
	}

	// returns # of coins trainer has
	public int getCoins() {
		return coins;
	}

	// adds coins to coins int
	public void addCoins(int coins) {
	}
	
	// removes coins from coins int
	public void removeCoins(int coins) {
	}
	
	// adds Pokemon to ArrayList<Pokemon>
	public void addPokemon(Pokemon p) {
	}
	
	// removes Pokemon from ArrayList<Pokemon>
	public void removePokemon(int r) {
	}
	
	// add item to ArrayList<Item>
	public void addItem(Item i) {
	}
	
	// removes item from ArrayList<Item>
	public void removeItem(int r) {
	}
}
