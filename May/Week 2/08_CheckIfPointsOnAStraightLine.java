/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:


Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 
 
Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

*/


class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int y_diff = coordinates[1][1]-coordinates[0][1];
        int x_diff = coordinates[1][0]-coordinates[0][0];
        int m = 0;
        boolean flag = true;
        
        if(coordinates.length == 2) return true;
        
        if(x_diff !=0) m = y_diff/x_diff;
        
        int c = coordinates[1][1] - (m * coordinates[1][0]);
        for(int i=0;i<coordinates.length;i++){
            int line = coordinates[i][1] - (m*coordinates[i][0]) - c;
            if(line !=0){
                flag = false;
                break;
            }
        }
        
        return flag;    
    }
}
