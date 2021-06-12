package com.example.dsu;

import java.util.Arrays;
import java.util.Scanner;

public class BooksExchangeEasy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[]  arr = new int[n+1];

            for(int i=1; i<=n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i=1; i<=n; i++) {
                int count = 1, j=i;
                while (arr[j] != i) {
                    j = arr[j];
                    count++;
                }
                System.out.printf("%d ", count);
            }

            System.out.println();

        }
    }

}