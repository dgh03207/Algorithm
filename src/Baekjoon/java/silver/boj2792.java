package Baekjoon.java.silver;

import java.util.*;
import java.io.*;

public class boj2792 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr,Collections.reverseOrder());
        int right = arr.get(0);
        int left = 1;
        int sum = 0;
        int answer = 0;
        int mid = 0;
        while(left<=right){
            mid = (right+left)/2;
            sum = 0;
            for (int i = 0; i < M; i++) {
                sum+= Math.ceil((double)arr.get(i)/mid);
            }
            if(sum>N){
                left = mid+1;
            }else{
                answer = mid;
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
