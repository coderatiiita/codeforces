package com.example.trees;

import java.util.*;

public class ChristmasSpruce {

    static Map<Integer, Node> mp = new HashMap<>();

    public static class Node {
        int v;
        List<Node> children;

        public Node(int v) {
            this.v = v;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Node root = new Node(1);
        mp.put(1, root);

        for(int i=1; i<=n-1; i++) {
            int parent = sc.nextInt();
            if(!mp.containsKey(parent)) {
                mp.put(parent, new Node(parent));
            }
            if(!mp.containsKey(i+1)) {
                mp.put(i+1, new Node(i+1));
            }
            mp.get(parent).children.add(mp.get(i+1));
        }

        //for(Node node : mp.)
    }

}