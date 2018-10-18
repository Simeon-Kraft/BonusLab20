package bonus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BonusLab20 {

	static List<String> menu = new ArrayList<>();
	static List<String> price = new ArrayList<>();
	static List<String> orderedItems = new ArrayList<>();
	static List<Double> itemPrices = new ArrayList<>();
	static Map<String, Double> menuItems = new HashMap<>();

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userItem = null;
		String goAgain = null;
		itemMap();
		getMenu();

		do {

			System.out.println("Enter the name of the product you'd like to buy: ");
			userItem = isValidOrder(scnr.nextLine().toLowerCase(), scnr);
			
			
			if (menuItems.containsKey(userItem)) {
				orderedItems.add(userItem);
				itemPrices.add(menuItems.get(userItem));
				System.out.println("Added one " + userItem + " at " + menuItems.get(userItem) + " a pop.");
			}

			
			System.out.println("Do you want anything else? (y/n)");
			goAgain = scnr.nextLine();
		} while (goAgain.equalsIgnoreCase("y"));
		
		
		System.out.println("Thank you for your patronage. Here's what you've got: ");
		System.out.printf("%-9s %12s", "Items" , "Price\n");
		System.out.println("======================\n");
		for (int i = 0; i < orderedItems.size(); i++) {
			
			System.out.printf("%-9s %12s",orderedItems.get(i), itemPrices.get(i));
			System.out.println("\n");
		}
		System.out.println("The average price of the selected goods is " + cartAverage() + ".");
		System.out.println("The most expensive item was found at index " + cartHighest() + " while the least expensive"
				+ " was found at index " + cartLowest() + ".");

	}

	public static void getMenu() {

		menu.add("apple");
		menu.add("banana");
		menu.add("chocolate");
		menu.add("danish");
		menu.add("eggplant");
		menu.add("fish");
		menu.add("grapes");
		menu.add("halloumi");

		price.add("$0.75");
		price.add("$0.55");
		price.add("$0.99");
		price.add("$1.25");
		price.add("$1.89");
		price.add("$6.99");
		price.add("$2.99");
		price.add("$4.89");

		System.out.println("Welcome to a weird farmer's market. Observe our wares!");
		System.out.printf("%-9s %12s", "Items" , "Price\n");
		System.out.println("======================");
		for (int i = 0; i < menu.size(); i++) {
			
			System.out.printf("%-9s %12s", menu.get(i),price.get(i));
			
			System.out.printf("\n");
		}

	}

	public static String isValidOrder(String str, Scanner scnr) {
		String returnValue;
		
		if (menuItems.containsKey(str)) {
			returnValue = str;
		} else {
			System.out.println("We dont sell those. Please choose a valid option:");
			returnValue = isValidOrder(scnr.nextLine().toLowerCase(), scnr);
		}
		
		return returnValue;
	}

	public static void itemMap() {

		menuItems.put("apple", .75);
		menuItems.put("banana", .55);
		menuItems.put("chocolate", .99);
		menuItems.put("danish", 1.25);
		menuItems.put("eggplant", 1.89);
		menuItems.put("fish", 6.99);
		menuItems.put("grapes", 2.99);
		menuItems.put("halloumi", 4.89);

	}
	
	public static double cartAverage() {
		double average = 0;
		for (int i = 0; i < itemPrices.size(); i++) {
			average = average + itemPrices.get(i) / itemPrices.size();
		}
		return average;
	}
	
	public static int cartLowest() {
		double lowest = itemPrices.get(0);
		int lowIndex = 0;
		for (int i = 0; i < itemPrices.size(); i++) {
			if(lowest > itemPrices.get(i)) {
				lowest = itemPrices.get(i);
				lowIndex = i;
			}
		}
		return lowIndex;
	}
	
	public static int cartHighest() {
		double highest = itemPrices.get(0);
		int highIndex = 0;
		for (int i = 0; i < itemPrices.size(); i++) {
			if(highest < itemPrices.get(i)) {
				highest = itemPrices.get(i);
				highIndex = i;
			}
		}
		return highIndex;
	}

}
