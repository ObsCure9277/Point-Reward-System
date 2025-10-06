
import java.util.Scanner;

public class Sorting extends Customer {

    private String[] sortedCustomerFollowInstagram;
    private String[] sortedCustomerPhoneNum;
    private String[] sortedCustomerName;
    private String[] sortedCustomerTier;
    private int[] sortedCustomerPoints;
    private int selection;
    private boolean correctSelection;

    public Sorting() {
    }

    public Sorting(String[] name, String[] tier, int[] points, String[] followInstagram, String[] phoneNum) {
        this.sortedCustomerName = name;
        this.sortedCustomerPhoneNum = phoneNum;
        this.sortedCustomerTier = tier;
        this.sortedCustomerPoints = points;
    }

    public String[] getSortedCustomerFollowInstagram() {
        return sortedCustomerFollowInstagram;
    }

    public String[] getSortedCustomerPhoneNum() {
        return sortedCustomerPhoneNum;
    }

    public String[] getSortedCustomerName() {
        return sortedCustomerName;
    }

    public String[] getSortedCustomerTier() {
        return sortedCustomerTier;
    }

    public int[] getSortedCustomerPoints() {
        return sortedCustomerPoints;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public boolean isCorrectSelection() {
        return correctSelection;
    }

    public void setCorrectSelection(boolean correctSelection) {
        this.correctSelection = correctSelection;
    }

    public void setSortedCustomerFollowInstagram(String[] sortedCustomerFollowInstagram) {
        this.sortedCustomerFollowInstagram = sortedCustomerFollowInstagram;
    }

    public void setSortedCustomerPhoneNum(String[] sortedCustomerPhoneNum) {
        this.sortedCustomerPhoneNum = sortedCustomerPhoneNum;
    }

    public void setSortedCustomerName(String[] sortedCustomerName) {
        this.sortedCustomerName = sortedCustomerName;
    }

    public void setSortedCustomerTier(String[] sortedCustomerTier) {
        this.sortedCustomerTier = sortedCustomerTier;
    }

    public void setSortedCustomerPoints(int[] sortedCustomerPoints) {
        this.sortedCustomerPoints = sortedCustomerPoints;
    }

    public void sortAscending(int[] points) {

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 0; j < points.length - i - 1; j++) {
                if (points[j] > points[j + 1]) {
                    // Swap points
                    int tempPoints = sortedCustomerPoints[j];
                    sortedCustomerPoints[j] = sortedCustomerPoints[j + 1];
                    sortedCustomerPoints[j + 1] = tempPoints;

                    // Swap names
                    String tempName = sortedCustomerName[j];
                    sortedCustomerName[j] = sortedCustomerName[j + 1];
                    sortedCustomerName[j + 1] = tempName;

                    // Swap ages
                    String tempFollowInstagram = sortedCustomerFollowInstagram[j];
                    sortedCustomerFollowInstagram[j] = sortedCustomerFollowInstagram[j + 1];
                    sortedCustomerFollowInstagram[j + 1] = tempFollowInstagram;

                    String tempPhoneNumber = sortedCustomerPhoneNum[j];
                    sortedCustomerPhoneNum[j] = sortedCustomerPhoneNum[j + 1];
                    sortedCustomerPhoneNum[j + 1] = tempPhoneNumber;

                    String tempTier = sortedCustomerTier[j];
                    sortedCustomerTier[j] = sortedCustomerTier[j + 1];
                    sortedCustomerTier[j + 1] = tempTier;
                }
            }
        }

    }

    public void chkSelection(int selection) {
        Scanner scan = new Scanner(System.in);
        do {
            if (getSelection() != 1 && getSelection() != 2) {
                setCorrectSelection(false);
                System.err.println("================================================="
                        + "\n\t  Error : Incorrect Selection, try again"
                        + "\n=================================================");
                do {
                    try {
                        System.out.print("Enter selection again:");
                        setSelection(scan.nextInt());
                        break;
                    } catch (Exception e) {
                        System.err.println("================================================="
                                + "\n\t  Error : Invalid input, try again"
                                + "\n=================================================");
                        scan.next();
                    }
                } while (true);
            } else {
                setCorrectSelection(true);
            }

        } while (isCorrectSelection() == false);

    }

    public void printUnsorted(String[] name, String[] tier, int[] points, String[] followInstagram, String[] phoneNum) {
        System.out.printf("%-10s %-10s %-20s %-15s %-10s%n", "Name", "Tier", "FollowInstagram", "Phone Number", "points");
        for (int i = 0; i < sortedCustomerName.length; i++) {
            System.out.printf("%-10s %-10s %-20s %-15s %-10d%n", name[i], tier[i], followInstagram[i], phoneNum[i], points[i]);
        }
    }

    public void printSorted() {
        System.out.printf("%-10s %-10s %-20s %-15s %-10s%n", "Name", "Tier", "FollowInstagram", "Phone Number", "points");
        for (int i = 0; i < sortedCustomerName.length; i++) {
            System.out.printf("%-10s %-10s %-20s %-15s %-10d%n", sortedCustomerName[i], sortedCustomerTier[i], sortedCustomerFollowInstagram[i], sortedCustomerPhoneNum[i], sortedCustomerPoints[i]);
        }
    }

    public static int compareTiers(String tier1, String tier2) {
        String[] tierOrder = {"normal", "bronze", "silver", "gold"};
        int index1 = getIndex(tier1, tierOrder);
        int index2 = getIndex(tier2, tierOrder);
        return Integer.compare(index1, index2);
    }

    public static int getIndex(String tier, String[] tierOrder) {
        for (int i = 0; i < tierOrder.length; i++) {
            if (tierOrder[i].equalsIgnoreCase(tier)) {
                return i;
            }
        }
        return -1; // Return -1 if tier not found (should not happen in this case)
    }

    public void sortTierAscending(String[] membershipTiers) {
        for (int i = 0; i < membershipTiers.length - 1; i++) {
            for (int j = 0; j < membershipTiers.length - i - 1; j++) {
                if (compareTiers(membershipTiers[j], membershipTiers[j + 1]) > 0) {
                    // Swap tiers
                    String tempTier = sortedCustomerTier[j];
                    sortedCustomerTier[j] = sortedCustomerTier[j + 1];
                    sortedCustomerTier[j + 1] = tempTier;

                    int tempPoints = sortedCustomerPoints[j];
                    sortedCustomerPoints[j] = sortedCustomerPoints[j + 1];
                    sortedCustomerPoints[j + 1] = tempPoints;

                    // Swap names
                    String tempName = sortedCustomerName[j];
                    sortedCustomerName[j] = sortedCustomerName[j + 1];
                    sortedCustomerName[j + 1] = tempName;

                    // Swap ages
                    String tempFollowInstagram = sortedCustomerFollowInstagram[j];
                    sortedCustomerFollowInstagram[j] = sortedCustomerFollowInstagram[j + 1];
                    sortedCustomerFollowInstagram[j + 1] = tempFollowInstagram;

                    String tempPhoneNumber = sortedCustomerPhoneNum[j];
                    sortedCustomerPhoneNum[j] = sortedCustomerPhoneNum[j + 1];
                    sortedCustomerPhoneNum[j + 1] = tempPhoneNumber;
                }
            }
        }
    }

}
