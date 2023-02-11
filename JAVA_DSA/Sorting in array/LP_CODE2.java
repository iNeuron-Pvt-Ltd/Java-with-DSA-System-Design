#include <bits/stdc++.h>
using namespace std;
// 0-based indexing used here 

void insertionSort(vector<int> &a)
{
    int n = a.size(); 
 
    for (int i = 1; i < n; i++) { 
        int j = i;
 
        // Insert a[i] into sorted left part 0..i-1
        while (j > 0 && a[j] < a[j - 1]) {
 
            // Swap a[j] and a[j-1]
            swap(a[j], a[j - 1]);
 
            // Decrement j by 1
            j --;
        }
    }
} 

 
// Driver Code
int main(){ 
	int n;
	cout<<"Enter the size of array"<<endl;
	cin>>n;
	vector<int>v(n);
	cout<<"Enter the elements"<<endl;
	for(int i=0;i<n;i++){
		cin>>v[i];
 	}
	insertionSort(v);
	cout<<"Array after sorting"<<endl;
	for(int i=0;i<n;i++){
	    cout<<v[i]<<" "; 
	 }
}
