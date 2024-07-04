package com.raddan.utils;

public class Printer {

    public void printMenu() {
        printBeautifulLabel();
        printOptions();
    }

    public void printGame(String word, int attempts) {
        int length = word.length();
        System.out.print("Word: ");
        for (int i = 0; i < length; i++) {
            System.out.print("_");
        }
        System.out.println();
        printInfo(attempts);
    }

    public void printHang(char[] letters, int attempts) {
        for (char letter : letters) {
            System.out.print(letter);
        }
        System.out.println();
        printInfo(attempts);
    }

    public void printWin() {
        System.out.println();
        System.err.println("You win!");
    }

    public void printLose() {
        System.out.println();
        System.err.println("You lose!");
    }

    void printInfo(int attempts) {
        System.out.println("Fails(" + attempts + "):");
        System.out.print("Letter: ");
    }

    void printOptions() {
        System.out.println("1. Start new game.");
        System.out.println("2. Exit.");
        System.out.print("Enter your option: ");
    }

    void printBeautifulLabel() {
        int labelLength = 9;
        int borderLength = (labelLength * 3) - 4;

        for (int i = 0; i < borderLength; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.println("* H  A  N  G  M  A  N *");

        for (int i = 0; i < borderLength; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void printWord(String word) {
        System.out.println();
        System.err.println("Word is: " + word);
    }
}
