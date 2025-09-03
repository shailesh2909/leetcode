class Solution {

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : arr) list.add(x);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = countStudents(list, mid);
            if (students <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int splitArray(int[] nums, int k) {
        return findPages(nums, k);
    }
}