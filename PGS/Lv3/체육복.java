/*
<Problem> - 체육복
전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

Condition
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.12.
 * 
 * <의사코드>
//학생들의 번호는 체격 순 -> 바로 앞번호나 뒷번호의 학생에게만 대여 가능
//체육복을 적절히 빌려 최대한 많은 학생이 들어야함.
//전체 학생의 수: n, 체육복을 도난당한 학생들의 번호가 담긴 배열: lost
//여벌의 체육복을 가져온 학생들의 번호가 담긴 배열: reserve
//체육수업을 들을 수 있는 학생의 최댓값은?
//최소 학생 수: n-lost.size();
//lost[i]+1 or lost[i]-1이 reserve[j]에 포함되면 카운트
//여벌 옷을 가진 학생이 도난 당한 경우는 
*/
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int total = n-lost.length;
        int[] checklo = new int[lost.length];
        int[] checkre = new int[reserve.length];//0으로 초기화
        //먼저 여벌옷 가진 학생이 분실했을 경우 확인
        for(int i=0;i<lost.length;i++){
             for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    total++;
                    checklo[i]=1;
                    checkre[j]=1;
                    break;
                }
            }
        }
        //나머지 학생 확인
        for(int i=0;i<lost.length;i++){
            if(checklo[i]==0){
                for(int j=0;j<reserve.length;j++){
                    if(checkre[j]==0&&(reserve[j]==lost[i]+1||reserve[j]==lost[i]-1)){
                        total++;
                        checkre[j]=1;
                        break;
                    }
                }    
            }
        }
        return total;
    }

    //다른 사람 풀이
    //내 풀이의 경우 시간복잡도 O(N^2)
    //하지만 다음과 같이 풀 경우, 시간복잡도(N)을 만들 수 있다.
    public int solution1(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--; //0부터 채워주기 위해
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) { //체육복을 분실하고 본인이 여벌을 갖지않은 경우
                if(i-1>=0 && people[i-1] == 1) {//배열 범위가 넘어가지 않게 조건 더해주면서 본인보다 번호 하나 아래의 사람에게 빌리는 경우,
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {//배열 범위가 넘어가지 않고 본인보다 번호 하나 많은 사람에게 빌리는 경우,
                    people[i]++;
                    people[i+1]--;
                }else //해당되지 않으면 그제서야 전체 사람 수에서 제외
                    answer--;
            }
        }
        return answer;
    }
}
