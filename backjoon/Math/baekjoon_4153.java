package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 직각삼각형 4153번
주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다.
각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.26.
 * 
 * <의사코드>
 * 직각삼각형 판단 -> 피타고라스 정리 A에서 직각을 이루는 두변 x, y와 A의 대변을 z라할 때,
 * x^2 + y^2 = z^2
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(1>0) {
      String str=br.readLine();
      if(str.equals("0 0 0")) break;
      else {
        int[] nums = new int[3];
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<3; i++){
          nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        if((nums[0]*nums[0] + nums[1]*nums[1]) == nums[2]*nums[2]) sb.append("right").append("\n");
        else sb.append("wrong").append("\n");
      }
    }
    System.out.print(sb.toString());
 }
}
/**
 * Best Coding(코드도 적당히 짧고 메모리와 시간이 작은 것을 중심으로)
 * @author  dlwodnsdl
 * 
 */
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] reader=new String[3];
    int a=0;
    int b=0;
    int c=0;
  for(;;){
    reader=br.readLine().split(" ");
    a=Integer.parseInt(reader[0]);        
    if(a==0){
      break;
    }
        b=Integer.parseInt(reader[1]);      
        String d=reader[2];
        c=Integer.parseInt(d);
    if((a*a+b*b==c*c)||((a*a+c*c==b*b)||(a*a==b*b+c*c))){
      System.out.println("right");
    }else{
      System.out.println("wrong");
    }
  }
 }
}
