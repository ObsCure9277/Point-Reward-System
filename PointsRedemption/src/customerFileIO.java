
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class customerFileIO extends Customer {

    public customerFileIO(String filePath) {
        super();
        readCustomerData(filePath);
    }

    private void writeNewPoints(String filePath, int index, int newPoints) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < getCustomerName().length; i++) {
                if (i == index) {
                    bw.write(getCustomerName()[i] + ", " + getCustomerTier()[i] + ", " + newPoints + ", " + getCustomerFollowInstagram()[i] + ", " + getCustomerPhoneNum()[i]);
                } else {
                    bw.write(getCustomerName()[i] + ", " + getCustomerTier()[i] + ", " + getCustomerPoints()[i] + ", " + getCustomerFollowInstagram()[i] + ", " + getCustomerPhoneNum()[i]);
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeCustomerName(String filePath, int index, String newName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < getCustomerName().length; i++) {
                if (i == index) {
                    bw.write(newName + ", " + getCustomerTier()[i] + ", " + getCustomerPoints()[i] + ", " + getCustomerFollowInstagram()[i] + ", " + getCustomerPhoneNum()[i]);
                } else {
                    bw.write(getCustomerName()[i] + ", " + getCustomerTier()[i] + ", " + getCustomerPoints()[i] + ", " + getCustomerFollowInstagram()[i] + ", " + getCustomerPhoneNum()[i]);
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeCustomerPhoneNum(String filePath, int index, String newPhoneNum) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < getCustomerName().length; i++) {
                if (i == index) {
                    bw.write(getCustomerName()[i] + ", " + getCustomerTier()[i] + ", " + getCustomerPoints()[i] + ", " + getCustomerFollowInstagram()[i] + ", " + newPhoneNum);
                } else {
                    bw.write(getCustomerName()[i] + ", " + getCustomerTier()[i] + ", " + getCustomerPoints()[i] + ", " + getCustomerFollowInstagram()[i] + ", " + getCustomerPhoneNum()[i]);
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void writeCustomerTier(String filePath, int index, String newTier) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < getCustomerName().length; i++) {
                if (i == index) {
                    bw.write(getCustomerName()[i] + ", " + newTier + ", " + getCustomerPoints()[i] + ", " + getCustomerFollowInstagram()[i] + ", " + getCustomerPhoneNum()[i]);
                } else {
                    bw.write(getCustomerName()[i] + ", " + getCustomerTier()[i] + ", " + getCustomerPoints()[i] + ", " + getCustomerFollowInstagram()[i] + ", " + getCustomerPhoneNum()[i]);
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readCustomerData(String filePath) {
        List<String> nameList = new ArrayList<>();
        List<String> tierList = new ArrayList<>();
        List<Integer> pointsList = new ArrayList<>();
        List<String> followInstagramList = new ArrayList<>();
        List<String> phoneNumList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                nameList.add(values[0]);
                tierList.add(values[1]);
                pointsList.add(Integer.parseInt(values[2]));
                followInstagramList.add(values[3]);
                phoneNumList.add(values[4]);
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        this.setCustomerName(nameList.toArray(new String[0]));
        this.setCustomerTier(tierList.toArray(new String[0]));
        this.setCustomerPoints(pointsList.stream().mapToInt(Integer::intValue).toArray());
        this.setCustomerFollowInstagram(followInstagramList.toArray(new String[0]));
        this.setCustomerPhoneNum(phoneNumList.toArray(new String[0]));

    }

    public void updateCustomerPoints(String filePath, int newPoints) {

        int[] currentPoints = getCustomerPoints();
        currentPoints[getIndexOfCustomer()] = newPoints;
        setCustomerPoints(currentPoints);
        writeNewPoints(filePath, getIndexOfCustomer(), newPoints);
    }

    public void updateCustomerName(String filePath, String newName) {
        String[] currentCustomerName = getCustomerName();
        currentCustomerName[getIndexOfCustomer()] = newName;
        setCustomerName(currentCustomerName);

        writeCustomerName(filePath, getIndexOfCustomer(), newName);
    }

    public void updateCustomerPhoneNumber(String filePath, String newPhoneNum) {

        String[] currentPhoneNum = getCustomerPhoneNum();
        currentPhoneNum[getIndexOfCustomer()] = newPhoneNum;
        setCustomerPhoneNum(currentPhoneNum);
        writeCustomerPhoneNum(filePath, getIndexOfCustomer(), newPhoneNum);
    }
    
    public void updateCustomerTier(String filePath, String newTier) {

        String[] currentCustomerTier = getCustomerTier();
        currentCustomerTier[getIndexOfCustomer()] = newTier;
        setCustomerTier(currentCustomerTier);
        writeCustomerTier(filePath, getIndexOfCustomer(), newTier);
    }

    public void addNewCustomer(String filePath, String newCustomerName, String newPhoneNumber) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write("\n" + newCustomerName + ", " + "normal, 0, No, " + newPhoneNumber);
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\ncustomerFileIO{"
                + "\ncustomerName = " + Arrays.toString(getCustomerName())
                + "\ncustomerTier = " + Arrays.toString(getCustomerTier())
                + "\ncustomerPoints=" + Arrays.toString(getCustomerPoints())
                + "\ncustomerFollowInstagram=" + Arrays.toString(getCustomerFollowInstagram())
                + "\ncustomerPhoneNum=" + Arrays.toString(getCustomerPhoneNum())
                + "\n}";
    }

}
