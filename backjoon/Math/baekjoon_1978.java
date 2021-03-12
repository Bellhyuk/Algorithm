package practice;

/*
<Problem> - 소수 찾기 1978번
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력: 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다.
다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력: 주어진 수들 중 소수의 개수를 출력한다.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.12.
 * 
 * <의사코드>
 * Scanner로 수를 각각 받고 소수 확인
 * 소수의 성질
 * 1. 소수 N은 1 or 자신 N으로만 나눠지는 수이다. -> 2~N-1로 나눠떨어지면 안된다.
 * 2. 증명된 사실에 의해 루트N까지만 확인해봐도 해당 수가 소수인지 판별할 수 있다.
 * 소수문제는 3단계를 거쳐서 생각해볼 수 있다.
 * 성질 1 접근 O(N) -> 성질 2 접근 O(루트N) -> 에라토스테네스의 체(각 소수의 배수를 제외)
 * 값을 찾을 때는 3단계까지 단순히 수를 구할 때는 2단계를 실행해주면 충분하다. 
 * 
 */

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt(), cnt = 0;
    for (int i = 0; i < test; i++) {
      int num = sc.nextInt();
      if (num == 2 || num == 3)
        cnt++; // 2와3일 경우는 아래 알고리즘에 포함이 안되므로 별도 카운트
      for (int j = 2; j <= Math.sqrt(num); j++) {// 성질2에 의해 루트num까지 확인
        if (num % j == 0)
          break;// 나눠떨어지면 break
        if (j + 1 > Math.sqrt(num))
          cnt++;// 끝까지 나눠떨어지지않으면 카운트
      }
    }
    System.out.println(cnt);
  }
}

/**
 * Best Coding(메모리와 시간이 작은 것을 중심으로)
 * 
 * @author rlaxorwn12
 * 
 *         일단 기본적으로 속도가 빠르려면 BufferedReader를 사용해야한다. 이분은 성질 2를 쓰지않았는데 나보다 빠른게..
 *         확실히 입출력에서 한번에 받고 쓰냐 매번 반복하느냐의 차이가 큰 것같다.
 * 
 */

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    String[] numbers = br.readLine().split(" ");
    int len = 0;
    int count = 0;

    first: for (int i = 0; i < numbers.length; i++) {
      len = Integer.parseInt(numbers[i]);

      if (len == 1)
        continue;

      for (int j = 2; j <= len; j++)
        if (len % j == 0 && len != j)
          continue first;

      count++;
    }
    System.out.println(count);
  }
}
