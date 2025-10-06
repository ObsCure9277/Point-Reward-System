import java.util.Scanner;

public class RewardTierManagement extends Customer implements Points {

    private String currentTier;
    private String choice;
    private String tierChoice;
    private String yesNo;
    private String updateChoice;
    private String inputName;
    private int currentPoints;
    private int[] tierPoint = {250, 500, 1000};

    public RewardTierManagement(String[] customerName, String[] customerTier, int[] customerPoints, String[] customerFollowInstagram, String[] customerPhoneNum) {
        super(customerName, customerTier, customerPoints, customerFollowInstagram, customerPhoneNum);
    }

    public String getCurrentTier() {
        return currentTier;
    }

    public void setCurrentTier(String currentTier) {
        this.currentTier = currentTier;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getTierChoice() {
        return tierChoice;
    }

    public void setTierChoice(String tierChoice) {
        this.tierChoice = tierChoice;
    }

    public String getYesNo() {
        return yesNo;
    }

    public void setYesNo(String yesNo) {
        this.yesNo = yesNo;
    }

    public String getUpdateChoice() {
        return updateChoice;
    }

    public void setUpdateChoice(String updateChoice) {
        this.updateChoice = updateChoice;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public void promptTierChoice() {
        int customerPoints = getCustomerPoints()[getIndexOfCustomer()];
        Scanner scan = new Scanner(System.in);

        System.out.println("");
        System.out.println("Customer tier: " + getCustomerTier()[getIndexOfCustomer()]);
        System.out.println("Customer points: " + getCustomerPoints()[getIndexOfCustomer()]);

        do {
            System.out.print("What tier you want to upgrade (bronze/silver/gold)? :");
            setUpdateChoice(scan.nextLine().toLowerCase());

            if (!"bronze".equals(getUpdateChoice()) && !"silver".equals(getUpdateChoice()) && !"gold".equals(getUpdateChoice())) {
                System.err.println("""
                                   ===============================================
                                   \t  Error : input invalid
                                   ===============================================""");
            }
        } while (!"bronze".equals(getUpdateChoice()) && !"silver".equals(getUpdateChoice()) && !"gold".equals(getUpdateChoice()));

        if (!getCustomerTier()[getIndexOfCustomer()].equals("")) {
            currentTier = getCustomerTier()[getIndexOfCustomer()];
            choice = getUpdateChoice();

            switch (currentTier) {
                case "gold" -> {
                    if (choice.equals("gold")) {
                        System.err.println("=============================================================");
                        System.err.println("\tYou are already at the highest tier.");
                        System.err.println("=============================================================");
                    }
                }
                case "silver" -> {
                    if (choice.equals("silver")) {
                        System.err.println("=============================================================");
                        System.err.println("\tInvalid choice. You cannot select " + getUpdateChoice() + ".");
                        System.err.println("=============================================================");
                    }
                }
                case "bronze" -> {
                    if (choice.equals("bronze")) {
                        System.err.println("=============================================================");
                        System.err.println("\tInvalid choice. You cannot select " + getUpdateChoice() + ".");
                        System.err.println("=============================================================");
                    } 
                }
                default -> {
                    if (choice.equals("normal")) {
                        System.out.println("What tier you want to upgrade(bronze/silver/gold)?");
                    }
                }
            }
        }
    }

    @Override
    public int calculatePoints() {
        int pointsRequired = getPointsRequired();
        currentPoints = getCustomerPoints()[getIndexOfCustomer()];

        if (!currentTier.equals(choice)) {
            if ((currentTier.equals("silver") && choice.equals("bronze"))) {
                System.err.println("=============================================================");
                System.err.println("\tInvalid choice. You cannot select " + choice + ".");
                System.err.println("=============================================================");
            } else if ((currentTier.equals("gold") && choice.equals("silver"))) {
                System.err.println("=============================================================");
                System.err.println("\tInvalid choice. You cannot select " + choice + ".");
                System.err.println("=============================================================");
            } else if ((currentTier.equals("gold") && choice.equals("bronze"))) {
                System.err.println("=============================================================");
                System.err.println("\tInvalid choice. You cannot select " + choice + ".");
                System.err.println("=============================================================");
            } else if ((currentTier.equals("silver") && choice.equals("gold"))) {
                if (currentPoints >= pointsRequired) {
                    currentPoints -= pointsRequired;
                    System.out.println("=============================================================");
                    System.out.println("Successfully upgraded to " + getUpdateChoice() + " tier.");
                    System.out.println("Remaining points: " + currentPoints);
                    System.out.println("=============================================================");
                } else {
                    System.err.println("=============================================================");
                    System.err.println("\tInsufficient points to upgrade to " + getUpdateChoice() + " tier.");
                    System.err.println("=============================================================");
                    System.out.println("Points required: " + pointsRequired);
                    System.out.println("Current points: " + currentPoints);
                }
            } else if ((currentTier.equals("bronze") && choice.equals("silver"))) {
                if (currentPoints >= pointsRequired) {
                    currentPoints -= pointsRequired;
                    System.out.println("=============================================================");
                    System.out.println("Successfully upgraded to " + getUpdateChoice() + " tier.");
                    System.out.println("Remaining points: " + currentPoints);
                    System.out.println("=============================================================");
                } else {
                    System.err.println("=============================================================");
                    System.err.println("\tInsufficient points to upgrade to " + getUpdateChoice() + " tier.");
                    System.err.println("=============================================================");
                    System.out.println("Points required: " + pointsRequired);
                    System.out.println("Current points: " + currentPoints);
                }
            } else if ((currentTier.equals("bronze") && choice.equals("gold"))) {
                if (currentPoints >= pointsRequired) {
                    currentPoints -= pointsRequired;
                    System.out.println("=============================================================");
                    System.out.println("Successfully upgraded to " + getUpdateChoice() + " tier.");
                    System.out.println("Remaining points: " + currentPoints);
                    System.out.println("=============================================================");
                } else {
                    System.err.println("=============================================================");
                    System.err.println("\tInsufficient points to upgrade to " + getUpdateChoice() + " tier.");
                    System.err.println("=============================================================");
                    System.out.println("Points required: " + pointsRequired);
                    System.out.println("Current points: " + currentPoints);
                }
            } else if ((currentTier.equals("normal") && choice.equals("gold"))) {
                if (currentPoints >= pointsRequired) {
                    currentPoints -= pointsRequired;
                    System.out.println("=============================================================");
                    System.out.println("Successfully upgraded to " + getUpdateChoice() + " tier.");
                    System.out.println("Remaining points: " + currentPoints);
                    System.out.println("=============================================================");
                } else {
                    System.err.println("=============================================================");
                    System.err.println("\tInsufficient points to upgrade to " + getUpdateChoice() + " tier.");
                    System.err.println("=============================================================");
                    System.out.println("Points required: " + pointsRequired);
                    System.out.println("Current points: " + currentPoints);
                    
                }
            } else if ((currentTier.equals("normal") && choice.equals("silver"))) {
                if (currentPoints >= pointsRequired) {
                    currentPoints -= pointsRequired;
                    System.out.println("=============================================================");
                    System.out.println("Successfully upgraded to " + getUpdateChoice() + " tier.");
                    System.out.println("Remaining points: " + currentPoints);
                    System.out.println("=============================================================");
                } else {
                    System.err.println("=============================================================");
                    System.err.println("Insufficient points to upgrade to " + getUpdateChoice() + " tier.");
                    System.err.println("=============================================================");
                    System.out.println("Points required: " + pointsRequired);
                    System.out.println("Current points: " + currentPoints);
                }
            } else {
                if (currentPoints >= pointsRequired) {
                    currentPoints -= pointsRequired;
                    System.out.println("=============================================================");
                    System.out.println("Successfully upgraded to " + getUpdateChoice() + " tier.");
                    System.out.println("Remaining points: " + currentPoints);
                    System.out.println("=============================================================");
                } else {
                    System.err.println("=============================================================");
                    System.err.println("Insufficient points to upgrade to " + getUpdateChoice() + " tier.");
                    System.err.println("=============================================================");
                    System.out.println("Points required: " + pointsRequired);
                    System.out.println("Current points: " + currentPoints);
                }
            }
        }
        return currentPoints;
    }

    public int getPointsRequired() {
        return switch (getUpdateChoice()) {
            case "bronze" ->
                250;
            case "silver" ->
                500;
            case "gold" ->
                1000;
            default ->
                0;
        };
    }

    public void tierMenu() {
        System.out.print(String.format("\n%-15s %d%s", "   1. Bronze", tierPoint[0], "pts")
                + String.format("\n%-15s %d%s", "   2. Silver", tierPoint[1], "pts")
                + String.format("\n%-15s %d%s", "   3. Gold", tierPoint[2], "pts")
                + "\n================================"
        );
    }
}