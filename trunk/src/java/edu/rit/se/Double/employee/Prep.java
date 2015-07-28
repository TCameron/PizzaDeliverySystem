package edu.rit.se.Double.employee;


/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.6
 * Class Prep
 * 
 * Jacob Juby:
 * I have implemented a easy algorithm for preping  un-preped  
 * MenuItems in the order.  I will surf through the Items and 
 * grab Topings mark them as preped and continue untill the entire
 * Order is preped.  I have Added Constructor functionality.  Added 
 * functionality so that you only need one instantiation of preps at
 * any time.
 */

//imports
import java.util.ArrayList;
import edu.rit.se.Double.Order;
import edu.rit.se.Double.item.BaseItem;
import edu.rit.se.Double.item.MenuItem;
import edu.rit.se.Double.item.Toping;

public class Prep extends PerformanceEmployee implements Runnable {



	//
    // Fields
    //
	private int time;
	private Toping currToping;
	private int numberOfPreps;
	private int i = 0;//incrementer for making sure that we dont 
                      //use to many preps
	
    //
    // Constructors
    //
    public Prep (String name, String passwd, int numberOfPreps) 
    {
        super(name, passwd);
        this.numberOfPreps = numberOfPreps;
    }
  
    //
    // Methods
    //
    /**
     * this method associates topings with BaseItems in the order and 
     * sends them to an actual prep function that will spend time 
     * preping them
     * last edit: Jacob Juby
     * 
     * @param        order the order that comes in will have some task 
     * performed on its contents by this method
     */
    public void perform( Order order )
    {
        boolean done = false;//loop controller
        while(!done)
        {
        	int counter = 0;//counter of items left to prep
        	BaseItem currentBase = null;
        	ArrayList<Toping> topings = new ArrayList<Toping>();
        	
           	for(MenuItem item : order.getListOfItems())
            {
           		//loop through the listOfOrders checking for Topings
           	    if(item instanceof Toping)
        	    {
           	    	if(((Toping)item).getStatus().equals(Toping.NOT_PREPED))
           	    	{
           	    	    if(currentBase == null)
           	    	    {
           	    	    	//if current base is equal to null then set it
           	    	    	currentBase = ((Toping)item).getBase();
           	    	    }
           	    	    else if(((Toping)item).getBase().equals(currentBase))
           	    	    {
           	    	    	//you will only get into this if statement if
           	    	    	//the current item's base is the exact same base
           	    	    	//as the current base
           	    	    	topings.add((Toping)item);
           	    	    }
           	    	}
        		}
            }
           	//send things to get preped
           	prep(topings, currentBase);
           	
           	//looping through again here to find out if we have finished
           	//the entire order
           	for(MenuItem item : order.getListOfItems())
           	{
                if(item instanceof Toping)
                {
                	if(((Toping)item).getStatus().equals(Toping.NOT_PREPED))
                	{
                        counter++;
                	}
                }
           	}
           	if(counter == 0)
           	{
           		//if counter is 0 then we are done :)
           		done = true;
           	}
        }
        order.setStatus(Order.STATUSES[1]);
    }
    
    /**
     * this method sleeps the thread according to the time it takes to
     * prep each item
     * last edit: Jacob Juby
     * @param      topings the topings to prep
     * @param      base the base associated with the topings
     * 
     */
    private void prep(ArrayList<Toping> topings, BaseItem base)
    {
    	for(Toping toping : topings)
    	{
    		while(i == numberOfPreps ){}
    	    
    		time = toping.getTime();
    		currToping = toping;
            
    		(new Thread(this)).start();
    	}
        
        base.makeReady();
    }

    
    public void run()
    {
    	i++;
    	currToping.setWorking(true);
        try{
        	Thread.sleep(time*1000);
        } catch(InterruptedException ie){}
        currToping.setWorking(false);
        currToping.setPreped();
        i--;
    }
}
