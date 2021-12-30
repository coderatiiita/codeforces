package com.patterns.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegerDiversity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] < 0) {
                    arr[i] = -arr[i];
                }
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }

            int count=0;

            for(int key : map.keySet()) {
                if (key == 0 || map.get(key) == 1) {
                    count += 1;
                } else if (map.get(key) > 1) {
                    count += 2;
                }
            }

            System.out.println(count);
        }

    }
}
