public class encryptor {
    public static String encrypt(String text){
        StringBuilder encryptedText = new StringBuilder();
        int i = 0;
        while(i<text.length()){
            char c = text.charAt(i);
            if(c == ' '){
                encryptedText.append(" ");
            }
            else{
                c = (char)(c + 5);
                encryptedText.append(c);
            }
            i++;
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text){
        StringBuilder decryptedText = new StringBuilder();
        int i = 0;
        while(i<text.length()){
            char c = text.charAt(i);
            if(c == ' '){
                decryptedText.append(" ");
            }
            else{
                c = (char)(c - 5);
                decryptedText.append(c);
            }
            i++;
        }
        return decryptedText.toString();
    }

    public static void main(String[] args){
        String text = encrypt("website: hi");
        System.out.println(text);
        String newText = decrypt(text);
        System.out.println(newText);
    }
}
