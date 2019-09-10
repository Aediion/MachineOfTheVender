/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.x;


import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// generates method stub
		String userChoice;
		boolean x = true;
		double total = 0;
		DecimalFormat df = new DecimalFormat("$0.00"); //BigInt is being fickle
                //BigDecimal intereString = new BigDecimal(Double.toString(df));
                //intereString = intereString.setScale(2, RoundingMode.HALF_UP);
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Vendermaster 3000");
		System.out.println("");
		System.out.println("Give me your money or get lost");
		System.out.println("");
		VendingMachine v = new VendingMachine("vend.txt");
                

		while (true) {
			System.out.print("A - Vendermaster 3000 |  X - Exit: ");
			userChoice = sc.next();
			switch (userChoice) {
			case ("a"):
			case ("A"):

				try {
					v.printMenu();
					v.vend();
					total +=v.getCurrency();
				} catch (Exception e) {
					System.out.println("Something is wrong here ");
				}

				break;

			case ("X"):
			case ("x"):
				System.out.println("");
				System.out
						.println("What is our profit you may ask ? "+df.format(total));
				System.out.println("Thank you for your money. Remember, if you shop elsewhere, I'll do unspeakable things to you.");
				System.exit(0); 
							
			}
		}
	}

}
