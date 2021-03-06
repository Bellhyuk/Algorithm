package practice;
/*
<Problem> - Fly me to the Alpha Centauri
공간이동 장치는  k광년을 이동하였을 때는 k-1 , k 혹은 k+1 광년만을 다시 이동할 수 있다.
예를 들어, 이 장치를 처음 작동시킬 경우 -1 , 0 , 1 광년을 이론상 이동할 수 있으나
사실상 음수 혹은 0 거리만큼의 이동은 의미가 없으므로 1 광년을 이동할 수 있으며,
그 다음에는 0 , 1 , 2 광년을 이동할 수 있는 것이다. 
( 여기서 다시 2광년을 이동한다면 다음 시기엔 1, 2, 3 광년을 이동할 수 있다. )

x지점에서 y지점을 향해 최소한의 작동 횟수로 이동하려 한다.
하지만 y지점에 도착해서도 공간 이동장치의 안전성을 위하여 y지점에 도착하기
바로 직전의 이동거리는 반드시 1광년으로 하려 한다.

입력: 테스트케이스의 개수 T, 각각의 테스트 케이스에 대한 현재 위치 x와 목표 위치 y가 정수로
순서대로 주어진다.(0 ≤ x < y < 2^31)

출력: 각 테스트 케이스에 대해 x지점에서 y지점까지 정확히 도달하는데 필요한 최소한의 횟수

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.11.
 * 
 * <의사코드>
 * 정확히 도달해아하는 것이 중요하다.
 * 도착지점 1광년 전 지점까지 도착하는데 필요한 횟수를 구하고 1를 더해준다.
 * k광년 이동 후 k-1. k, k+1 광년만큼 이동할 수 있다.
 * 지점에 상관없이 거리에 의존
 * 
 * x지점과 y지점 사이의 거리 dist = y-x
 * 계산에 필요한 거리 dist-1
 * 최소 이동을 위해 각 회차당 될수록 많은 거리를 이동
 *
 * 잘못 알고 있었다.. 도착할때 무조건 1이 아니라 1광년이 될 수 있게 만들어야한다는 거였다니...
 * 1 - 1           1
 * 2 - 1 1         2
 * 3 - 1 1 1       3
 * 4 - 1 2 1       3
 * 5 - 1 2 1 1     4
 * 6 - 1 2 2 1     4
 * ...
 * 3부터 같은 횟수가 일정한 규칙에 따라 적용된다.
 * 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 * 3 3 4 4 5 5 5 6  6  6  7  7  7  7  8  8  8  8
 *  2   2    3      3         4           4
 * 
 * 
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  public class Main {
  	public static void main(String args[]) {
  	  Scanner sc = new Scanner(System.in);
  	  int test=sc.nextInt();
  	  while(test-->0) {
  	    long start = sc.nextInt(), end = sc.nextInt(), cnt=0;
  	    long dist = end-start;
        int flag=0;
        long a = dist-3, b=2;
  	    if(dist==1) cnt=1;
  	    else if(dist==2) cnt=2;
  	    else {
  	      while(true) {
  	        if(a>=b) a-=b;
  	        else {
  	          cnt = b*2-1;
  	          break;
  	        } 
  	        if(a>b) a-=b;
  	        else {
  	          cnt = b*2;
  	          break;
  	        }
  	        b++;
  	      }
  	    }
  	    System.out.println(cnt);
  	  }
  	}
  }
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author ooop0422
 * 
 * 거리가 제곱수되는 지점을 기준으로 횟수 값이 증가하는 것을 확인할 수 있다.
 * 거리 값의 제곱근 j을 기준으로 그 다음 제곱수까지의 범위를 생각하자.
 * distance = n * n -> 2n-1
 * 제곱수를 기준으로 distance의 제곱근 수만큼 횟수 반복
 * distance <= n*(n+1) -> 2n
 * 그 이후 값은 제곱근 값만큼 회수를 또 반복
 * -> 2n+1
 * 이를 통해 계산할 수 있다.
 * 
 */
  
public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for(int i=0 ; i<T ; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        double distance = y-x;

        double dsqrt = Math.sqrt(distance);
        int nsqrt = (int) dsqrt;
        if(distance == nsqrt*nsqrt)//거리가 제곱수인 경우
            sb.append(2*nsqrt-1).append("\n");
        else if (distance <= nsqrt*(nsqrt+1))//제곱수를 기준보다 크면서 그 다음 제곱수까지 제곱근 값만큼 수가 반복되므로
            sb.append(2*nsqrt).append("\n");
        else //
            sb.append(2*nsqrt+1).append("\n");
    }
    System.out.println(sb);
	}
}

