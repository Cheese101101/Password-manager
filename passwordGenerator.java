import java.util.Random;

public class passwordGenerator {
    public static String generator(int length){
        Random random = new Random();

        String password = random.ints(48, 123).limit(length).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return password;
    }

    public static void main(String[] args){
        String password = generator(10);
        System.out.println(password);
    }
}
