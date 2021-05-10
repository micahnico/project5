import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * runs the game until the player quits
 * @author prince
 */
public class Game {
	final static int ITEM_COST = 50;

	public static void main(String[] args) throws Exception {
		// loads the existing pokemon and items into the game
		ArrayList<Pokemon> pokemon = loadPokemon();
		ArrayList<Item> items = new ArrayList<>(List.of(new MaxRevive(ITEM_COST), new Potion(ITEM_COST), new SuperPotion(ITEM_COST)));

		Scanner sc = new Scanner(System.in);
		//make new trainer and ask for option
		System.out.print("What's your name trainer? ");
		String name = sc.next();
		Trainer active = new Trainer(name);
		System.out.println("Welcome " + name);

		//Giving new Trainer a pokemon
		if (active.pokemonList().size() == 0) {
			buyPokemon(active, pokemon);
			active.save();
		}

		int opt;
		do {
			//Presenting the menu
			opt = presentMenu();
			if (opt == 1) {// Trainer wants to buy pokemon
				buyPokemon(active, pokemon);
			} else if (opt == 2) {//Trainer wants to fight
				System.out.println("Choose a pokemon to fight with");
				active.printPokemon();
				int o = choosePokemon(active.pokemonList().size());
				Random rnd = new Random();
				Pokemon fighter = active.getPokemon(o);
				Pokemon opponent = pokemon.get(rnd.nextInt(pokemon.size()));
				System.out.println("\t--" + fighter.getName() + " against " + opponent.getName() + "\t--");
				boolean hasWon = Battle.fight(fighter, opponent, active, items);
				if (hasWon) {
					active.addWin();
					System.out.println("Congratulations you received 100 coins!");
					active.addCoins(100);
				} else {
					System.out.println("You lost. Here's 1 coin to help you deal with your misery.");
					active.addCoins(1);
					active.addLoss();
				}
			} else if (opt == 3) {
				System.out.println();
				System.out.println("Current inventory: ");
				System.out.println("Enter the number beside a pokemon to view it");
				active.printPokemon();
				int max = active.pokemonList().size();
				if (max < 1) {
					continue;
				}
				int o = choosePokemon(max);
				Pokemon pok = active.getPokemon(o);
				pok.getInfo();
			}
			active.save();
		} while (opt > 0);
	}

	/**
	 * loads pokemon from json files
	 * @return all the found pokemon
	 * @author micahnico
	 */
	public static ArrayList<Pokemon> loadPokemon() {
		ArrayList<Pokemon> allPokemon = new ArrayList<>();
		Set<String> filesToLoad = loadDirectory(new File("Pokemon"));
		Reader reader;

		for (String file : filesToLoad) {
			try {
				reader = Files.newBufferedReader(Paths.get(file));
			} catch (IOException e) {
				return null;
			}
			RuntimeTypeAdapterFactory<Attack> attackAdapter = RuntimeTypeAdapterFactory.of(Attack.class, "type")
							.registerSubtype(BlastAttack.class, "BlastAttack")
							.registerSubtype(ChargeAttack.class, "ChargeAttack")
							.registerSubtype(StormAttack.class, "StormAttack");
			Gson gson = new GsonBuilder().registerTypeAdapterFactory(attackAdapter).create();
			allPokemon.add(gson.fromJson(reader, Pokemon.class));
		}
		return allPokemon;
	}

	/**
	 * uses recursion to load all the files inside of a specified directory
	 * @param dir starting directory
	 * @return Set of all files in the directory
	 * @author micahnico
	 */
	public static Set<String> loadDirectory(File dir) {
		Set<String> filesToLoad = new HashSet<>();
		if (dir.isDirectory()) {
			for (File file : Objects.requireNonNull(dir.listFiles())) {
				filesToLoad.addAll(loadDirectory(file));
			}
		} else {
			filesToLoad.add(dir.getPath());
		}
		return filesToLoad;
	}

	public static int presentMenu() throws Exception{
		Scanner sc = new Scanner(System.in);
		//Options
		System.out.println();
		System.out.println("What are you looking to do?");
		System.out.println("0- quit");
		System.out.println("1- buy pokemon/item");
		System.out.println("2- fight");
		System.out.println("3- Inventory");
		int opt = -1;
		while (opt < 0 || opt > 3) {
			System.out.print("Please enter a number between 0 and 3: ");
			try {
				opt = sc.nextInt();
			} catch (Exception e) {
				System.out.println("That's not a number!");
			}
			sc.nextLine();
		}
		return opt;
	}

	public static void buyPokemon(Trainer t, ArrayList<Pokemon> pokemon) {
		System.out.println("You have " + t.getCoins() + " coins");
		if (t.getCoins() >= Pokemon.COST) {
			Random rnd = new Random();
			Pokemon p = pokemon.get(rnd.nextInt(pokemon.size()));
			t.addPokemon(p);
			t.removeCoins(Pokemon.COST);
			System.out.println("Congratulations you have received " + p.getName() + "!");
			System.out.println("You now have " + t.getCoins() + " coins");
		} else {
			System.out.println("You don't have enough coins to buy a pokemon");
		}
	}

	public static int choosePokemon(int max) {
		Scanner sc = new Scanner(System.in);

		int opt=-1;
		while(opt <= 0 || opt > max) {
			System.out.print("Please enter a viable number: ");
			try {
				opt = sc.nextInt();
			} catch (Exception e) {
				System.out.println("That's not a number!");
			}
			sc.nextLine();
		}
		return opt - 1;
	}
}
