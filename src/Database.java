import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

/**
 * Handles writing and parsing of json from a file
 * each line in the file is a json string
 * @author micahnico
 */
public interface Database {
  Object getData();
  String getName();

  /**
   * this makes sure that if there are any classes that extend parents, that data is saved and instantiated to the correct type
   * if not needed, don't override it
   *
   * @param <T> the type of the adapter factory
   * @return the specified adapter factory
   */
  default <T> RuntimeTypeAdapterFactory<T> adapterFactory() {
    return null;
  }

  /**
   * saves the current object to a json file of the same name of the object
   * @throws FileNotFoundException
   */
  default void save() throws FileNotFoundException {
    PrintWriter out = new PrintWriter(getName() + ".json");
    Gson gson = new GsonBuilder().registerTypeAdapterFactory(adapterFactory()).create();
    String json = gson.toJson(getData());

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
    Gson gson = new GsonBuilder().registerTypeAdapterFactory(adapterFactory()).create();
    return gson.fromJson(reader, getData().getClass());
  }
}