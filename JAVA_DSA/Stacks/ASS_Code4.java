import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static int[] asteroidCollision(int[] a) {
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<a.length; i++){
            list.add(a[i]);
            int j=list.size()-1;

            // This is the condition for collision
            while(j>0 && (list.get(j)<0 && list.get(j-1)>=0)){
                int first = list.remove(list.size()-1);
                int second = list.remove(list.size()-1);
                int third;
                if(Math.abs(first)==Math.abs(second)){
                    //If both have same value then both will destory
                    j=j-2;
                    continue;
                }else if(Math.abs(first)>Math.abs(second)){
                    //If first have greater value then 2nd will destory
                    j--;
                    list.add(first);
                }else{
                    //If 2nd have greater value then 1st will destory
                    j--;
                    list.add(second);
                }
            }
        }
        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
        
    }
	public static void main(String[] args){
        int []a = {5,10,-5};
        System.out.println("The desired output is : ");
        
        int []arr = asteroidCollision(a);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
	}
}
