import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * runs the game until the player quits
 */
public class Game {
	public static void main(String[] args) {
		// loads the existing pokemon and items into the game
		ArrayList<Pokemon> pokemon = loadPokemon();
		ArrayList<Item> items = loadItems();
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
	 * loads items from json files
	 * @return all the found items
	 * @author micahnico
	 */
	public static ArrayList<Item> loadItems() {
		ArrayList<Item> allItems = new ArrayList<>();
		Set<String> filesToLoad = loadDirectory(new File("items"));
		Reader reader;

		for (String file : filesToLoad) {
			try {
				reader = Files.newBufferedReader(Paths.get(file));
			} catch (IOException e) {
				return null;
			}
			Gson gson = new Gson();
			allItems.add(gson.fromJson(reader, Item.class));
		}
		return allItems;
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
