package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 네 번째 점 3009번
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서
필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다.
좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.24.
 * 
 * <의사코드>
 * x 좌표 끼리 비교해서 같은 값이 존재하지 않으면 해당 값 x좌표 할당
 * y 좌표 마찬가지
 * -> 점들의 x 좌표끼리 y좌표 끼리 모았을 때 중복이 존재해야 직사각형이 형성된다.
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] xaxis = new int[1001];
    int[] yaxis = new int[1001];
    for(int i=0;i<3;i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      xaxis[Integer.parseInt(st.nextToken())]++;
      yaxis[Integer.parseInt(st.nextToken())]++;
    }
    int idx=0;
    for(int num:xaxis) {
      if(num==1) sb.append(idx).append(" ");
      idx++;
    }
    idx=0;
    for(int num:yaxis) {
      if(num==1) sb.append(idx);
      idx++;
    }
    System.out.println(sb);
 }
}
/**
 * Best Coding(코드도 적당히 짧고 메모리와 시간이 작은 것을 중심으로)
 * @author msjun23
 * 
 * x, y를 3개 받으면서 리턴 값을 저장할 공간을 하나 더 여유롭게 잡음
 * 그리고 if else if else를 통해 3개니까 가능한 알고리즘
 * 괜히 for문을 쓰는 것보다 낫네..
 * 
 */
public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int x[] = new int[4];
    int y[] = new int[4];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }
    
    if (x[0] == x[1]) x[3] = x[2];
    else if(x[0] == x[2]) x[3] = x[1];
    else x[3] = x[0];
    
    if (y[0] == y[1]) y[3] = y[2];
    else if(y[0] == y[2]) y[3] = y[1];
    else y[3] = y[0];
    
    System.out.println(x[3] + " " + y[3]);
  }
}
