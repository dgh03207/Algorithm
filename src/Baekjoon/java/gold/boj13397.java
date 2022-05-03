package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj13397 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int answer = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[][] prefix = new int[N][N];

        for (int i = 0; i < N; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j < N; j++) {
                if (i==j){
                    prefix[i][j] = nums[i];
                }else{
                    if(nums[j]>max){
                        max = nums[j];
                    }else if(nums[j]<min){
                        min = nums[j];
                    }
                    prefix[i][j] = max-min;
                }
            }
        }

        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int left = 0;
        int right = sorted[N-1]-sorted[0];
        int maxValue = 0;
        answer = right;
        while(M>1&&left<=right){
            int mid = (left+right)/2;
            maxValue= 0;
            int cnt = 0;
            for (int i = N-1; i >=0;) {
                if(cnt>M) break;
                cnt+=1;
                int j = i;

                while(j>=0){
                    if(prefix[j][i]>mid){
                        if(i!=j){
                            maxValue = Math.max(maxValue,prefix[j+1][i]);
                            break;
                        }
                    }
                    j-=1;
                }
                i=j;
            }
            if(cnt<=M){
                answer = Math.min(answer,mid);
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(answer);
    }
}
