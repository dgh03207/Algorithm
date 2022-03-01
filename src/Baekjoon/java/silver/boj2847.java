package Baekjoon.java.silver;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//게임을 만든 동준이
public class boj2847 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        if(N>=2) {
            int prev = scores[N-1];
            for (int i = N - 2; i >= 0; i--) {
                int now = scores[i];
                if(now>=prev){
                    int minus = now-prev+1;
                    now-= minus;
                    answer += minus;
                }
                prev = now;
            }
        }

        System.out.println(answer);

    }
}
