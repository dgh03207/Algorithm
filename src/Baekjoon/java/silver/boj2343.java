package Baekjoon.java.silver;

import java.io.*;
import java.util.*;

public class boj2343 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] video = new int[N];
        for (int i = 0; i < N; i++) {
            video[i] = Integer.parseInt(st.nextToken());
        }
        int right = Arrays.stream(video).sum();
        int left = 1;
        int mid = 0;
        int answer = 0;
        while(left<=right){
            int cnt = 0;
            int sum =0;
            mid = (right+left)/2;
            for(int i=0;i<N;i++){
                if(mid<video[i]){
                    cnt = M+1;
                    break;
                }
                sum += video[i];
                if(cnt>M) break;
                if(sum>mid){
                    cnt +=1;
                    sum = video[i];
                }else if(sum==mid){
                    cnt +=1;
                    sum = 0;
                }
            }
            if(sum>0) cnt+=1;
            if(cnt>M){
                left = mid+1;
            }else{
                right = mid-1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
