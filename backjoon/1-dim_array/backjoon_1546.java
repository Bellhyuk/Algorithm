/*
<Problem> - 평균 No.1546
일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.09.
 * @version 1.0
 * 
 * <의사코드>
 * 배열 크기 N
 * 각 수 배열에 저장 및 최대값 추출 M
 * (각 값 더하기)/M*100/N
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();//배열 크기
		int idx=0;
		int[] arr = new int[size];
		for(int grade: arr) {//점수가 담긴 배열 생성
			arr[idx++]=sc.nextInt();
		}
		int max=0, sum=0;
		for(int i=0;i<size;i++) {//각 값의 합 및 최대값 추출 
			if(max<arr[i]) max=arr[i];
			sum += arr[i];
		}
		System.out.println(sum/max*100.0/size);//float를 곱해줌으로써 자동 형변환
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author hyunsu11
 * 
 * 배열을 쓰지않고 어떤 class를 쓴 것이 아닌 for문 하나만으로 구현
 * 값을 받자마자 바로 계산해서 합으로 정리 - 참고하자.
 * 
 */
class Main { 
	public static void main(String[]z){
		Scanner S = new Scanner(System.in);
		int R=0,H=0,a=S.nextInt(); //R=값들의 합, H=최대값, a=size
		for(int i=0;i<a;i++){
			int b=S.nextInt();
			R+=b;
			if(b>H) H=b;
		}
	System.out.print(R*100.0/(H*a));
	}
}
