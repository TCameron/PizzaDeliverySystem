package edu.rit.se.Double.employee;

import edu.rit.se.Double.Order;


/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.2
 * Class PerformanceEmployee
 * 
 * Jacob Juby
 *     I have added constructor functionality.
 */
abstract public class PerformanceEmployee extends Employee {

    //
    // Fields
    //

  
    //
    // Constructors
    //
    public PerformanceEmployee (String name, String passwd) 
    {
        super(name, passwd);
    }
  
    //
    // Methods
    //
    /**
     * @param        order the order that comes in will have some task performed on its
     * contents by this method
     */
    abstract public void perform( Order order );

    //
    // Accessor methods
    //
}
