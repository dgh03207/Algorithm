package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16988 {
    static int N,M,board[][];
    static int[] selected;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        selected = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private static void combi(int cnt, int start){
        if(cnt==2){
            int r1 = selected[0]/N;
            int c1 = 0;
            if(selected[0]%N==0) c1=N-1;
            else c1=selected[0]%N-1;

            int r2 = selected[1]/N;
            int c2 = 0;
            if(selected[1]%N==0) c2=N-1;
            else c1=selected[1]%N-1;

            dfs(r1,c1,r2,c2);
            return;
        }
        for (int i = start; i < N*M; i++) {
            int r = i/N;
            int c = 0;
            if(i%N==0) c=N-1;
            else c=i%N-1;

            if(board[r][c]!=0) continue;
            selected[cnt] = i;
            combi(cnt+1,start+1);
        }

    }
    private static void dfs(int r1,int c1,int r2,int c2){

    }
}
