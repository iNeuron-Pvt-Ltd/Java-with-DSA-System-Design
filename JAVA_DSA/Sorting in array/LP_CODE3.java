include < bits / stdc++.h >
using namespace std;

// 0 based indexing used 
void selectionSort(vector < int > & a) {
    int n = a.size();

    for (int i = 0; i < n - 1; i++) // i represents the current index
    {
        // Find the minimum element in unsorted part of the array
        int min_index = i;
        for (int j = i + 1; j < n; j++) {
            if (a[j] < a[min_index])
                min_index = j;
        }

        // Swap the found minimum element with the current element 
        if (min_index != i)
            swap(a[min_index], a[i]);
    }
}







// Driver Code
int main() {
    int n;
    cout << "Enter the size of array" << endl;
    cin >> n;
    vector < int > v(n);
    cout << "Enter the elements" << endl;
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }
    selectionSort(v);
    cout << "Array after sorting" << endl;
    for (int i = 0; i < n; i++) {
        cout << v[i] << " ";
    }
}
