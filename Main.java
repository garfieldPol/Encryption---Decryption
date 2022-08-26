package encryptdecrypt;

// dodatkowe dwa elementy z fabryki inaczej kodowane

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathToFile = "";
        String Newdata = "";
        String targetOperation = "enc";
        String pathToSaveFile = "";
        String algorithm = "shift";
        int key = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-in")) {
                pathToFile = args[i + 1];
            } else if (args[i].equals("data")) {
                Newdata = args[i + 1];
            } else if (args[i].equals("dec")) {
                targetOperation = "dec";
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-out")) {
                pathToSaveFile = args[i + 1];
            } else if (args[i].equals("-alg")) {
                algorithm = args[i + 1];

            }
        }

        File input = new File(pathToFile);
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                Newdata = scanner.nextLine();

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error no file found: " + pathToFile);
        }


        //PassWord Demo
        PasswordsFactory passwordsFactory = new PasswordsFactory();
        if (targetOperation == "dec" && algorithm == "unicode") {
            Password passwordDecrypted = passwordsFactory.getPassword(Newdata, targetOperation, key, algorithm);

            if (pathToSaveFile.equals("")) {

            } else {
                Save(passwordDecrypted.toString(), pathToSaveFile);

            }

        } else if (targetOperation == "dec" && algorithm == "shift") {
            Password passwordDecryptedShift = passwordsFactory.getPassword(Newdata, targetOperation, key, algorithm);

            if (pathToSaveFile.equals("")) {

            } else {
                Save(passwordDecryptedShift.toString(), pathToSaveFile);

            }
        }
        // Encrypted Below
        else if (targetOperation == "enc" && algorithm == "unicode") {
            Password passwordEncrypted = passwordsFactory.getPassword(Newdata, targetOperation, key, algorithm);

            if (pathToSaveFile.equals("")) {

            } else {
                Save(passwordEncrypted.toString(), pathToSaveFile);

            }

        } else if (targetOperation == "enc" && algorithm == "shift") {
            Password passwordEncryptedShift = passwordsFactory.getPassword(Newdata, targetOperation, key, algorithm);

            if (pathToSaveFile.equals("")) {

            } else {
                Save(passwordEncryptedShift.toString(), pathToSaveFile);

            }


        }
    }

    //Zapis tekstu do pliku
    private static void Save(String password, String pathToSaveFile) {
        File file = new File(pathToSaveFile);
        try (FileWriter writer = new FileWriter(file)) {
            if (password != null) {
                writer.write(password);
            } else {
                System.out.println("Error empty string");
            }

            System.out.println(password);
        } catch (IOException e) {
            System.out.printf("Error an exception occurred %s", e.getMessage());
        }
//    }}


    }
}















