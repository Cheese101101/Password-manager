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

    public static void setName(String newName){
        name = newName;
        FIles.readFile();
        FIles.addToFile(newName);
        FIles.addToFile("password: default");
        FIles.addToFile("username: default");
        FIles.deleteFile();
        FIles.writeFile();
    }

    public static void setPassword(String newPassword){
        password = newPassword;
        FIles.readFile();
        FIles.rewriteFile(name, "password: ", newPassword);
        FIles.deleteFile();
        FIles.writeFile();
    }

    public static void main(String[] args){
        name = "riyaraval";
        setPassword("hihihi");
    }
}
