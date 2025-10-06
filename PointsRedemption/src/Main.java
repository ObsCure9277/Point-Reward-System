
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePath = "customerFile.txt";
        customerFileIO customerReader = new customerFileIO(filePath);

        Home home = new Home();

        RewardTierManagement getTier = new RewardTierManagement(customerReader.getCustomerName(), customerReader.getCustomerTier(), customerReader.getCustomerPoints(), customerReader.getCustomerFollowInstagram(), customerReader.getCustomerPhoneNum());

        PointsEarning pointsEarning = new PointsEarning(customerReader.getCustomerName(), customerReader.getCustomerTier(), customerReader.getCustomerPoints(), customerReader.getCustomerFollowInstagram(), customerReader.getCustomerPhoneNum());

        PointsRedemption pointsRedemption = new PointsRedemption(customerReader.getCustomerName(), customerReader.getCustomerTier(), customerReader.getCustomerPoints(), customerReader.getCustomerFollowInstagram(), customerReader.getCustomerPhoneNum());

        ContactManagement contactManagement = new ContactManagement(
                customerReader.getCustomerName(),
                customerReader.getCustomerTier(),
                customerReader.getCustomerPoints(),
                customerReader.getCustomerFollowInstagram(),
                customerReader.getCustomerPhoneNum()
        );

        Sorting sorting = new Sorting();

        //CHEAH SENG YIK (Staff Log In and Sign Up)
        StaffFile staffReader = new StaffFile("staff.txt");
        User user1 = new User(staffReader.getStaffName(), staffReader.getStaffPassword());

        System.out.println("==========================="
                + "\n       Staff Log In"
                + "\n===========================");

        do {
            do {
                try {
                    System.out.println("----------------------------"
                            + "\n1. Sign Up"
                            + "\n2. Sign In"
                            + "\n----------------------------"
                    );
                    System.out.print("Selection : ");
                    user1.setSelection(scanner.nextInt());
                    break;
                } catch (Exception e) {
                    System.err.println("================================================="
                            + "\n\t  Error : Please enter an integer"
                            + "\n=================================================");
                    scanner.next();
                }
            } while (true);
            user1.chkSelection(user1.getSelection());
            if (user1.getSelection() == 1) {
                do {
                    do {
                        System.out.print("Create a new staff name: ");
                        user1.setNewName(scanner.next().toLowerCase());
                        user1.chkNewName(user1.getNewName(), user1.getStaffName());
                    } while (user1.isStaffNameExist() == true);
                    user1.chkSymbolsOrNumbersExist();
                } while (user1.isStaffNameExist() == true);
                System.out.print("Create a new password: ");
                user1.setNewPassword(scanner.next());
                System.out.println("================================================="
                        + "\n\t  Sign Up Successful"
                        + "\n=================================================");
                staffReader.addNewStaff("staff.txt", user1.getNewName(), user1.getNewPassword());
                staffReader.readStaffData("staff.txt");
                user1.setStaffName(staffReader.getStaffName());
                user1.setStaffPassword(staffReader.getStaffPassword());
                user1.chkBackToMain();
            } else if (user1.getSelection() == 2) {
                do {
                    System.out.print("Enter staff name: ");
                    user1.setName(scanner.next().toLowerCase());
                    user1.chkStaffName(user1.getName(), user1.getStaffName());
                } while (user1.isStaffNameExist() == false);
                do {
                    System.out.print("Enter your password: ");
                    user1.chkStaffPassowrd(scanner.next(), user1.getStaffPassword());
                } while (user1.isCorrectPassword() == false);
                user1.setBackToMain("n");
            }

        } while (user1.isBackToMain().equals("y"));

        do {
            //NG SHEN ZHI (Home page)

            home.serviceSelection();

            switch (home.getHomeChoice()) {

                case "1":   //CHEAH SENG YIK (Points Earning)

                    System.out.print("========================"
                            + "\n      Earn Points"
                            + "\n========================");
                    do {
                        System.out.print("\nenter customer name: ");
                        pointsEarning.setTempName(scanner.next().toLowerCase());
                        pointsEarning.chkCustomerName(pointsEarning.getTempName(), customerReader.getCustomerName());
                    } while (pointsEarning.isCustomerNameExist() == false);
                    do {
                        System.out.print("=================================="
                                + "\nChoose customer points earning method\n"
                                + "=================================="
                                + "\nInput I for instagram method\n"
                                + "Input P for purchase amount method\n"
                                + "Selection:");
                        pointsEarning.setEarningMethod(scanner.next().charAt(0));
                    } while (pointsEarning.getEarningMethod() != 'i' && pointsEarning.getEarningMethod() != 'I' && pointsEarning.getEarningMethod() != 'p' && pointsEarning.getEarningMethod() != 'P');

                    pointsEarning.setCustomerPoints(customerReader.getCustomerPoints());
                    pointsEarning.setCustomerTier(customerReader.getCustomerTier());
                    pointsEarning.setCustomerName(customerReader.getCustomerName());
                    pointsEarning.setCustomerFollowInstagram(customerReader.getCustomerFollowInstagram());
                    pointsEarning.setCustomerPhoneNum(customerReader.getCustomerPhoneNum());

                    System.out.println("Initial total points: " + pointsEarning.getCustomerPoints()[pointsEarning.getIndexOfCustomer()]);
                    pointsEarning.setCustomerPoints(pointsEarning.calculatePoints());
                    System.out.println("points earned : " + pointsEarning.getPointsEarned());
                    System.out.println("New total points : " + pointsEarning.getCustomerPoints()[pointsEarning.getIndexOfCustomer()]);
                    customerReader.setCustomerFollowInstagram(pointsEarning.getCustomerFollowInstagram());
                    customerReader.updateCustomerPoints(filePath, customerReader.getCustomerPoints()[pointsEarning.getIndexOfCustomer()]);
                    break;

                case "2":   //LOO JIE QI (Points Redemption)

                    System.out.println("==========================="
                            + "\n     Points Redemption"
                            + "\n===========================");

                    pointsRedemption.redeemMenu();

                    do {
                        System.out.print("\nCustomer Name\t\t: ");
                        pointsRedemption.setTempCustomerName(scanner.next().toLowerCase());

                        pointsRedemption.chkCustomerName(pointsRedemption.getTempCustomerName(), customerReader.getCustomerName());

                    } while (!pointsRedemption.isCustomerNameExist());

                    System.out.println("Customer Total Points\t: " + customerReader.getCustomerPoints()[pointsRedemption.getIndexOfCustomer()]);
                    System.out.println("Tier\t\t\t: " + customerReader.getCustomerTier()[pointsRedemption.getIndexOfCustomer()]);

                    pointsRedemption.selectRedeemItem();

                    do {
                        do {
                            do {
                                try {

                                    pointsRedemption.setNotEnoughPointsSelection("N");
                                    do {
                                        System.out.print("Number\t\t\t: ");
                                        pointsRedemption.setNumberOfItem(scanner.nextInt());

                                        if (pointsRedemption.getNumberOfItem() <= 0 || pointsRedemption.getNumberOfItem() > 3) {
                                            pointsRedemption.setValidInputNumber(false);
                                            System.err.println("================================================="
                                                    + "\nError : input invalid (input have to be 1/2/3)"
                                                    + "\n=================================================");
                                        } else {
                                            pointsRedemption.setValidInputNumber(true);
                                        }
                                    } while (!pointsRedemption.isValidInputNumber());
                                    pointsRedemption.setTempPointsDeduct(pointsRedemption.chkPointsDeduct(pointsRedemption.getRedeemItem(), pointsRedemption.getNumberOfItem()));
                                } catch (InputMismatchException ex) {
                                    pointsRedemption.setValidInputNumber(false);
                                    System.err.println("================================================="
                                            + "\nError : input invalid (input have to be integer)"
                                            + "\n=================================================");
                                    scanner.next();
                                }

                            } while (!pointsRedemption.isValidInputNumber());

                            if (pointsRedemption.getTempPointsDeduct() > customerReader.getCustomerPoints()[pointsRedemption.getIndexOfCustomer()]) {
                                pointsRedemption.setValidInputNumber(false);
                                System.err.println("================================================="
                                        + "\n    Error : Points not enough, choose again"
                                        + "\n=================================================");
                            }

                            if (!pointsRedemption.isValidInputNumber()) {
                                do {
                                    System.out.print("\nDo you want to choose again (Y\\N) : ");
                                    pointsRedemption.setNotEnoughPointsSelection(scanner.next().toUpperCase());

                                    if (!pointsRedemption.getNotEnoughPointsSelection().equals("Y") && !pointsRedemption.getNotEnoughPointsSelection().equals("N")) {
                                        System.err.println("================================================="
                                                + "\n  Error : input invalid (input have to be Y or N)"
                                                + "\n=================================================");
                                    }

                                } while (!pointsRedemption.getNotEnoughPointsSelection().equals("Y") && !pointsRedemption.getNotEnoughPointsSelection().equals("N"));

                                if (pointsRedemption.getNotEnoughPointsSelection().equals("N")) {
                                    pointsRedemption.setValidInputNumber(true);
                                }
                            } else {
                                System.out.print("Points deduct\t\t: ");
                                System.out.println(pointsRedemption.getTempPointsDeduct());

                                System.out.print("Customer Total Points\t: ");
                                pointsRedemption.setCustomerPointsAt(pointsRedemption.getIndexOfCustomer(), pointsRedemption.calculatePoints());
                                customerReader.updateCustomerPoints(filePath, pointsRedemption.getCustomerPoints()[pointsRedemption.getIndexOfCustomer()]);
                                System.out.println(customerReader.getCustomerPoints()[pointsRedemption.getIndexOfCustomer()]);
                            }

                        } while (!pointsRedemption.isValidInputNumber());
                    } while (pointsRedemption.getNotEnoughPointsSelection().equals("Y"));

                    break;

                case "3":   //LOO JIE QI (Contact Management)

                    System.out.println("==========================="
                            + "\n    Contact Management"
                            + "\n===========================");

                    System.out.println("\nCustomer information checking = C"
                            + "\nCustomer information update   = U");
                    do {
                        System.out.print("Customer information (C/U)\t: ");
                        contactManagement.setServiceSelection(scanner.next().toUpperCase());
                        if (!(contactManagement.getServiceSelection().equals("C") || contactManagement.getServiceSelection().equals("U"))) {
                            System.err.println("================================================="
                                    + "\n\tError : input invalid (input C or U)"
                                    + "\n=================================================");
                        }
                    } while (!(contactManagement.getServiceSelection().equals("C") || contactManagement.getServiceSelection().equals("U")));

                    switch (contactManagement.getServiceSelection()) {
                        case "C":
                            do {
                                System.out.print("\nCustomer Name\t\t\t: ");
                                contactManagement.setTempCustomerName(scanner.next().toLowerCase());

                                contactManagement.chkCustomerName(contactManagement.getTempCustomerName(), customerReader.getCustomerName());

                            } while (!contactManagement.isCustomerNameExist());

                            contactManagement.printCustomerInformation();

                            break;

                        case "U":
                            contactManagement.modificationList();

                            do {
                                do {
                                    contactManagement.setValidInputNumber(false);
                                    try {
                                        System.out.print("Number\t\t\t: ");
                                        contactManagement.setNumberOfModification(scanner.nextInt());
                                        contactManagement.setValidInputNumber(true);
                                    } catch (InputMismatchException ex) {
                                        System.err.println("================================================="
                                                + "\nError : input invalid (input have to be integer)"
                                                + "\n=================================================");
                                        scanner.next();
                                    }

                                } while (!contactManagement.isValidInputNumber());

                                switch (contactManagement.getNumberOfModification()) {
                                    case 1:
                                        System.out.println("\nAdd new customer");
                                        do {
                                            System.out.print("New Customer Name\t: ");
                                            contactManagement.setTempCustomerName(scanner.next().toLowerCase());
                                            contactManagement.setCustomerNameExist(true);
                                            contactManagement.chkSymbolsOrNumbersExist();
                                            contactManagement.chkNameExist();
                                        } while (!contactManagement.isCustomerNameExist());

                                        do {

                                            System.out.print("Phone Number\t\t: ");
                                            contactManagement.setNewPhoneNumber(scanner.next()); // to let user input String with the phone num is because the phone num will be write in the file correctly or else using int the first number "0" will be remove
                                            if (contactManagement.getNewPhoneNumber().matches("[0-9]+")) {
                                                contactManagement.setValidInputNumber(true);
                                            } else {
                                                contactManagement.setValidInputNumber(false);
                                                System.err.println("================================================="
                                                        + "\nError : input invalid (input have to be integer)"
                                                        + "\n=================================================");
                                            }
                                        } while (!contactManagement.isValidInputNumber());
                                        customerReader.addNewCustomer(filePath, contactManagement.getTempCustomerName(), contactManagement.getNewPhoneNumber());
                                        customerReader.readCustomerData(filePath);
                                        contactManagement.setCustomerName(customerReader.getCustomerName());
                                        contactManagement.setCustomerTier(customerReader.getCustomerTier());
                                        contactManagement.setCustomerPoints(customerReader.getCustomerPoints());
                                        contactManagement.setCustomerFollowInstagram(customerReader.getCustomerFollowInstagram());
                                        contactManagement.setCustomerPhoneNum(customerReader.getCustomerPhoneNum());

                                        System.out.println("Customer information has created");
                                        break;

                                    case 2:
                                        System.out.println("\nChange customer name");
                                        scanner.nextLine();
                                        do {
                                            System.out.print("Customer Name\t\t: ");
                                            contactManagement.setTempCustomerName(scanner.next().toLowerCase());

                                            contactManagement.chkCustomerName(contactManagement.getTempCustomerName(), customerReader.getCustomerName());

                                        } while (!contactManagement.isCustomerNameExist());

                                        do {
                                            System.out.print("Change name\t\t: ");
                                            contactManagement.setTempCustomerName(scanner.next().toLowerCase());
                                            contactManagement.setCustomerNameExist(true);
                                            contactManagement.chkSymbolsOrNumbersExist();
                                            contactManagement.chkNameExist();
                                        } while (!contactManagement.isCustomerNameExist());

                                        customerReader.updateCustomerName(filePath, contactManagement.getTempCustomerName());
                                        System.out.println("Customer Name has changed successfully");
                                        break;

                                    case 3:
                                        System.out.println("\nChange customer phone number");
                                        scanner.nextLine();
                                        do {
                                            System.out.print("Customer Name\t\t: ");
                                            contactManagement.setTempCustomerName(scanner.next().toLowerCase());

                                            contactManagement.chkCustomerName(contactManagement.getTempCustomerName(), customerReader.getCustomerName());

                                        } while (!contactManagement.isCustomerNameExist());

                                        do {

                                            System.out.print("Change Phone Number\t: ");
                                            contactManagement.setNewPhoneNumber(scanner.next()); // to let user input String with the phone num is because the phone num will be write in the file correctly or else using int the first number "0" will be remove
                                            if (contactManagement.getNewPhoneNumber().matches("[0-9]+")) {
                                                contactManagement.setValidInputNumber(true);
                                            } else {
                                                contactManagement.setValidInputNumber(false);
                                                System.err.println("================================================="
                                                        + "\nError : input invalid (input have to be integer)"
                                                        + "\n=================================================");
                                            }
                                        } while (!contactManagement.isValidInputNumber());
                                        customerReader.updateCustomerPhoneNumber(filePath, contactManagement.getNewPhoneNumber());
                                        System.out.println("Customer Phone Number has changed successfully");
                                        break;
                                        
                                    case 4:
                                        break;

                                    default:
                                        System.err.println("================================================="
                                                + "\nError : input invalid (input have to be 1/2/3/4)"
                                                + "\n=================================================");
                                        contactManagement.setModificationNumber(false);

                                }
                            } while (!contactManagement.isModificationNumber());
                            break;

                        default:
                            System.err.println("================================================="
                                    + "\n\t  Error : input invalid"
                                    + "\n=================================================");

                    }

                    break;

                case "4":   //NG SHEN ZHI (Reward Tier)

                    int updateNewPoints;
                    String tier = customerReader.getCustomerTier()[customerFileIO.getIndexOfCustomer()];

                    System.out.println("================================");
                    System.out.println("     Reward Tier Management     ");
                    System.out.println("================================");

                    getTier.tierMenu();
                    getTier.setCustomerName(customerReader.getCustomerName());
                    getTier.setCustomerTier(customerReader.getCustomerTier());
                    getTier.setCustomerPoints(customerReader.getCustomerPoints());

                    do {
                        System.out.println("");
                        System.out.print("Enter customer name: ");
                        getTier.setInputName(scanner.next().toLowerCase());
                        getTier.chkCustomerName(getTier.getInputName(), customerReader.getCustomerName());
                    } while (getTier.isCustomerNameExist() == false);

                    do {
                        System.out.print("Do you want to upgrade ? (yes/no): ");
                        getTier.setYesNo(scanner.next().toLowerCase());
                        if (!"yes".equals(getTier.getYesNo()) && !"no".equals(getTier.getYesNo())) {
                            System.err.println("""
                                               ===============================================
                                               \t  Error : input invalid
                                               ===============================================""");
                        }
                    } while (!"yes".equals(getTier.getYesNo()) && !"no".equals(getTier.getYesNo()));

                    if (!"no".equals(getTier.getYesNo())) {

                        getTier.promptTierChoice();
                        updateNewPoints = getTier.calculatePoints();

                        if (getTier.getUpdateChoice() != null && (getTier.getCurrentPoints() >= getTier.getPointsRequired())) {
                            if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("silver") && getTier.getUpdateChoice().equals("bronze"))) {
                            } else if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("gold") && getTier.getUpdateChoice().equals("silver"))) {
                            } else if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("gold") && getTier.getUpdateChoice().equals("bronze"))) {
                            } else if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("silver") && getTier.getUpdateChoice().equals("gold"))) {
                                customerReader.updateCustomerTier(filePath, getTier.getUpdateChoice());
                            } else if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("bronze") && getTier.getUpdateChoice().equals("silver"))) {
                                customerReader.updateCustomerTier(filePath, getTier.getUpdateChoice());
                            } else if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("bronze") && getTier.getUpdateChoice().equals("gold"))) {
                                customerReader.updateCustomerTier(filePath, getTier.getUpdateChoice());
                            } else if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("normal") && getTier.getUpdateChoice().equals("gold"))) {
                                customerReader.updateCustomerTier(filePath, getTier.getUpdateChoice());
                            } else if (!tier.equals(getTier.getUpdateChoice()) && (tier.equals("normal") && getTier.getUpdateChoice().equals("silver"))) {
                                customerReader.updateCustomerTier(filePath, getTier.getUpdateChoice());
                            } else {
                                customerReader.updateCustomerTier(filePath, getTier.getUpdateChoice());
                            }
                        }
                        customerReader.updateCustomerPoints(filePath, updateNewPoints);
                    }
                    break;

                case "5":  //NG SHEN ZHI (Sorting Customer Information)
                    sorting.setSortedCustomerPoints(customerReader.getCustomerPoints());
                    sorting.setSortedCustomerTier(customerReader.getCustomerTier());
                    sorting.setSortedCustomerName(customerReader.getCustomerName());
                    sorting.setSortedCustomerFollowInstagram(customerReader.getCustomerFollowInstagram());
                    sorting.setSortedCustomerPhoneNum(customerReader.getCustomerPhoneNum());
                    System.out.println("================================");
                    System.out.println("     Customer Information       ");
                    System.out.println("================================");
                    do {
                        try {
                            System.out.println("----------------------------"
                                    + "\n1. View customer information"
                                    + "\n2. exit to menu"
                                    + "\n----------------------------"
                            );
                            System.out.print("Selection (1/2):");
                            sorting.setSelection(scanner.nextInt());
                            break;
                        } catch (Exception e) {
                            System.err.println("================================================="
                                    + "\n\t  Error : Please enter an integer"
                                    + "\n=================================================");
                            scanner.next();
                        }
                    } while (true);

                    sorting.chkSelection(sorting.getSelection());
                    if (sorting.getSelection() == 2) {
                        break;
                    }
                    sorting.printUnsorted(customerReader.getCustomerName(), customerReader.getCustomerTier(), customerReader.getCustomerPoints(), customerReader.getCustomerFollowInstagram(), customerReader.getCustomerPhoneNum());
                    do {
                        try {
                            System.out.println("----------------------------------"
                                    + "\n1. Sort by points(ascending order)"
                                    + "\n2. Sort by tier (ascending order)"
                                    + "\n----------------------------------"
                            );
                            System.out.print("Selection (1/2):");
                            sorting.setSelection(scanner.nextInt());
                            break;
                        } catch (Exception e) {
                            System.err.println("================================================="
                                    + "\n\t  Error : Please enter an integer"
                                    + "\n=================================================");
                            scanner.next();
                        }
                    } while (true);
                    sorting.chkSelection(sorting.getSelection());
                    if (sorting.getSelection() == 1) {
                        sorting.sortAscending(sorting.getSortedCustomerPoints());
                        System.out.println("Sorted by Points(ascending)");
                        sorting.printSorted();
                    } else {
                        sorting.sortTierAscending(sorting.getSortedCustomerTier());
                        System.out.println("Sorted by Tier(ascending)");
                        sorting.printSorted();
                    }

                    break;

                case "6":
                    System.exit(0);
                    break;

                default:
                    System.err.println("================================================="
                            + "\n\t\tError : input invalid"
                            + "\n=================================================");

            }

            do {
                System.out.print("Do you want to keep using this system? (Y/N)");
                home.keepUsingSystem = scanner.next();
                if (!(home.keepUsingSystem.equalsIgnoreCase("Y") || home.keepUsingSystem.equalsIgnoreCase("N"))) {
                    System.err.println("================================================="
                            + "\n\tError : input invalid (input Y or N)"
                            + "\n=================================================");
                }
            } while (!(home.keepUsingSystem.equalsIgnoreCase("Y") || home.keepUsingSystem.equalsIgnoreCase("N")));

        } while (home.keepUsingSystem.equalsIgnoreCase("Y"));

        System.out.println("================================================="
                + "\n\t\tTHANK YOU"
                + "\n=================================================");
    }

}
