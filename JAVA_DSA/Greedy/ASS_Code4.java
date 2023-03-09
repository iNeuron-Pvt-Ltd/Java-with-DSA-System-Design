import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
   public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                int prev = (i == 0 || flowerbed[i - 1] == 0) ? 0 : 1;
                int next = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) ? 0 : 1;
                
                if(prev == 0 && next == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
	public static void main(String[] args){
		int flowerbed[] = {1, 0, 0, 0, 1};
		int n = 1;
		System.out.println("The desired output is :  " + canPlaceFlowers(flowerbed , n));
	}
}
