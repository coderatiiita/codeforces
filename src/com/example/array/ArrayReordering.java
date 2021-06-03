package com.example.array;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayReordering {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n=sc.nextInt();
            int[] arr = new int[n];
            List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                if(arr[i] % 2 == 0) {
                    even.add(arr[i]);
                } else {
                    odd.add(arr[i]);
                }
            }
            int evens = even.size(), odds= odd.size();
            int ans=evens * (evens-1)/2;
            ans+=odds*evens;

            for(int i=0; i<odd.size(); i++) {
                for(int j=i+1; j<odd.size(); j++) {
                    if(gcd(odd.get(i), odd.get(j)) > 1) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }
}