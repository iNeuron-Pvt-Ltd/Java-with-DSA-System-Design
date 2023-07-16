bucketSort(a[], n)  
1. Create 'n' empty buckets  
2. Do for each array element a[i]  
       2.1. Put array elements into buckets, i.e. insert a[i] into bucket[n*a[i]]  
3. Sort the elements of individual buckets by using the insertion sort.  
4. At last, gather or concatenate the sorted buckets.  
End bucketSort
