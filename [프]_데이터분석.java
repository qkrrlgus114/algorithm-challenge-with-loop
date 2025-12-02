import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int[][] answer = solve(data, ext, val_ext, sort_by);
        return answer;
    }

    public static int[][] solve(int[][] data, String ext, int val_ext, String sort_by){
        // 1. ext가 val_ext보다 작은 값의 개수 확인
        int cnt = 0;
        for(int i=0; i<data.length; i++){
            if(ext.equals("code")){
                if(data[i][0] < val_ext) cnt++;
            } else if(ext.equals("date")){
                if(data[i][1] < val_ext) cnt++;
            } else if(ext.equals("maximum")){
                if(data[i][2] < val_ext) cnt++;
            } else if(ext.equals("remain")){
                if(data[i][3] < val_ext) cnt++;
            }
        }
        int[][] result = new int[cnt][4];

        int idx = 0;
        for(int i=0; i<data.length; i++){
            if(ext.equals("code")){
                if(data[i][0] < val_ext) {
                    result[idx][0] = data[i][0];
                    result[idx][1] = data[i][1];
                    result[idx][2] = data[i][2];
                    result[idx++][3] = data[i][3];
                }
            } else if(ext.equals("date")){
                if(data[i][1] < val_ext) {
                    result[idx][0] = data[i][0];
                    result[idx][1] = data[i][1];
                    result[idx][2] = data[i][2];
                    result[idx++][3] = data[i][3];
                }
            } else if(ext.equals("maximum")){
                if(data[i][2] < val_ext) {
                    result[idx][0] = data[i][0];
                    result[idx][1] = data[i][1];
                    result[idx][2] = data[i][2];
                    result[idx++][3] = data[i][3];
                }
            } else if(ext.equals("remain")){
                if(data[i][3] < val_ext) {
                    result[idx][0] = data[i][0];
                    result[idx][1] = data[i][1];
                    result[idx][2] = data[i][2];
                    result[idx++][3] = data[i][3];
                }
            }
        }

        // 정렬
        if(sort_by.equals("code")){
            Arrays.sort(result, (o1, o2) -> {
                return o1[0] - o2[0];
            });
        } else if(sort_by.equals("date")){
            Arrays.sort(result, (o1, o2) -> {
                return o1[1] - o2[1];
            });
        } else if(sort_by.equals("maximum")){
            Arrays.sort(result, (o1, o2) -> {
                return o1[2] - o2[2];
            });
        } else if(sort_by.equals("remain")){
            Arrays.sort(result, (o1, o2) -> {
                return o1[3] - o2[3];
            });
        }

        return result;
    }


}