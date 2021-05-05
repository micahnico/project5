import com.google.gson.Gson;

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
	public static void main(String[] args) throws FileNotFoundException {
		// loads the existing pokemon and items into the game
		ArrayList<Pokemon> pokemon = loadPokemon();
		ArrayList<Item> items = new ArrayList<>(List.of(new MaxRevive(100), new Potion(100), new SuperPotion(100)));

		Scanner sc=new Scanner(System.in);
		//make new trainer and ask for option
		System.out.println("What's your name trainer?");
		String name=sc.next();
		Trainer active = new Trainer(name);
		System.out.println("Welcome "+name);

		int opt=0;
		while(opt<1){
			System.out.println("What are you looking to do?");
			if (!sc.hasNextInt()){
				System.out.println("Only enter your number options");
				opt=0;
			}
			else {

			}
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
			Gson gson = new Gson();
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


}
