package encryptdecrypt;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String command = "enc";
        boolean out = false;
        String outPath = null;
        int a = 0;
        String s = "";
        String o = "";
        String alg = "shift";


        for (int i = 0; i < args.length; i += 2) {
            switch ((args[i])) {
                case "-mode":
                    command = args[i + 1];
                    break;
                case "-key":
                    a = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    s = args[i + 1];
                    break;
                case "-in":
                    s = read(args[i + 1]);
                    break;
                case "-out":
                    out = true;
                    outPath = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }

        Cryptor ciph = new Cryptor();
        if (alg.equals("unicode")) {
            if (command.equals("dec")) {
                ciph.setCipherMethod(new Decryptor());
            } else {
                ciph.setCipherMethod(new Encryptor());
            }
        } else {
            if (command.equals("dec")) {
                ciph.setCipherMethod(new ShiftDecrypt());
            } else {
                ciph.setCipherMethod(new ShiftEncrypt());
            }
        }
        o = ciph.cipher(s, a);


        if (out) {
            write(outPath, o);
        }
    }


    //reading data from file
    public static String read(String path) {
        File file = new File(path);
        String data = "";
        try {
            Scanner scanner = new Scanner(file);
            data = scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    //writing data to a file
    public static void write(String path, String data) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
