package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16964 {
    static int N,answer[];
    static boolean[][] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        answer = new int[N];

        graph = new boolean[N][N];
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
            graph[b][a] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);
    }

    private static void dfs(int n,int order){
        if(n==N){
            return;
        }

        for (int i = 0; i < N; i++) {
            if(i!=n&&graph[n][i]){
            }
        }
    }
}
