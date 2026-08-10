/**
 * Student Name: Andrew Mugisa
 * Student Number:
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Lab Professor: Howard Rosenblum
 */

/**
 * This is a basic encryption method
 * *It will take in a string and encrypt it by shifting characters
 */


public class Caesar extends Cipher {

    private final int shift;

    public Caesar(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            /**
             * If char is less than first char --> append char to result
             * If char is greater than last char ---> append character to result
             *
             * else
             * Shift chars and append to result
             */
            if ((ch < Cipher.FIRST_CHAR) || (ch > Cipher.LAST_CHAR)) {
//               if(ch < FIRST_CHAR){result.append(ch);}
//               if(ch > LAST_CHAR){result.append(ch);}
                result.append(ch);
            } else {
                result.append((char) ((ch + shift - Cipher.FIRST_CHAR + Cipher.CHAR_DIFF) % Cipher.CHAR_DIFF + Cipher.FIRST_CHAR));
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if ((ch < Cipher.FIRST_CHAR) || (ch > Cipher.LAST_CHAR)) {
                result.append(ch);
            } else {
                result.append((char) ((ch - shift - Cipher.FIRST_CHAR + Cipher.CHAR_DIFF) % Cipher.CHAR_DIFF + Cipher.FIRST_CHAR));
            }

        }
        return result.toString();
    }

}
