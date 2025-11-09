import java.util.Scanner;

public class MonthlyTemperatures {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        double[] temps = new double[12];
        double total = 0;

        for (int i = 0; i < months.length; i++) {
            System.out.print("Enter average temperature for " + months[i] + ": ");
            temps[i] = input.nextDouble();
            total += temps[i];
        }

        System.out.print("\nEnter 'year' to display all months or enter a month name: ");
        String choice = input.next();

        if (choice.equalsIgnoreCase("year")) {
            double highest = temps[0], lowest = temps[0];
            for (int i = 0; i < months.length; i++) {
                System.out.printf("%s: %.1f°F%n", months[i], temps[i]);
                if (temps[i] > highest) highest = temps[i];
                if (temps[i] < lowest) lowest = temps[i];
            }
            double average = total / temps.length;
            System.out.printf("Yearly average temperature: %.1f°F%n", average);
            System.out.printf("Highest temperature: %.1f°F%n", highest);
            System.out.printf("Lowest temperature: %.1f°F%n", lowest);
        } else {
            boolean found = false;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equalsIgnoreCase(choice)) {
                    System.out.printf("Average temperature for %s is %.1f°F%n", months[i], temps[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid month name entered.");
            }
        }
        input.close();
    }
}
