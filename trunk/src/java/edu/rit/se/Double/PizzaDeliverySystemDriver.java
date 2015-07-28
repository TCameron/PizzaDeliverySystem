package edu.rit.se.Double;
import java.util.ArrayList;
import java.util.Scanner;

import edu.rit.se.Double.Customer;
import edu.rit.se.Double.employee.Employee;
import edu.rit.se.Double.item.Menu;
import edu.rit.se.Double.item.MenuItem;

/**
 * @author Jacob Juby, Timothy Cameron, Cody Pugliese, Heriberto Munoz, Ken Van
 *         Dalsum
 * @version 0.0.1 Pizza Delivery System Driver this is the implementation of the
 *          PDS CLI interface.
 */

public class PizzaDeliverySystemDriver {

	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		// TODO status; it's the big one. Indicator of functionality of the program. 
		// TODO listorders; Also important.
		// TODO estimate order; Important, but completed...read Order Object
		
		
		// TODO Add functionality to commands.
		// TODO read
		// <a>http:/I'v/download.oracle.com/javase/6/docs/api/java/lang/String.html</a>
		// ... It's really helpful!

		Scanner in = new Scanner(System.in);
		String[] input;

		 
		KitchenQue kitchen = new KitchenQue();
		kitchen.start();
		
		
		Menu menu = new Menu();
		//for debugging
		//comment this out if you want to run for realz
		menu.defaultMenu();
		
		
		while ( true ) {
			System.out.print("pizzaDeliverySystem $ ");
			input = in.nextLine().toLowerCase().trim().split(" ");
			
			//scope
			Order order = null;
			
			
			// Quit the interpreter when the user types "quit" or "exit"
			if ( input[0].equals("quit") || input[0].equals("exit") ) {

				break;

			} else if ( input[0].equals("login") ) {

				System.out.println("Code for login goes here.");

			} else if ( input[0].equals("order") ) {

				// TODO Add new/returning customer information
				//	remember that the identifier for any customer is the phone number.
				
				// TODO Remember that an Order consists of MenuItems, so
				// here are the constructors for both:
				// MenuItem -> public MenuItem (String name, double price, int size)
				// Order -> public Order (ArrayList<MenuItem> listOfItems, Customer customer, Employee employee, int id)
				
				//Needed for MenuItem
				String itemName;
				
				//Needed for Order
				ArrayList<MenuItem> curOrder = new ArrayList<MenuItem>();
				int orderNumber = 0;
				
				boolean done = false;
				while(!done) {
				    System.out.print("Enter item name(enter none to stop): ");
				    itemName = in.nextLine();
				    if(itemName.compareToIgnoreCase("none") == 0)
				    {
				    	done = true;
				    }
				    else if(menu.isOnMenu(itemName))
				    {
				    	curOrder.add(menu.getOffMenu(itemName));
				    }
				    else
				    {
				    	System.out.println("Item not on menu");
				    }
				}
				
				done = false;
				String cusName = null;
				String cusNum = null;
				while(!done) {
					System.out.println("Enter Customer Name:");
					cusName = in.nextLine();
					System.out.println("Enter Customer Number(xxx-xxxx):");
					cusNum = in.nextLine();
					
					System.out.println("y to continue, anything to re-enter:");
					String temp = in.nextLine();
					if(temp.startsWith("y"))
					{
						done = true;
					}
				}
				order = new Order(curOrder, 
						                new Customer(cusName, cusNum, null),
						                null,
						                orderNumber);
				
				orderNumber++;
				if(order != null)
					    kitchen.addToList(order);
				
			} else if ( input[0].equals("status") ) {
				int orderToLookUp;
				
				
				System.out.println("Code for checking on the status of an order goes here. ");

			} else if ( input[0].equals("listorders") ) {

				System.out.println("Code for listing the progress of all oders goes here.");

			} else if ( input[0].equals("report") ) {

				System.out.println("Code for generating a manager report goes here.");

			} else if ( input[0].equals("customer") ) {

				System.out.println("Code for details on a specified customer goes here.");

			} else if ( input[0].equals("estimateorder") ) {

				System.out.println("Code for the estimation on the finish time of an order goes here.");

			} else if ( input[0].equals("menu") ) {

				System.out.println(menu);

			} else if ( input[0].equals("changemenu") ) {

				System.out.println("Code for changing the menu goes here.");

			} else if ( input[0].equals("help") ) {
				// TODO Finish this up after integration.
				System.out.println("Usage: [command] [parameters]\n"
						+ "Commands: \n"
						+ "exit / quit - Exit the Pizza Delivery System \n"
						+ "login - Log into the system.  \n\t"
						+ "ex. $ login -u admin -p password \n\t"
						+ "ex. $ login \n\t" + "Username: admin \n\t"
						+ "Password: password \n"
						+ "order - Place an order \n"
						+ "makeorder - Send an order to the kitchen. \n"
						+ "status - Find out the status of an order \n"
						+ "listorders - Place an order \n"
						+ "order - Place an order \n"
						+ "order - Place an order \n");
			} else {

				System.out.println("Usage: [command] [parameters]\n"
						+ "Type \"help\" for a list of all the commands.");

			}

		}

	}

}
