import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
   public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] curr = new int[] {intervals[0][0], intervals[0][1]};
        int maxCap = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < curr[1]) continue; 
            curr[0] = intervals[i][0];
            curr[1] = intervals[i][1];
            maxCap++;
        }
        return intervals.length - maxCap;
    }
	public static void main(String[] args){
	    int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		int n = 1;
		System.out.println("The desired output is :  " + eraseOverlapIntervals(intervals));
	}
}
