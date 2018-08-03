/*
 * Group 5 - Clair, Johnathan, Christopher
 * PP 13.5
 * Group Assignment
 */

package bankqueue;
import java.util.Arrays;

public class BankLine<T> {

    private Customer[] customerArray;
    private int queueSize;
    private int front, rear, count = 0;

    BankLine(int size) {
        queueSize = size;
        customerArray = new Customer[size];
        Arrays.fill(customerArray, new Customer());
    }
    
    public int getSize() {
        return count;
    }
    
    public void enqueue(Customer input) {

        if (count + 1 <= queueSize) {
            customerArray[rear] = input;
            rear++;
            count++;
        } else {
            System.out.println("Sorry, but the line is full!");
        }
    }

    public Customer dequeue() {
        if (!isEmpty()) {
            Customer temp = customerArray[front];
            customerArray[front] = new Customer();
            front++;
            count--;
            return temp;            
        } else {
            System.out.println("Nobody is in line!");
            return null;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
