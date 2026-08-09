package V1;

/**
 * Student Name: Andrew Mugisa
 * Student Number:
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Lab Professor: Howard Rosenblum
 */
public class Vigenere extends Cipher {


    private final String paraphrase;

    private final int length;

    public Vigenere(String paraphrase) {
        this.paraphrase = paraphrase;
        this.length = paraphrase.length();
    }

    @Override
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char tch = text.charAt(i);
            // Reset paraphrase index automatically
            char pch = paraphrase.charAt(i % length);

            if ((tch < FIRST_CHAR) || (tch > LAST_CHAR)) {
                result.append(tch);
            } else {
                int shifted = tch + (pch - FIRST_CHAR);

                while (shifted > LAST_CHAR) {
                    shifted -= (LAST_CHAR - FIRST_CHAR + 1);
                }

                result.append((char) shifted);
            }

        }
        return result.toString();
    }

    @Override
    public String decrypt(String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < key.length(); i++) {
            char tch = key.charAt(i);
            // Reset paraphrase index automatically
            char pch = paraphrase.charAt(i % length);

            if ((tch < FIRST_CHAR) || (tch > LAST_CHAR)) {
                result.append(tch);
            } else {
                int shifted = tch - (pch - FIRST_CHAR);

                while (shifted < FIRST_CHAR) {
                    shifted += (LAST_CHAR - FIRST_CHAR + 1);
                }

                result.append((char) shifted);
            }

        }
        return result.toString();
    }
}
