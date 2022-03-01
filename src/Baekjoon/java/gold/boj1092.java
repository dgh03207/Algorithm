package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//배
public class boj1092 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] boxes = new int[M];
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);
        Arrays.sort(boxes);


        int answer = 0;

        cannotMove:
        while(M>=0){
            answer +=1;
            for (int i = N-1; i >= 0; i--) {
                if(M==0) break cannotMove;
                if(weights[N-1]<boxes[M-1]){
                    answer = -1;
                    break cannotMove;
                }
                for (int j = M-1; j >=0 ; j--) {
                    if(weights[i]>=boxes[j]){
                        boxes[j]=-1;
                        break;
                    }
                }
            }
            answer +=1;
        }

        System.out.println(answer);

    }
}
