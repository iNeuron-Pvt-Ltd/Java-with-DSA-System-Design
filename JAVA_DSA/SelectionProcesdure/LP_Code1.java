import java.util.Scanner;
class Solution {
  static int findInversionCount(int arr[], int n) {
    int count = 0;
    for(int i = 0; i < n - 1; i++) 
      for(int j = i + 1; j < n; j++) 
        if(arr[i] > arr[j]){
            count++;
        }
    return count;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements you want in the array :");
    int n = sc.nextInt();
    int arr[] = new int[n];

    System.out.println("Enter the Array elements:");
    for (int x = 0; x < n; x++)arr[x] = sc.nextInt();
    System.out.println("Inversion Count is : " + findInversionCount(arr, n));
  }
}
