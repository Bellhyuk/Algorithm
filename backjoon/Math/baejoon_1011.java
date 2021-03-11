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
 * 1. 1 2 3 4 5 6 초항1 등차1 등차수열의 합이 dist-1을 넘지 않을 때까지 횟수
 * 2. 0~30의 경우 초과하기 전 3번째까지 건드리나 어떻게든 수가 처리되며 횟수는 최대 횟수가 일정하게 유지되는 것을 확인할 수 있음
 * -> 등차수열의 합으로 나눈 값+1로 구할 수 있다.
 * 
 * 잘못 알고 있었다.. 도착할때 무조건 1이 아니라 1광년이 될 수 있게 만들어야한다는 거였다니...
 * 
 */
import java.util.*;
  public class Main {
  	public static void main(String args[]) {
  	  Scanner sc = new Scanner(System.in);
  	  int test=sc.nextInt();
  	  while(test-->0) {
  	    int start = sc.nextInt(), end = sc.nextInt();
  	    long dist= end-start, cnt=1;
  	    while(true){
          if(Math.ceil((double)dist/2)<=cnt*(1+cnt)/2){
              cnt--;
              break;
            }
          cnt++;
  	    }
  	    if(dist<=1) cnt=1;
  	    else if(Math.ceil((double)dist/2)>cnt*(cnt+1)/2) cnt = cnt * 2 + 1;
  	    else cnt = cnt*2;
  	    System.out.println(cnt);
  	  }
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
/*public class Main {
	public static void main(String[] args) throws IOException{

	}
}*/
