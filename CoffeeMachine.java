package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int cups = 9;
    public static int money = 550;


    public static void displayState() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cups + " of disposable coffee cups\n" +
                money + " of money");
    }

    public static int checkAvailability(int coffee) {
        int error = 0;
        if (coffee == 1) {
            if (water - 250 < 0)
                error = 1;
            else if (coffeeBeans - 16 < 0)
                error = 3;
        }
        else if (coffee == 2) {
            if (water - 350 < 0)
                error = 1;
            if (milk - 75 < 0)
                error = 2;
            if (coffeeBeans - 20 < 0)
                error = 3;
        }
        else if (coffee == 3) {
            if (water - 200 < 0)
                error = 1;
            if (milk - 100 < 0)
                error = 2;
            if (coffeeBeans - 12 < 0)
                error = 3;
        }
        return error;
    }

    public static void buy(int coffee) {
        cups -= 1;

        if (coffee == 1) {
            water -= 250;
            coffeeBeans -= 16;
            money += 4;
        }
        else if (coffee == 2) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            money += 7;
        }
        else if (coffee == 3) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            money += 6;
        }
    }

    public static void fill(int w, int m, int b, int c) {
        water += w;
        milk += m;
        coffeeBeans += b;
        cups += c;
    }

    public static void take() {
        money = 0;
    }

    public static void main(String[] args) {

        //System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans\nPouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
        Scanner scanner = new Scanner(System.in);
        String option;
        do {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            option = scanner.next();

            if (option.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String opt = scanner.next();
                if (opt.equals("back")) {
                    continue;
                }
                else {
                    int coffee = Integer.parseInt(opt);
                    int result = checkAvailability(coffee);
                    if (result == 0)
                        buy(coffee);
                    else if (result == 1)
                        System.out.println("Sorry, not enough water!");
                    else if (result == 2)
                        System.out.println("Sorry, not enough milk");
                    else if (result == 3)
                        System.out.println("Sorry, not enough coffee beans");
                    else if (result == 4)
                        System.out.println();
                }
            } else if (option.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add:");
                int water = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int milk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add");
                int beans = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cups = scanner.nextInt();
                fill(water, milk, beans, cups);
                System.out.println();
            } else if (option.equals("take")) {
                take();
                System.out.println();
            }
            else if (option.equals("remaining")) {
                displayState();
            }
            else if (option.equals("back")) {

            }
        }while (!option.equals("exit"));
    }
}
