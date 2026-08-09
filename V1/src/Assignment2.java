public class Assignment2 {


    public static void main(String[] args) {

        //keep prompting user until they press 0 to exit/ quit the program

        System.out.println("\nWelcome to the encryption tool");

        EncryptionTool encryptionTool = new EncryptionTool();

        while (true) {

            //get the initial user option/choice
            int option = encryptionTool.getMenuItem();

            //take them to the selected option workflow and throw exception if anything goes wrong
            switch (option) {
                case 0:
                    //exit the program
                    System.out.print("Program written by Andrew Mugisa");
                    System.exit(0);
                    //return;
                case 1: //encrypt
                    /**
                     * Here the user will be able to encrypt text
                     * let the user select between ceasar and vigenere
                     * Encrypt and output the encrypted text for each case
                     */

                    System.out.print("\nEncrypted text= " + encryptionTool.encryptText() + "\n");
                    break;

                case 2: //decrypt
                    /**
                     * Here the user will be able to decrypt text
                     * let the user select between ceasar and vigenere
                     * Decrypt and output the decrypted text for each case
                     */

                    System.out.print("\nDecrypted text= " + encryptionTool.decryptText() + "\n");
                    break;
                case 3:
                    encryptionTool.encryptFile();
                    break;
                case 4:
                    encryptionTool.decryptFile();
                    break;
            }
        }

    }
}