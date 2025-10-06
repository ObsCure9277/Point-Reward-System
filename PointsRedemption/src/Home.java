
import java.util.Scanner;

public class Home {

    private String homeChoice;
    private Scanner scanner;
    String keepUsingSystem = "Yes";

    public String getHomeChoice() {
        return homeChoice;
    }

    public void setHomeChoice(String homeChoice) {
        this.homeChoice = homeChoice;
    }

    public void serviceSelection() {
        scanner = new Scanner(System.in);

        do {

            System.out.println("\n\n     ==========================="
                    + "\n        Points Reward System"
                    + "\n     ===========================");

            System.out.println("--------------------------------------"
                    + "\n1. Points Earning"
                    + "\n2. Points Redemption"
                    + "\n3. Contact Management"
                    + "\n4. Reward Tier Management"
                    + "\n5. Customer Database"
                    + "\n6. Exit"
                    + "\n--------------------------------------"
            );

            // Prompt the staff to select a service
            System.out.print("\nPlease select a service (1/2/3/4/5/6): ");
            homeChoice = scanner.next();
            System.out.println("\n\n");

            if (!"1".equals(homeChoice) && !"2".equals(homeChoice) && !"3".equals(homeChoice) && !"4".equals(homeChoice) && !"5".equals(homeChoice) && !"6".equals(homeChoice)) {
                System.err.println("Invalid choice. Please select a valid service.");
            }

        } while (!"1".equals(homeChoice) && !"2".equals(homeChoice) && !"3".equals(homeChoice) && !"4".equals(homeChoice) && !"5".equals(homeChoice) && !"6".equals(homeChoice));

    }
}
