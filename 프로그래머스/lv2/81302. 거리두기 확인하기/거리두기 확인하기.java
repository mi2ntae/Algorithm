import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int[] answer = new int[5];
        char[][] room;
        loop: for(int i=0;i<5;i++){
            System.out.println(i+"번방");
            room= new char[5][5];
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    room[j][k]=places[i][j].charAt(k);
                }
            }
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(room[j][k]=='P'){
                        Queue<int[]> q = new ArrayDeque<>();
                        boolean[][] v = new boolean[5][5];
                        v[j][k]=true;
                        q.add(new int[]{j,k,0});
                        System.out.println("시작점 "+j+" "+k);
                        while(!q.isEmpty()){
                            int[] temp = q.poll();
                            System.out.println(temp[0]+" "+temp[1]);
                            if(room[temp[0]][temp[1]]=='P' && temp[2]!=0){
                                answer[i]=0;
                                continue loop;
                            }
                            if(temp[2]>=2) continue;
                            for(int l=0;l<4;l++){
                                int x = temp[0]+dx[l];
                                int y = temp[1]+dy[l];
                                if(x>=0&&y>=0&&x<5&&y<5&&!v[x][y]&&room[x][y]!='X'){
                                    q.add(new int[]{x,y,temp[2]+1});
                                    v[x][y]=true;
                                }
                            }
                        }
                    }
                }
            }
            answer[i]=1;
        }
        return answer;
    }
}