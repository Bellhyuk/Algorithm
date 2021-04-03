package inflearn;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    no_3 T = new no_3();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();// 문자열
    System.out.println(T.solution(str));
  }
}
