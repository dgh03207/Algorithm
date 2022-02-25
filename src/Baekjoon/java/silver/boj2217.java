package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//로프
public class boj2217 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weight);

        int w = 0;
        int answer = 0;
        int cnt = 1;
        for (int i = N-1; i >= 0; i--) {
            w += weight[i];
            if(answer < w*cnt){
                answer = w*cnt;
            }
            cnt ++;
        }
        System.out.println(answer);

    }
}
