package com.patterns.trees;

import java.util.*;

public class BmailComputerNetwork {

    public static class Node {
        int val;
        int parent;

        public Node(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<Integer, Node> mp = new HashMap<>();
        Node root = new Node(1, -1), temp;
        mp.put(1, root);
        for (int i=2; i<=n; i++) {
            mp.put(i, new Node(i, sc.nextInt()));
        }
        temp = mp.get(n);
        List<Integer> ans = new ArrayList<>();
        while(temp.parent != -1) {
            ans.add(temp.val);
            temp = mp.get(temp.parent);
        }
        ans.add(temp.val);
        Collections.reverse(ans);
        for(int i : ans) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

}