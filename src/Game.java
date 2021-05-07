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
 */
public class Game {
	public static void main(String[] args) throws Exception {
		// loads the existing pokemon and items into the game
		ArrayList<Pokemon> pokemon = loadPokemon();
		ArrayList<Item> items = new ArrayList<>(List.of(new MaxRevive(100), new Potion(100), new SuperPotion(100)));

		Scanner sc = new Scanner(System.in);
		//make new trainer and ask for option
		System.out.println("What's your name trainer?");
		String name=sc.next();
		Trainer active = new Trainer(name);
		System.out.println("Welcome " + name);

		//Giving new Trainer a pokemon
		Random rnd =  new Random();
		receivePokemon(active, pokemon.get(rnd.nextInt(pokemon.size())));

		//Presenting the menu
		int opt =  presentMenu();

		if (opt ==1){// Trainer wants to buy pokemon
			//I have no idea how the  store works

		}
		else  if(opt == 2 ){//Trainer wants to   fight
			System.out.println("Choose a pokemon to fight with");
			active.printPokemons();
			int o = choosePokemon(active.pokemonList().size());
			Pokemon fighter = active.getPokemon(o);
			Pokemon opponent = pokemon.get(rnd.nextInt(pokemon.size()));
			System.out.println("\t--" +fighter.getName() + " againts " + opponent.getName() + "\t--");
			Battle b = new Battle();
			boolean hasWon = b.Fight(fighter, opponent);
			if (hasWon) {
				active.addWin();
				System.out.println("Congratulations you received 100 coins!");
				active.addCoins(100);
			}
			else{
				active.addLoss();
			}
		}
		else if(opt == 3){
			active.printPokemons();
			int o = choosePokemon(active.pokemonList().size());
			Pokemon pok = active.getPokemon(o);
			pok.getInfo();
		}
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

	public static void receivePokemon(Trainer t, Pokemon p){
		System.out.println("Congratulations you have received a pokemon!");
		System.out.println(p.getName());
		t.addPokemon(p);
	}

	public static int presentMenu() throws Exception{
		Scanner sc = new Scanner(System.in);
		//Options
		System.out.println("What are you looking to do?");
		System.out.println("1- buy pokemon/item");
		System.out.println("2- fight");
		System.out.println("3- Inventory");
		int opt=0;
		while(opt < 1 && opt > 3) {

			while (!sc.hasNextInt()) {
				throw new Exception("Only enter your number options");
			}
			opt = sc.nextInt();
			if(opt < 1 && opt > 3){
				throw new Exception("Choose between 1, 2 and 3");
			}
		}
		return opt;
	}

	public static int choosePokemon(int max) throws Exception{
		Scanner sc = new Scanner(System.in);

		int opt=-1;
		while(opt < 0 && opt > max) {

			while (!sc.hasNextInt()) {
				throw new Exception("Only enter your number options");
			}
			opt = sc.nextInt();
			if(opt < 1 && opt > max){
				throw new Exception("Choose a valid number");
			}
		}
		return opt;
	}
}
