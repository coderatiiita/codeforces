package com.example.dfs;

import java.util.*;

public class Reposts {

    static Map<String, List<String>> adjList = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        while(n-->0) {
            String s=sc.nextLine();
            while(s.equals(""))
                s=sc.nextLine();
            String[] list = s.split(" ");
            if(!adjList.containsKey(list[2].toLowerCase())) {
                adjList.put(list[2].toLowerCase(), new ArrayList<>());
            }
            if(!adjList.containsKey(list[0].toLowerCase())) {
                adjList.put(list[0].toLowerCase(), new ArrayList<>());
            }
            adjList.get(list[2].toLowerCase()).add(list[0].toLowerCase());
        }
        System.out.println(maxDepth("polycarp"));
    }

    private static int maxDepth(String node) {
        if(adjList.get(node).size() == 0) {
            return 1;
        }
        int depth = 0;
        for(int i=0; i<adjList.get(node).size(); i++) {
            depth = Math.max(maxDepth(adjList.get(node).get(i))+1, depth);
        }
        return depth;
    }

}
