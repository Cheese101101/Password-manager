import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;


public class FIles{
    static StringBuffer fileText = new StringBuffer();
    static Map<String, website> storage;


    public static void readFile(){
        String str;
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                fileText.append(str).append("\n");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void encrypt(){
        String str;
        fileText.setLength(0);
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                String tempText = encryptor.encrypt(str);
                fileText.append(tempText).append("\n");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void decrypt(){
        String str;
        fileText.setLength(0);
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                String tempText = encryptor.decrypt(str);
                fileText.append(tempText).append("\n");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Map<String,website> setStorage(){
        String webName = "";
        String username;
        String password = "";
        website web;
        String str;
        storage = new HashMap<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                if(str.startsWith("website: ")){
                    webName = str.substring(9).trim();
                }
                if(str.startsWith("password: ")){
                    password = str.substring(10).trim();
                }
                if(str.startsWith("username: ")){
                    username = str.substring(10).trim();
                    web = new website(webName,password,username);
                    storage.put(webName, web);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return storage;
    }

    public static void rewriteFile(String webName, String type, String name){
        String oldName = "";
        String str;
        boolean found = false;
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                if(str.contains(webName)){
                    found = true;
                }
                if(str.startsWith(type) && (found)){
                    oldName = str.substring(type.length()).trim();
                    found = false;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        int startIndex = fileText.indexOf(oldName);
        int endIndex = startIndex + oldName.length();
        fileText.replace(startIndex, endIndex, name);

    }

    public static void writeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage"))) {
            writer.write(fileText.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileText.setLength(0);
    }

    public static void addToFile(String info){
        fileText.append(info).append("\n");
    }

    public static void indent(){
        fileText.append("-").append("\n");
    }

    public static void setPin(String pin){
        String str;
        String oldPin = "";
        boolean found = false;
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                if(str.startsWith("pin: ")){
                    found = true;
                    oldPin = str.substring(5).trim();
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        if(!found){
            StringBuffer tempFileText = new StringBuffer();
            tempFileText.append("pin: ").append(pin).append("\n").append("-").append("\n");
            fileText = tempFileText.append(fileText);
        }
        if(found){
            int startIndex = fileText.indexOf(oldPin);
            int endIndex = startIndex + oldPin.length();
            fileText.replace(startIndex, endIndex, pin);
        }
    }

    public static String getPin(){
        String str;
        String pin = null;
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                if(str.startsWith("pin: ")){
                    pin = str.substring(5).trim();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return pin;
    }
    public static void main(String[] args){
        readFile();
        rewriteFile("pp", "password: ","awesome8");
        addToFile("hi");
        writeFile();
    }
}