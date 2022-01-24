package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//완전 범죄
public class boj13700 {
    static int N,S,X,D,F,B,K,move_cnt[];
    static int dr[];
    static boolean[] buildings;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken())-1;
        D = Integer.parseInt(st.nextToken())-1;
        F = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dr = new int[]{F,-B};
        move_cnt = new int[N];
        Arrays.fill(move_cnt,Integer.MAX_VALUE);

        buildings = new boolean[N];

        if(K>0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                buildings[Integer.parseInt(st.nextToken())-1] = true;
            }
        }
        bfs();

        if(move_cnt[D]==Integer.MAX_VALUE) System.out.println("BUG FOUND");
        else System.out.println(move_cnt[D]);

    }

    private static boolean isRange(int a){
        return a>=0&&a<N;
    }

    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S,0});
        move_cnt[S] = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nr = now[0]+dr[i];
                int cnt = now[1]+1;
                if(isRange(nr)&&cnt<move_cnt[nr]&&!buildings[nr]){
                    move_cnt[nr] = cnt;
                    if(nr!=D) queue.add(new int[]{nr,cnt});
                }
            }
        }

    }
}
