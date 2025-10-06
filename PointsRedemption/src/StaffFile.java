
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaffFile extends Staff {

    public StaffFile(String filePath) {
        super();
        readStaffData(filePath);
    }
    
    public void addNewStaff(String filePath, String newStaffUsername, String newPassword) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write("\n" + newStaffUsername + ", " + newPassword);
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readStaffData(String filePath) {
        List<String> staffNameList = new ArrayList<>();
        List<String> staffPasswordList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                staffNameList.add(values[0]);
                staffPasswordList.add(values[1]);

            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        this.setStaffName(staffNameList.toArray(new String[0]));
        this.setStaffPassword(staffPasswordList.toArray(new String[0]));

    }

    @Override
    public String toString() {
        return super.toString()
                + "\nStaffFile{"
                + "\nstaffName = " + Arrays.toString(getStaffName())
                + "\nstaffPassword=" + Arrays.toString(getStaffPassword())
                + "\n}";
    }

}
