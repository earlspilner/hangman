package com.raddan.service;

import com.raddan.enums.Words;
import com.raddan.utils.Printer;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Service {

    private final Printer printer = new Printer();
    private final Scanner scanner = new Scanner(System.in);
    private int attempts;
    public boolean isActive = true;

    public void start() {
        printer.printMenu();
        int option = scanner.nextInt();
        if (option == 2) {
            System.exit(0);
        }
        startGame();
    }

    public void startGame() {
        String word = getRandomWord();
        char[] letters = new char[word.length()];
        fillArray(letters);
        printer.printGame(word, 0);

        while (isActive) {
            char letter = scanner.next().charAt(0);
            if (isContains(word, letter)) {
                success(word, letters, letter);
                String currentWord = new String(letters);
                if (currentWord.equals(word)) {
                    printer.printWord(word);
                    printer.printWin();
                    System.exit(0);
                }
                printer.printHang(letters, attempts);
            } else {
                attempts++;
                printer.printHang(letters, attempts);
            }

            if (attempts == 9) {
                setInactive();
                printer.printWord(word);
                printer.printLose();
                System.exit(0);
            }
        }
    }

    void setInactive() {
        this.isActive = false;
    }

    String getRandomWord() {
        int idx = ThreadLocalRandom.current().nextInt(Words.values().length);
        return Words.values()[idx].toString();
    }

    boolean isContains(String word, char ch) {
        char[] wordArray = word.toCharArray();
        for (char c : wordArray) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    int findIdx(String word, char ch, int startIndex) {
        char[] wordArray = word.toCharArray();
        for (int i = startIndex; i < wordArray.length; i++) {
            if (ch == wordArray[i]) {
                return i;
            }
        }
        return -1;
    }

    void fillArray(char[] word) {
        int len = word.length;
        for (int i = 0; i < len; i++) {
            word[i] = '_';
        }
    }

    void success(String word, char[] letters, char letter) {
        int idx = 0;
        while (idx != -1) {
            idx = findIdx(word, letter, idx);
            if (idx != -1) {
                letters[idx] = letter;
                idx++;
            }
        }
    }

}
