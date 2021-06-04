package com.example.trees;

import java.util.*;

public class ChristmasSpruce {

    static Map<Integer, Node> mp = new HashMap<>();

    public static class Node {
        int v;
        List<Node> children;
        Set<Integer> leafChildren;
        boolean isLeaf;
        int parent;

        public Node(int v) {
            this.v = v;
            this.children = new ArrayList<>();
            this.leafChildren = new HashSet<>();
            this.isLeaf = true;
            this.parent = -1;
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
            mp.get(parent).isLeaf = false;
            if(mp.get(i+1).isLeaf)
                mp.get(parent).leafChildren.add(i+1);
            //mp.get(parent).children.add(mp.get(i+1));
            mp.get(i+1).parent = parent;
            if(mp.get(parent).parent != -1) {
                if(mp.get(mp.get(parent).parent).isLeaf) {
                    mp.get(mp.get(parent).parent).isLeaf = false;
                }
                mp.get(mp.get(parent).parent).leafChildren.remove(parent);
            }
        }

        for(Node node : mp.values()) {
            if(!node.isLeaf && node.leafChildren.size() < 3) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

}