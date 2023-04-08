import java.util.*;
 
public class Main {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        boolean[] map=new boolean[nums.length];
        List<Integer> list=new ArrayList<Integer>();
        //sort the array so that duplicate entries will be next to each other
        Arrays.sort(nums);
        mapCombo(nums,map,res,list);
        return res;
    }
    
    private static void mapCombo(int[] nums,boolean[] map,List<List<Integer>> res,List<Integer> list){
        
        //base condition : Whenever our list size becomes same as arr size, we got our combination
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(!map[i]){
                list.add(nums[i]);
                //Pick 
                map[i]=true;
                mapCombo(nums,map,res,list);
                //Not pick
                map[i]=false;
                list.remove(list.size()-1);
                //to avoid duplicates combination
                while(i+1<nums.length && nums[i]==nums[i+1])i++;
            }
        }
    }
    public static void main(String[] args) {
        int []arr = {1,2,2,1,1};
        List<List<Integer>>answer;
        
        answer = permuteUnique(arr);
        
        for(List<Integer> x:answer){
            for(Integer y:x)System.out.print(y + " ");
            System.out.println();
        }
    }
}
 