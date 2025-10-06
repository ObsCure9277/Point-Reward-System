
public abstract class Staff {

    private static int indexOfStaff = 0;
    private boolean staffNameExist = false;
    private String[] staffName;
    private String[] staffPassword;
    private boolean correctPassword = true;

    public Staff() {
    }

    public Staff(String[] staffName, String[] staffPassword) {
        this.staffName = staffName;
        this.staffPassword = staffPassword;
    }

    public static int getIndexOfStaff() {
        return indexOfStaff;
    }

    public static void setIndexOfStaff(int indexOfStaff) {
        Staff.indexOfStaff = indexOfStaff;
    }

    public boolean isCorrectPassword() {
        return correctPassword;
    }

    public void setCorrectPassword(boolean correctPassword) {
        this.correctPassword = correctPassword;
    }

    public boolean isStaffNameExist() {
        return staffNameExist;
    }

    public void setStaffNameExist(boolean staffNameExist) {
        this.staffNameExist = staffNameExist;
    }

    public String[] getStaffName() {
        return staffName;
    }

    public void setStaffName(String[] staffName) {
        this.staffName = staffName;
    }

    public String[] getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String[] staffPassword) {
        this.staffPassword = staffPassword;
    }

    public void chkStaffName(String tempStaffName, String[] staffName) {
        setIndexOfStaff(-1);
        for (int i = 0; i < staffName.length; i++) {
            if (tempStaffName.equals(staffName[i])) {
                setIndexOfStaff(i);
                setStaffNameExist(true);
                break;
            }
        }

        if (!isStaffNameExist()) {
            System.err.println("-------------------------------------------------"
                    + "\n\t  Error : Staff Username Not Found"
                    + "\n-------------------------------------------------");
        }
    }

    public void chkNewName(String tempStaffName, String[] staffName) {
        setIndexOfStaff(-1);
        for (int i = 0; i < staffName.length; i++) {
            if (tempStaffName.equals(staffName[i])) {
                staffNameExist = true;
                break;
            } else {
                staffNameExist = false;
            }
        }

        if (staffNameExist) {
            System.err.println("-------------------------------------------------"
                    + "\n\t  Error : Staff Username Taken"
                    + "\n-------------------------------------------------");
        }
    }

    public void chkStaffPassowrd(String tempStaffPassword, String[] password) {
        if (password[getIndexOfStaff()].equals(tempStaffPassword)) {
            System.out.print("log in successful");
            setCorrectPassword(true);
        } else {
            setCorrectPassword(false);
            System.err.println("-------------------------------------------------"
                    + "\n\t  Error : invalid password, try again "
                    + "\n-------------------------------------------------");
        }
    }

    @Override
    public String toString() {
        return "Staff{"
                + "\ncustomerName=" + staffName
                + "\n customerTier=" + staffPassword
                + '}';
    }
}
