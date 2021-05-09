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
	 * @return The name of the item class, which is the name of the item
	 */
	public String getName() {
		return this.getClass().getName();
	}

	/**
	 * 
	 * @param p the name of the pokemon you would like to use the item on
	 * @return boolean of whether the item was able to be used or not
	 */
	public abstract boolean use(Pokemon p);
	
}
