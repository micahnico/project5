
public class Item extends Trainer {
	
	private String name;
	private int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// returns item name
	public String getName() {
		return name;
	}

	// returns item price
	public int getPrice() {
		return price;
	}
	
	public void maxRevive() {
		if(currentHealth == 0) {
			currentHealth += 50;
		}
		else {
			System.out.println("Pokemon must have health of 0 to use Max Revive.");
		}
		coins - 3;
	}
	
	public void potion() {
		if(currentHealth < 91) {
			currentHealth += 10;
		}
		else if(currentHealth == 0) {
			System.out.println("Sorry, Pokemon must be revived in order to use Potion.");
		}
		else {
			System.out.println("Pokemon's health is to high to use Potion.");
		}
		coins - 1;
	}
	
	public void superPotion() {
		if(currentHealth < 76) {
			currentHealth += 25;
		}
		else if(currentHealth == 0) {
			System.out.println("Sorry, Pokemon must be revived in order to use Super Potion.");
		}
		else {
			System.out.println("Pokemon's health is to high to use Super Potion.");
		}
		coins - 2;
	}
