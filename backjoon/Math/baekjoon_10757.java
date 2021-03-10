package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
<Problem> - 큰 수 A+B No.10757번
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
첫째 줄에 A와 B가 주어진다.(A,B는 매우 큰 정수)
첫째 줄에 A+B를 출력
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.10.
 * 
 * <의사코드>
 * 도통 갈피를 못잡겠다.. 기본 함수를 이용한 알고리즘으로는 어떻게 풀까?
 * 단순히 int가 아닌 math 클래스 내 큰 수를 다루는 클래스 BigInteger 클래스를 사용
 * long 타입 값을 넘어선 값의 합을 구해야하는 경우, Java는 BigInteger 클래스를 이용할 수 있다.
 * 하지만 C의 경우 알고리즘으로 풀어야하는데 이는 각 수를 개별적으로 더하고
 * 이를 String화하여 만들어 줄 수 있다고 생각한다.
 */
import java.util.*;
  public class Main {
  	public static void main(String args[]) {
  	  Scanner sc = new Scanner(System.in);
  	  BigInteger big1 = new BigInteger(sc.next());
  	  BigInteger big2 = new BigInteger(sc.next());
  	  
  	  System.out.print(big1.add(big2));
  	}
  }
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author thgml111
 * 
 * 읽어와야하는 수가 크기때문에 BufferedReader와 StringBuilder 사용
 * 뒤에서부터 각각 더하고 올려주는 식으로 계산하여 sb에 append해줌
 * 그리고 append가 앞에서부터 이뤄지니 reverse를 통해 뒤집어준다.
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringBuilder sb = new StringBuilder();
	  String[] inputs = br.readLine().split(" "); // A, B 받기
	  
	  int flag = 0;//값의 합이 10이 넘어 값을 넘겨줘야하는지 확인
	  
	  for(int i=inputs[0].length()-1, j=inputs[1].length()-1; i>=0||j>=0; i--,j--) {
	    int num = flag;
	    if(i>=0)num += inputs[0].charAt(i) - '0';
	    if(j>=0)num += inputs[1].charAt(j) - '0';
	    if(num>10) {
	      flag = 1;
	      num -= 10;
	    }else flag=0;
	    sb.append(num);
	  }
	  if(flag==1) sb.append(1);
	  
	  System.out.println(sb.reverse());
	}
}
