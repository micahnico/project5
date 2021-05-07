import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Handles writing and parsing of json from a file
 * each line in the file is a json string
 * @author micahnico
 */
public interface Database {
  Object getData();
  String getName();
  /**
   * allows each class that implements Database to save and load subtypes of classes
   * since for some reason it doesn't by default
   * @return gson object with every adapter
   */
  Gson gsonWithAdapters();

  /**
   * saves the current object to a json file of the same name of the object
   * @throws FileNotFoundException
   */
  default void save() throws FileNotFoundException {
    PrintWriter out = new PrintWriter(getName() + ".json");
    String json = gsonWithAdapters().toJson(getData());

    out.print(json);
    out.flush();
    out.close();
  }

  /**
   * loads the object from its corresponding json file or returns null if it doesn't exist
   * @return parsed Object
   */
  default Object load() {
    Reader reader;
    try {
      reader = Files.newBufferedReader(Paths.get(getName() + ".json"));
    } catch (IOException e) {
      return null;
    }
    return gsonWithAdapters().fromJson(reader, getData().getClass());
  }
}