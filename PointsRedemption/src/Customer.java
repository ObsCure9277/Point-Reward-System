
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Customer {

    Scanner scanner = new Scanner(System.in);

    private static int indexOfCustomer;
    private static boolean validInputNumber = false;
    private boolean customerNameExist;
    private String[] customerName;
    private String[] customerTier;
    int[] customerPoints;
    private String[] customerFollowInstagram;
    private String[] customerPhoneNum;
    private String tempCustomerName;

    public Customer() {
    }

    public Customer(String[] customerName, String[] customerTier, int[] customerPoints, String[] customerFollowInstagram, String[] customerPhoneNum) {
        this.customerName = customerName;
        this.customerTier = customerTier;
        this.customerPoints = customerPoints;
        this.customerFollowInstagram = customerFollowInstagram;
        this.customerPhoneNum = customerPhoneNum;
    }

    public static int getIndexOfCustomer() {
        return indexOfCustomer;
    }

    public static void setIndexOfCustomer(int indexOfCustomer) {
        Customer.indexOfCustomer = indexOfCustomer;
    }

    public boolean isCustomerNameExist() {
        return customerNameExist;
    }

    public void setCustomerNameExist(boolean customerNameExist) {
        this.customerNameExist = customerNameExist;
    }

    public String[] getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String[] customerName) {
        this.customerName = customerName;
    }

    public String[] getCustomerTier() {
        return customerTier;
    }

    public void setCustomerTier(String[] customerTier) {
        this.customerTier = customerTier;
    }

    public int[] getCustomerPoints() {
        return customerPoints;
    }

    public void setCustomerPoints(int[] customerPoints) {
        this.customerPoints = customerPoints;
    }

    public String[] getCustomerFollowInstagram() {
        return customerFollowInstagram;
    }

    public void setCustomerFollowInstagram(String[] customerFollowInstagram) {
        this.customerFollowInstagram = customerFollowInstagram;
    }

    public String[] getCustomerPhoneNum() {
        return customerPhoneNum;
    }

    public void setCustomerPhoneNum(String[] customerPhoneNum) {
        this.customerPhoneNum = customerPhoneNum;
    }

    public String getTempCustomerName() {
        return tempCustomerName;
    }

    public void setTempCustomerName(String tempCustomerName) {
        this.tempCustomerName = tempCustomerName;
    }

    public static boolean isValidInputNumber() {
        return validInputNumber;
    }

    public static void setValidInputNumber(boolean validInputNumber) {
        Customer.validInputNumber = validInputNumber;
    }

    public void chkCustomerName(String tempCustomerName, String[] cusName) {
        setCustomerNameExist(false);
        for (int i = 0; i < cusName.length; i++) {
            if (tempCustomerName.equals(cusName[i])) {
                setIndexOfCustomer(i);
                setCustomerNameExist(true);
                break;
            }
        }

        if (!isCustomerNameExist()) {
            System.err.println("================================================="
                    + "\n\t  Error : Customer Name Not Found"
                    + "\n=================================================");
        }
    }

    @Override
    public String toString() {
        return "Customer{" + "scanner=" + scanner + ", customerNameExist=" + customerNameExist + ", customerName=" + customerName + ", customerTier=" + customerTier + ", customerPoints=" + customerPoints + ", customerFollowInstagram=" + customerFollowInstagram + ", customerPhoneNum=" + customerPhoneNum + ", tempCustomerName=" + tempCustomerName + '}';
    }

}
