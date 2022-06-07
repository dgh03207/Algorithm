package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15684 {
    static int extra;
    static int N,M,H;
    static boolean success;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        extra = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boolean[][] ladders = new boolean[H][N];
        if(M>0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int h = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                ladders[h][n] = true;
            }
        }
        dfs(0,0,ladders,0);
        if(!success){
            while(extra<3&&!success){
                int[] dn = new int[]{1,-1};
                int[] dh = new int[]{0,0};
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < N; j++) {
                        if(i<N-1&&ladders[i][j+1]) continue;
                        if(i>0&&ladders[i][j-1]) continue;
                        ladders[i][j] = true;
                        dfs(0,0,ladders,0);
                    }
                }
            }

        }

        System.out.println(extra);
    }

    private static void dfs(int depth,int now, boolean[][] ladders,int start){
        if(depth==H){
            if(start==now) return;
        }
        for (int i = 0; i < N; i++) {
            if(depth==0) start = i;
            if(i>0){
                if(ladders[depth][i-1]){
                    dfs(depth+1,i-1,ladders,start);
                }
            }
            if(i<N-1){
                if(ladders[depth][i+1]){
                    dfs(depth+1,i+1,ladders,start);
                }
            }
        }
    }
}
