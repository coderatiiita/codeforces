package com.patterns.twopointers;

import java.util.Scanner;

public class Letters {
    static long sum=0;
    static int i=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfDorms, noOfLetters;
        noOfDorms = sc.nextInt();
        noOfLetters = sc.nextInt();

        long[] rooms = new long[noOfDorms];
        long[] letters = new long[noOfLetters];
        for (int i = 0; i < noOfDorms; i++) {
            rooms[i] = sc.nextLong();
        }
        for (int i = 0; i < noOfLetters; i++) {
            letters[i] = sc.nextLong();
        }

        for (long letter: letters) {
            solve(noOfDorms, rooms, letter);
        }
    }

    private static void solve(int noOfDorms, long[] rooms, long letter) {
        while(i<noOfDorms && rooms[i]+sum < letter) {
            sum += rooms[i];
            i++;
        }
        System.out.printf("%d %d\n", i+1, letter-sum);
    }
}
