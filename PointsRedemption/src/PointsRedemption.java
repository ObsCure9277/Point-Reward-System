
public class PointsRedemption extends Customer implements Points{

    private static String redeemItem;
    private int[] productForRedemption = {900, 600, 250};
    private int[] discountForRedemption = {400, 300, 200};
    private int tempPointsDeduct;
    private int numberOfItem;
    private String notEnoughPointsSelection;

    public PointsRedemption(String[] customerName, String[] customerTier, int[] customerPoints, String[] customerFollowInstagram, String[] customerPhoneNum) {
        super(customerName, customerTier, customerPoints, customerFollowInstagram, customerPhoneNum);

    }
    
    public int[] getProductForRedemption() {
        return productForRedemption;
    }

    public int[] getDiscountForRedemption() {
        return discountForRedemption;
    }

    public static String getRedeemItem() {
        return redeemItem;
    }

    public static void setRedeemItem(String redeemItem) {
        PointsRedemption.redeemItem = redeemItem;
    }

    public int getTempPointsDeduct() {
        return tempPointsDeduct;
    }

    public void setTempPointsDeduct(int tempPointsDeduct) {
        this.tempPointsDeduct = tempPointsDeduct;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public String getNotEnoughPointsSelection() {
        return notEnoughPointsSelection;
    }

    public void setNotEnoughPointsSelection(String notEnoughPointsSelection) {
        this.notEnoughPointsSelection = notEnoughPointsSelection;
    } 
    

    public void redeemMenu() {
        System.out.println("---------------Product---------------"
                + String.format("\n%-15s %d%s", "1. Burger", productForRedemption[0], "pts")
                + String.format("\n%-15s %d%s", "2. McFlurry", productForRedemption[1], "pts")
                + String.format("\n%-15s %d%s", "3. French Fries", productForRedemption[2], "pts")
                + "\n--------------------------------------"
                + "\n\n---------------Discount---------------"
                + String.format("\n%-15s %d%s", "1. 30% Discount", discountForRedemption[0], "pts")
                + String.format("\n%-15s %d%s", "2. 20% Discount", discountForRedemption[1], "pts")
                + String.format("\n%-15s %d%s", "3. 10% Discount", discountForRedemption[2], "pts")
                + "\n--------------------------------------"
        );
    }

    public void selectRedeemItem() {
        redeemItem = "";
        System.out.println("\nFree Product = F, Discount = D");
        do {
            System.out.print("Redeem(F/D)\t\t: ");
            redeemItem = scanner.nextLine().toUpperCase();
            if (!(redeemItem.equals("F") || redeemItem.equals("D"))) {
                System.err.println("==============================================="
                        + "\n\tError : input invalid (input F or D)"
                        + "\n===============================================");
            }
        } while (!(redeemItem.equals("F") || redeemItem.equals("D")));
    }

    public int chkPointsDeduct(String redeemItem, int numberOfItem) {

        switch (redeemItem.toUpperCase()) {
            case "F":
                return getProductForRedemption()[numberOfItem - 1];
            case "D":
                return getDiscountForRedemption()[numberOfItem - 1];
            default:
                System.err.println("==============================================="
                        + "\n\t  Error : input invalid"
                        + "\n===============================================");
                return 0;
        }
    }
    
    public void setCustomerPointsAt(int index, int cusPoints) {
        if (index >= 0 && index < getCustomerPoints().length) {
            customerPoints[index] = cusPoints;
        } else {
            System.out.println("Index out of bounds");
        }
            
    }
    
    @Override
    public int calculatePoints() {
        return getCustomerPoints()[getIndexOfCustomer()] - getTempPointsDeduct();
    }

    @Override
    public String toString() {
        return "PointsRedemption{" + "productForRedemption=" + productForRedemption + ", discountForRedemption=" + discountForRedemption + ", tempPointsDeduct=" + tempPointsDeduct + ", numberOfItem=" + numberOfItem + '}';
    }

    

    

}
