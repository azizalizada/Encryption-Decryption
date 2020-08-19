package encryptdecrypt;

public class Encryptor implements CiphingMethod {
    @Override
    public String cipher(String s, Integer n) {
        // Encryption process
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (char) (arr[i] + n);
            }

            return String.valueOf(arr);
        }
    }
