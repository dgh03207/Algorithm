package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

//내 선물을 받아줘 2
public class boj15886 {
    static int N;
    static HashSet<Integer> set = new HashSet<>();
    static String[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = br.readLine().split("");

        for (int i = 0; i < N; i++) {
            boolean[] check = new boolean[N];
            dfs(i,map,check);
        }
        System.out.println(set.size());

    }
    private static void dfs(int n, String[] str,boolean[] check){
        if(set.contains(n)) return;
        if(check[n]){
            set.add(n);
            return;
        }

        check[n] = true;
        if(map[n].equals("E")) dfs(n+1,str,check);
        else dfs(n-1,str,check);
    }

}
