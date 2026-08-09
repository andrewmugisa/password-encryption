/**
 * Student Name: Andrew Mugisa
 * Student Number:
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Lab Professor: Howard Rosenblum
 */

public abstract class Cipher {
    /**
     * First and last valid characters to be used
     */
    protected static final char FIRST_CHAR = ' ';
    protected static final char LAST_CHAR = '~';

    //Number of characters between first and last characters to be used
    protected static final int CHAR_DIFF = (LAST_CHAR - FIRST_CHAR + 1);

    public abstract String encrypt(String text);

    public abstract String decrypt(String text);

}
