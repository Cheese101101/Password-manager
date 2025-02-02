import java.util.Map;
import java.util.Scanner;
public class frontInterface {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        website web;
        FIles.readFile();
        FIles.decrypt();
        FIles.writeFile();
        String pin = FIles.getPin();
        boolean secure = false;
        if(pin == null){
            secure = true;
        }
        else{
            System.out.println("Please enter the pin: ");
            String userInput = scanner.next();
            if(userInput.equals(pin)){
                secure = true;
            }
        }
        if(secure) {
            System.out.println("Choose from the following menu: \n 1. Add new website \n 2. Update password or username for existing website \n 3. Generate new password \n 4. Get password or username for existing website \n 5. Set pin");
            try {
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Choose from the following menu: \n 1. Add only website \n 2. Add new website with username and password");
                    option = scanner.nextInt();
                    if (option == 1) {
                        System.out.println("Please enter the website name: ");
                        String webName = scanner.next();
                        web = new website();
                        web.setName(webName);
                        return;
                    }
                    if (option == 2) {
                        System.out.println("Please enter the website name: ");
                        String webName = scanner.next();
                        System.out.println("Please enter the password: ");
                        String password = scanner.next();
                        System.out.println("Please enter the username: ");
                        String username = scanner.next();
                        web = new website();
                        web.setName(webName);
                        web.setPassword(password);
                        web.setUsername(username);
                        return;
                    }
                }
                if (option == 2) {
                    System.out.println("Choose from the following menu: \n 1. Update password \n 2. Update username \n 3. Update both");
                    option = scanner.nextInt();
                    if (option == 1) {
                        System.out.println("Please enter the website name: ");
                        String webName = scanner.next();
                        System.out.println("Please enter the new password: ");
                        String password = scanner.next();
                        web = new website(webName);
                        web.setPassword(password);
                        return;
                    }
                    if (option == 2) {
                        System.out.println("Please enter the website name: ");
                        String webName = scanner.next();
                        System.out.println("Please enter the new username: ");
                        String username = scanner.next();
                        web = new website(webName);
                        web.setUsername(username);
                        return;
                    }
                    if (option == 3) {
                        System.out.println("Please enter the website name: ");
                        String webName = scanner.next();
                        System.out.println("Please enter the new password: ");
                        String password = scanner.next();
                        System.out.println("Please enter the new username: ");
                        String username = scanner.next();
                        web = new website(webName);
                        web.setPassword(password);
                        web.setUsername(username);
                        return;
                    }
                }
                if (option == 3) {
                    System.out.println("Please enter the length of the password wanted: ");
                    int length = scanner.nextInt();
                    String password = passwordGenerator.generator(length);
                    System.out.println("Password generated: " + password);
                    return;
                }
                if (option == 4) {
                    System.out.println("Please enter the website name: ");
                    String webName = scanner.next();
                    String searchList = FIles.search(webName);
                    System.out.println("Choose from the following: \n" + searchList);
                    webName = scanner.next();

                    Map<String, website> storage = FIles.setStorage();
                    web = storage.get(webName);
                    String password = web.getpassword();
                    String username = web.getUsername();
                    System.out.println("Password: " + password);
                    System.out.println("Username: " + username);
                    return;

                }
                if (option == 5) {
                    System.out.println("Please enter the new pin: ");
                    String newPin = scanner.next();
                    FIles.readFile();
                    FIles.setPin(newPin);
                    FIles.writeFile();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                FIles.readFile();
                FIles.encrypt();
                FIles.writeFile();
            }
        }
        else{
            System.out.println("Invalid access");
        }
    }
}