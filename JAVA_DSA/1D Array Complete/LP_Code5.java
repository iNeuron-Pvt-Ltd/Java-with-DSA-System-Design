public class Main
{
    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 5 , 4 , 6 , 4};
        int N = arr.length;
          
        System.out.println("Duplicate elements in given array: ");  
        //Searches for duplicate element  
        for(int i = 0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) {  
                if(arr[i] == arr[j])  
                    System.out.println(arr[j]);  
            }  
        }  
    }
}
