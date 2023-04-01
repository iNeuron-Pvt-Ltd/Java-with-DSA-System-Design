import java.io.*;
import java.util.*;

public class Main{
    public static int frogJump(int []heights , int n , int idx){
        if(idx >= n)return 0;
        return Math.min(frogJump(heights , n , idx + 1) + Math.abs(heights[Math.min(idx+1  , n-1)] - heights[idx]) ,
        frogJump(heights , n , idx + 2) + Math.abs(heights[Math.min(n-1 ,idx+2)] - heights[idx]));
    }
    public static void main(String[] args) {
        int[] heights={3,10,13,12,5};
        int n=heights.length;
        System.out.println("The minimum cost is : " + frogJump(heights,n,0));
    }
}