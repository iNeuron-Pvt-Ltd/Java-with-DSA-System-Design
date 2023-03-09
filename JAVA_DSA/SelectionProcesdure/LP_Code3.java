import java.util.Arrays;

class Solution {
	public static int partition(int[] arr, int low, int high){
		int pivot = arr[high], pivotloc = low;
		for (int i = low; i <= high; i++) {
			// inserting elements of less value
			// to the left of the pivot location
			if (arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[pivotloc];
				arr[pivotloc] = temp;
				pivotloc++;
			}
		}

		// swapping pivot to the final pivot location
		int temp = arr[high];
		arr[high] = arr[pivotloc];
		arr[pivotloc] = temp;

		return pivotloc;
	}

	public static int kthSmallest(int[] arr, int low, int high, int k){
		// find the partition
		int partition = partition(arr, low, high);

		// if partition value is equal to the kth position,
		// return value at k.
		if (partition == k - 1)
			return arr[partition];

		// if partition value is less than kth position,
		// search right side of the array.
		else if (partition < k - 1)return kthSmallest(arr, partition + 1, high, k);

		// if partition value is more than kth position,
		// search left side of the array.
		else return kthSmallest(arr, low, partition - 1, k);
	}
	public static void main(String[] args){
		int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };
		int[] arraycopy	= new int[] { 10, 4, 5, 8, 6, 11, 26 };

		int kPosition = 3;
		int length = array.length;

		if (kPosition > length) {
			System.out.println("Index out of bound");
		}
		else {
			System.out.println("K-th smallest element in array : "+ kthSmallest(arraycopy, 0, length - 1,kPosition));
		}
	}
}
