/*
 * Group 5 - Clair, Johnathan, Christopher
 * PP 13.5
 * Group Assignment
 */

package bankqueue;

import java.util.LinkedList;

public class BankLine<T> {
    
    private LinkedList<Customer> queue;

    BankLine() {
        queue = new LinkedList<Customer>();
    }
    
    public Customer nextCustomer(){
        return queue.removeFirst();
    }
    
    public void addCustomer(Customer cust){
        queue.addLast(cust);
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
    
}
