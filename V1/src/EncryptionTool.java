/**
 * Student Name: Andrew Mugisa
 * Student Number:
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Lab Professor: Howard Rosenblum
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * The worker class for encrypting/decrypting data
 */
public class EncryptionTool {

    /**
     * scanner : Scanner - The only Scanner to be used by the various methods in this class
     */
    private final Scanner scanner = new Scanner(System.in);
    /**
     * inputFile : File - The input File to be used when encrypting/decrypting files
     */
    private File inputFile;
    /**
     * outputFile : File - The output File to be used when encrypting/decrypting
     */
    private File outputFile;


    /**
     * Description: Method to get user input for the selected Cipher. Must contain
     * all the user input prompts needed to create and return a valid cipher
     *
     * @return a valid cipher for user input
     */
    private Cipher getCipher() {
        // Cipher caesar;
        //Cipher vigenere;

        while (true) {
            System.out.print("\nWhich method do you want to use (1=Caesar, 2=Vigenère)? ");
            try {
                int encryptionToolChoice = scanner.nextInt();
                scanner.nextLine();

                String textInput;
                switch (encryptionToolChoice) {
                    case 1:

                        System.out.print("\nWhat is the shift? ");
                        int shiftOption = scanner.nextInt();
                        scanner.nextLine();

                        Cipher caesar = new Caesar(shiftOption);

                        return caesar;

                    case 2:
                        System.out.print("\nWhat is the passphrase? ");
                        String passphrase = scanner.nextLine();

                        Cipher vigenere = new Vigenere(passphrase);

                        return vigenere;
                }

            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }

        }
    }


    /**
     * Description: Method to get user input for the selected files to be used for
     * encrypting/decrypting files.
     * <p>
     * - Will display the file selection dialogue box
     * - Instance variable inputFile is set to the file selected by the user
     * - Instance variable outputFile is created in the same directory and with the same
     * filename as the input file, but with the file extension provided in the parameter
     *
     * @param extension The extension for the output file
     * @return true if the files were successfully created
     * <p>
     * Note: This method may NOT be changed in any way
     */
    private boolean getFile(String extension) {
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            inputFile = jfc.getSelectedFile();
            if (!inputFile.canRead()) {
                System.out.println("Unable to read " + inputFile.getAbsolutePath());
                return false;
            }
            String outputName = inputFile.getAbsolutePath();
            outputName = outputName.substring(0, outputName.lastIndexOf(".") + 1) + extension;
            outputFile = new File(outputName);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Description: Method to get user input for main menu option
     *
     * @return The valid menu option
     */
    public int getMenuItem() {
        while (true) {

            System.out.println("" +
                    "1. Encrypt Text \n" +
                    "2. Decrypt Text \n" +
                    "3. Encrypt File \n" +
                    "4. Decrypt File \n" +
                    "0. Quit"
            );

            System.out.print("Please select an option: ");


            try {
                //get the initial user option/choice
                int option = scanner.nextInt();

                if (option < 0 || option > 4) {
                    System.out.println("Value out of range (0-4) ");
                } else {
                    return option;
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter an integer");
                scanner.nextLine();
            }
        }
    }

    /**
     * Description: Method to encrypt user input text
     *
     * @return Encrypted text
     */
    public String encryptText() {
        Cipher selectedCipher = getCipher();
        System.out.print("\nWhat is the text to be encrypted? ");
        String textInput = scanner.nextLine();

        return selectedCipher.encrypt(textInput);
    }

    /**
     * Description: Method to decrypt user input text
     *
     * @return Decrypted text
     */
    public String decryptText() {
        Cipher selectedCipher = getCipher();
        System.out.print("\nWhat is the text to be decrypted? ");
        String textInput = scanner.nextLine();

        return selectedCipher.decrypt(textInput);
    }

    /**
     * Description: Method to encrypt user selected file
     */

    public void encryptFile() {
        System.out.print("Opening file ");

        // Get the input and output files
        if (!getFile("enc")) {
            return;
        }

        // Create the cipher
        Cipher selectedCipher = getCipher();

        // Read the input file and write the encrypted text to the output file
        try {
            Scanner fileScanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            while (fileScanner.hasNextLine()) {
                String text = fileScanner.nextLine();
                String encryptedText = selectedCipher.encrypt(text);
                writer.println(encryptedText);
            }

            fileScanner.close();
            writer.close();

            System.out.println("Encrypted file stored in "
                    + outputFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Unable to encrypt file");
        }
    }

    /**
     * Description: Method to decrypt user selected file
     */
    public void decryptFile() {
        System.out.print("Opening file ");

        // Get the input and output files
        if (!getFile("txt")) {
            return;
        }

        // Create the cipher
        Cipher selectedCipher = getCipher();

        // Read the input file and write the decrypted text to the output file
        try {
            Scanner fileScanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            while (fileScanner.hasNextLine()) {
                String text = fileScanner.nextLine();
                String decryptedText = selectedCipher.decrypt(text);
                writer.println(decryptedText);
            }

            fileScanner.close();
            writer.close();

            System.out.println("Decrypted file stored in "
                    + outputFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Unable to decrypt file");
        }
    }



}
