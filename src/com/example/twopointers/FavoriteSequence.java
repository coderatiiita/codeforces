package com.example.twopointers;

import java.util.Arrays;
import java.util.Scanner;

public class FavoriteSequence {

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            solve(nums, n);
        }
    }

    private static void solve(int[] nums, int n) {
        int[] res = nums.clone();
        int left = 0, right = n-1;
        int i=0;
        while(left < right) {
            res[i++] = nums[left++];
            res[i++] = nums[right--];
            if(left == right) {
                res[i] = nums[left];
            }
        }

        Arrays.stream(res).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
