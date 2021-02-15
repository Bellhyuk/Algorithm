/*
<Problem> - 다이얼 No.5622번

전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다.
숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때,
각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.

할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.

첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.15.
 * 
 * <의사코드>
 * 한 칸당 1초
 * 단어가 존재하지 않는 1과 0은 제외
 * 아스키코드 값으로 범위 지정
 * 문자열을 받고 각 값 하나씩 받아서 비교해 숫자확인
 * 각 숫자에+2 값 시간에 더해주기
 * 
 * System.in.read() 활용!!
 * 
 */
import java.util.*;
import java.io.IOException;
public class Main {
	public static void main(String args[]) throws IOException{
		int num, time=0;
		while((num=System.in.read())>=65) {
			if(num>='A' && num<='C') time+=3;
			else if(num>='D' && num<='F') time+=4;
			else if(num>='G' && num<='I') time+=5;
			else if(num>='J' && num<='L') time+=6;
			else if(num>='M' && num<='O') time+=7;
			else if(num>='P' && num<='S') time+=8;
			else if(num>='T' && num<='V') time+=9;
			else time+=10;
		}
		System.out.println(time);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author hyunsu11
 * 
 * 아예 다이얼 값을 넣어 놓고 시작
 * charAt()을 활용하여 배열 T와 값 비교
 * 
 */
public class Main {
	public static void main(String[] args){
		String S=new Scanner(System.in).next();
		int R=0,T[]={0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7};
		for(int i=0;i<S.length();i++){
			R+=T[S.charAt(i)-65]+3;
			}
		System.out.print(R);
	}
}
