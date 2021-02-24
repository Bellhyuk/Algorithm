package practice;
/*
<Problem> - ACM호텔 No.10250번
호텔 정문으로부터 걷는 거리가 가장 짧도록 방을 배정하는 프로그램을 작성하고자 한다.

문제를 단순화하기 위해서 호텔은 직사각형 모양이라고 가정하자. 각 층에 W 개의 방이 있는 H 층 건물이라고 가정하자 (1 ≤ H, W ≤ 99). 그리고 엘리베이터는 가장 왼쪽에 있다고 가정하자(그림 1 참고). 이런 형태의 호텔을 H × W 형태 호텔이라고 부른다.
호텔 정문은 일층 엘리베이터 바로 앞에 있는데, 정문에서 엘리베이터까지의 거리는 무시한다.
또 모든 인접한 두 방 사이의 거리는 같은 거리(거리 1)라고 가정하고 호텔의 정면 쪽에만 방이 있다고 가정한다.

우선 순위 - 거리 > 층
여러분이 작성할 프로그램은 초기에 모든 방이 비어있다고 가정하에 이 정책에 따라 N 번째로 도착한 손님에게 배정될 방 번호를 계산하는 프로그램이다

입력 - 프로그램의 입력은 T 개의 테스트 데이터로 이루어져 있는데 T 는 입력의 맨 첫 줄에 주어진다. 각 테스트 데이터는 한 행으로서 H, W, N, 세 정수를 포함하고 있으며 각각 호텔의 층 수, 각 층의 방 수, 몇 번째 손님인지를 나타낸다(1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W). 

출력 - 각 테스트 데이터마다 정확히 한 행을 출력하는데, 내용은 N 번째 손님에게 배정되어야 하는 방 번호를 출력한다.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.24.
 * 
 * <의사코드>
 * 특정 방 번호에 우선적으로 넣는 경우가 없기 때문에 각 층의 1호부터 채우며
 * 1호가 가득찰 경우 1층의 2호로 넘어가는 식으로 채워주면 된다. -> /와 %의 적절한 혼합
 * 
 * T - 테스트 수, 반복문 횟수
 * H - 층 높이
 * W - 한 층에 있는 방 수
 * N - 몇 번째 손님
 * 
 * 호수: N/H+1
 * 층: N%H
 * 방 번호: 층+호수 String으로 더해주기
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0) {
			int H=sc.nextInt(), W=sc.nextInt(), N=sc.nextInt(), room = (int)Math.ceil((double)N/H);
			int floor = N%H==0 ? H: N%H;
			String roomstr = room<10 ? '0'+String.valueOf(room) : String.valueOf(room);
			System.out.println(String.valueOf(floor) + roomstr);
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author algorithm777
 * 
 * printf method를 통해 자리수 0 추가
 * 올림값을 (n-1)/h+1을 통해 표현할 수 있다는 점을 배움
 * 
 */
public class Main {
	public static void main(String[] args){
        Scanner k= new Scanner(System.in);
        int i=k.nextInt();
        while(i-->0){
        int h=k.nextInt(), w=k.nextInt(), n=k.nextInt();
        System.out.printf("%d%02d\n",n%h>0 ? n%h : h, (n-1)/h+1);
        }
	}
}
