package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5567 {
    static int N,M,cnt;
    static boolean[] checked;
    static boolean[][] relation;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cnt = 0;
        checked = new boolean[N+1];
        relation = new boolean[N+1][N+1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b]= true;
            relation[b][a] = true;
        }
        checked[1] = true;
        dfs(0,1);
        System.out.println(cnt);
    }
    private static void dfs(int depth,int now){
        if(depth==2){
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!relation[now][i]) continue;
            if(!checked[i]){
                cnt+=1;
            }
            checked[i] = true;
            dfs(depth+1,i);
        }
    }
}
