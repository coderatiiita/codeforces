package com.example.binarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistancesToZero {

    static List<Integer> zeroIndex = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
            if(nums[i] == 0) {
                zeroIndex.add(i);
            }
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            int idx = bSearch(i);
            if(idx==-1) {
                res[i] = Math.abs(i-zeroIndex.get(0));
            } else if(idx == zeroIndex.size()-1){
                res[i] = Math.abs(i-zeroIndex.get(zeroIndex.size()-1));
            } else {
                res[i] = Math.min(Math.abs(i-zeroIndex.get(idx)),
                                    Math.abs(i-zeroIndex.get(idx+1)));
            }
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
    }

    private static int bSearch(int i) {
        int l=0, r=zeroIndex.size()-1;
        int idx=-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(zeroIndex.get(mid) <= i) {
                idx = mid;
                l = mid+1;
            } else {
                r=mid-1;
            }
        }
        return idx;
    }

}