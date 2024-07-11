import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;


public class FIles{
    static StringBuffer fileText = new StringBuffer();

    public static void deleteFile(){
        File file = new File("storage");
        file.delete();
    }
    public static void readFile(){
        String str = "";
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                fileText.append(str).append("\n");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void rewriteFile(String webName, String type, String name){
        String oldName = "";
        String str = "";
        boolean found = false;
        try(BufferedReader fileReader = new BufferedReader(new FileReader("storage"))){
            while((str = fileReader.readLine()) != null){
                if(str.startsWith(webName)){
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

    public static void main(String[] args){
        readFile();
        rewriteFile("pp", "password: ","awesome8");
        addToFile("hi");
        deleteFile();
        writeFile();
    }

}