package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3079 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long answer = Long.MAX_VALUE;
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }
        

        Arrays.sort(T);

        long left = 0;
        long right = Long.MAX_VALUE;
        while(left<=right){
            long mid = (left+right)/2;
            if(answer < mid) break;
            long cnt = 0;
            for (int j = 0; j < N; j++) {
                if(mid<T[j]) break;
                if(cnt>=M) break;
                cnt += mid/T[j];
            }
            if(cnt>=M){
                right = mid-1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }

        System.out.println(answer);


    }
}
