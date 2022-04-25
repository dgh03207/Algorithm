package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        double[] lan = new double[K];
        for (int i = 0; i < K; i++) {
            lan[i] =Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);
        long left = 1;
        long right = (long)lan[K-1];
        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2;
            long cut = 0;

            for (int i = 0; i < K; i++) {
                cut += Math.floor(lan[i]/mid);
                if(cut>=N){
                    answer= mid;
                    left = mid+1;
                    break;
                }
            }
            if(cut<N){
                right = mid-1;
            }
        }

        System.out.println(answer);
    }
}
