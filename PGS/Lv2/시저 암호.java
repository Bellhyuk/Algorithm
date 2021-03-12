package practice;
/*
<Problem> - 시저 암호
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

Condition
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.12.
 * 
 * <의사코드>
//문자열과 숫자의 변환
//charAt으로 string 내 값 비교
//아스키코드 값을 고려하여 계산 공백=32, 'A'=65, 'Z'=90, 'a'=97, 'z'=122
//StringBuilder를 통해 n을 더해준 값 String으로 변환
 */

class Solution {
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int ascii = s.charAt(i);
            if(ascii==' ') {
              sb.append(' ');
              continue;
            } 
            else if(ascii+n>'z') ascii-=26;
            else if(ascii+n>'Z'&&ascii<'a') ascii-=26;
            sb.append((char)(ascii+n));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
      String s = "z";
      int n = 1;   
      System.out.println(solution(s, n));
    }
}
