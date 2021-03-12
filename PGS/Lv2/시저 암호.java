//문자열과 숫자의 변환
//아스키코드 값을 고려하여 계산 공백=32, 'A'=65, 'Z'=90, 'a'=97, 'z'=122
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
