package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1755 {
	//숫자 놀이
	static ArrayList<String> numbers = new ArrayList<>();	//0인덱스에는 zero one인덱스에는 two와 같이 담기위해 ArrayList 생성
	 
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//numbers 배열에 담기위해 number배열에 순서대로 숫자 텍스트를 넣음
		String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
				
		//숫자 텍스트를 numbers라는 ArrayList에 담는 작업
		for (int n = 0; n < 10; n++) {
			numbers.add(number[n]);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//M이상 N이하의 정수를 받아옴
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int size = N-M;
		String[] inputN = new String[size+1];						// 입력받은 숫자를 받아올 inputN배열
		int a =-1;													// inputN배열에 0번 인덱스부터 순서대로 담아오기위한 인덱스 변수 a
		for (int i = M; i <= N; i++) {
			String num = Integer.toString(i);						// inputN배열에 숫자를 받아오기전에, convert를 통해 0->zero와 같이 바꾸는 작업을 진행함
			inputN[++a] = convert(num);								// 0->zero와같이 바꾸는 convert를 진행하기위한 convert() 함수
		}

		Arrays.sort(inputN);										// 변한이 끝난 배열을 정렬해주는 작업
		
		int cnt = 0;												//10개씩 출력해주기위한 cnt 변수
		for (int i = 0; i <= size; i++) {							
			cnt++;													// for문마다 1씩 증가시켜줌
			sb.append(encoding(inputN[i]));							// 스트링빌더에 encoding이 완료된 inputN의 요소를 담아줌
			if(cnt%10==0) sb.append("\n");							// cnt가 10의 배수가 되면, 줄바꿈을 스트링 빌더에 추가함
			else sb.append(" ");									// 10의 배수가 아니면, 숫자끼리 띄워주기위해 띄어쓰기를 스트링 빌더에 추가함
		}
		
		System.out.println(sb.toString());
	}
	
	// 0->zero와 같은 변환 작업이 진행된 스트링을 반환하는 convert 함수
	private static String convert(String num) {
		String converted = "";
		
		for (int i = 0; i < num.length(); i++) {					// 받아온 숫자의 길이 만큼 for문을 돌려주는데,
			int temp = Integer.parseInt(num.split("")[i]);			// 받아온 숫자를 split한 것을 숫자로 만들어 temp에 저장함
			if(num.length()==1)										// 두자리 숫자인 경우 가운데를 띄워주기위해 if문으로 경우를 나눔
				converted +=numbers.get(temp);						// numbers배열에 temp인덱스에 해당하는 텍스트를 받아와 encoded 변수에 추가함
			else if(i==0){
				converted +=numbers.get(temp)+" ";					// num길이가 1이 아니면서 i가 0일경우 띄어쓰기를 추가함
			}else {
				converted +=numbers.get(temp);
			}
		}
		
		return converted;											// 최종적으로 변환된 텍스트 반환
	}
	
	// convert된 스트링을 다시 원상복귀 시켜 encoded된 스트링을 반환하는 encoding 함수
	private static String encoding(String num) {					
		String encoded = "";
		String[] temp = num.split(" ");								// " "빈칸으로 띄어쓰기 된 것대로 num을 나눠 temp 배열에 저장함
		if(temp.length==1) {										// 배열의 크기가 1인경우 numbers에서 temp에 해당하는 인덱스를 스트링으로 변환시켜 반환함 
			return Integer.toString(numbers.indexOf(temp[0]));
		}else {
			for (int i = 0; i < 2; i++) {							// 배열의 크기가 2인경우는 두자리 숫자인 경우이므로, for문으로 하나씩 변환시켜 encoded 변수에 저장할 것임
				encoded+= Integer.toString(numbers.indexOf(temp[i]));//numbers 배열에서 temp[i]에 해당하는 인덱스를 텍스트로 변환시켜서 encoded 변수에 추가시킴
			}
		}
		
		return encoded;												// encoded 변수를 반환함
	}
}
