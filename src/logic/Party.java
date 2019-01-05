package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Party {

	private HashMap<Item, Integer> selectedItemsUnits = new HashMap<>();
	private Customer customer = new Customer();
	private String date="";
	private int attendance = 10;
	private double finalPrice = 0.0;
	private String comments = "";

	/**
	 * Add an item to the party reservation
	 * 
	 * @param Item i
	 * @param      int units
	 */
	public void addItem(Item i, int units) {

		// Checking if the item has been already chosen for the party reservation
		if (itemIsInParty(i)) {
			int unitsInOrder = selectedItemsUnits.get(i);
			// Adding the new number of units to the ones already chosen
			selectedItemsUnits.put(i, units + unitsInOrder);

		} else {
			// Adding the new product
			selectedItemsUnits.put(i, units);
		}
		// Recalculate total
		calculateFinalPrice();

		System.out.println(getBill());

	}

	/**
	 * Delete an item from the party reservation
	 * 
	 * @param Item i
	 */
	public void deleteItem(Item i) {
		
		selectedItemsUnits.remove(i);
		// Recalculate total
		calculateFinalPrice();

		System.out.println(getBill());

	}

	/**
	 * Updates the total price for items reserved
	 */
	private void calculateFinalPrice() {
		finalPrice = 0.0;
		double numGroups = attendance / 10;
		for (Item i : selectedItemsUnits.keySet()) {
			finalPrice += i.getUnitPrice() * selectedItemsUnits.get(i) + i.getGroupPrice() * numGroups;
		}
	}

	/**
	 * Checks if the item passed as parameter is already reserved in the party
	 * 
	 * @param Item i
	 * @return boolean true if it is reserved,false otherwise
	 */
	public boolean itemIsInParty(Item i) {

		for (Item item : getSelectedItems()) {
			if (item.equals(i))
				return true;
		}
		return false;
	}

	/**
	 * Provides a String text for items in category Drink
	 * 
	 * @return String drink items
	 */
	private List<Item> getDrinkItems() {
		List<Item> drinks = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Drink))
				drinks.add(i);
		}
		return drinks;
	}

	/**
	 * Provides a String text for items in category Food
	 * 
	 * @return String food items
	 */
	private List<Item> getFoodItems() {
		List<Item> food = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Food))
				food.add(i);
		}
		return food;
	}

	/**
	 * Provides a String text for items in category Place
	 * 
	 * @return String place items
	 */
	private List<Item> getPlaceItems() {
		List<Item> places = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Place))
				places.add(i);
		}
		return places;
	}

	/**
	 * Provides a String text for items in category Decoration
	 * 
	 * @return String deco items
	 */
	private List<Item> getDecoItems() {
		List<Item> decos = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Decoration))
				decos.add(i);
		}
		return decos;
	}

	/**
	 * Provides a String text for items in category Others
	 * 
	 * @return String other items
	 */
	private List<Item> getOtherItems() {
		List<Item> other = new ArrayList<Item>();
		for (Item i : selectedItemsUnits.keySet()) {
			if (i.getCategory().equals(ItemCategory.Others))
				other.add(i);
		}
		return other;
	}

	/**
	 * Sets the number of attendants coming to the party and updates total price
	 * 
	 * @param int people
	 */
	public void setAttendance(int people) {
		attendance = people;
		calculateFinalPrice();
	}

	/**
	 * Provides the number of attendants coming to the party
	 * 
	 * @return int attendants
	 */
	public int getAttendance() {
		return attendance;
	}

	/**
	 * Sets the date for the party
	 * 
	 * @param String date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Provides the date for the party
	 * 
	 * @return String date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Provides the text containing the comments of the party reservation
	 * 
	 * @return String comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Sets the comments done by the customer during the party reservation
	 * 
	 * @param String comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Provides the final price for the party reservation
	 * 
	 * @return double price
	 */
	public double getFinalPrice() {
		calculateFinalPrice();
		return finalPrice;
	}

	/**
	 * Provides the list of items reserved
	 * 
	 * @return Set<Item> items
	 */
	public Set<Item> getSelectedItems() {
		return selectedItemsUnits.keySet();
	}

	/**
	 * Provides the hashmap containing the items reserved and the number of units of
	 * each item
	 * 
	 * @return HashMap<Item, Integer>
	 */
	public HashMap<Item, Integer> getSelectedItemsUnits() {
		return selectedItemsUnits;
	}

	/**
	 * Provides the customer associated to the party reservation
	 * 
	 * @return Customer customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Provides the final price of the reservation applying the registered user's
	 * 15% discount
	 * 
	 * @return double discounted total
	 */
	public double getWithDiscount() {
		return finalPrice * 0.85;
	}

	/**
	 * Removes all items for the party
	 */
	public void clearOrder() {
		selectedItemsUnits.clear();
	}

	/**
	 * Provides the party bill in text format
	 * 
	 * @return String bill
	 */
	public String getBill() {
		StringBuilder sb = new StringBuilder();
		sb.append("PARTY BILL\n------------------\n");
		String cus = "** CUSTOMER: " + customer.getName() + " " + customer.getSurname();

		if (customer.isLogged()) {
			cus += " (Registered customer: " + customer.getUsername() + ")";
		}
		sb.append(cus + "\n");
		sb.append("** NIF: " + customer.getNIF() + "\n");

		sb.append("** PARTY DATE AND TIME: " + date+ "\n");
		sb.append("** NUMBER OF ATTENDANTS: " + attendance + "\n");

		sb.append(
				"\nPRODUCTS:   NAME / CODE / UNITS  / TOTAL PRODUCT\n--------------------------------------------------------------------------\n");

		sb.append(itemsBill(getDecoItems()));
		sb.append(itemsBill(getDrinkItems()));
		sb.append(itemsBill(getFoodItems()));
		sb.append(itemsBill(getPlaceItems()));
		sb.append(itemsBill(getOtherItems()) + "\n");

		sb.append("\nCOMMENTS\n-------------------------\n");
		sb.append(comments + "\n");

		String price = "\nTOTAL BILL ";
		if (customer.isLogged()) {
			price += "WITH CUSTOMER DISCOUNT: " + String.valueOf(finalPrice) + " - "
					+ String.valueOf(finalPrice - getWithDiscount()) + " = " + String.valueOf(getWithDiscount());
		} else
			price += String.valueOf(finalPrice);
		sb.append(price + " €\n");

		return sb.toString();
	}

	/**
	 * Provides a text for the bill with all items in the list
	 * 
	 * @param list of items
	 * @return String text
	 */
	private String itemsBill(List<Item> list) {
		String items = "";
		if (!list.isEmpty()) {
			items+= "\n"+String.valueOf(list.get(0).getCategory())+":";
			for (Item i : list) {
				int units = getSelectedItemsUnits().get(i);
				items += "\n* " + i.getName() + " / " + i.getCode() + " / " + String.valueOf(units) + " / "
						+ String.valueOf(units * i.getPrice()) + " €";
			}
		}
		return items;
	}

}
