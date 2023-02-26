public class Main
{    
/* Function to merge the subarrays of arr[] */  
static void merge(int arr[], int l, int mid, int r)    
{    
    int i, j, k;  
    int n1 = mid - l + 1;    
    int n2 = r - mid;    
      
    int []lArr=new int[n1];
    int []rArr=new int[n2]; //temporary arrays  
      
    /* copy data to temp arrays */  
    for ( i = 0; i < n1; i++)    
    lArr[i] = arr[l + i];    
    for ( j = 0; j < n2; j++)    
    rArr[j] = arr[mid + 1 + j];    
      
    i = 0; /* initial index of first sub-array */  
    j = 0; /* initial index of second sub-array */   
    k = l;  /* initial index of merged sub-array */  
      
    while (i < n1 && j < n2)    
    {    
        if(lArr[i] <= rArr[j])    
        {    
            arr[k] = lArr[i];    
            i++;    
        }    
        else    
        {    
            arr[k] = rArr[j];    
            j++;    
        }    
        k++;    
    }    
    while (i<n1)    
    {    
        arr[k] = lArr[i];    
        i++;    
        k++;    
    }    
      
    while (j<n2)    
    {    
        arr[k] = rArr[j];    
        j++;    
        k++;    
    }    
}    
  
static void mergeSort(int arr[], int l, int r)  
{  
    if (l < r)   
    {  
        int mid = (l + r) / 2;  
        mergeSort(arr, l, mid);  
        mergeSort(arr, mid + 1, r);  
        merge(arr, l, mid, r);  
    }  
}  
  
/* Function to print the array */  
static void display(int arr[], int n)  
{  
    for (int i = 0; i < n; i++)  
        System.out.print(arr[i] + " " ) ;
}  
  

public static void main(String[] args) {
    int arr[] = {6 , 4 , 2 , 7 , 9 , 11 , 12 , 5};  
    int n = arr.length;  
    System.out.println("Before sorting array elements are - ");  
    display(arr, n);  
    System.out.println("");
    mergeSort(arr, 0, n - 1);  
    System.out.println("After sorting array elements are - ");  
    display(arr, n);  
     

	}
}


