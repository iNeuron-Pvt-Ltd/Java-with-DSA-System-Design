
class Main{

// An interval has start time and end time
static class Interval{
	int start;
	int end;
	public Interval(int start, int end){
		super();
		this.start = start;
		this.end = end;
	}
};

static boolean isIntersect(Interval arr[], int n){

	int max_ele = 0;

	// Find the overall maximum element
	for (int i = 0; i < n; i++)
	{
		if (max_ele < arr[i].end)
			max_ele = arr[i].end;
	}

	// Initialize an array of size max_ele
	int []aux = new int[max_ele + 1];
	for (int i = 0; i < n; i++)
	{

		// starting point of the interval
		int x = arr[i].start;

		// end point of the interval
		int y = arr[i].end;
		aux[x]++;
		aux[y ]--;
	}
	for (int i = 1; i <= max_ele; i++)
	{
		// Calculating the prefix Sum
		aux[i] += aux[i - 1];

		// Overlap
		if (aux[i] > 1)
			return true;
	}

	// If we reach here, then no Overlap
	return false;
}

public static void main(String[] args){
	Interval arr1[] = { new Interval(1, 3), new Interval(7, 9),	new Interval(4, 6), new Interval(10, 13) };
	int n1 = arr1.length;

	if(isIntersect(arr1, n1))
		System.out.print("Yes\n");
	else
		System.out.print("No\n");
    }
}
