/*
 * Group 5 - Clair, Johnathan, Christopher
 * PP 13.6
 * Group Assignment
 */
package bankqueue;
public class Customer {
    private int id;
    
    Customer(int number){
        this.id = number;
    }

    public String toString() {
        return "Customer " + id;
    }
}