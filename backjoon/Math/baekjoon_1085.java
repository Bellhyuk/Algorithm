package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 직사각형에서 탈출 1085번
한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고,
오른쪽 위 꼭짓점은 (w, h)에 있다.
직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 x, y, w, h가 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.24.
 * 
 * <의사코드>
 * x와 w를 비교. y와 h를 비교
 * 두 값에서 가장 작은 값을 출력
 * 총 3번의 비교
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int x = Integer.parseInt(str[0]);
    int y = Integer.parseInt(str[1]);
    int w = Integer.parseInt(str[2]);
    int h = Integer.parseInt(str[3]);
    int minx = (x>=w-x) ? w-x : x;
    int miny = (y>=h-y) ? h-y : y;
    int min = (minx>=miny) ? miny : minx;
    System.out.println(min);
 }
}
/**
 * Best Coding(메모리와 시간이 작은 것을 중심으로)
 * @author alsxmqkqh23
 * 
 * for문으로 비교해도 좋지.. 배열에 초기화를 수식으로 하는 발상은 기억해두자.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());
        
    //x,w-x,y,h-y중 가장 작은 값
    int[] arr = {x,w-x,y,h-y};
    int min = x;
    for(int i=0;i<arr.length;i++) {
      if(min > arr[i]) {
        min = arr[i];
      }
    }
    System.out.println(min);
  }
}
