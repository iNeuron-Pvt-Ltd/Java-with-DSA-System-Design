public class Main{  
    //  Here last element is taken as pivot  
    static int partition (int arr[], int first, int last)  
    {  
        int pivot = arr[last]; // pivot element  
        int i = (first - 1);  
      
        for (int j = first; j <= last - 1; j++)  
        {  
            // If current element is smaller than the pivot  
            if (arr[j] < pivot)  
            {  
                i++; // increment index of smaller element  
                int temp = arr[i];  
                arr[i] = arr[j];  
                arr[j] = temp;  
            }  
        }  
               int temp = arr[i+1];  
                arr[i+1] = arr[last];  
                arr[last] = temp;  
        return (i + 1);  
    }  
  
    static void quickSort(int arr[], int first, int last)   
    {  
        if (first < last)  
        {  
            int p = partition(arr, first, last);  //p is partitioning index  
            quickSort(arr, first, p - 1);  
            quickSort(arr, p + 1, last);  
        }  
    }  
   
    static void display(int arr[], int n){  
        int i;  
        for (i = 0; i < n; i++)  
            System.out.print(arr[i] + " ");  
    }  
    public static void main(String[] args) {  
    int arr[] = { 2, 1, 5, 3, 8, 9};  
    int n = arr.length;  
    System.out.println("\nBefore sorting array elements are - ");  
    display(arr, n);  
    quickSort(arr, 0, n - 1);  
    System.out.println("\nAfter sorting array elements are - ");  
    display(arr, n);  
    System.out.println();  
    }  
}
