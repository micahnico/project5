import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainerTest {
  @Test
  void basicGettersAndSetters() {
    Trainer t = new Trainer("Test Trainer");
    assertEquals(t.getName(), "Test Trainer");
    assertEquals(t.getWins(), 0);
    assertEquals(t.getLosses(), 0);
    assertEquals(t.getCoins(), 0);

    t.setName("Bob");
    assertEquals(t.getName(), "Bob");
    t.addWin();
    assertEquals(t.getWins(), 1);
    t.addLoss();
    assertEquals(t.getLosses(), 1);
    t.addCoins(400);
    assertEquals(t.getCoins(), 400);
    t.removeCoins(300);
    assertEquals(t.getCoins(), 100);
  }

  @Test
  void pokemonAndItemMethods() {
    Trainer t = new Trainer("Test Trainer");
    Pokemon p = new Pokemon("Fire", "Test", 50, 50, 50);
    Item item = new Item("Test", 700);

    t.addPokemon(p);
    t.addPokemon(p);
    assertEquals(t.getPokemon(0), p);

    t.addItem(item);
    t.addItem(item);
    assertEquals(t.getItem(0), item);

    t.removePokemon(0);
    t.removePokemon(p);
    assertEquals(t.pokemon().size(), 0);

    t.removeItem(0);
    t.removeItem(item);
    assertEquals(t.items().size(), 0);
  }
}