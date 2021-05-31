package com.example.twopointers;

import java.util.Scanner;

public class SerejaAndDima {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int left = 0, right = n-1;
        int s=0, d=0;
        boolean turn = true;
        while(left <= right) {
            if(turn) {
                if (nums[left] > nums[right]) {
                    s += nums[left];
                    left++;
                } else {
                    s += nums[right];
                    right--;
                }
            } else {
                if (nums[left] > nums[right]) {
                    d += nums[left];
                    left++;
                } else {
                    d += nums[right];
                    right--;
                }
            }
            turn = !turn;
        }

        System.out.printf("%d %d\n", s, d);
    }
}
