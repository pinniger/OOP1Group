/*
 * Group 5 - Clair, Johnathan, Christopher
 * PP 13.5
 * Group Assignment
 */
package bankqueue;
import java.util.Random;

public class BankQueue 
{
    private static final int MAX_NUM_CUSTOMERS = 5;
    private static final int MAX_CUST_SERVICED = 4;
    private static final int CYCLES = 10;
    
    public static void main(String[] args) {
       int numCust, custServced;
       Customer person;
       
       Random gen = new Random();
       int custCount = 0;
       BankLine line = new BankLine();
       
        for (int i = 0; i < CYCLES; i++) 
        {
            numCust = gen.nextInt(MAX_NUM_CUSTOMERS);
            
            for (int j = 0; j < numCust; j++) 
            {
                person = new Customer(custCount++);
                line.addCustomer(person);
                System.out.println(person + " joins the line");
            }
            
            custServced = gen.nextInt(MAX_CUST_SERVICED);
            
            for (int j = 0; j < custServced; j++) 
            {
                if (line.isEmpty()) {
                    System.out.println("Teller waiting");
                } else {
                    System.out.println(line.nextCustomer() + " is being serviced");
                }
            }
        }
       
        System.out.println("Bank closing...");
        while(!line.isEmpty())
            System.out.println(line.nextCustomer() + " is being serviced");
       
    }
    
}
