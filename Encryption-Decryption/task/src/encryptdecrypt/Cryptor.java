package encryptdecrypt;

public class Cryptor {
    private CiphingMethod cipherMethod;

    public void setCipherMethod(CiphingMethod method){
        this.cipherMethod = method;
    }

    public String cipher(String s, Integer n){
        return this.cipherMethod.cipher(s,n);
    }

}
