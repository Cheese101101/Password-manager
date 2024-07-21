public class website {
    public String name;
    public String password;
    public String username;

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
    public void setName(String newName){
        name = newName;
        FIles.readFile();
        FIles.addToFile("website: "+newName);
        FIles.addToFile("password: default");
        FIles.addToFile("username: default");
        FIles.indent();
        FIles.writeFile();
    }

    public void setPassword(String newPassword){
        password = newPassword;
        FIles.readFile();
        FIles.rewriteFile(name, "password: ", newPassword);
        FIles.writeFile();
    }

    public void setUsername(String newUsername){
        username = newUsername;
        FIles.readFile();
        FIles.rewriteFile(name, "username: ", newUsername);
        FIles.writeFile();
    }
}
