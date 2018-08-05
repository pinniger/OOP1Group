/*
 * Group 5 - Clair, Johnathan, Christopher
 * PP 13.6
 * Group Assignment
 */
package bankqueue;

import java.text.DecimalFormat;
import java.util.Random;


public class BankSimulation2Queues {
    private final int MAX_NUM_CUSTOMERS = 20;
    private final int MAX_CUST_SERVICED = 5;
    private final int NUM_TELLERS = 8;

    private Random gen;
    private int custCount;
    private BankLine[] lines;
    private int tellers[];
    private int stats[];

    public BankSimulation2Queues() {
        gen = new Random();
        custCount = 0;
        lines = new BankLine[NUM_TELLERS];
        stats = new int[NUM_TELLERS];
        for (int i = 0; i < NUM_TELLERS; i++) {
            lines[i] = new BankLine();
            stats[i] = 0;
        }
        tellers = new int[NUM_TELLERS];
    }

    private void displayStats(int numCycles) {
        float max = 0f;
        float average;
        int best = 0;

        DecimalFormat form = new DecimalFormat("0.0");
        System.out.println("\nAverage customers served per cycle:\n Teller number");

        for (int i = 0; i < NUM_TELLERS; i++) {
            System.out.print("  " + i + "  ");
        }
        
        System.out.println("\n-----------------------------------------");

        for (int i = 0; i < NUM_TELLERS; i++) {
            System.out.print(" ");
            average = (float) stats[i] / numCycles;
            if (average > max) {
                max = average;
                best = i;
            }
            System.out.print(form.format(average) + " ");
        }

        System.out.println("\n\nTeller " + best + " had the shortest average waiting time");
    }

    private int findShortestLine(Customer person) {
        int lineNumber = 0;
        int leastCustomers = lines[0].size();
        
        for (int i = 0; i < NUM_TELLERS; i++) {
            if (lines[i].size() < leastCustomers) {
                lineNumber = i;
                leastCustomers = lines[i].size();
            }
        }

        lines[lineNumber].addCustomer(person);
        return lineNumber;
    }

    public void run(int cycles) {
        int numCust, custServiced;
        int max;
        Customer person;

        for (int i = 0; i < cycles; i++) 
        {
            numCust = gen.nextInt(MAX_NUM_CUSTOMERS);
            for (int j = 0; j < numCust; j++) {
                person = new Customer(custCount++);
                System.out.println(person + " joins line " + findShortestLine(person));
            }

            max = 0;

            for (int j = 0; j < NUM_TELLERS; j++) {
                custServiced = gen.nextInt(MAX_CUST_SERVICED);
                if (custServiced > max) {
                    max = custServiced;
                }
                tellers[j] = custServiced;
                stats[j] += custServiced;
            }

            for (int j = 0; j < max; j++) {
                for (int k = 0; k < NUM_TELLERS; k++) {
                    if (tellers[k]-- > 0) {
                        if (lines[k].isEmpty()) {
                            System.out.println("Teller " + k + " waiting for new customers");
                        } else {
                            System.out.println("Teller " + k + " finished serving " + lines[k].nextCustomer());
                        }
                    }
                }
            }
        }
        
        System.out.println("Bank Closing...");
        for (int i = 0; i < NUM_TELLERS; i++) {
            while(!lines[i].isEmpty())
                System.out.println("Teller " + i + " is serving " + lines[i].nextCustomer());
                   
        }
        displayStats(cycles);
    }

}
