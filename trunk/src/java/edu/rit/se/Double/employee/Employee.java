package edu.rit.se.Double.employee;


/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.2
 * Class Employee
 * an employee is a base abstract class to be extended by more specific employees
 * and their jobs
 * 
 * Jacob Juby
 *     Added Constructor functionality
 */
abstract public class Employee {

    //
    // Fields
    //

  private String name;
  private String passwd;
  
    //
    // Constructors
    //
    public Employee(){}
    
    public Employee (String name, String passwd) 
    { 
        this.name = name;
        this.passwd = passwd;
    }
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of name
     * @param newVar the new value of name
     */
    public void setName ( String newVar ) {
      name = newVar;
    }

    /**
     * Get the value of name
     * @return the value of name
     */
    public String getName ( ) {
      return name;
    }

    /**
     * Set the value of passwd
     * @param newVar the new value of passwd
     */
    public void setPasswd ( String newVar ) {
      passwd = newVar;
    }

    /**
     * Get the value of passwd
     * @return the value of passwd
     */
    public String getPasswd ( ) {
      return passwd;
    }


}
