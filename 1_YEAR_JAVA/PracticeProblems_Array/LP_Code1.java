public class ReverseArr1 {  
    public int[]  reverseArray(int arr[]) {  
        int size = arr.length;  
        int ptr1 = 0;  
        int ptr2 = size - 1;  
      
        while(ptr1 < ptr2) {  
            int temp = arr[ptr1];  
            arr[ptr1] = arr[ptr2];  
            arr[ptr2] = temp;  
              
            ptr1 = ptr1 + 1;  
            ptr2 = ptr2 - 1;  
        }  
        return arr;  
    }  
      
    public static void main(String argvs[]) {  
        ReverseArr1 obj = new ReverseArr1();  
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};  
        int len = arr.length;  
        System.out.println("For the input array: ");  
        for(int  i = 0; i < len; i++)  
         System.out.print(arr[i] + " ");  
        
        int ans[] = obj.reverseArray(arr);  
        
        System.out.println();  
        System.out.println("The reversed array is: ");  
        for(int  i = 0; i < len; i++)  
         System.out.print(ans[i] + " "); 
        
        System.out.println("\n ");  
    }  
}  
