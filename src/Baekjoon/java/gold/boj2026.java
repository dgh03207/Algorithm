package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj2026 {
   static int N,K;
   static boolean flag;
   static boolean[][] isFriends;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        isFriends = new boolean[N][N];
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            isFriends[a][b] = true;
            isFriends[b][a] = true;
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(isFriends[i][j]) cnt++;
            }
            if(cnt>=K-1){

            }
        }
    }
    
    private static void dfs(int now,int idx,boolean[] checked){
        if(flag) return;
        
        if(idx==K){
            return;
        }
        for (int i = 0; i < N; i++) {
            if(checked[i]||!isFriends[now][i]) continue;
            
        }
        
    }
}
