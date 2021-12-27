package com.patterns.trees;

import java.util.*;

public class KefaAndPark {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cats = new int[n+1];
        for(int i=1; i<=n; i++) {
            cats[i] = sc.nextInt();
        }

        ArrayList<Integer>[] adjList = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=1; i<=n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }

        countPath(adjList, n, m, cats[1], 1, cats, new HashSet<>());

        System.out.println(count);
    }

    private static void countPath(ArrayList<Integer>[] adjList, int n, int m, int catsSeen, int i, int[] cats, Set<Integer> visited) {
        if(catsSeen > m) {
            return;
        }
        visited.add(i);
        boolean isLeaf = true;
        for (int k=0; k<adjList[i].size(); k++) {
            int j = adjList[i].get(k);
            if(!visited.contains(j)) {
                isLeaf = false;
                if(cats[j] == 1) {
                    countPath(adjList, n, m, catsSeen+1, j, cats, visited);
                } else {
                    countPath(adjList, n, m, 0, j, cats, visited);
                }
            }
        }
        if(isLeaf) {
            count++;
        }
    }

}