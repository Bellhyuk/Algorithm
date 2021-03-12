//학생들의 번호는 체격 순 -> 바로 앞번호나 뒷번호의 학생에게만 대여 가능
//체육복을 적절히 빌려 최대한 많은 학생이 들어야함.
//전체 학생의 수: n, 체육복을 도난당한 학생들의 번호가 담긴 배열: lost
//여벌의 체육복을 가져온 학생들의 번호가 담긴 배열: reserve
//체육수업을 들을 수 있는 학생의 최댓값은?
//최소 학생 수: n-lost.size();
//lost[i]+1 or lost[i]-1이 reserve[j]에 포함되면 카운트
//여벌 옷을 가진 학생이 도난 당한 경우
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
