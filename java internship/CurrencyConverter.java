import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This class is our main program for converting currencies.
// We're not using a fancy online service here, just a fixed list of rates
// to keep things simple and focused on the core logic.
public class CurrencyConverter {

    public static void main(String[] args) {
        // The Scanner is our tool for getting input from the user, like their currency choices and amount.
        Scanner sc = new Scanner(System.in);

        // We use a Map to store our exchange rates. Think of it like a dictionary:
        // The "key" is the currency code (like "USD"), and the "value" is its rate
        // relative to a single, common currency. In our case, that's the US Dollar.
        Map<String, Double> rates = new HashMap<>();

        // Now we'll fill our map with some currency rates.
        // The rates are approximate, but they're good enough to get the job done!
        // The USD rate is 1.0 because everything else is measured against it.
        rates.put("USD", 1.0);       // US Dollar
        rates.put("INR", 83.5);      // Indian Rupee
        rates.put("NPR", 133.5);     // Nepalese Rupee
        rates.put("BTN", 83.5);      // Bhutanese Ngultrum (it's often tied to INR)
        rates.put("BDT", 117.5);     // Bangladeshi Taka
        rates.put("PKR", 278.0);     // Pakistani Rupee
        rates.put("LKR", 307.5);     // Sri Lankan Rupee
        rates.put("AFN", 73.0);      // Afghan Afghani
        rates.put("CNY", 7.28);      // Chinese Yuan
        rates.put("MMK", 2100.0);    // Myanmar Kyat
        rates.put("EUR", 0.93);      // Euro
        rates.put("GBP", 0.81);      // British Pound
        rates.put("JPY", 155.0);     // Japanese Yen

        // Let's greet the user and show them all the currencies we can handle.
        System.out.println("----------------------------------------");
        System.out.println("Hello! Welcome to the Currency Converter.");
        System.out.println("We can currently convert between these currencies:");
        System.out.println(rates.keySet()); // .keySet() gives us a nice list of all the currency codes.
        System.out.println("----------------------------------------");

        // First, we need to know what currency they're starting with.
        System.out.print("Please enter the 3-letter code for your starting currency (e.g., INR): ");
        // We read their input and use .toUpperCase() to make sure it matches our keys,
        // so the user doesn't have to worry about capitalization.
        String base = sc.next().toUpperCase();

        // Next, we ask for the currency they want to convert to.
        System.out.print("And what currency would you like to convert to? (e.g., USD): ");
        String target = sc.next().toUpperCase();

        // Now we ask for the amount they want to convert.
        System.out.print("Great! How much " + base + " would you like to convert? ");
        double amount = sc.nextDouble();

        // Here's the core logic. We first check if both currencies exist in our map.
        // This is important to prevent errors if the user types something wrong.
        if (rates.containsKey(base) && rates.containsKey(target)) {
            // Get the exchange rate for our starting currency.
            double baseRate = rates.get(base);
            // Get the exchange rate for our target currency.
            double targetRate = rates.get(target);

            // This is the clever part:
            // 1. We first convert our amount from the starting currency to USD.
            //    (For example, if we have 83.5 INR, dividing by the INR rate of 83.5 gives us 1 USD).
            double inUSD = amount / baseRate;
            
            // 2. Then, we convert that USD amount to our target currency.
            //    (For example, multiplying that 1 USD by the EUR rate of 0.93 gives us 0.93 EUR).
            double converted = inUSD * targetRate;

            // Finally, we give the user their result in a friendly, easy-to-read format.
            // The "%.2f" makes sure the numbers only have two decimal places, just like real money.
            System.out.printf("\nFantastic! %.2f %s is equal to %.2f %s.\n", amount, base, converted, target);
        } else {
            // If the user entered an unsupported currency, we tell them so.
            System.out.println("\nOops! It looks like one or both of the currency codes you entered aren't supported.");
            System.out.println("Please try again using one of these codes: " + rates.keySet());
        }

        // It's good practice to close the scanner when we're done with it to save resources.
        sc.close();
    }
}
