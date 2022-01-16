package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj18232 {

    static int N,M,S,E,times[];
    static LinkedList<Integer>[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken())-1;
        E = Integer.parseInt(st.nextToken())-1;

        map = new LinkedList[N];
        times = new int[N];

        for (int i = 0; i < N; i++) {
            map[i] = new LinkedList<>();
            times[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x].offer(y);
            map[y].offer(x);
        }

        bfs();
        System.out.println(times[E]);
    }

    private static boolean isRange(int n) {
        return n >= 0 && n < N;
    }


    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{S,0});
        times[S] = 0;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int next = temp[0];
            int time = temp[1];

            if(times[next]<time) continue;
            times[next] = time;
            time+=1;
            if(next==E) continue;

            //텔레포트로 이동할 수 있는지
            for (int i = 0; i < map[next].size(); i++) {
                if (times[map[next].get(i)] > time) {
                    times[map[next].get(i)] = time;
                    queue.add(new int[]{map[next].get(i), time});
                }
            }
            if (isRange(next + 1)&&times[next+1]>time) {
                times[next+1] = time;
                queue.add(new int[]{next + 1, time});
            }
            if (isRange(next - 1)&&times[next-1]>time){
                times[next-1] = time;
                queue.add(new int[]{next - 1, time});
            }
        }

    }
}
