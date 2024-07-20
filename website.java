public class website {
    public static String name;
    public static String password;
    public static String username;

    public String getName(){
        return name;
    }

    public String getpassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public website(){

    }
    public website(String newName){
        name = newName;
    }
    public website(String newName, String newPassword, String newUsername){
        name = newName;
        password = newPassword;
        username = newUsername;
    }
    public static void setName(String newName){
        name = newName;
        FIles.readFile();
        FIles.addToFile("website: "+newName);
        FIles.addToFile("password: default");
        FIles.addToFile("username: default");
        FIles.indent();
        FIles.writeFile();
    }

    public static void setPassword(String newPassword){
        password = newPassword;
        FIles.readFile();
        FIles.rewriteFile(name, "password: ", newPassword);
        FIles.writeFile();
    }

    public static void setUsername(String newUsername){
        username = newUsername;
        FIles.readFile();
        FIles.rewriteFile(name, "username: ", newUsername);
        FIles.writeFile();
    }
}
