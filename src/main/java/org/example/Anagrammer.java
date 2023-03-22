package org.example;

import java.util.Scanner;

public class Anagrammer {

    public static void permute(String string, String prefix, String[] anagrams) {
        int length = string.length();
        if (length == 0) {
            for (int i = 0; i < anagrams.length; i++) {
                if (anagrams[i] == null) {
                    anagrams[i] = prefix;
                    return;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                String newPrefix = prefix + string.charAt(i);
                String newString = string.substring(0, i) + string.substring(i + 1, length);
                for (int j = 0; j < anagrams.length; j++) {
                    if (anagrams[j] == null) {
                        permute(newString, newPrefix, anagrams);
                        break;
                    }
                }
            }
        }
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void printPermutations(int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = scanner.nextLine();

        String[] anagrams = new String[n];
        permute(word, "", anagrams);
        for (int i = 0; i < n; i++) {
            System.out.println(anagrams[i].substring(0, 1).toUpperCase() + anagrams[i].substring(1));
        }


    }

    public static void printAllPermutations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = scanner.nextLine();
        int n = factorial(word.length());
        String[] anagrams = new String[n];

        permute(word, "", anagrams);
        for (int i = 0; i < n; i++) {
            System.out.println(anagrams[i].substring(0, 1).toUpperCase() + anagrams[i].substring(1));
        }


    }
}















