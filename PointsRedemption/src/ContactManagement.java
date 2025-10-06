
public class ContactManagement extends Customer implements ChkName{

    private String newPhoneNumber;
    private String serviceSelection;
    private int numberOfModification;
    private static boolean modificationNumber = true;

    public ContactManagement() {

    }

    public ContactManagement(String[] customerName, String[] customerTier, int[] customerPoints, String[] customerFollowInstagram, String[] customerPhoneNum) {
        super(customerName, customerTier, customerPoints, customerFollowInstagram, customerPhoneNum);
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public void setNewPhoneNumber(String newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }

    public String getServiceSelection() {
        return serviceSelection;
    }

    public void setServiceSelection(String serviceSelection) {
        this.serviceSelection = serviceSelection;
    }

    public int getNumberOfModification() {
        return numberOfModification;
    }

    public void setNumberOfModification(int numberOfModification) {
        this.numberOfModification = numberOfModification;
    }

    public static boolean isModificationNumber() {
        return modificationNumber;
    }

    public static void setModificationNumber(boolean modificationNumber) {
        ContactManagement.modificationNumber = modificationNumber;
    }

    public void printCustomerInformation() {
        System.out.println("Tier\t\t\t\t: " + getCustomerTier()[getIndexOfCustomer()]
                + "\nCustomer Total Points\t\t: " + getCustomerPoints()[getIndexOfCustomer()]
                + "\nCustomer Following Instagram\t: " + getCustomerFollowInstagram()[getIndexOfCustomer()]
                + "\nCustomer Phone Number\t\t: " + getCustomerPhoneNum()[getIndexOfCustomer()]);
    }

    public void modificationList() {
        System.out.println("\n---------------Modification---------------"
                + "\n1. Add new customer"
                + "\n2. Change customer name"
                + "\n3. Change customer phone number"
                + "\n4. Exit"
                + "\n------------------------------------------\n"
        );
    }

    public void chkNameExist() {
        for (int i = 0; i < getCustomerName().length; i++) {
            if (getTempCustomerName().equals(getCustomerName()[i])) {
                System.err.println("================================================="
                        + "\n     Error : Name already exist in the file"
                        + "\n=================================================");
                setCustomerNameExist(false);
            }
        }
    }
    
    @Override
    public void chkSymbolsOrNumbersExist() {
        if(getTempCustomerName().matches("^[a-zA-z]+$")) {
            setCustomerNameExist(true);
        }else {
            System.err.println("================================================="
                        + "\n   Error : Name cannot have symbol or numbers"
                        + "\n=================================================");
            setCustomerNameExist(false);
        }
    }

    @Override
    public String toString() {
        return "ContactManagement{" + "newPhoneNumber=" + newPhoneNumber + ", serviceSelection=" + serviceSelection + ", numberOfModification=" + numberOfModification + '}';
    }

}
