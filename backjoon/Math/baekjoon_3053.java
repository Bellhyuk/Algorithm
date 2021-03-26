package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 택시 기하학 3053번
19세기 독일 수학자 헤르만 민코프스키는 비유클리드 기하학 중 택시 기하학을 고안했다.
택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.
D(T1,T2) = |x1-x2| + |y1-y2|
두 점 사이의 거리를 제외한 나머지 정의는 유클리드 기하학에서의 정의와 같다.
따라서 택시 기하학에서 원의 정의는 유클리드 기하학에서 원의 정의와 같다.
원: 평면 상의 어떤 점에서 거리가 일정한 점들의 집합

반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와,
택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 반지름 R이 주어진다. R은 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄에는 유클리드 기하학에서 반지름이 R인 원의 넓이
둘째 줄에는 택시 기하학에서 반지름이 R인 원의 넓이를 출력
정답과의 오차는 0.0001까지 허용한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.26.
 * 
 * <의사코드>
 * 일단 소수점이 나오는 것이 기본 -> 자료형 double
 * 유클리드 기하학 원의 넓이 pi * r^2
 * 
 * A(a, b)에서 B(c, d)의 거리
 * 유클리드 r = sqrt((c-a)^2 + (d-b)^2)
 * 비유클리드 내 택시 기하학 r = |c-a| + |d-b| 
 * 택시 기하학의 원-> 각변의 길이가 sqrt(2)*r이며 45도 기울어진 정사각형
 * 
 * 비유클리드 기하학의 개념에 대해서는 일반 평면이 아닌 구의 3차원 평면 혹은 시내라는 특정 공간의 평면으로 생각해보자
 */
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double r = Double.parseDouble(br.readLine());
    System.out.println(Math.PI*r*r);
    System.out.println(2*r*r);
  }
}
