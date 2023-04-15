import java.util.*;
import java.util.Scanner;
public class Main{
   public static void permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return ;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        findAllPermutationso(nums, used, list, result);
        
        for(List<Integer> li : result){
            for(Integer item : li){
                System.out.print(item + "  ");
            }
            System.out.println("");
        }
    }

    public static void findAllPermutations(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            findAllPermutationso(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
   
    public static void main(String[] args){
        int []arr = {1 , 4 , 4 , 3};
        System.out.println("The possible permutations are : ");
        permuteUnique(arr);
    }
}
