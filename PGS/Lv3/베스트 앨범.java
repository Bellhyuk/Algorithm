package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
<Problem> - 베스트 앨범
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.27.
 * 
 * 제대로 건드려보지도 못해서 다른 사람의 풀이를 보고 답습
 * 출처: velog.io/@hyeon930/프로그래머스-베스트앨범-Java
 * 
 * <의사 코드>
//장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범으로 출시
//노래는 고유번호로 구분

//수록 기준
//1. 장르 - 속한 노래의 재생 수 합이 가장 큰 장르 먼저 수록 - 내림차순
//2. 노래 - 장르 내에서 가장 많이 재생된 노래 먼저 수록 - 내림차순
//3. 고유 번호 - 장르 같고 노래 재생 수 같으면 고유 번호가 낮은 순서 - 오름차순

//장르 배열 genres와 재생 배열 plays가 주어진다.
//베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 배열 형식으로 return

//의사코드
//<정렬>
//비교는 안에서부터!
//고유 번호 비교 -> 재생 수 비교 -> 장르 내 재생 수 합 비교
//(장르, 재생 수) Map genreMap -> 장르가 같으면 재생 수 비교
//(고유번호, 장르, 재생수) 객체 Song -> 재생수가 같으면 고유번호 비교
//전체 Song 순서를 담은 List songList

//<삽입>
//베스트 앨범으로 추출 장르별로 많이 재생된 노래 2개
//장르 수록 개수 확인할 (장르, 수록 수) Map albumMap
//최종 Song을 넣은 List albumList
 */
class Solution {
 
  class Song implements Comparable<Song>{
    int idx;
    String genre;
    int play;
    
    public Song(int idx, String genre, int play) {
      this.idx = idx;
      this.genre = genre;
      this.play = play;
    }

    @Override
    public int compareTo(Song o) {//return이 음수면 인자 객체보다 호출 객체가 작은 것이 됨.
      //오름 차순 -> 호출 값-인자 값, 내림 차순 -> 인자 값-호출 값
      if(this.play==o.play) {//재생수가 같으면 고유번호 비교
        return this.idx - o.idx;//오름차순 
      }else {
        return o.play-this.play;//내림차순
      }
    }
  }

  public int[] solution(String[] genres, int[] plays) {
    Map<String, Integer> genreMap = new HashMap<>();
    Map<String, Integer> albumMap = new HashMap<>();
    List<Song> songList = new ArrayList<>();
    List<Song> albumList = new ArrayList<>();
    
  //genreMap 만들고 songList만들기
    for(int i=0; i<genres.length; i++) { 
      int idx = i;
      String genre = genres[i];
      int play = plays[i];
      
      songList.add(new Song(idx, genre, play));
      
      if(genreMap.containsKey(genre)) {
        genreMap.put(genre, genreMap.get(genre)+play);
      }else {
        genreMap.put(genre, play);
      }
    }
    //정렬 재정의
    Comparator<Song> com = new Comparator<Song>() {
      @Override
      public int compare(Song o1, Song o2) {
        if(o1.genre.equals(o2.genre)) { //장르가 같으면 재생 수 비교, 내림차순
          return o1.compareTo(o2);
        }else {//다르면 재생수 합 비교, 내림차순
          return genreMap.get(o2.genre) - genreMap.get(o1.genre);
        }
      }
    };
    //만들었으니까 정렬
    Collections.sort(songList, com);
    
    //삽입
    for(int i=0; i<songList.size(); i++) {
      Song song = songList.get(i);
      if(!albumMap.containsKey(song.genre)) {
        albumMap.put(song.genre, 1);
        albumList.add(song);
      }else {
        if(albumMap.get(song.genre)>=2) continue;
        else {
          albumMap.put(song.genre, albumMap.get(song.genre)+1);
          albumList.add(song);
        }
      }
    }
    int[] answer = new int[albumList.size()];
    //출력
    for(int i=0; i<albumList.size(); i++) {
      answer[i] = albumList.get(i).idx;
    }
    return answer;
}
  /*
   * <다른 사람 풀이>
   * <장르, 곡 정보> genresMap, <장르, 총 장르 재생수> playMap, 앨범 곡 리스트 resultAL
   * <곡 고유번호, 재생횟수>를 담는 곡정보 infoMap에 genre를 기준으로 값 대입
   * Object를 쓰는게 어색한 나에게 아직 범접할 수 없는 레벨...
   */
  
  
    public int[] solution1(String[] genres, int[] plays) {
      HashMap<String, Object> genresMap = new HashMap<String, Object>();      //<장르, 곡 정보> 
      HashMap<String, Integer> playMap = new HashMap<String, Integer>(); //<장르, 총 장르 재생수>
      ArrayList<Integer> resultAL = new ArrayList<Integer>();
  
      for(int i = 0; i < genres.length; i++){
          String key = genres[i];
          HashMap<Integer, Integer> infoMap;       // 곡 정보 : <곡 고유번호, 재생횟수>
  
          if(genresMap.containsKey(key)){
               infoMap = (HashMap<Integer, Integer>)genresMap.get(key);
          }
          else {
              infoMap = new HashMap<Integer, Integer>();
          }
  
          infoMap.put(i, plays[i]);
          genresMap.put(key, infoMap);
  
          //재생수
          if(playMap.containsKey(key)){
              playMap.put(key, playMap.get(key) + plays[i]);
          }
          else {
              playMap.put(key, plays[i]);
          }
      }
  
      int mCnt = 0;
      Iterator it = sortByValue(playMap).iterator();
  
      while(it.hasNext()){
          String key = (String)it.next();
          Iterator indexIt = sortByValue((HashMap<Integer, Integer>)genresMap.get(key)).iterator();
          int playsCnt = 0;
  
          while(indexIt.hasNext()){
              resultAL.add((int)indexIt.next());
              mCnt++;
              playsCnt++;
              if(playsCnt > 1) break;
          }
      }
  
      int[] answer = new int[resultAL.size()];
  
      for(int i = 0; i < resultAL.size(); i++){
          answer[i] = resultAL.get(i).intValue();
      }
  
      return answer;
  }
  
  private ArrayList sortByValue(final Map map){
      ArrayList<Object> keyList = new ArrayList();
      keyList.addAll(map.keySet());
  
      Collections.sort(keyList, new Comparator(){
          public int compare(Object o1, Object o2){
              Object v1 = map.get(o1);
              Object v2 = map.get(o2);
  
              return ((Comparable) v2).compareTo(v1);
          }
      });
  
      return keyList;
  }
  
}
