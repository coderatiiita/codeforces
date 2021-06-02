package com.example.binarySearch;

import java.util.Scanner;

public class NewYearAndHurry {

    static int[] qMins;
    static final int totalTime = 60*4;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        qMins = new int[n];
        for(int i=0; i<n; i++) {
            if(i==0)
                qMins[i] = 5;
            else qMins[i] = 5*(i+1) + qMins[i-1];
        }
        int mins = sc.nextInt();

        int idx = bSearch(qMins, n, totalTime-mins);

        if(idx == -1) {
            System.out.println("0");
        } else {
            System.out.printf("%d\n", idx+1);
        }
    }

    private static int bSearch(int[] qMins, int n, int val) {
        int left = 0, right = n-1;
        int idx=-1;

        while(left<=right) {
            int mid = left + (right-left)/2;
            if(qMins[mid] <= val) {
                idx = mid;
                left=mid+1;
            } else {
                right=mid-1;
            }
        }

        return idx;
    }
}