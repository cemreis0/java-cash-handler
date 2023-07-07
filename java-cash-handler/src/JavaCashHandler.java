import java.text.DecimalFormat;
import java.util.Scanner;

public class JavaCashHandler {
    public static void main(String[] args) {
        /*  Develop an application that reads a purchase price and an amount tendered
            and then displays the change in dollars, quarters, dimes, nickels, and
            pennies. Two input values are entered in cents, for example, 3480 for $34.80
            and 70 for $0.70. Display the output in the following format:

                 Purchase Price: $ 34.80
                Amount Tendered: $ 40.00
                 Your change is: $ 5.20

                 5 one-dollar bill(s)
                 0 quarter(s)
                 2 dime(s)
                 0 nickel(s)
                 0 penn(y/ies)

                Thank you for your business. Come back soon

            Notice the input values are to be entered in cents (int data type), but
            the echo printed values must be displayed with decimal points (float
            data type).
         */

        // cent equivalents of coins
        final int PENNY_TO_CENTS = 1;
        final int NICKEL_TO_CENTS = 5;
        final int DIME_TO_CENTS = 10;
        final int QUARTER_TO_CENTS = 25;
        final int DOLLAR_TO_CENTS = 100;

        // new line constant
        final String NEW_LINE = "\n";

        // values of coins
        int penny, nickel, dime, quarter, dollar;

        // input values
        int price, tender; // data type is int, they are entered in cents

        // change variables, changeAtFirst is displayed in output
        int change, changeAtFirst;

        // these values need to be displayed in dollars, so there will be typecasting
        double priceInDollars, tenderInDollars, changeAtFirstInDollars;

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // read input from the user
        System.out.print("Enter price:  $ ");
        price = scanner.nextInt();
        System.out.print("Enter tender: $ ");
        tender = scanner.nextInt();

        // compute change in cents
        // changeAtFirst is used to display the change in output
        change = tender - price;
        changeAtFirst = change;

        // compute the amount of coins
        // approach: filter from high to low, dollar to penny, the value of change is shrunk each time, if possible
        dollar = change / DOLLAR_TO_CENTS;
        change = change % DOLLAR_TO_CENTS;
        quarter = change / QUARTER_TO_CENTS;
        change = change % QUARTER_TO_CENTS;
        dime = change / DIME_TO_CENTS;
        change = change % DIME_TO_CENTS;
        nickel = change / NICKEL_TO_CENTS;
        change = change % NICKEL_TO_CENTS;
        penny = change / PENNY_TO_CENTS;

        // convert the price, tender and changeAtFirst from cents to dollars
        priceInDollars = (double) price / 100;
        tenderInDollars = (double) tender / 100;
        changeAtFirstInDollars = (double) changeAtFirst / 100;

        // output
        System.out.println(
                "Purchase Price:    $ " + df.format(priceInDollars) + NEW_LINE +
                        "Amount Tendered:   $ " + df.format(tenderInDollars) + NEW_LINE + NEW_LINE +
                        "Your change is:    $ " + df.format(changeAtFirstInDollars) + NEW_LINE + NEW_LINE +
                        "                   " + dollar + " one dollar bill(s)" + NEW_LINE +
                        "                   " + quarter + " quarter(s)" + NEW_LINE +
                        "                   " + dime + " dime(s)" + NEW_LINE +
                        "                   " + nickel + " nickel(s)" + NEW_LINE +
                        "                   " + penny + " penn(y/ies)" + NEW_LINE + NEW_LINE +
                        "Thank you for your business. Come back soon."
        );
    }
}