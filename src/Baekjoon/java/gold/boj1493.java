package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj1493 {
    static int[] cubeCnt,boxInfo,cubeSize;
    static int N,answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boxInfo = new int[3];
        for (int i = 0; i < 3; i++) {
            boxInfo[i] = Integer.parseInt(st.nextToken());
        }
        N = Integer.parseInt(br.readLine());
        cubeCnt = new int[20];
        cubeSize = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cubeSize[i] = Integer.parseInt(st.nextToken());
            cubeCnt[cubeSize[i]] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getLength(boxInfo));
    }

    public static int getLength(int[] box){
        for (int i = N-1; i > 0; i--) {
            int size = (int)Math.pow(2,cubeSize[i]);
            int cnt = 1;
            boolean flag = true;

            if(box[0]>=size&&box[1]>=size&&box[2]>=size){
                for (int j = 0; j < 3; j++) {
                    if(box[j]>=size){
                        int t = (int)(box[j]/size);
                        if(t>=cubeCnt[i]){}
                        if(box[j]%size!=0) flag = false;
                    }else{
                        flag = false;
                        break;
                    }
                }
                if(cnt<cubeCnt[i]){
                    cubeCnt[i] = 0;
                    cnt = cubeCnt[i];
                }
                else if(flag) {
                    return answer;
                }
                if(box[2]>N) {
                    answer+=getLength(new int[]{box[0], box[1], box[2] - N});
                }
                if(box[0]>N) {
                    answer +=getLength(new int[]{box[0] - N, box[1], N});
                }
                if(box[1]>N) {
                    answer +=getLength(new int[]{box[0], box[1] - N, N});
                }
            }
        }
        return answer;
    }
}
