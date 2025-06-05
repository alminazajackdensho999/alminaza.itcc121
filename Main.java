import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Services map: service number → [name, price]
        Map<Integer, String> serviceNames = Map.of(
                1, "Swedish Massage",
                2, "Shiatsu Massage",
                3, "Hot Stone Massage",
                4, "Foot Massage",
                5, "Facial"
        );
        Map<Integer, Integer> servicePrices = Map.of(
                1, 500,
                2, 600,
                3, 800,
                4, 300,
                5, 400
        );

        List<Integer> selected = new ArrayList<>();

        while (true) {
            // Display services
            System.out.println("\nServices:");
            for (int i = 1; i <= 5; i++) {
                System.out.printf("%d. %s - PHP %d\n", i, serviceNames.get(i), servicePrices.get(i));
            }

            // Show menu
            System.out.println("\nOptions:\n1. Add service\n2. Remove service\n3. Checkout\n4. Cancel");
            System.out.print("Choose an option (1-4): ");
            String action = input.nextLine();

            if (action.equals("1")) {
                System.out.print("Enter service number to add: ");
                int choice = Integer.parseInt(input.nextLine());
                if (serviceNames.containsKey(choice)) {
                    selected.add(choice);
                    System.out.println("Added " + serviceNames.get(choice));
                } else {
                    System.out.println("Invalid service number.");
                }

            } else if (action.equals("2")) {
                System.out.print("Enter service number to remove: ");
                int choice = Integer.parseInt(input.nextLine());
                if (selected.contains(choice)) {
                    selected.remove(Integer.valueOf(choice));
                    System.out.println("Removed " + serviceNames.get(choice));
                } else {
                    System.out.println("Service not in selection.");
                }

            } else if (action.equals("3")) {
                if (selected.isEmpty()) {
                    System.out.println("No services selected.");
                    continue;
                }

                // Print selected services
                double total = 0;
                System.out.println("\nSelected Services:");
                for (int i : selected) {
                    System.out.printf("- %s: PHP %d\n", serviceNames.get(i), servicePrices.get(i));
                    total += servicePrices.get(i);
                }

                // Ask for discount
                while (true) {
                    System.out.println("\nAre you:\n1. Senior (20% discount)\n2. Student (10% discount)\n3. None\n4. Cancel transaction");
                    System.out.print("Choose an option (1-4): ");
                    String discount = input.nextLine();

                    if (discount.equals("1")) {
                        total *= 0.8;
                        break;
                    } else if (discount.equals("2")) {
                        total *= 0.9;
                        break;
                    } else if (discount.equals("3")) {
                        break;
                    } else if (discount.equals("4")) {
                        System.out.println("Transaction cancelled.");
                        return;
                    } else {
                        System.out.println("Invalid option.");
                    }
                }

                System.out.printf("\n**** Client's Bill Summary ****\n\n\nTotal after discount: PHP %.2f\n", total);
                System.out.println("\n\nCome again!\nThank you!");
                break;

            } else if (action.equals("4")) {
                System.out.println("Transaction cancelled.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}
