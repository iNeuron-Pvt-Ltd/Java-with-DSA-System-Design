public class Main
{
	public static void main(String[] args) {
		int []arr = {1,2,3,4,1};
		int n = 5;
		int flag = 0;
		for(int i=0;i<n/2;i++){
		   int temp = arr[i];
		   arr[i] = arr[n - i - 1];
		   arr[n - i - 1] = temp;
		}
		
		System.out.println("The reversed array is : ");
		for(int i=0;i<n;i++){
		   System.out.print(arr[i] + "  ");
		}
	}
}
