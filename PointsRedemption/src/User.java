import java.util.Scanner;
public class User extends Staff implements ChkName{
    private String name; 
    private String password; 
    private String newName; 
    private String newPassword;
    private int selection; 
    private boolean correctSelection; 
    private String backToMain; 
     
    
    public User(){
        
    }
    public User(String[] staffName ,String[] staffPassword){
        super(staffName,staffPassword); 
         
    }
    public User(String name, String password){
        this.name = name; 
        this.password = password; 
    }

    public void setName(String name){
        this.name = name; 
    }
    
    public String getName(){
        return name; 
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    
    }
    public void setNewName(String newName){ 
       this.newName = newName; 
    }
   
    public String getNewName() {
        return newName;
    }

    public void setCorrectSelection(boolean correctSelection) {
        this.correctSelection = correctSelection;
    }

    public boolean isCorrectSelection() {
        return correctSelection;
    }
    
    public void setNewPassword(String password){
       this.newPassword = password; 
    }
   
    public String getNewPassword() {
        return newPassword;
    }
    
    public int getSelection(){
        return selection; 
    }
    
    public void setSelection(int selection) {
        this.selection = selection;
    }

    public String isBackToMain() {
        return backToMain;
    }

    public void setBackToMain(String backToMain) {
        this.backToMain = backToMain;
    }
    public void chkBackToMain(){
        Scanner scan = new Scanner(System.in); 
        do{
            
            System.out.print("Back to login/signup page, input y" + "\nExit Program, input n\n");
            System.out.print("selection: ");
            setBackToMain(scan.next().toLowerCase());
            
            if(isBackToMain().length() == 1){
                if(isBackToMain().equals("y")){
                    setBackToMain("y"); 
                }
                else if (isBackToMain().equals("n")){
                    System.exit(0);
                }
                else {
                    System.err.println("================================================="
                        + "\n\t  Error : Incorrect Selection, try again"
                        + "\n=================================================");
                }
            }
            else{
              System.err.println("================================================="
                        + "\n\t  Error : Invalid input, try again"
                        + "\n=================================================");  
            }
            
        }while(!isBackToMain().equals("y") && !isBackToMain().equals("n")); 
    }
    public void chkSelection(int selection){
        Scanner scan = new Scanner(System.in); 
        do{
        if(getSelection() != 1 && getSelection() != 2){
            setCorrectSelection(false); 
            System.err.println("================================================="
                        + "\n\t  Error : Incorrect Selection, try again"
                        + "\n=================================================");
            do{
            try{
            System.out.print("Enter selection again:" );
            setSelection(scan.nextInt());
            break;
            }
            catch (Exception e){
                System.err.println("================================================="
                        + "\n\t  Error : Invalid input, try again"
                        + "\n=================================================");
                scan.next(); 
            }
            }while(true); 
        }
        else{
            setCorrectSelection(true); 
        }
        }while(isCorrectSelection() == false); 
            
    }    
    
    @Override
    public void chkSymbolsOrNumbersExist() {
        if(getNewName().matches("^[a-zA-z]+$")) {
            this.setStaffNameExist(false);
            
        }else {
            System.err.println("================================================="
                        + "\n   Error : Name cannot have symbol or numbers"
                        + "\n=================================================");
            this.setStaffNameExist(true);
        }
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", newName=" + newName + ", newPassword=" + newPassword + ", selection=" + selection + ", correctSelection=" + correctSelection + ", backToMain=" + backToMain + '}';
    }
    
    
    
    
    
}