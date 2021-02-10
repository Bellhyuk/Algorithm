/*
<Problem> - 평균은 넘겠지 No.4344

첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.10.
 * @version 1.0
 * 
 * <의사코드>
 * 테스트 케이스 - 첫번째 for문 기준
 * 평균이 넘는 학생들의 비율을 반올림하여 소수점 셋째짜리까지 출력
 * 1)평균 계산(점수 합/학생 수) - for문
 * 2)평균과 개별 점수 비교해서 넘으면 count - for문
 * 3)학생 비율(count/학생수*100%) 출력
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int loop = sc.nextInt(), i=0;i<loop;i++) {//테스트 케이스만큼 반복
			int stunum = sc.nextInt(), sum=0, ave=0;
			int[] grade = new int[stunum];
			//평균 계산
			for(int j=0;j<stunum;j++) {
				grade[j] = sc.nextInt();
				sum += grade[j];
			}
			ave = sum/stunum;
			int count = 0;
			//값 비교 및 count
			for(int a: grade) {
				if(a>ave) count++;
			}
			//학생 비율 계산 및 출력
			System.out.printf("%.3f%%", count*100.0/stunum);
			System.out.println("");
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author kahowt
 * 
 * printf를 이용한 나와 달리 String.foramt() 방식을 이용함.
 * 
 */
class Main { 
	public static void main(String[]z){
		Scanner s=new Scanner(System.in);
		int C=s.nextInt(),i=0;
		for(;i<C;i++){
			int N=s.nextInt(),j=0,a[]=new int[N],c=0,w=0,p=0;
			for(;j<N;j++){
				a[j]=s.nextInt();
				c+=a[j];
			}
			for(;w<N;w++){
				if(a[w]>(double)c/N) p++; 
			}
			System.out.println(String.format("%.3f", ((double)p/N*100))+"%");
		}
	}
}


