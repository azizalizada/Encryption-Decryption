package encryptdecrypt;

public class ShiftEncrypt implements  CiphingMethod {
    @Override
    public String cipher(String s, Integer n) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                if(Character.isUpperCase(arr[i])) {
                    arr[i] = (char) ((arr[i] + n - 65) % 26 + 65);
                }else {
                    arr[i] = (char) ((arr[i] + n - 97) % 26 + 97);
                }
            }
        }
        return String.valueOf(arr);
    }
}
