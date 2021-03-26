import java.io.*;
import java.util.*;
/*
<Problem> - 터렛 1002번
각자 터렛에 근무하고 있다.
조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
한 줄에 x1, y1, r1, x2, y2, r2가 주어진다.
x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고,
r1, r2는 10,000보다 작거나 같은 자연수이다.

출력
각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다.
만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.26.
 * 
 * <의사코드>
 * (x1, y1)과 (x2, y2) 사이의 거리 d
 * d = sqrt((x1-x2)^2+(y1-y2)^2)
 * d > r1+r2 -> 0
 * d = r1+r2 -> 1
 * d < r1+r2 -> 2
 * x1==x2 && y1==y2 && r1==r2 -> -1
 * 
 * 그림을 그려서 모든 경우의 수를 살펴보자. 머리로만 그리려니까 몇몇 경우의 수를 빼먹는다..
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int test = Integer.parseInt(br.readLine());
    while(test-->0) {
      String[] read = br.readLine().split(" ");
      int x1 = Integer.parseInt(read[0]);
      int y1 = Integer.parseInt(read[1]);
      int r1 = Integer.parseInt(read[2]);
      int x2 = Integer.parseInt(read[3]);
      int y2 = Integer.parseInt(read[4]);
      int r2 = Integer.parseInt(read[5]);
      double d = Math.sqrt((x1-x2)*(x1-x2)+ (y1-y2)*(y1-y2));
      if(x1==x2 && y1==y2 && r1==r2) sb.append(-1).append("\n");
      else if(d>r1+r2 || d<Math.abs(r1-r2)) sb.append(0).append("\n");
      else if(d==r1+r2 || d==Math.abs(r1-r2)) sb.append(1).append("\n");
      else sb.append(2).append("\n");
    }
    System.out.println(sb);
  }
}
