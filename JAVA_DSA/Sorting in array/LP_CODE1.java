#include <bits/stdc++.h>
using namespace std;

// 0 based indexing used 
void bubbleSort(vector<int>&a){
  int n = a.size();
  for (int i = 0; i < n - 1; i++){
    // Last i elements are already at correct sorted positions
    // so no need to check them
    for (int j = 0; j < n - i - 1; j++){
      if (a[j] > a[j + 1]){
        swap(a[j], a[j + 1]);
      }
    }
  }
}
 
// Driver Code
int main()
{ int n;
 cout<<"Enter the size of array"<<endl;
 cin>>n;
 vector<int>v(n);
 cout<<"Enter the elements"<<endl;
 for(int i=0;i<n;i++){
     cin>>v[i];
 }
 bubbleSort(v);
 cout<<"Array after sorting"<<endl;
 for(int i=0;i<n;i++){
    cout<<v[i]<<" "; 
 }
}
