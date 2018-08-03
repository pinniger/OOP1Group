/*
 * Group 5 - Clair, Johnathan, Christopher
 * PP 13.5
 * Group Assignment
 */
package bankqueue;
public class Customer {
    private String name;
    Customer(){
        name = null;
    }
    
    Customer(String name){
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
