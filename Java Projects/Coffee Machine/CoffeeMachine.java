package machine;
import java.util.Scanner;

//TODO:
// 1)create a enum just for the beverages (ESPRESSO, LATTE and CAPPUCCINO) with their internal field variables (coffe, mil, water and cost)
// 2) create a num for the state (RUNNING, OFF, FILLING_WATER, FILLING...etc)
// 3) create a class outside the CoffeMachine class and put all the methods and global fields variables (current water, current money, etc) there along with all the other methods for the normal functioning of the coffee machine.
// 4) From the main method i just created an instance of Scanner and one of the newCoffeeMachine class (which one i passed the scanner as an argument to it's constructor)

public class CoffeeMachine {

    // Class variables
    private int cap_water;
    private int cap_milk;
    private int cap_beans;
    private int cap_cups;
    private int amount_money;

    // Constructor
    public CoffeeMachine(int cap_water, int cap_milk, int cap_beans, int cap_cups, int amount_money) {
        this.cap_water = cap_water;
        this.cap_milk = cap_milk;
        this.cap_beans = cap_beans;
        this.cap_cups = cap_cups;
        this.amount_money = amount_money;
    }

    // getters and setters
    public int getCap_water() {
        return cap_water;
    }

    public void setCap_water(int cap_water) {
        this.cap_water = cap_water;
    }

    public int getCap_milk() {
        return cap_milk;
    }

    public void setCap_milk(int cap_milk) {
        this.cap_milk = cap_milk;
    }

    public int getCap_beans() {
        return cap_beans;
    }

    public void setCap_beans(int cap_beans) {
        this.cap_beans = cap_beans;
    }

    public int getCap_cups() {
        return cap_cups;
    }

    public void setCap_cups(int cap_cups) {
        this.cap_cups = cap_cups;
    }

    public int getAmount_money() {
        return amount_money;
    }

    public void setAmount_money(int amount_money) {
        this.amount_money = amount_money;
    }

    // Public method to print the status of the coffee machine.
    public void print() {
        System.out.println();
        System.out.println("The coffee machine has:\n" +
                            cap_water + " of water\n" +
                            cap_milk + " of milk\n" +
                            cap_beans + " of coffee beans\n" +
                            cap_cups + " of disposable cups\n" +
                            amount_money + " of money");
    }

    public static void main(String[] args) {

        // creates a Coffee Machine object with initialization
        Scanner s = new Scanner(System.in);
        CoffeeMachine CM = new CoffeeMachine(400,540,120,9,550);
        boolean isDone = false;
        while(isDone == false) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch (s.next()) {
                case "buy":
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    switch (s.next()) {
                        case "1":
                            // checking is enough resources to make the selected coffee.
                            if(CM.getCap_water() >= 250 && CM.getCap_beans() >= 16 && CM.getCap_cups() >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                CM.setCap_water(CM.getCap_water() - 250);
                                CM.setCap_beans(CM.getCap_beans() - 16);
                                CM.setCap_cups(CM.getCap_cups() - 1);
                                CM.setAmount_money(CM.getAmount_money() + 4);
                            }
                            else {
                                System.out.println("Sorry, not enough water!");
                            }
                            break;
                        case "2":
                            if(CM.getCap_water() >= 350 && CM.getCap_milk() >= 75 && CM.getCap_beans() >= 20 && CM.getCap_cups() >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                CM.setCap_water(CM.getCap_water() - 350);
                                CM.setCap_milk(CM.getCap_milk() - 75);
                                CM.setCap_beans(CM.getCap_beans() - 20);
                                CM.setCap_cups(CM.getCap_cups() - 1);
                                CM.setAmount_money(CM.getAmount_money() + 7);
                            }
                            else {
                                System.out.println("Sorry, not enough water!");
                            }
                            break;
                        case "3":
                            if(CM.getCap_water() >= 200 && CM.getCap_milk() >= 100 && CM.getCap_beans() >= 12 && CM.getCap_cups() >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                CM.setCap_water(CM.getCap_water() - 200);
                                CM.setCap_milk(CM.getCap_milk() - 100);
                                CM.setCap_beans(CM.getCap_beans() - 12);
                                CM.setCap_cups(CM.getCap_cups() - 1);
                                CM.setAmount_money(CM.getAmount_money() + 6);
                            }
                            else {
                                System.out.println("Sorry, not enough water!");
                            }
                            break;
                    }
                    break;
                case "fill":
                    System.out.println();
                    System.out.println("Write how many ml of water do you want to add: ");
                    CM.setCap_water(CM.getCap_water() + s.nextInt());
                    System.out.println("Write how many ml of milk do you want to add: ");
                    CM.setCap_milk(CM.getCap_milk() + s.nextInt());
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    CM.setCap_beans(CM.getCap_beans() + s.nextInt());
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    CM.setCap_cups(CM.getCap_cups() + s.nextInt());
                    break;
                case "take":
                    System.out.println();
                    System.out.println("I gave you $" + CM.getAmount_money());
                    break;
                case "remaining":
                    CM.print();
                    break;
                case "exit":
                    isDone = true;
            }

        }
    }
}
