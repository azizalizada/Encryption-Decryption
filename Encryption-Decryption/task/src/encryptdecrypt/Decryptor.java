package encryptdecrypt;

public class Decryptor implements CiphingMethod{
    @Override
    public String cipher(String s, Integer n) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] - n);
        }
        return String.valueOf(arr);
    }
}
