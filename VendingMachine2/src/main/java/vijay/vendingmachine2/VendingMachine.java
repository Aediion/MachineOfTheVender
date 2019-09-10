/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.x;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VendingMachine {

	private Item[] stock; 
	private double money; 

	
	//App driver = new App();

	
	DecimalFormat df = new DecimalFormat("$0.00");
	Scanner scan = new Scanner(System.in);
	boolean currencyLoop = true;
	boolean itemLoop = true;
	int count = 0;

	
	ArrayList<String> desItem = new ArrayList();
	ArrayList<Double> priceItem = new ArrayList();
	ArrayList<Integer> quanItem = new ArrayList();



	public VendingMachine(String filename) {
		File file = new File(filename);
		Scanner scan = null;
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		int totalItem = 0;
		while (scan.hasNextLine()) {
			scan.nextLine();
			totalItem++;
		} 
			
		stock = new Item[totalItem];
		scan.close();
                
            try {
                // Open the file again with a new scanner to read the items
                scan = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VendingMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
		int itemAmount;    //I don't know why this number works but 0 doesn't
		double itemPrice;
		String itemInfo;
		String line;

		
		// iterate item objects and put them into the array of stock
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			String[] tokens = line.split(",");
			try {
				itemInfo = tokens[0];
				itemPrice = Double.parseDouble(tokens[1]);
				itemAmount = Integer.parseInt(tokens[2]);

				stock[count] = new Item(itemInfo, itemPrice, itemAmount);
				count++;

				// add the index to ArrayList for each column (information,
				// price and amount)
				desItem.add(itemInfo);
				priceItem.add(itemPrice);
				quanItem.add(itemAmount);

			} catch (NumberFormatException nfe) {
				System.out.println("Error in " + filename + " on row "
						+ (count + 1) + ".");
			}
		} 
		scan.close();

		money = 0.0;
	} 

	int choice;
	String itemName;

	
	public void vend() throws Exception {
		currencyLoop = true;
		itemLoop = true;
		System.out
				.print("Please enter some money into the machine (enter -1 to exit): ");
		money = Double.parseDouble(scan.nextLine());
		
		if (money == -1) {
			System.out
					.println("Ok fine, don't buy anything. Your change is "
							+ df.format((-1) * money));
			System.out.println("");
			currencyLoop = false;
			//driver.getClass();
			money = 0;
		}
		if (money > 0) {
			while (currencyLoop) {
				getCurrency(); 
				while (itemLoop) {
					// choice = scan.nextInt();
					try {
						System.out
								.print("You now have "
										+ df.format(money)
										+ " to spend. Please make a selection (enter 0 to exit): ");
						choice = Integer.parseInt(scan.nextLine());

						if (money >= priceItem.get(choice - 1)
								&& quanItem.get(choice - 1) > 0) {
							// if user have enough money and this item stocked
							// then money - item's price and the amount of
							// this item - 1.
							
							desItem.get(choice - 1);
							priceItem.get(choice - 1);
							quanItem.get(choice - 1);
							money = money - priceItem.get(choice - 1);
							quanItem.set(choice - 1,
									quanItem.get(choice - 1) - 1);

							System.out.println("You have bought "
									+ desItem.get(choice - 1) + " for "
									+ df.format(priceItem.get(choice - 1))
									+ ". Your change is " + df.format(money));
							System.out.println("");
							money = priceItem.get(choice - 1);
							currencyLoop = false; // y = false.
							itemLoop = false;
							//driver.getClass();
						}

						else if (money < priceItem.get(choice - 1)
								&& quanItem.get(choice - 1) > 0) {
							System.out
									.println("You do not have enough money. Please add more money or exit.");
							addCurrency(money); 
							break;
						} else if (quanItem.get(choice - 1) <= 0) {
							// if item is sold out. return to ask user
							
							System.out
									.println("Sorry, we're sold out ! ");
							currencyLoop = true;
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid ");
					}

				}
			}

		}

	}


	public double getCurrency() {
		return money;
	}


	public void addCurrency(double userMoney) {

		System.out
				.print("Give me $$$ (enter -1 to exit): ");
		double addCurrency = Double.parseDouble(scan.nextLine());
		if (addCurrency == -1) {
			System.out
					.println("Yeah fine, go away. Your change is "
							+ df.format((-1) * addCurrency));
			System.out.println("");
			money  = 0;
			currencyLoop = false;
			//driver.getClass();
		} else {

			money = money + addCurrency;
			currencyLoop = true;
		}

	}

	
        
	public void printMenu() {
		System.out.println("");
		System.out.println("Menu:");

		System.out.printf("%-8s %-10s %-8s %-8s\n", "Item#", "Item", "Price",
				"Qty");
		for (int i = 0; i < stock.length; i++) {
			System.out.printf("%-8s %-10s %-8s %-8s\n", i + 1, desItem.get(i),
					priceItem.get(i), quanItem.get(i));
		}
	}

}
