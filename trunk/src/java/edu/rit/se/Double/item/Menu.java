
package edu.rit.se.Double.item;

import java.util.ArrayList;
/**
 * @author Jake Juby
 * @version 0.0.3
 * Menu for Menu-ing and such
 * 
 * Jacob Juby
 *     I have added functionality for checking if something is on the menu.
 * Also functionality for grabbing actual MenuItems off the menu and putting 
 * them in an order as copies ofcorse.
 */
public class Menu 
{
	private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    
	/**
	 * 
	 */
	public Menu()
    {
    }
	
	/**
	 * 
	 * @param item
	 */
	public void addToMenu(MenuItem item)
	{
        menu.add(item);
	}
	
	/**
	 * 
	 * @param item to test against the menu
	 * @return a boolean depending on the equality of the item passed
	 * in and the items on the menu
	 */
	public boolean isOnMenu(String item)
	{
		for(MenuItem m : menu)
		{
			if(m.getName().equals(item.toLowerCase()))
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param item the name of the item you want from the menu
	 * @return the MenuItem that you requested or null if it doesn't exist
	 */
	public MenuItem getOffMenu(String item)
	{
		for(MenuItem m : menu)
		{
			if(m.getName().equals(item))
			{
				if(m instanceof BaseItem)
				{
					return new BaseItem(m.getName(), m.getPrice(), 
							   ((BaseItem)m).getTime(), m.getSize());
				}
				else
				{
					return new Toping(((Toping)m).getBase(), m.getName(),
							   m.getPrice(), m.getSize());
				}
			}
		}
		return null;
	}
	
	/**
	 * the toString() of the menu display the string representation 
	 * of the Menu
	 * 
	 * @Override Object.toString()
	 */
	public String toString()
	{
		String result = "MENU:\n";
		
		for(MenuItem item : menu)
		{
			result += item.getName()+"\t"+item.getPrice()+"\n";
		}
		return result;
	}
	
	public void defaultMenu()
	{
		//call this method if you want the default menu
		//menuitem constructors
		// public Toping (BaseItem base, String name, double price, int time)
		// public BaseItem (String name, double price, int time, int size)
		
		BaseItem pizza = new BaseItem("pizza", 5.00, 300, 5);
		menu.add(new BaseItem("pizzaaaaaa", 5.00, 300, 5));
		menu.add(new BaseItem("pizza logs", 5.30, 150, 3));
		menu.add(new BaseItem("garlic bread", 5.00, 200, 3));
		menu.add(new BaseItem("chicken wings", 3.25, 125, 2));
		menu.add(new Toping(pizza, "peperoni", .25, 25));
		menu.add(new Toping(pizza, "extra cheese", .35, 30));
		menu.add(new Toping(pizza, "mushrooms", .45, 60));
		menu.add(new Toping(pizza, "anchovies", .20, 55));
		
	}
}
