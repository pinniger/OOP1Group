/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankqueue;
import java.util.Random;
import java.util.Scanner;

public class BankQueue {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int maxSize = 8;
        BankLine line = new BankLine(8);
        
        for (int i = 0; i < maxSize; i++) {
            int option = random.nextInt(2);
            
            if(option == 0 || line.getSize() == 0)
            {
                System.out.println("Enter a customer name and number ot queue");
                String name = input.next();
                
                line.enqueue(new Customer(name));
                System.out.println(name + " got in line at position " + line.getSize());
            } else {
                Customer cust = line.dequeue();
                System.out.println(cust.name + " has finished at the teller, the line size is now " + line.getSize());
            }
        }
    }
    
}
