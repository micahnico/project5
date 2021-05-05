/**
 * @author JoshSpicher
 */
public abstract class Item {

	final private int price;

	/**
	 * creates a new item and gives it a price
	 * @param price
	 */
	public Item(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @return the price of the item
	 */
	// returns item price
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @param p the name of the pokemon you would like to use the item on
	 */
	public abstract void use(Pokemon p);
	
}
