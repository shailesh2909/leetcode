class Solution {

    public int count(int n) 
    {
        int cnt = 0;
        while (n != 0) 
        {
            if ((n & 1) == 1) 
            { 
                cnt++;
            }
            n = n >> 1;
        }
        return cnt;
    }

    int partition(int a[], int low, int high) 
    {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {

            if ((count(a[j]) < count(pivot)) ||
               (count(a[j]) == count(pivot) && a[j] <= pivot)) {

                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    void sort(int a[], int l, int h) 
    {
        if (l < h) 
        {
            int pi = partition(a, l, h);
            sort(a, l, pi - 1);
            sort(a, pi + 1, h);
        }
    }

    public int[] sortByBits(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }
}