package encryptdecrypt;

public class ShiftDecrypt implements  CiphingMethod {
    @Override
    public String cipher(String s, Integer n) {
        char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    if (Character.isAlphabetic(arr[i])) {
                        if(Character.isUpperCase(arr[i])) {
                            int a = (arr[i] - 65 - n) % 26;
                            if(a < 0) {
                                arr[i] = (char) (a + 26 + 65);
                            }else {
                                arr[i] = (char) (a + 65);
                            }
                        }else {
                            int a = (arr[i] - 97 - n) % 26;
                            if(a < 0) {
                                arr[i] = (char) (a + 26 + 97);
                            }else {
                                arr[i] = (char) (a + 97);
                            }                        }
                    }
                }
        return String.valueOf(arr);
    }
}
