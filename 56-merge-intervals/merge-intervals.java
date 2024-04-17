
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort the intervals based on their start times using merge sort
        mergeSort(intervals, 0, intervals.length - 1);

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            // If currentInterval overlaps with interval, merge them
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                merged.add(currentInterval);
                currentInterval = interval;
            }
        }

        merged.add(currentInterval);

        return merged.toArray(new int[merged.size()][]);
    }

    // Merge sort implementation
    private void mergeSort(int[][] intervals, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(intervals, low, mid);
            mergeSort(intervals, mid + 1, high);
            merge(intervals, low, mid, high);
        }
    }

    // Merge step of merge sort
    private void merge(int[][] intervals, int low, int mid, int high) {
        int[][] temp = new int[high - low + 1][2];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (intervals[i][0] < intervals[j][0]) {
                temp[k++] = intervals[i++];
            } else {
                temp[k++] = intervals[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = intervals[i++];
        }

        while (j <= high) {
            temp[k++] = intervals[j++];
        }

        for (i = low; i <= high; i++) {
            intervals[i] = temp[i - low];
        }
    }
}
