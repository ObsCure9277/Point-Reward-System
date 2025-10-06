
import java.util.Scanner;

public class PointsEarning extends Customer implements Points {

    private String tempName;
    private char earningMethod;
    private double purchaseAmount;
    private int pointsEarned;
    private int index;

    public PointsEarning(String[] customerName, String[] customerTier, int[] customerPoints, String[] customerFollowInstagram, String[] customerPhoneNum) {
        super(customerName, customerTier, customerPoints, customerFollowInstagram, customerPhoneNum);

    }

    public PointsEarning(String tempName) {
        this.tempName = tempName;
    }

    public char getEarningMethod() {
        return earningMethod;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public int getIndex() {
        return index;
    }

    public void setTempName(String TempName) {
        this.tempName = TempName;
    }

    public String getTempName() {
        return tempName;
    }

    public void setEarningMethod(char earningMethod) {
        this.earningMethod = earningMethod;
        if (this.earningMethod != 'p' && this.earningMethod != 'P' && this.earningMethod != 'i' && this.earningMethod != 'I') {
            System.err.println("-------------------------------------------------"
                    + "\n\t  Error : Earning method invalid"
                    + "\n-------------------------------------------------");

        }
    }

    public void setPurhcaseamount(double purchaseAmount) {

        this.purchaseAmount = purchaseAmount;
    }

    public void setCustomerPoints(int pointsEarned) {
        getCustomerPoints()[getIndexOfCustomer()] += pointsEarned;

    }

    @Override
    public int calculatePoints() {

        if (earningMethod == 'i' || earningMethod == 'I') {
            if (this.getCustomerFollowInstagram()[getIndexOfCustomer()].equals("Yes")) {
                System.err.println("-------------------------------------------------"
                        + "\n\t  Error : You can only follow once "
                        + "\n-------------------------------------------------");
                this.pointsEarned = 0;
            } else {
                this.pointsEarned = 5;
            }

        } else if (earningMethod == 'p' || earningMethod == 'P') {
            Scanner scan = new Scanner(System.in);
            do {
                System.out.print("enter purchase amount: ");
                if (scan.hasNextDouble()) {
                    this.purchaseAmount = scan.nextDouble();
                    break;
                } else {
                    System.err.println("-------------------------------------------------"
                            + "\n\t  Error : Purchase amount invalid"
                            + "\n\t  Please try again"
                            + "\n-------------------------------------------------");
                    scan.next();
                }
            } while (true);
            if (getCustomerTier()[getIndexOfCustomer()].equals("gold")) {
                this.pointsEarned = (int) Math.round(purchaseAmount) * 4;
            } else if (getCustomerTier()[getIndexOfCustomer()].equals("silver")) {
                this.pointsEarned = (int) Math.round(purchaseAmount) * 3;
            } else if (getCustomerTier()[getIndexOfCustomer()].equals("bronze")) {
                this.pointsEarned = (int) Math.round(purchaseAmount) * 2;
            } else {
                this.pointsEarned = (int) Math.round(purchaseAmount);
            }

        } else {
            System.err.print("Please try again pick valid earning method");

        }

        return pointsEarned;

    }

    @Override
    public String toString() {
        return "PointsEarning{" + "tempName=" + tempName + ", earningMethod=" + earningMethod + ", purchaseAmount=" + purchaseAmount + ", pointsEarned=" + pointsEarned + ", index=" + index + '}';
    }

}
