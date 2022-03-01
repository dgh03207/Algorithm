package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//센서
public class boj2212 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int answer = 0;
        if(N>K) {
            int[] sensors = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sensors[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sensors);
            int[] distance = new int[N - 1];
            for (int i = 0; i < N - 1; i++) {
                distance[i] = Math.abs(sensors[i] - sensors[i + 1]);
            }

            answer = Arrays.stream(distance).sorted().limit(N - K).sum();
        }
        System.out.println(answer);
    }
}
